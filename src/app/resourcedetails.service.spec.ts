import { TestBed } from '@angular/core/testing';

import { ResourcedetailsService } from './resourcedetails.service';

describe('ResourcedetailsService', () => {
  let service: ResourcedetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResourcedetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
