import { Component, OnInit } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BookingdetailsService } from '../bookingdetails.service';
import { ResourcedetailsService } from '../resourcedetails.service';
import { Resourcedetails } from '../resourcedetails';


@Component({
  selector: 'app-bar-chart',
  templateUrl: './bar-chart.component.html',
  styleUrls: ['./bar-chart.component.scss']
})
export class BarChartComponent implements OnInit {

  resourceId: number;
  submitted = true;
  todate = new Date();
  reportForm: FormGroup;
  startDate: Date;
  endingDate: Date;

  res: Resourcedetails;

  enquiry: number;
  accepted: number;
  rejected: number;

  public barChartOptions: ChartOptions = {
    responsive: true,
  };
  public barChartLabels: Label[] = ['Enquiry', 'Accepted', 'Rejected'];
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;
  public barChartPlugins = [];



  public barChartData: ChartDataSets[] = [
    { data: [this.enquiry, this.accepted, this.rejected], label: '' }
  ];

  constructor(private formBuilder: FormBuilder,
    private bookingService: BookingdetailsService,
    private resourceDetailsService: ResourcedetailsService,
    private route: ActivatedRoute) {

    this.barChartData = [{ data: [], label: 'Resource' }];

  }

  ngOnInit(): void {
    // getting value passed in url
    this.resourceId = this.route.snapshot.params['resourceId'];
    this.createForm();

  }

  createForm() {

    this.reportForm = this.formBuilder.group({
      date: ['', Validators.required],
      endDate: ['', Validators.required]
    });
  }

  onSubmit() {
    this.submitted = false;

    // getting value from form
    this.startDate = this.reportForm.controls.date.value;
    this.endingDate = this.reportForm.controls.endDate.value;
    // callimg method to find total number of enquiry
    this.bookingService.reportEnquiry(this.resourceId, this.startDate, this.endingDate).subscribe(
      data => {
        this.enquiry = data
        // setting values to chart
        this.barChartData[0].data[0] = this.enquiry
      },
      error => console.log(error));

    // callimg method to find total number of accepted bookings
    this.bookingService.acceptedReport(this.resourceId, this.startDate, this.endingDate).subscribe(
      data => {
        this.accepted = data
        // setting values to chart
        this.barChartData[0].data[1] = this.accepted
      },
      error => console.log(error));

    // callimg method to find total number of rejected  bookings
    this.bookingService.rejectedReport(this.resourceId, this.startDate, this.endingDate).subscribe(
      data => {
        this.rejected = data
        // setting values to chart
        this.barChartData[0].data[2] = this.rejected

      },
      error => console.log(error));

    //calling method to get resouce details
    this.getResource();

  }
  getResource() {

    // search resourceby id
    this.resourceDetailsService.searchById(this.resourceId).subscribe(
      data => {
        this.res = data
        this.barChartData[0].label=this.res.resource.resourceType
      },
      error => console.log(error)
    );
  }





}
