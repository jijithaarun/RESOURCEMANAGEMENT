import { Component, OnInit } from '@angular/core';
import { Registration } from '../registration';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';
import { Course } from '../course';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  register:Registration=new Registration();
  submitted=false;
  registerForm:FormGroup;
  registrationId:number;
  courses:Observable<Course[]>;
  registerFile:File;

  data:any;

  constructor(private formBuilder:FormBuilder,
    private router:Router,
    private registerService:RegistrationService,
    private toastr:ToastrService,
    private courseService:CourseService) { }

  ngOnInit(): void {
    this.createForm();
    this.getCourse();  
  }

  createForm()
  {
    this.registerForm = this.formBuilder.group({

      registrationId: ['', Validators.required],
      name: ['', Validators.required, Validators.pattern['^[a-zA-Z ]{3,30}$']],
      address: ['', Validators.required],
      district: ['', Validators.required],
      state: ['', Validators.required],
      pincode: ['', Validators.required],
      nationality: ['', Validators.required],
      phone: ['', Validators.required],
      gender: ['', Validators.required],
      dob: ['', Validators.required],
      email: ['', Validators.required, Validators.email],
      courseId: ['', Validators.required]
      // photo:['',Validators.required]
    })
  }

  onSubmit() {
    // this.submitted = true;
     this.register = new Registration();
     this.register.name = this.registerForm.controls.name.value;
     this.register.address = this.registerForm.controls.address.value;
     this.register.district = this.registerForm.controls.district.value;
     this.register.state = this.registerForm.controls.state.value;
     this.register.pincode = this.registerForm.controls.pincode.value;
     this.register.nationality = this.registerForm.controls.nationality.value;
     this.register.phone = this.registerForm.controls.phone.value;
     this.register.gender = this.registerForm.controls.gender.value;
     this.register.dateOfBirth = this.registerForm.controls.dob.value;
     this.register.email = this.registerForm.controls.email.value;
     this.register.courseId = this.registerForm.controls.courseId.value;
 
     //this.register.photo = this.registerForm.controls.phone.value;
 
     this.save();
 
   }

   onSelectFile(event) {
    const file = event.target.files[0];
    console.log(file);
    this.registerFile = file;
    console.log("picture file name", this.registerFile);

  }
 
   save() {

     /* const formData = new FormData();
      formData.append('resource', JSON.stringify(this.res));
     
      formData.append('file', this.resourceFile,this.resourceFile.name);
      

      this.resourceDetailsService.createResource(formData).subscribe((Response) => {
        console.log(Response);
        if (Response.status == 'error') {
          this.toastr.error('data not created', 'creating resource type');
          this.router.navigateByUrl('/coordinator/viewResourceDetails');
        }
        else {
          this.toastr.success('New Resource Successfully Created', 'Creating ResourceType');
          this.router.navigateByUrl('/coordinator/viewResourceDetails');
        }

      },
      error=>console.log(error));
    }*/
 
    const formData=new FormData();
    formData.append('registration',JSON.stringify(this.register));
    formData.append('file',this.registerFile,this.registerFile.name);

      this.registerService.registerAdd(formData)
     .subscribe(data => { this.data = data;
 
       console.log(data);
       this.registrationId = this.data.registrationId;
       this.router.navigate(['registerComponent/mulQualification/', this.registrationId]);
 
     this.toastr.success('Personal Details Added Successfully', 'Registration');
 
   }, error => console.log(error));
     //this.enquiryService.registerAdd(this.register).subscribe(data => console.log(data), error => console.log(error));
 
     //this.registrationId = this.data.registrationId;
     //console.log("after subscribing "+this.registrationId);
 
     //-----this.gotoQualification(this.data.registrationId);
 
 
    
 
 
 
   /*}
   gotoQualification(registrationId: number) {
     this.router.navigate(['registerComponent/mulQualification/', registrationId]);
     //this.router.navigate(['mulQualification']);    
   }
 */
 
   }


   getCourse()
   {
     this.courses=this.courseService.courseList();

   }
 
}
