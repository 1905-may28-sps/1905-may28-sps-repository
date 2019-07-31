import { Injectable } from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpHeaders, HttpClient} from '@angular/common/http';
import {Playlist} from '../../shared/playlist';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlaylistService {

  url = environment.userUrl;
  requestOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  };

  constructor( private http: HttpClient) {}

  public addPlaylist( playlist: Playlist) {
    console.log(playlist);
    return this.http.post<Playlist>(`${this.url}/playlists`, playlist, this.requestOptions);
  }

  public getPlaylist(id): Observable<any>  {
    console.log(id);

    return this.http.get(`${this.url}/ownerPlaylists/ownerId=${id}`);
  }

}

