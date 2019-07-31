import {Component, Input, OnInit} from '@angular/core';
import {Playlist} from '../../shared/playlist';
import {ApiService} from '../../services/api.service/api.service';
import {PlaylistService} from '../../services/playlist.service/playlist.service';
import {tracks} from '../../shared/tracks';

@Component({
  selector: 'app-shortdashboard',
  templateUrl: './shortdashboard.component.html',
  styleUrls: ['./shortdashboard.component.scss']
})
export class ShortdashboardComponent implements OnInit {

  @Input() dashboardId: number;
  title = 'clientSide';
  playlist: Playlist = new Playlist();
  playlists: Playlist[] = [];
  trkId: number;
  lsttrk: any[] = [];


  constructor(private apiService: ApiService,
              private playlistService: PlaylistService) {
  }

  lsttracks: tracks[] = [];
  trk: tracks = new tracks();
  // playlist: Playlist = new Playlist();
  public trackId = 0;
  user = JSON.parse(localStorage.getItem('userData'));


  ngOnInit() {
    this.apiService.gettracks().subscribe(
      data => {
        this.lsttracks = data;
        // console.log(this.lsttracks);
        const res: tracks[] = [];
        for (const x in this.lsttracks) {
          for (let i = 0; i < data.total; i++) {
            this.lsttracks.hasOwnProperty(x) && res.push(this.lsttracks[x][i]);
          }
          this.lsttracks = res;
        }
        // console.log(this.lsttracks[0]);
      });
    // console.log(this);
    this.onReturnPlaylist();

  }

  onReturnPlaylist() {
    this.playlistService.getPlaylist(this.user.id).subscribe(
      resp => {
        // console.log(resp);
        this.playlists = resp;

        if (resp !== null) {
          this.playlists.forEach(arraryItem => {
            var trackid = arraryItem.trackId;
            // console.log(trackid);
            this.getTracks(trackid);
          });
        }
      });
  }

  getTracks(trackid) {
    this.apiService.getTrackById(trackid).subscribe(
      data => {
        var trk = data;
        this.lsttrk.push(trk);
      }
    );
    // console.log(this.lsttrk);
  }


  addToPlaylist(id) {
    this.playlist.playlistId = 0;
    this.playlist.ownerId = this.user.id;
    this.playlist.name = 'My Playlist';
    this.playlist.trackId = id;
    this.playlist.userPlaylistId = 6;
    // console.log(this.playlist);
    console.log(this.playlist);

    this.playlistService.addPlaylist(this.playlist).subscribe(
      resp => {
        this.playlist.playlistId = 0;
        this.playlist.ownerId = this.user.id;
        this.playlist.name = 'food';
        this.playlist.trackId = id;
      },
      error => {
        window.alert('Something went wrong, We could not create your playlist');
      }
    );
  }


  showInput() {
    document.getElementById('pickPlaylist').remove();
    document.getElementById('playlistName').removeAttribute('hidden');
    document.getElementById('addPlaylist').removeAttribute('hidden');
  }
}
