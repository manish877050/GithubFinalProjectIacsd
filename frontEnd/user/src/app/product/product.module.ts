import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import { CartComponent } from './cart/cart.component';
import { GalleryComponent } from './gallery/gallery.component';
import { ProductService } from './product.service';
import { CartService } from './cart.service';


@NgModule({
  declarations: [CartComponent, GalleryComponent],
  imports: [CommonModule, ProductRoutingModule, HttpClientModule, FormsModule],
  providers: [ProductService,CartService],
})
export class ProductModule {}
