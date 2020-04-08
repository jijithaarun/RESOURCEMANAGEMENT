import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Roledetails } from '../roledetails';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { RoledetailsService } from '../roledetails.service';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {

  roleName: Observable<Roledetails[]>;
  addUser: FormGroup;
  addRoleDetails: FormGroup;
  user: User = new User();


  constructor(private roleDetailsService: RoledetailsService,
    private router: Router,
    private formBuilder: FormBuilder,
    private userService: UserService,
    private toastr:ToastrService) { }

  ngOnInit(): void {
    this.createForm();
    this.getRole();
  }


  createForm() {
    this.addUser = this.formBuilder.group({
      userName: ['', Validators.required],
      password: ['', Validators.required]
    });


    this.addRoleDetails = this.formBuilder.group({
      roleId: ['', Validators.required]
    });
  }
  getRole() {
    this.roleName = this.roleDetailsService.getRoleDetails();
  }

  onSubmit() {
    console.log(this.addUser.value);

    this.user.userName = this.addUser.controls.userName.value;
    this.user.password = this.addUser.controls.password.value;
    this.user.roleDetails = this.addRoleDetails.value;
    this.user.isActive = "Y";

    this.userService.addUser(this.user).subscribe(data=>console.log(data),error=>console.log(error));
    this.toastr.success('New user added Successfully','Creating user');
    this.router.navigateByUrl('/manager');
    
    if(this.user==null)
    {
      this.toastr.error('cannot add user');
    }
   

  }

}
