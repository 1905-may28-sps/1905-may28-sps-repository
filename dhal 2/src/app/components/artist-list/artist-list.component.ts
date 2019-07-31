import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service/api.service';

@Component({
  selector: 'app-artist-list',
  templateUrl: './artist-list.component.html',
  styleUrls: ['./artist-list.component.scss']
})
export class ArtistListComponent implements OnInit {
  userinput: string;
  lsttracks;
  // inject apiservice
  constructor(private apiService: ApiService) {}

  ngOnInit() {
   this.apiService.getalbums().subscribe(
     info => {
      // console.log(info.data);
     })

  }

  onClickMe(){
    
    this.apiService.getsearch(this.userinput).subscribe(
      results => {
        this.lsttracks = results.data;
        
      });
    
  }

}
