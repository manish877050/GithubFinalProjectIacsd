import { ProfileService } from './../profile.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  firstName = '';
  lastName = '';
  zip = '';
  country = '';
  email = '';
  phone = '';
  address = '';
  constructor(private ProfileService: ProfileService) {}

  ngOnInit(): void {
    this.ProfileService.getProfileDetails(sessionStorage.userId).subscribe(
      (response) => {
        this.firstName = response.data.firstName;
        this.lastName = response.data.lastName;
        this.phone = response.data.phone;
        this.email = response.data.email;
      }
    );
  }

  update(): void {}
}
