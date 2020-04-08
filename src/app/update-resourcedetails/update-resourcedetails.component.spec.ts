import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateResourcedetailsComponent } from './update-resourcedetails.component';

describe('UpdateResourcedetailsComponent', () => {
  let component: UpdateResourcedetailsComponent;
  let fixture: ComponentFixture<UpdateResourcedetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateResourcedetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateResourcedetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
