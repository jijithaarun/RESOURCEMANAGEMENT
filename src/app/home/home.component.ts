import { Component, OnInit } from '@angular/core';
import { ResourcedetailsService } from '../resourcedetails.service';
import { Resourcedetails } from '../resourcedetails';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Resource } from '../resource';
import { ResourceService } from '../resource.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: string;
  pictureName: any;

  resourceType: Observable<Resource[]>;
  searchResource: FormGroup;
  resourceTypeId: number;

  resources: Observable<Resourcedetails[]>;

  constructor(private resourceDetailsService: ResourcedetailsService,
    private router: Router,private resourceService: ResourceService,
    private formBuilder:FormBuilder) { }

  ngOnInit(): void {
  
    this.getResourceDetails();
    this.getResources();
    this.searchResource = this.formBuilder.group({
      resourceTypeId: ['', Validators.required],
    });
    
  }

  // method to search
  onSubmit(){
    this.resourceTypeId= this.searchResource.controls.resourceTypeId.value;
    console.log(this.resourceTypeId)
    this.resources = this.resourceDetailsService.searchResourceActive(this.resourceTypeId);
  }

    // get resourcetype
    getResources() {
      this.resourceType = this.resourceService.getResourceList();
    }  

  // method to get all details
  getResourceDetails() {
    this.resources = this.resourceDetailsService.getActiveResources();
  
    console.log(this.resources);
  }


  getImage()
  {
    this.retrievedImage=this.resourceDetailsService.getResourceImage();
  }

  // method to view more details
  viewResource(resourceId: number){
    // link
    this.router.navigate(['/resourceDetails', resourceId]);
  }

}
