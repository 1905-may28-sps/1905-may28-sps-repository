import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})


export class ApiService {

  constructor(private httpclient: HttpClient) {}
  gettracks(): Observable<any> {
    return this.httpclient.get('https://cors-anywhere.herokuapp.com/https://api.deezer.com/chart/0/tracks');
  }


  getalbums(): Observable<any> {
    return this.httpclient.get('https://cors-anywhere.herokuapp.com/https://api.deezer.com/chart/0/albums');
  }
  
  getsearch(searchvariable: string): Observable<any> {
    return this.httpclient.get(`https://cors-anywhere.herokuapp.com/https://api.deezer.com/search?q=artist:"${searchvariable}"`);
  }


  getartists(): Observable<any> {
    return this.httpclient.get('https://cors-anywhere.herokuapp.com/https://api.deezer.com/chart/0/artists');
  }


  getgenres(): Observable<any> {
    return this.httpclient.get('https://cors-anywhere.herokuapp.com/https://api.deezer.com/genre');
  }

  // getTrackById(id): Observable<any> {
  //   return this.httpclient.get(`https://deezerdevs-deezer.p.rapidapi.com/track/${id}`);
  // }

  getTrackById(id: any): Observable<any> {
    // return this.httpclient.get(`https://deezerdevs-deezer.p.rapidapi.com/track/${id}`);
    return this.httpclient.get(`https://cors-anywhere.herokuapp.com/https://api.deezer.com/track/${id}`);
  }

}
