import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable()
export class AuthconfigInterceptor implements HttpInterceptor {

  constructor(private authService: AuthService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<unknown>> {


    console.log("Interceptor");
    // add authorization header with jwt token if available
    let token = sessionStorage.getItem('token');
    console.log(token);
    if (token) {
      console.log("inside");

     // authReq = request.clone({ headers: request.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + token) });
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`
        }
      });
    }
    console.log(request)
     // add authorization header with jwt token if available
  /*   let currentUser = this.authService.currentUserValue;
     if (currentUser && currentUser.token) {
         request = request.clone({
             setHeaders: {
                 Authorization: `Bearer ${currentUser.token}`
             }
         });
     }*/
    return next.handle(request);
  }
}
