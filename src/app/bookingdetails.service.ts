import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { booking } from './bookingdetails';

@Injectable({
  providedIn: 'root'
})
export class BookingdetailsService {


  constructor(private httpClient: HttpClient) { }

  addBooking(booking: booking): Observable<any> {
    console.log("booking detals");
    return this.httpClient.post(environment.apiurl + "/book", booking);
  }
  getAllBooking(): Observable<any> {
    return this.httpClient.get(environment.apiurl + "/booking");
  }

  searchById(bookingId: number): Observable<any> {
    return this.httpClient.get(environment.apiurl + "/booking/" + bookingId);
  }

  updateBooking(booking: Object): Observable<any> {
    return this.httpClient.put(environment.apiurl + "/booking", booking);
  }

  reportEnquiry(resourceId: number, startDate: Date, endingDate: Date): Observable<any> {
    return this.httpClient.get(environment.apiurl + "/booking-report/" + resourceId + "&" + startDate + "&" + endingDate);
  }

  acceptedReport(resourceId: number, startDate: Date, endingDate: Date): Observable<any> {
    return this.httpClient.get(environment.apiurl + "/booking-acceptedreport/" + resourceId + "&" + startDate + "&" + endingDate);
  }

  rejectedReport(resourceId: number, startDate: Date, endingDate: Date): Observable<any> {
    return this.httpClient.get(environment.apiurl + "/booking-rejectedreport/" + resourceId + "&" + startDate + "&" + endingDate);
  }

  sendMail(url,data)
  {
    return this.httpClient.post(url,data);
  }
}
