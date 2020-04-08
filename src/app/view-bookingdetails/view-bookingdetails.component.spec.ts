import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewBookingdetailsComponent } from './view-bookingdetails.component';

describe('ViewBookingdetailsComponent', () => {
  let component: ViewBookingdetailsComponent;
  let fixture: ComponentFixture<ViewBookingdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewBookingdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewBookingdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
