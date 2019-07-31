import { Component, OnInit } from '@angular/core';
import {albums} from '../../shared/album';
import {ApiService} from '../../services/api.service/api.service';

@Component({
  selector: 'app-album-list',
  templateUrl: './album-list.component.html',
  styleUrls: ['./album-list.component.scss']
})
export class AlbumListComponent implements OnInit {

  constructor(private _ApiService: ApiService) {

  }

  lstalbum: albums[] = [];


  ngOnInit() {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.

    this._ApiService.getalbums().subscribe(
      data => {
        this.lstalbum = data;
        console.log('in subscribe');
        console.log(this.lstalbum);
        var res2: albums[] = [];

        for (var x in this.lstalbum) {
          for (let i = 0; i < data.total; i++) {
            this.lstalbum.hasOwnProperty(x) && res2.push(this.lstalbum[x][i]);
          }

          this.lstalbum = res2;
        }
        console.log(this.lstalbum);
      });


  }
}
