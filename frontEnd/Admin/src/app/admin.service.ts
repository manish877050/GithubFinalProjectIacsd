import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AdminService implements CanActivate {

  url = 'http://localhost:8080/admin'

  constructor(
    private router:Router,
    private httpclient:HttpClient) { }
 

  login(email:string  , password :string){
        const body = {

          email:email,
          password:password
        }
          return this.httpclient.post(this.url +"/signin"  , body)
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

    // user already logged in
    //launch the component
    if(sessionStorage['firstname'] && sessionStorage['lastname']){
      return true;
    }
    this.router.navigate(['/login'])
      //user has not loggin yet
      // do not launch the component 
      return false;
  }

}
