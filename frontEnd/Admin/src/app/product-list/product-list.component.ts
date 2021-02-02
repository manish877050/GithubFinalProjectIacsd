import { ProductService } from './../product.service';
import { Component, OnInit } from '@angular/core';
import { title } from 'process';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {


  products = []

  constructor(private productService:ProductService,
              private router:Router) { }

  ngOnInit(): void {
      this.loadProducts()
  }

  loadProducts(){
    this.productService.getProducts()
    .subscribe(response =>{
      if(response['status'] == 'success'){
        console.log(response)
        this.products = response['data']
      }else{
        console.log(response['error'])
      }
    })
  }

  


  toggleActive(products){
    this.productService.toggleActiveProduct(products)
    .subscribe(response =>{

      if(response['status'] == 'success'){
         this.loadProducts()
      }else{
          console.log(response['error'])
      }
    })
}

onEdit(product){
  this.router.navigate(['/add-product'] , {queryParams:{id:product['id']}})
}



uploadImage(product){
 
  this.router.navigate(['/upload-image'] , {queryParams:{id:product['id']}})
  

}

addProduct(){
 // this.router.navigate(['/add-product'])
}

}

