import { Component, OnInit } from '@angular/core';
import { ResourceService } from '../resource.service';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Resource } from '../resource';

@Component({
  selector: 'app-update-resourcetype',
  templateUrl: './update-resourcetype.component.html',
  styleUrls: ['./update-resourcetype.component.scss']
})
export class UpdateResourcetypeComponent implements OnInit {

  resourceId: number;
  editResourceForm: FormGroup;
  resource: Resource;

  constructor(private resourceService: ResourceService,
    private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private toastr: ToastrService) { }

  ngOnInit(): void {
    // getting value passed in url
    this.resourceId = this.route.snapshot.params['resourceId'];

    // local method calling
    this.creatForm();

    //search by id
    this.resourceService.searchById(this.resourceId).subscribe(
      data => this.resource = data,
      error => console.log(error)
    );

    console.log(this.resource);
  }

  creatForm() {
    this.editResourceForm = this.formBuilder.group({
      resourceTypeId: [''],
      resourceType: ['', Validators.required]
    });
  }

  onSubmit() {
    //assigning values into resource from fromGroup
    this.resource = this.editResourceForm.value;
    console.log(this.resource);

    //calling method to insert
    this.resourceService.updateResourceType(this.resource).subscribe(
      data=>console.log(data), error=> console.log(error)
    );
    this.toastr.success('New Resource Successfully Created', 'Creating ResourceType');
    this.router.navigateByUrl('/coordinator/viewResourceType');
  }

}
