import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Resourcedetails } from '../resourcedetails';
import { ResourcedetailsService } from '../resourcedetails.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-report',
  templateUrl: './view-report.component.html',
  styleUrls: ['./view-report.component.scss']
})
export class ViewReportComponent implements OnInit {

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

  viewChart(resourceId: number){
    this.router.navigate(['/manager/barChart', resourceId]);
  }


}
