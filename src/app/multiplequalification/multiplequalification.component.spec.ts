import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MultiplequalificationComponent } from './multiplequalification.component';

describe('MultiplequalificationComponent', () => {
  let component: MultiplequalificationComponent;
  let fixture: ComponentFixture<MultiplequalificationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MultiplequalificationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MultiplequalificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
