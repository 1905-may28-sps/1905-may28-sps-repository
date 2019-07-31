import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {User} from '../../shared/model';
import {UsersService} from '../../services/user.service/users.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {


  user: User = new User();
  dataSource: User = new User();

  constructor(private userService: UsersService, private router: Router) { }

  ngOnInit() {
  }

  signInUser() {

    console.log(`LOGGING IN ${this.user}`);

    this.userService.logIn(this.user).subscribe(
      resp => {
        console.log(resp);
        console.log(this.user);
        /* this.user.id = 0;
         this.user.email = '';
         this.user.firstName = '';
       */
        this.dataSource = resp;
        localStorage.setItem('userData', JSON.stringify(this.dataSource));
        this.user = new User();
        this.router.navigateByUrl('/dashboard');
      });

  }

  goToRegister() {
    this.router.navigateByUrl('/registration');

  }

}
