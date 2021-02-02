import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  url = 'http://localhost:8080/brand'

  constructor(private httpClient:HttpClient) { }


  getBrand(){
    return this.httpClient.get(this.url)
}

  
}


