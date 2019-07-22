import { TestBed } from '@angular/core/testing';

import { PhoneService } from './phone.service';

describe('PhoneService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PhoneService = TestBed.get(PhoneService);
    expect(service).toBeTruthy();
  });
});
