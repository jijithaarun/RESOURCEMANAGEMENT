import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { first } from 'rxjs/operators';
import { User } from '../user';
import { Jwtresponse } from '../jwtresponse';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  isSubmitted = false;
  jwtResponse: Jwtresponse;

  constructor(private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router) { }


  ngOnInit(): void {
    if (sessionStorage.getItem('ACCESS_ADMIN') !== null) {
      this.router.navigateByUrl('');
    }
    this.loginForm = this.formBuilder.group({

      userName: ['', [Validators.required, Validators.minLength(2)]],
      password: ['', [Validators.required]]

    });
  }
  get formControls() { return this.loginForm.controls; }

  login() {

    this.isSubmitted = true

    //invalid entry in form
    if (this.loginForm.invalid)
      return;

      // valid entry
    if (this.loginForm.valid) {

      //calling method from AuthService
      this.authService.loginVerify(this.loginForm.value).subscribe(data => {
        this.jwtResponse = data;
        sessionStorage.setItem("token", data.token);
        //checking roleId
        if (data.roleId === 1) {
           // logged as CEO
           sessionStorage.setItem("ACCESS_MANAGER", "logged");
           sessionStorage.setItem("username", data.userName);
           this.router.navigateByUrl('/manager');
         
        }
        else if(data.roleId===2){
          // logged as Admin/Cordinator
          console.log(data.roleId);
          sessionStorage.setItem("ACCESS_COORDINATOR", "logged");
          sessionStorage.setItem("username", data.userName);
          this.router.navigateByUrl('/coordinator');
        
        } else if(data.roleId===3){
          // logged as Admin/Cordinator
          console.log(data.roleId);
          sessionStorage.setItem("ACCESS_MAINADMIN", "logged");
          sessionStorage.setItem("username", data.userName);
          this.router.navigateByUrl('/mainadmin');
          
        }
        else {
          console.log("invalid Role");
        }
      });
    }
    else
      return;
  }
}
