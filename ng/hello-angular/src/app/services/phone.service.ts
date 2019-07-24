import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { Phone } from '../models/phone.model';

@Injectable()
export class PhoneService {

  url = environment.phoneAppUrl;
  reqOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'}) 
  };

  constructor(private http: HttpClient) { }

  public getAllPhones(): Observable<Phone[]>{
    return this.http.get<Phone[]>(`${this.url}/phone`)
  }

  //POST! 
  public addPhone(phone: Phone){
   // this.reqOptions.headers.append('test', 'test'); //if you have more headers
    return this.http.post<Phone>(`${this.url}/phone`, phone, this.reqOptions );
  }


}
