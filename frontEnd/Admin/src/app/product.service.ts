import { CategoryService } from './category.service';
import { title } from 'process';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class ProductService {


  url = 'http://localhost:8080/product'

  constructor(private httpClient:HttpClient) { }


  getProducts(){
   
   return  this.httpClient.get(this.url +"/get")
  }



  updateProduct(id,title:string,price:number ,brand:number ,category:number , description:string){

     const body = {
      title:title,
      brand:{
        id:brand  
      },
      category:{
          id:category
      },
      description:description

    }
  

    //console.log(category)
   return  this.httpClient.put(this.url + '/' +id , body)
  }


  getProductsdetails(id){
    
    return  this.httpClient.get(this.url + "/details/"+id)
   }
 


  insertProduct(title :string  , price:number , description:string, category:number, brand:number){

    const body = {
       title:title,
       description:description,
       price:price,
       category:category,
       brand:brand

    }
  
   return  this.httpClient.post(this.url + '/create' , body)
  }






  toggleActiveProduct(products){
    const body = {}
   return this.httpClient.put(this.url + `/update-state/${products['id']}/${products['isActive'] == 0 ? 1: 0}` , body)
  }



 
  
  uploadImage(id ,file){
    
    const body = new FormData
    body.append('file',file)
    return this.httpClient.post(this.url + `/upload-image/`+id , body)


  }


}