import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  url = 'http://localhost:8080/product/';

  constructor(private HttpCilent: HttpClient) {}

  loadAllProduct() {
    return this.HttpCilent.get(this.url, { responseType: 'json' });
  }
}
