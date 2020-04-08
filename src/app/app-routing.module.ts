import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AddResourcetypeComponent } from './add-resourcetype/add-resourcetype.component';
import { ViewResourcetypeComponent } from './view-resourcetype/view-resourcetype.component';
import { UpdateResourcetypeComponent } from './update-resourcetype/update-resourcetype.component';
import { AddResourcedetailsComponent } from './add-resourcedetails/add-resourcedetails.component';
import { ViewResourcedetailsComponent } from './view-resourcedetails/view-resourcedetails.component';
import { UpdateResourcedetailsComponent } from './update-resourcedetails/update-resourcedetails.component';
import { ResourcedetailsComponent } from './resourcedetails/resourcedetails.component';
import { AddBookingComponent } from './add-booking/add-booking.component';
import { BookingdetailsComponent } from './bookingdetails/bookingdetails.component';
import { ViewBookingdetailsComponent } from './view-bookingdetails/view-bookingdetails.component';
import { BarChartComponent } from './bar-chart/bar-chart.component';
import { ViewReportComponent } from './view-report/view-report.component';
import { AddUserComponent } from './add-user/add-user.component';
import { MainadminComponent } from './mainadmin/mainadmin.component';
import { ManagerComponent } from './manager/manager.component';
import { CoordinatorComponent } from './coordinator/coordinator.component';
import { ViewUserComponent } from './view-user/view-user.component';
import { RegisterComponent } from './register/register.component';
import { MultiplequalificationComponent } from './multiplequalification/multiplequalification.component';
import { AddCourseComponent } from './add-course/add-course.component';


const routes: Routes = [

  { path: "", component: HomeComponent },
  { path: "home", component: HomeComponent },
  { path: "bookingForm/:resourceId", component: AddBookingComponent },
  { path: "login", component: LoginComponent },
  { path: "resourceDetails/:resourceId", component: ResourcedetailsComponent },

  {
    path: "coordinator", component: CoordinatorComponent,
    children: [
      { path: "addResourceType", component: AddResourcetypeComponent },
      { path: "viewResourceType", component: ViewResourcetypeComponent },
      { path: "updateResourceType/:resourceId", component: UpdateResourcetypeComponent },
      { path: "addResourceDetails", component: AddResourcedetailsComponent },
      { path: "viewResourceDetails", component: ViewResourcedetailsComponent },
      { path: "updateResourceDetails/:resourceId", component: UpdateResourcedetailsComponent },
      { path: "viewBookingDetails", component: ViewBookingdetailsComponent },
      { path: "bookingDetails/:bookingId", component: BookingdetailsComponent },
      { path: "updateResourceDetails/:resourceId", component: UpdateResourcedetailsComponent },
      { path: "addcourse", component: AddCourseComponent }


    ]
  },
  {
    path: "mainadmin", component: MainadminComponent,
    children: [
      { path: "adduser", component: AddUserComponent },
      { path: "viewuser", component: ViewUserComponent }
    ]
  },

  {
    path: "manager", component: ManagerComponent,
    children: [
      { path: "barChart/:resourceId", component: BarChartComponent },
      { path: "viewReport", component: ViewReportComponent }
    ]
  },
  {
    path: "registration", component: RegisterComponent,
    children: [
      { path: "mulQualification/:registrationId", component: MultiplequalificationComponent }]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
