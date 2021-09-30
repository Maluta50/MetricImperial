import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MetricImperialUnitsComponent } from './metric-imperial-units.component';

describe('MetricImperialUnitsComponent', () => {
  let component: MetricImperialUnitsComponent;
  let fixture: ComponentFixture<MetricImperialUnitsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MetricImperialUnitsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MetricImperialUnitsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
