import { TestBed } from '@angular/core/testing';

import { AuthentifictionService } from './authentifiction.service';

describe('AuthentifictionService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AuthentifictionService = TestBed.get(AuthentifictionService);
    expect(service).toBeTruthy();
  });
});
