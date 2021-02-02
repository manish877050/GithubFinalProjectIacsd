import { UserServiceService } from './../user-service.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

users = []

  constructor(private userServiceService:UserServiceService) { }

  ngOnInit(): void {
    this.loadUser()
  }

  loadUser(){

    this.userServiceService.getUsers().
    subscribe(response =>{
        console.log(response)
      if(response['status'] == 'success'){
          this.users = response['data']
      }else{
          console.log(response['error'])
      }
    })

  }



    toggleActive(user){
    this.userServiceService.toggleActiveUser(user)
    .subscribe(response =>{

      if(response['status'] == 'success'){
         this.loadUser()
      }else{
          console.log(response['error'])
      }
    })

  }

 

}
