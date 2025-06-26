import { TestBed } from '@angular/core/testing';

import { CirculerserviceService } from './circulerservice.service';

describe('CirculerserviceService', () => {
  let service: CirculerserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CirculerserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
