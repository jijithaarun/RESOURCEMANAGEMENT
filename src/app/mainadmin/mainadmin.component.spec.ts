import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MainadminComponent } from './mainadmin.component';

describe('MainadminComponent', () => {
  let component: MainadminComponent;
  let fixture: ComponentFixture<MainadminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MainadminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MainadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
