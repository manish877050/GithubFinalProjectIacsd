import { AuthService } from './../auth.service';
import { ToastrService } from 'ngx-toastr';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  firstName = '';
  lastName = '';
  email = '';
  password = '';
  constructor(private toastr: ToastrService, private service: AuthService) {}

  ngOnInit(): void {}

  signup() {
    this.toastr.info(`please wait`);

    this.service
      .signup(this.firstName, this.lastName, this.email, this.password)
      .subscribe((response) => {
        this.toastr.success(`user ${this.firstName} registerd`);
      });
  }
}
