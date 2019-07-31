import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {User} from '../../shared/model';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  url = environment.userUrl;
  reqOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  };


  constructor( private http: HttpClient) {}

  public  addUser( user: User) {
    console.log(user);
    user.authorId = user.id;
    user.raterId = user.id;
    console.log(this.url);
    return this.http.post<User>(`${this.url}/users`, user, this.reqOptions);
  }

  public logIn(user: User) {
    return this.http.post<User>(`${this.url}/login`, user, this.reqOptions );
  }

  public getUserById(id) {
    return this.http.get<User>(`${this.url}/users/id=${id}`);
  }

}




