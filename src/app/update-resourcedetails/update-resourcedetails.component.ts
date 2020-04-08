import { Component, OnInit } from '@angular/core';
import { Resourcedetails } from '../resourcedetails';
import { ResourcedetailsService } from '../resourcedetails.service';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { Resource } from '../resource';
import { ResourceService } from '../resource.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-update-resourcedetails',
  templateUrl: './update-resourcedetails.component.html',
  styleUrls: ['./update-resourcedetails.component.scss']
})
export class UpdateResourcedetailsComponent implements OnInit {

  resourceId: number;
  res: Resourcedetails;
  editResourceForm: FormGroup;
  resourceType: Observable<Resource[]>;
  resource: Resourcedetails;
  addResourceType: FormGroup;

  constructor(private resourceDetailsService: ResourcedetailsService,
    private router: Router,
    private resourceService: ResourceService,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private toastr: ToastrService) { }

  ngOnInit(): void {

    // getting value passed in url
    this.resourceId = this.route.snapshot.params['resourceId'];
    console.log(this.resourceId);
    // local method calling
    this.creatForm();
    this.getResources();

    // search resourceby id
    this.resourceDetailsService.searchById(this.resourceId).subscribe(
      data => this.res = data,
      error => console.log(error)
    );
    console.log(this.res);
  }
  creatForm() {

    this.addResourceType = this.formBuilder.group({
      resourceTypeId: ['', Validators.required],
    });

    this.editResourceForm = this.formBuilder.group({
      resourceId: [''],
      resourceCapacity: ['', Validators.required],
      noOfSystems: ['', Validators.required],
      projector: ['', Validators.required],
      whiteBoard: ['', Validators.required],
      resourceRate: ['', Validators.required],

    });
  }

  getResources() {
    this.resourceType = this.resourceService.getResourceList();
    console.log(this.resourceType);
  }

  onSubmit() {

    //setting values
    this.res.resource = this.addResourceType.value;
    this.res.resourceCapacity = this.editResourceForm.controls.resourceCapacity.value;
    this.res.noOfSystems = this.editResourceForm.controls.noOfSystems.value;
    this.res.projector = this.editResourceForm.controls.projector.value;
    this.res.whiteBoard = this.editResourceForm.controls.whiteBoard.value;
    this.res.resourceRate = this.editResourceForm.controls.resourceRate.value;

    // calling method to update
    this.resourceDetailsService.updateResource(this.res).subscribe(
      data => console.log(data), error => console.log(error)
    );
    this.toastr.success('New Resource Successfully Updated', 'Updating ResourceType');
    this.router.navigateByUrl('/coordinator/viewResourceDetails');
  }

  
  deActivateResource(resourceId: number) {

    // search resourceby id
  /*  this.resourceDetailsService.searchById(resourceId).subscribe(
      data => this.resource = data,
      error => console.log(error)
    );*/

    // changing value of isactive
    this.res.isActive = "N";
    console.log(this.res);
    // calling update method
    this.resourceDetailsService.updateResource(this.res).subscribe(
      data => console.log(data),
      error => console.log(error)
    );
    this.toastr.success('Resource Successfully Deactivated', 'Resource Management');
    this.router.navigateByUrl('/coordinator/viewResourceDetails');
  }

  activateResource(resourceId: number) {

    // search resourceby id
   /* this.resourceDetailsService.searchById(resourceId).subscribe(
      data => this.resource = data,
      error => console.log(error)
    );*/

    // changing value of isactive
    this.res.isActive = "Y";

    // calling update method
    this.resourceDetailsService.updateResource(this.res).subscribe(
      data => console.log(data),
      error => console.log(error)
    );
    this.toastr.success('Resource Successfully Activated', 'Resource Management');
    this.router.navigateByUrl('/coordinator/viewResourceDetails');
  }

}
