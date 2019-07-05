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
  color: string = '#a3b79f';
  currentTime: Date;
  someNum = Math.random();

  constructor() {
    setInterval(
      () => {
        this.currentTime = new Date();
      }, 1000);
  }

  ngOnInit() {
  }

}
