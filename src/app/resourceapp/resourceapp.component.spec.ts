import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResourceappComponent } from './resourceapp.component';

describe('ResourceappComponent', () => {
  let component: ResourceappComponent;
  let fixture: ComponentFixture<ResourceappComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResourceappComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResourceappComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
