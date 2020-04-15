import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  addUser(User: Object): Observable<any> {
    return this.httpClient.post(environment.apiurl + "/user", User);
  }

  viewUser():Observable<any>
  {
    return this.httpClient.get(environment.apiurl+"/user");
  }

}
