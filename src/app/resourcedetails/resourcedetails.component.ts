import { Component, OnInit } from '@angular/core';
import { ResourcedetailsService } from '../resourcedetails.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Resourcedetails } from '../resourcedetails';

@Component({
  selector: 'app-resourcedetails',
  templateUrl: './resourcedetails.component.html',
  styleUrls: ['./resourcedetails.component.scss']
})
export class ResourcedetailsComponent implements OnInit {

  resourceId: number;
  res: Resourcedetails;

  constructor(private resourceDetailsService: ResourcedetailsService,
    private route: ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    // getting value passed in url
    this.resourceId = this.route.snapshot.params['resourceId'];
  
    this.getResource();
  }
  
  getResource() {

    // search resourceby id
    this.resourceDetailsService.searchById(this.resourceId).subscribe(
      data => this.res = data,
      error => console.log(error)
    );
  }

  book(resourceId: number) {
    this.router.navigate(['/bookingForm',resourceId]);

  }

}
