import { Router } from '@angular/router';
import { OrderService } from './../order.service';
import { ToastrService } from 'ngx-toastr';
import { CartService } from '../cart.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  cart = this.CartService.getCart();
  total = this.CartService.getTotal();
  // tslint:disable-next-line: no-shadowed-variable
  constructor(
    private CartService: CartService,
    private toast: ToastrService,
    private OrderService: OrderService,
    private Router: Router
  ) {}

  ngOnInit(): void {
    console.log(`total ${this.total}`);
  }

  getTotal(): number {
    return this.CartService.getTotal();
  }

  updateQty(item: any, qty: number): void {
    this.CartService.findAndUpdateQty(item, qty);
  }

  remove(item): void {
    this.CartService.findAndRemoveProduct(item);
  }
  setTotal(): void {
    this.CartService.setTotal(0);
  }

  placeOrder(): void {
    this.OrderService.placeOrder(this.cart);
  }
}
