import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http:HttpClient) { }


  public findCourse(courseId: number): Observable<any> {
    return this.http.get(environment.apiurl + "/course-by-id/"+ courseId);
  }


  courseList():Observable<any>
  {
    return this.http.get(environment.apiurl+"/course");
  }
}
