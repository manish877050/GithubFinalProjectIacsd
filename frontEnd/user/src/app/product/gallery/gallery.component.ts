import { title } from 'process';
import { ToastrService } from 'ngx-toastr';
import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.css'],
})
export class GalleryComponent implements OnInit {
  products = [];
  //cartProduct: Object = '';
  constructor(
    private service: ProductService,
    private toast: ToastrService,
    private CartService: CartService
  ) {}

  ngOnInit(): void {
    this.loadProducts();
  }
  loadProducts() {
    this.service.loadAllProduct().subscribe((response) => {
      console.log(response);
      if (response['status'] == 'success') {
        this.products = response['data'];
      } else {
        this.toast.error(`Oppps.. Something wrong here`);
      }
    });
  }
  addToCart(product, orderType) {
    this.CartService.addToCart(product, orderType);
  }
}
