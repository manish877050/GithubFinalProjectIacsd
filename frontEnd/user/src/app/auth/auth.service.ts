import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthService implements CanActivate {
  url = 'http://localhost:8080/user/';
  constructor(private router: Router, private httpClient: HttpClient) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    if (sessionStorage.email) {
      return true;
    }
    this.router.navigate(['auth/login']);
    return false;
  }

  login(email: string, password: string) {
    const body = {
      email: email,
      password: password,
    };

    return this.httpClient.post<any>(this.url + 'signin', body);
  }

  signup(firstName, lastName, email, password) {
    const body = {
      firstName: firstName,
      lastName: lastName,
      email: email,
      password: password,
    };
    console.log(`signup`);
    console.log(body);
    return this.httpClient.post<any>(this.url + 'signup', body);
  }
}
