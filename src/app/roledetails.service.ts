import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RoledetailsService {

  constructor(private httpClient:HttpClient) { }

  addRole(roledetails: Object): Observable<any> {
    console.log("Service");
    console.log(roledetails);
    return this.httpClient.post(environment.apiurl + "/roledetails", roledetails);
  }

    //view all roledetails
    getRoleDetails(): Observable<any> {
      return this.httpClient.get(environment.apiurl + "/roledetails");
    }
  
    //search by id
    searchById(roleId: number): Observable<any> {
      return this.httpClient.get(environment.apiurl + "/roledetails-by-id/" + roleId);
    }
    
}
