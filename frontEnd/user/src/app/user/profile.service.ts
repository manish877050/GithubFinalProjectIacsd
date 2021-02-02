import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ProfileService {
  url = 'http://localhost:8080/user/';
  constructor(private HttpClient: HttpClient) {}

  getProfileDetails(id: number): any {
    return this.HttpClient.get(this.url + 'details/' + id);
  }
}
