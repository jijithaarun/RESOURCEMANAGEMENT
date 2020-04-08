import { TestBed } from '@angular/core/testing';

import { RoledetailsService } from './roledetails.service';

describe('RoledetailsService', () => {
  let service: RoledetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RoledetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
