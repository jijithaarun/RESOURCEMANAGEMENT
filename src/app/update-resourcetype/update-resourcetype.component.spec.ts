import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateResourcetypeComponent } from './update-resourcetype.component';

describe('UpdateResourcetypeComponent', () => {
  let component: UpdateResourcetypeComponent;
  let fixture: ComponentFixture<UpdateResourcetypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateResourcetypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateResourcetypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
