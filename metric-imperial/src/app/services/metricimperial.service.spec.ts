import { TestBed } from '@angular/core/testing';

import { MetricimperialService } from './metricimperial.service';

describe('MetricimperialService', () => {
  let service: MetricimperialService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MetricimperialService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
