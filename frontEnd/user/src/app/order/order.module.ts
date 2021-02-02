import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OrderRoutingModule } from './order-routing.module';
import { HistoryComponent } from './history/history.component';
import { PreviewComponent } from './preview/preview.component';


@NgModule({
  declarations: [HistoryComponent, PreviewComponent],
  imports: [
    CommonModule,
    OrderRoutingModule
  ]
})
export class OrderModule { }
