import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  showIf: boolean = true;
  numArr: number[] = [0, 1, 2, 3, 4, 5];

  constructor() { }

  ngOnInit() {
  }

  toggleShow(){
    this.showIf = !this.showIf;
  }

}
