import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddResourcedetailsComponent } from './add-resourcedetails.component';

describe('AddResourcedetailsComponent', () => {
  let component: AddResourcedetailsComponent;
  let fixture: ComponentFixture<AddResourcedetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddResourcedetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddResourcedetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
