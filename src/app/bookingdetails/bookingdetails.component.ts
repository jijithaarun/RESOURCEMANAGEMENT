import { Component, OnInit } from '@angular/core';
import { booking } from '../bookingdetails';
import { BookingdetailsService } from '../bookingdetails.service';
import { ResourcedetailsService } from '../resourcedetails.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-bookingdetails',
  templateUrl: './bookingdetails.component.html',
  styleUrls: ['./bookingdetails.component.scss']
})
export class BookingdetailsComponent implements OnInit {
  bookingId: number;
  booking: booking;

  loading= false;
  buttonText = "Submit";

  constructor(private bookingService: BookingdetailsService,
    private resourceDetailsService: ResourcedetailsService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    //getting value passed in url
    this.bookingId = this.route.snapshot.params['bookingId'];
    this.getBooking();

  }

  getBooking() {
    this.bookingService.searchById(this.bookingId).subscribe(
      data => this.booking = data,
      error => console.log(error)
    );
    console.log(this.booking);
  }

  rejectBooking(bookingId: number) {
    //setting value
    this.booking.bookingStatus = "N";
    this.booking.pending = "N";
    //calling update booking method
    this.updateBooking();
    // setting value
    this.booking.resourceDetails.isBooked = "N";
    this.booking.resourceDetails.isAccepted = "N";
    this.booking.resourceDetails.typeOfUse = "Available";
    //calling update Resource method
    this.updateResource();
    this.register();
    this.router.navigateByUrl("/admin/viewBookingDetails");
  }

  acceptBooking(bookingId: number) {
    this.booking.pending = "N";
    this.booking.bookingStatus = "Y";
    //calling update booking method
    this.updateBooking();
    // setting value
    this.booking.resourceDetails.isAccepted = "Y";
    this.booking.resourceDetails.typeOfUse = "external";
    //calling update Resource method
    this.updateResource(); 
    this.register();
    this.router.navigateByUrl("/admin/viewBookingDetails");
  }

  updateBooking() {
    //calling update method
    this.bookingService.updateBooking(this.booking).subscribe(
      data => console.log(data), error => console.log(error)
    );
  }

  updateResource() {
    this.resourceDetailsService.updateResource(this.booking.resourceDetails).subscribe(
      data => console.log(data),
      error => console.log(error)
    );
  }


  //sending mail
  register() {
    this.loading = true;
    this.buttonText = "Submitting";
    let user={
      name:this.booking.custName,
      email:this.booking.email,
      resourceTypeName:this.booking.resourceDetails.resource.resourceType,
      action:this.booking.bookingStatus
    }
    this.bookingService.sendMail("http://localhost:3000/sendmail",user).subscribe(
      data=>{
        let res:any=data;
        console.log(user.action);
        console.log(
          `Hi ${user.name}:mail has been sent and the message id is ${res.messageId}`
        );
      },
      err=>{
        console.log(err);
        this.loading=false;
        this.buttonText="Submit";
      },()=>{
        this.loading=false;
        this.buttonText="Submit";
      }
    );

  }

}
