import { BrandService } from './../brand.service';
import { CategoryService } from './../category.service';
import { ProductService } from './../product.service';
import { title } from 'process';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {


  title = ''
  description = ''
  price = 0

  product = {}
  
  products = null
  category = 0
  brand  = 0

  categories = []
  brands = []
 


  constructor(private router:Router,
    private activatedRoute:ActivatedRoute
    ,private productService:ProductService,
    private categoryService:CategoryService,
    private brandService:BrandService) { }

  ngOnInit(): void {

    this.getBrand()
    this.getCategory()
    
    const id = this.activatedRoute.snapshot.queryParams['id']
    if(id){
      this.productService.getProductsdetails(id).
      subscribe(response=>{
        if(response['status'] = 'success'){
          //console.log(response)
          const Products = response['data']
          //console.log(Products)
          this.product = Products
          if(this.product){
          //const product = Products
          console.log(this.product)
          this.title = this.product['title']
          this.price = this.product['price']
          this.category = this.product['category']['id']
          this.brand = this.product['brand']['id']
          this.description = this.product['description']
          }
        }
          
          

          
          
          
        
        //}
      }) 
    }
 }

  onUpdate(){
      //if product exists then update h
      this.productService.updateProduct(this.product['id'],this.title,this.price , this.brand , this.category ,this.description)
      .subscribe(response=>{
          console.log(response) 
       if(response['status'] == 'success'){
           this.router.navigate(['/product-list'])
       }else{
             console.log(response['error'])
             console.log(this.categories)
       }
      }) 

    }
  


  getCategory(){

    this.categoryService.getCategory().
    subscribe(response=>{
      if(response['status'] == 'success'){
        this.categories = response['data']
      }else{
        console.log(response['error'])
      }
    })

  }
  getBrand(){

    this.brandService.getBrand().
    subscribe(response=>{
      if(response['status'] == 'success'){
        this.brands = response['data']
      }else{
        console.log(response['error'])
      }
    })

  }



}
