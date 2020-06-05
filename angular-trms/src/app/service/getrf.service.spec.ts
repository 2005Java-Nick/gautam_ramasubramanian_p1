import { TestBed } from '@angular/core/testing';

import { GetrfService } from './getrf.service';

describe('GetrfService', () => {
  let service: GetrfService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetrfService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
