import { Component, OnInit } from '@angular/core';
import { Resource } from '../resource';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ResourceService } from '../resource.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-resourcetype',
  templateUrl: './add-resourcetype.component.html',
  styleUrls: ['./add-resourcetype.component.scss']
})
export class AddResourcetypeComponent implements OnInit {

  resource: Resource;
  addResourceForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private resourceService: ResourceService,
    private router: Router,
    private toastr: ToastrService) { }

  ngOnInit(): void {
    this.createForm();
  }


  createForm() {

    this.addResourceForm = this.formBuilder.group({

      resourceType: ['', Validators.required]
    });
  }

  onSubmit() {
    //assigning values into resource from fromGroup
    this.resource = this.addResourceForm.value;
    console.log(this.resource);
    
    //calling method to insert
    this.resourceService.createResourceType(this.resource).subscribe(
      data=>console.log(data), error=> console.log(error)
    );
    this.toastr.success('New Resource Successfully Created','Creating ResourceType');
    this.router.navigateByUrl('/coordinator/viewResourceType');
  }
}
