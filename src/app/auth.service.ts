import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from './user';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';
import { Jwtresponse } from './jwtresponse';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private httpClient: HttpClient,
    private router: Router) { }

  public loginVerify(user: User) {
    // calling webservice url and passing username and password
    return this.httpClient.post<Jwtresponse>(environment.apiurl + "/authenticate", user);
  }

  public isLoggedIn() {
    if (sessionStorage.getItem('ACCESS_MANAGER') == null && sessionStorage.getItem('ACCESS_COORDINATOR') == null) {
      this.router.navigateByUrl('/login');
    }
    else {
      return;  //localStorage.getItem('ACCESS_ADMIN') !== null;
    }
  }

  public logout() {
    sessionStorage.removeItem('ACCESS_MANAGER');
    sessionStorage.removeItem('ACCESS_COORDINATOR');
    sessionStorage.removeItem('ACCESS_MAINADMIN');
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('token');
  }
}
