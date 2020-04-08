import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddResourcetypeComponent } from './add-resourcetype.component';

describe('AddResourcetypeComponent', () => {
  let component: AddResourcetypeComponent;
  let fixture: ComponentFixture<AddResourcetypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddResourcetypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddResourcetypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
