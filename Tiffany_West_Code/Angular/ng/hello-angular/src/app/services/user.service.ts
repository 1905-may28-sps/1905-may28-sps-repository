import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user.model';



//this is where i get an error when I take it out
@Injectable()
export class UserService {

  constructor(private http: HttpClient) { }

  url = 'http://localhost:8085/mybankapp/users';

  public getUsers(){
    return this.http.get<User[]>(this.url);
  }
}
