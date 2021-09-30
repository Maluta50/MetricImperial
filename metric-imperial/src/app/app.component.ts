import { Component } from '@angular/core';
import { MetricimperialService } from 'src/app/services/metricimperial.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'metric-imperial';
  currentUnit = null;
  currentIndex = -1;
  units: any;


  constructor(private metricimperialService: MetricimperialService) { }

      ngOnInit(): void {
      this.retrieveMetricImperialUnits();
}

  retrieveMetricImperialUnits(): void {
    this.metricimperialService.getAll()
      .subscribe(
        data => {
          this.units = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
}
