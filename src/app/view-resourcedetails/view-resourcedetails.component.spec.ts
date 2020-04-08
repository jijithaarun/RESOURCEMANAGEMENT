import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewResourcedetailsComponent } from './view-resourcedetails.component';

describe('ViewResourcedetailsComponent', () => {
  let component: ViewResourcedetailsComponent;
  let fixture: ComponentFixture<ViewResourcedetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewResourcedetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewResourcedetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
