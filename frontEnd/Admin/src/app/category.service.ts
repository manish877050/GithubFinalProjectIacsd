import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  url = 'http://localhost:8080/category'

  constructor(private httpClient:HttpClient) { }


  getCategory(){
  
    return this.httpClient.get(this.url)
}
}
