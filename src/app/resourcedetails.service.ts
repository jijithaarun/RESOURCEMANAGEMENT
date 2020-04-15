import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResourcedetailsService {

  deactivate: string = "N";
  constructor(private httpClient: HttpClient) { }

  //create resource type
  /*createResource(resource: Object): Observable<any> {
    console.log("Service");
    console.log(resource);
    return this.httpClient.post(environment.apiurl + "/resourcedetails", resource);
  }*/

  createResource(formData: FormData): Observable<any> {
    console.log("Service");
    console.log(formData);
    return this.httpClient.post(environment.apiurl + "/resourcedetails", formData);
  }

  //view all resourceDetails
  getResourceDetails(): Observable<any> {
    return this.httpClient.get(environment.apiurl + "/resourcedetails");
  }

  //search by id
  searchById(resourceId: number): Observable<any> {
    return this.httpClient.get(environment.apiurl + "/resourcedetails-id/" + resourceId);
  }
  
  updateResource(resource: Object): Observable<any>{
    return this.httpClient.put(environment.apiurl + "/resourcedetails", resource);
  }

  getActiveResources() : Observable<any>{
    return this.httpClient.get(environment.apiurl + "/resourcedetails-isactive");
    
  }

  getResourceImage():Observable<any>
  {
    return this.httpClient.get(environment.apiurl+"/resourcedetails-image")
  }
}
