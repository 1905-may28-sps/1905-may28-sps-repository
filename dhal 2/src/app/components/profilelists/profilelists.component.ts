import { Component, OnInit } from '@angular/core';
import {Playlist} from '../../shared/playlist';

@Component({
  selector: 'app-profilelists',
  templateUrl: './profilelists.component.html',
  styleUrls: ['./profilelists.component.scss']
})
export class ProfilelistsComponent implements OnInit {
  playlists: Playlist[] = [];

  constructor() { }

  ngOnInit() {
  }
  // $('#location-button').click(function(){
  //
  //   if (navigator.geolocation) {
  //     alert('it is supported');
  //     navigator.geolocation.getCurrentPosition(function(position) {
  //       console.log(position);
  //       $.get( 'http://maps.googleapis.com/maps/api/geocode/json?latlng="+ position.coords.latitude + "," + position.coords.longitude +"&sensor=false', function(data) {
  //         console.log(data);
  //       })
  //       var img = new Image();
  //       img.src = 'https://maps.googleapis.com/maps/api/staticmap?center=' + position.coords.latitude + ',' + position.coords.longitude + '&zoom=13&size=800x400&sensor=false';
  //       $('#output').html(img);
  //     });
  //
  //   } else {
  //     console.log('geo location is not supported')
  //   }
  // })

}
