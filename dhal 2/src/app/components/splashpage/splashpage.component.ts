import {Component, OnInit} from '@angular/core';
import {PlaylistService} from '../../services/playlist.service/playlist.service';
import {ApiService} from '../../services/api.service/api.service';
import {tracks} from '../../shared/tracks';
import {Playlist} from '../../shared/playlist';

@Component({
  selector: 'app-splashpage',
  templateUrl: './splashpage.component.html',
  styleUrls: ['./splashpage.component.sass']
})
export class SplashpageComponent implements OnInit {
  title = 'clientSide';
  playlist: Playlist = new Playlist();
  playlists: Playlist[] = [];
  trkId : number;
  lsttrk: any[] = [];
  lsttracks: tracks[] = [];
  trk: tracks = new tracks();
  // playlist: Playlist = new Playlist();
  public trackId = 0;
  user = JSON.parse(localStorage.getItem('userData'));



  constructor(private apiService: ApiService,
              private playlistService: PlaylistService) {
  }

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


    function moveToSelected(element) {
      if (element ==='next') {
        console.log(element);
        selected = (selected).next();
        console.log((selected).next);
      } else if (element == 'prev') {
        console.log(element)
        var selected = (selected).prev();
      } else {
        var selected = element;

      }

      var next = $(selected).next();
      var prev = $(selected).prev();
      var prevSecond = $(prev).prev();
      var nextSecond = $(next).next();

      $(selected).removeClass().addClass('selected');

      $(prev).removeClass().addClass('prev');
      $(next).removeClass().addClass('next');

      $(nextSecond).removeClass().addClass('nextRightSecond');
      $(prevSecond).removeClass().addClass('prevLeftSecond');

      $(nextSecond).nextAll().removeClass().addClass('hideRight');
      $(prevSecond).prevAll().removeClass().addClass('hideLeft');
    }

    // Eventos teclado
    $(document).keydown(function (e) {
      switch (e.which) {
        case 37: // left
          moveToSelected('prev');
          break;

        case 39: // right
          moveToSelected('next');
          break;

        default:
          return;
      }
      e.preventDefault();
    });

    $('#carousel div').click(function() {
      moveToSelected((this));
    });

    $('#prev').click(function () {
      moveToSelected('prev');
    });

    $('#next').click(function () {
      moveToSelected('next');
    });

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
        // console.log(data);
        var trk = data;
        this.lsttrk.push(trk);
      }
    );
    // console.log(this.lsttrk);
  }


  addToPlaylist(id) {
    this.playlist.playlistId = 0;
    this.playlist.ownerId = this.user.id;
    this.playlist.name = 'food';
    this.playlist.trackId = id;
    this.playlist.userPlaylistId = 6;
    // console.log(this.playlist);

    this.playlistService.addPlaylist(this.playlist).subscribe(
      resp => {
        // console.log('Adding to playlist 2');
        // console.log(resp);
        // console.log(this.playlist);
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
}



