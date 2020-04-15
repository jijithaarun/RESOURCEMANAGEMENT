import { TestBed } from '@angular/core/testing';

import { BookingdetailsService } from './bookingdetails.service';

describe('BookingdetailsService', () => {
  let service: BookingdetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookingdetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
