import { Component, OnInit } from '@angular/core';
import { ResourceService } from '../resource.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Resource } from '../resource';

@Component({
  selector: 'app-view-resourcetype',
  templateUrl: './view-resourcetype.component.html',
  styleUrls: ['./view-resourcetype.component.scss']
})
export class ViewResourcetypeComponent implements OnInit {

  p: number = 1;
  resources: Observable<Resource[]>;

  constructor(private resourceService: ResourceService,
    private toastr: ToastrService,
    private router: Router) { }

  ngOnInit(): void {

    this.getResources();
  }
  getResources() {

    this.resources = this.resourceService.getResourceList();
    console.log(this.resources);
  }

  editResource(resourceId: number) {
    this.router.navigate(['/coordinator/updateResourceType', resourceId]);
  }

}
