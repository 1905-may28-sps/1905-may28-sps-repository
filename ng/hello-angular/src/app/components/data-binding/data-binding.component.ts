import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit {

  text: string = 'hello world';
  bool: boolean = true;
  count: number = 0;
  color: string = 'magenta';
  currentTime: Date;
  someNum = Math.random();
  obj = {
    name: 'gen', 
    age: 100
  }
  myName: string;

  constructor() {
    setInterval(
      () => {
        this.currentTime = new Date();
      }, 1000);
  }

  ngOnInit() {
  }

  incrementCount(){
    this.count++;
  }

}
