import { Component, OnInit } from '@angular/core';
import { Phone } from 'src/app/models/phone.model';
import { PhoneService } from 'src/app/services/phone.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-phone-app',
  templateUrl: './phone-app.component.html',
  styleUrls: ['./phone-app.component.css']
})
export class PhoneAppComponent implements OnInit {

  phones: Phone[] = [];

  phone: Phone = new Phone();


  constructor(private phoneService: PhoneService, private router: Router) { }

  ngOnInit() {
    this.getPhones();
  }

  getPhones(){
    this.phoneService.getAllPhones().subscribe(
      thisIsABody => {
        console.log(thisIsABody);
        this.phones = thisIsABody;
      },
      error => console.log('something bad happened')
    );

  }

  addPhone(){
    console.log(this.phone);
    //validate that all fields are filled in 
    this.phoneService.addPhone(this.phone).subscribe(
      resp => {
          console.log(resp);
          this.phones.push(resp);
          this.phone.version = '';
          this.phone.brand = '';
      },
      error=>{
        console.log('could not post phone');
      }
    )
   
  }

  differentRoute(){
    this.router.navigateByUrl('/home');
  }

  test(p: Phone){
    console.log(p);
  }

  testing(){
    console.log("HI")
  }

}

