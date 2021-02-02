import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { HistoryComponent } from './history/history.component';
import { PreviewComponent } from './preview/preview.component';

const routes: Routes = [
  {path:'history',component:HistoryComponent},
  {path:'preview',component:PreviewComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes), FormsModule, HttpClientModule],
  exports: [RouterModule],
})
export class OrderRoutingModule {}
