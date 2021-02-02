import { Router } from '@angular/router';
import { AdminService } from './../admin.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  email = ''
  password = ''

  constructor(private router:Router,
    private adminService:AdminService) {

    
   }

  ngOnInit(): void {
  }


  onLogin(){
    this.adminService.login(this.email , this.password).
    subscribe(response =>{
      console.log(response)
      if(response['status'] == 'success'){
          //alert("welcome")
        const data = response['data']
       // sessionStorage['token'] = data['token']
        sessionStorage['firstname'] = data['firstName']
        sessionStorage['lastname']  = data['lastName']
        this.router.navigate(['/dashboard'])
      }else{
        alert("incorrect  username and password")
      }
    })

  }
}
