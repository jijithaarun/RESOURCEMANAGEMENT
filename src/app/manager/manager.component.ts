import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.scss']
})
export class ManagerComponent implements OnInit {

// variable
userName: string;
constructor(private authService: AuthService,
  private router: Router) { }

ngOnInit(): void {

  this.userName = localStorage.getItem("username");
  console.log(this.userName);
}

// logout
logout() {
  this.authService.logout();
  this.router.navigateByUrl("/login");
}

}
