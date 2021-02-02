import { element } from 'protractor';
import { title } from 'process';
// tslint:disable-next-line: quotemark
import { ToastrService } from 'ngx-toastr';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  item = [];
  total = 0;
  placedOrder = [];
  constructor(private toast: ToastrService) {}

  // tslint:disable-next-line: typedef
  addToCart(product, orderType) {
    if (this.item.length === 0) {
      this.item.push(this.structureItem(product, orderType, 1));
      this.setTotalAmount(
        orderType === 'regular' ? product.price : product.price * 0.4
      );
      this.toast.success(`${product.title} Added To Cart `);
    } else {
      // structure product first
      product = this.structureItem(product, orderType, 1);
      // finding product in cart
      if (this.findAndUpdateQty(product, 1)) {
        this.toast.success(`${product.title} Qty Changed`);
      } else {
        this.item.push(this.structureItem(product, orderType, 1));
        this.setTotalAmount(
          orderType === 'regular' ? product.price : product.price * 0.4
        );
        this.toast.success(`${product.title} Added To Cart `);
      }
    }
  }

  // tslint:disable-next-line: typedef
  getCart() {
    return this.item;
  }

  // set product structure
  structureItem(product, orderType: string, qty: number): any {
    const cartItem = {
      id: product.id,
      product: product.id,
      title: product.title,
      price: orderType === 'regular' ? product.price : product.price * 0.4,
      image: product.image,
      type: orderType,
      qty: qty,
    };
    return cartItem;
  }

  // tslint:disable-next-line: typedef
  getTotal() {
    return this.total;
  }

  setTotal(price: number) {
    this.total = price;
  }

  setCart(value): void{
    this.item = value;
  }

  setTotalAmount(price: number): void {
    this.total += price;
  }

  findAndUpdateQty(product, qty: number): boolean {
    let result = false;
    let priceType: number = 0;
    this.item.forEach((element) => {
      if (element.id === product.id && element.type === product.type) {
        if ((element.qty === 1 && qty < 0) || (element.qty === 10 && qty > 0)) {
          this.toast.error(`Qty must be between 1 To 10`);
        } else {
          element.qty += qty;
          // setting price nature
          // i.e is it to be reduced or increase
          qty > 0 ? (priceType = 1) : (priceType = -1);
          product.orderType === 'regular'
            ? this.setTotalAmount(priceType * product.price)
            : this.setTotalAmount(priceType * product.price * 0.4);
          result = true;
        }
      }
    });
    return result;
  }

  // get index of item
  findIndex(product): number {
    return this.item.findIndex(
      (item) => item.id === product.id && item.type === product.type
    );
  }

  // update qty
  update(index, qty): void {
    if (
      this.item[index][' qty '] + qty > 0 &&
      this.item[index][' qty '] + qty <= 10
    ) {
      this.item[index][' qty '] += 1;
    } else {
      this.toast.error(`item qty should be between 1-10`);
    }
  }

  findAndRemoveProduct(product): void {
    this.item.forEach((item) => {
      if (item.id === product.id && item.type === product.type) {
        console.log(`match found`);
        this.item.splice(product, 1);
        this.total -= product.price;
        this.toast.success(`${product.title} removed from cart`);
      }
    });
  }
}
