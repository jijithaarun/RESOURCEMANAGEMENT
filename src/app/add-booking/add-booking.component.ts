import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { booking } from '../bookingdetails';
import { Observable } from 'rxjs';
import { Resourcedetails } from '../resourcedetails';
import { BookingdetailsService } from '../bookingdetails.service';
import { ResourcedetailsService } from '../resourcedetails.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Resource } from '../resource';

@Component({
  selector: 'app-add-booking',
  templateUrl: './add-booking.component.html',
  styleUrls: ['./add-booking.component.scss']
})
export class AddBookingComponent implements OnInit {
  addBookingForm: FormGroup;
  addResourceForm: FormGroup;
  booking: booking = new booking();
  resourceId: number;
  todate = new Date();
  res:Resourcedetails;

  constructor(private formBuilder: FormBuilder,
    private bookingDetailsService: BookingdetailsService,
    private resourceDetailService: ResourcedetailsService,
    private router: Router,
    private toastr: ToastrService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.resourceId = this.route.snapshot.params['resourceId'];
    this.bookingForm();
  }

  name="[a-zA-Z ]*";
  address="^[a-zA-Z0-9_-]{8,15}$";
  phoneNumber="^((\\+91-?)|0)?[0-9]{10}$";
  bookingForm() {
    this.addBookingForm = this.formBuilder.group({
      custName: ['', [Validators.required,Validators.minLength(4),Validators.maxLength(20),Validators.pattern(this.name)]],
      custAddress: ['', [Validators.required,Validators.pattern(this.address),Validators.maxLength(20)]],
      phoneNumber: ['', [Validators.required,Validators.pattern]],
      email: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      purpose: ['', Validators.required]
    });

    
    this.addResourceForm=this.formBuilder.group({
      resourceId:[this.resourceId],
      
    });
    this.resourceDetailService.searchById(this.resourceId).subscribe(
      data=>this.res=data,

      error=>console.log(error)
    );
  
  }

  onSubmit() {
    console.log(this.addBookingForm.value);
    //setting values
    this.booking.resourceDetails=this.addResourceForm.value;
    this.booking.custName = this.addBookingForm.controls.custName.value;

    this.booking.custAddress = this.addBookingForm.controls.custAddress.value;
    this.booking.phoneNumber = this.addBookingForm.controls.phoneNumber.value;
    this.booking.email = this.addBookingForm.controls.email.value;
    this.booking.startDate = this.addBookingForm.controls.startDate.value;
    this.booking.endDate = this.addBookingForm.controls.endDate.value;
    this.booking.purpose = this.addBookingForm.controls.purpose.value;

    
    this.bookingDetailsService.addBooking(this.booking).subscribe(
      data => console.log(data), error => console.log(error));
    this.toastr.success('booking successfully');
    this.router.navigateByUrl('/home');
  }

}
