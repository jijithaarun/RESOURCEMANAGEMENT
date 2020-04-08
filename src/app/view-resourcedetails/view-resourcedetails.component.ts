import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ResourcedetailsService } from '../resourcedetails.service';
import { Resourcedetails } from '../resourcedetails';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-resourcedetails',
  templateUrl: './view-resourcedetails.component.html',
  styleUrls: ['./view-resourcedetails.component.scss']
})
export class ViewResourcedetailsComponent implements OnInit {

  p: number = 1;
  resources: Observable<Resourcedetails[]>;
 

  constructor(private resourceDetailsService: ResourcedetailsService,
    private router: Router) { }

  ngOnInit(): void {

    this.getResourceDetails();
  }

  getResourceDetails() {
    this.resources = this.resourceDetailsService.getResourceDetails();
  }

  editResource(resourceId: number) {
    this.router.navigate(['/coordinator/updateResourceDetails', resourceId]);
  }



}
