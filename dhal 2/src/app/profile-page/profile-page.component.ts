import { Component, OnInit } from '@angular/core';
import { Playlist } from '../shared/playlist';
import { tracks } from '../shared/tracks';
import { ApiService } from '../services/api.service/api.service';
import { PlaylistService } from '../services/playlist.service/playlist.service';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.scss']
})
export class ProfilePageComponent implements OnInit {
  playlist: Playlist = new Playlist();
  playlists: Playlist[] = [];
  trkId: number;
  lsttrk: any[] = [];
  lsttracks: tracks[] = [];
  trk: tracks = new tracks();
  name: string;
  // playlist: Playlist = new Playlist();
  public trackId = 0;
  user = JSON.parse(localStorage.getItem('userData'));


  constructor(private apiService: ApiService,
              private playlistService: PlaylistService) {
}



  ngOnInit() {
    this.onReturnPlaylist();

  }

  onReturnPlaylist() {
    this.playlistService.getPlaylist(this.user.id).subscribe(
      resp => {
        console.log(resp);
        console.log(resp[0].name);
        this.name = resp[0].name;
        this.playlists = resp;

        if (resp !== null) {
          this.playlists.forEach(arraryItem => {
            const trackid = arraryItem.trackId;
            // console.log(trackid);
            this.getTracks(trackid);
          });
        }
      });
  }

   getTracks(trackid) {
     this.apiService.getTrackById(trackid).subscribe(
       data => {
         // console.log(data);
         var trk = data;
         this.lsttrk.push(trk);
       }
     );
     // console.log(this.lsttrk);
   }

}
