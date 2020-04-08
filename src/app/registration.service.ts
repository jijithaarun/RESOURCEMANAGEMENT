import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient) { }

  //adding registration details
  public registerAdd(reg: Object): Observable<any> {

    return this.http.post(environment.apiurl + "/registration", reg);
  }

  //listing registers
  public listRegisters(): Observable<any> {
    return this.http.get(environment.apiurl + "/registration");

  }

  //adding registration follow ups
  public addFollowReg(flreg: Object): Observable<any> {
    return this.http.post(environment.apiurl + "/followupregister", flreg)
  }

  //status updating as informed
  public regStatusUpd(registrationId: number): Observable<any> {
    console.log("inside service+++");
    return this.http.put(environment.apiurl + "/status/" + registrationId, '');
  }

  //search
  public searchByDate(registrationDate: Date): Observable<any> {
    return this.http.get(environment.apiurl + "/registration-by-date/" + registrationDate);
  }

  //add multiple qualifications
  public createMulQuals(mulQual: Object): Observable<any> {
    return this.http.post(environment.apiurl + "/mulqualification", mulQual);
  }

  //addpayment
  public addPayment(pay: Object): Observable<any> {

    return this.http.post(environment.apiurl + "/payment", pay);
  }

  
}
