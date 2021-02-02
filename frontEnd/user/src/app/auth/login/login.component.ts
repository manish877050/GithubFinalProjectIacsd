import { ToastrService } from 'ngx-toastr';
import { AuthService } from './../auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  email = '';
  password = '';
  constructor(
    private Router: Router,
    private AuthService: AuthService,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {}

  login() {
    console.log(this.email + '' + this.password);
    if (this.email.length === 0) {
      this.toastr.error('please enter email');
    } else if (this.password.length === 0) {
      this.toastr.error('please enter password');
    } else {
      this.AuthService.login(this.email, this.password).subscribe(
        (response) => {
          console.log(response);
          if (response.status === 'success') {
            sessionStorage.email = response.data.email;
            sessionStorage.userId = response.data.id;
            this.toastr.success(`Welcome  ${response.data.firstName}`);
            this.Router.navigate(['home/product/gallery']);
          } else {
            this.toastr.error(` ${response.messege} `);
            this.Router.navigate(['/auth/login']);
          }
        }
      );
    }
  }
}
