import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewResourcetypeComponent } from './view-resourcetype.component';

describe('ViewResourcetypeComponent', () => {
  let component: ViewResourcetypeComponent;
  let fixture: ComponentFixture<ViewResourcetypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewResourcetypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewResourcetypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
