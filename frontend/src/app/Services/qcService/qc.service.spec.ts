import { TestBed } from '@angular/core/testing';

import { QcService } from './qc.service';

describe('QcService', () => {
  let service: QcService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(QcService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
