import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MetricImperialUnitsComponent } from './components/metric-imperial-units/metric-imperial-units.component';

const routes: Routes = [
  { path: '', redirectTo: 'metricimperial', pathMatch: 'full' },
  { path: 'metricimperial', component: MetricImperialUnitsComponent }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
