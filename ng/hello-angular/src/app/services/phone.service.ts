import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { Phone } from '../models/phone.model';

@Injectable()
export class PhoneService {

  url = environment.phoneAppUrl;

  constructor(private http: HttpClient) { }

  public getAllPhones(): Observable<Phone[]>{
    return this.http.get<Phone[]>(`${this.url}/phone`)
  }


}
