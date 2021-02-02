import { FormsModule } from '@angular/forms';
import { GalleryComponent } from './gallery/gallery.component';
import { CartComponent } from './cart/cart.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

const routes: Routes = [
  { path: 'cart', component: CartComponent },
  { path: 'gallery', component: GalleryComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes), FormsModule, HttpClientModule],
  exports: [RouterModule],
})
export class ProductRoutingModule {}
