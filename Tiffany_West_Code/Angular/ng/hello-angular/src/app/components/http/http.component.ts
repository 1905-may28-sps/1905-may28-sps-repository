import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import  { User }        from 'src/app/models/user.model';

@Component({
  selector: 'app-http',
  templateUrl: './http.component.html',
  styleUrls: ['./http.component.css']
})
export class HttpComponent implements OnInit {
  users: User[] =[];




  constructor(private userService: UserService) {
    console.log('in user service constructor')
   }

  ngOnInit() {
    this.getUsers();
    console.log('in user service onInIt')
    //console.log(this.users);
  }

   getUsers(){
    //here we will leverage our user service's get users method ...
    this.userService.getUsers().subscribe(
      //think of this method being like the function in readystatechange with AJAX
      resp =>{
            if(resp != null){
              this.users = resp;
              console.log(this.users);

            }else{
              console.log('error loading users')
            }
      },
      error => console.log('you messed up sis')
    );
  }

}
