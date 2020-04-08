import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Resource } from './resource';


@Injectable({
  providedIn: 'root'
})
export class ResourceService {

  constructor(private httpClient: HttpClient) { }

  //get all details
  getResourceList(): Observable<any> {
    return this.httpClient.get(environment.apiurl + "/resource");
  }

  //create resource type
  createResourceType(resource: Object): Observable<any> {
    return this.httpClient.post(environment.apiurl + "/resource", resource);
  }

  //search by id
  searchById(resourceId: number): Observable<any> {
    return this.httpClient.get(environment.apiurl + "/resource/" + resourceId);
  }

  //update resource type
  updateResourceType(resource: Resource): Observable<any> {
    return this.httpClient.put(environment.apiurl + "/resource", resource);
  }

}
