import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user.model';


/*
A service is a broad category encompassing any value, function, 
or feature that an app needs. A service is typically a class
with a narrow, well-defined purpose 

They are annotated with the @Injectable decorator, as they are
a primary example of the use of angulars application of 
Dependency Injection
*/

@Injectable({
  providedIn: 'root'
})
export class UserService {

    /* our first use of Dependency Injection!
  here, by declaring a private variable and defining its type, we are
  allowing Angular to inject an instance of an HttpClient so that 
  we can use it to send HTTP requests
  */
  constructor(private http: HttpClient) { }

  url = 'http://localhost:8081/bank-app/users';

  public getUsers(){
    return this.http.get<User[]>(this.url);
  }


}
