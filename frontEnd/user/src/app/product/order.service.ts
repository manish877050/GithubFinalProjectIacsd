import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CartService } from './cart.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  url: string = 'http://localhost:8080/order';
  constructor(
    private CartService: CartService,
    private toast: ToastrService,
    private Router: Router
  ) {}
  placeOrder(order): any {
    this.toast.success(`order placed`);
    this.CartService.placedOrder = order;
    this.CartService.setCart(0);
    this.CartService.total = 0;
    this.Router.navigate([`/home/product/gallery`]);
  }
}
