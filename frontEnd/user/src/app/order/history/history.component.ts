import { CartService } from './../../product/cart.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css'],
})
export class HistoryComponent implements OnInit {
  orderdProduct = [];
  constructor(private CartService: CartService) {}

  ngOnInit(): void {
    this.orderdProduct = this.CartService.placedOrder;
  }
}
