import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-http',
  templateUrl: './http.component.html',
  styleUrls: ['./http.component.css']
})
export class HttpComponent implements OnInit {
  users: User[] = [];

  constructor(private userService: UserService) { 
    console.log('in user service constructor')
  }

  ngOnInit() {
    this.getUsers();
    console.log('in user service onInit');
    console.log(this.users);
  }

  getUsers(){
    // here we will leverage our user service's get users method 
    // we will SUBSCRIBE to the observable that the method returns
    this.userService.getUsers().subscribe(
      //this about this method being like the function in onreadystatechange with AJAX
      resp => {
        if(resp != null){
          this.users = resp;
        }
        else{
          console.log('Error loading users, null value sent back')
        }
      },
      error => console.log('something unexpected happened')
    );
  }

}
