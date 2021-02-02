import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  url = 'http://localhost:8080/admin'
  constructor(private httpClient:HttpClient) { }


  getUsers(){

    //add the token to request header  
   return  this.httpClient.get(this.url + '/getuser')
  }
  

  toggleActiveUser(user){

    const httpheadaer = {
      headers: new HttpHeaders({
        token:sessionStorage['token']
      })

    }

    const body = {
      status:user['active']== 1 ? 0 : 1
    }
   return  this.httpClient.put(this.url + "/toogle-activate/"+ user['id'],body,httpheadaer)
  }

 }




