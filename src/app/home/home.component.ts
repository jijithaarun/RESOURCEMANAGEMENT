import { Component, OnInit } from '@angular/core';
import { ResourcedetailsService } from '../resourcedetails.service';
import { Resourcedetails } from '../resourcedetails';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

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

  resources: Observable<Resourcedetails[]>;

  constructor(private resourceDetailsService: ResourcedetailsService,
    private router: Router) { }

  ngOnInit(): void {

    this.getResourceDetails();

  }

  // method to get all details
  getResourceDetails() {
    this.resources = this.resourceDetailsService.getActiveResources();

    console.log(this.resources);
  }



  // method to view more details
  viewResource(resourceId: number) {
    // link
    this.router.navigate(['/resourceDetails', resourceId]);
  }

}
