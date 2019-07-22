import { Component, OnInit } from '@angular/core';
import { Phone } from 'src/app/models/phone.model';
import { PhoneService } from 'src/app/services/phone.service';

@Component({
  selector: 'app-phone-app',
  templateUrl: './phone-app.component.html',
  styleUrls: ['./phone-app.component.css']
})
export class PhoneAppComponent implements OnInit {

  phones: Phone[] = [];

  constructor(private phoneService: PhoneService) { }

  ngOnInit() {
    this.getPhones();
  }

  getPhones(){
    this.phoneService.getAllPhones().subscribe(
      thisIsABody => {
        this.phones = thisIsABody;
      },
      error => console.log('something bad happened')
    );

  }

}
