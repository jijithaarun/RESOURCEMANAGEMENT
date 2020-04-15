import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { booking } from '../bookingdetails';
import { BookingdetailsService } from '../bookingdetails.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-bookingdetails',
  templateUrl: './view-bookingdetails.component.html',
  styleUrls: ['./view-bookingdetails.component.scss']
})
export class ViewBookingdetailsComponent implements OnInit {
  p: number = 1;
  bookings: Observable<booking[]>;
  constructor(private bookingService: BookingdetailsService,
    private router: Router) { }

  ngOnInit(): void {
    this.getBookingDetails();

  }

  getBookingDetails() {
    this.bookings = this.bookingService.getAllBooking();
  }

  viewBooking(bookingId: number) {
    this.router.navigate(['/coordinator/bookingDetails', bookingId])
  }

}
