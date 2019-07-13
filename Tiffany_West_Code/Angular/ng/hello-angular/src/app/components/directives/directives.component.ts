import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  showIf: boolean = true;
  numArr: number[] = [0, 1, 2, 3, 4, 5];

  placeholder = 0;
  buttonClass = 'btn btn-warning';
  classList = ['primary', 'secondary', 'warning', 'danger',
  'light', 'dark'];
  employees = [
    {
      name: 'Genesis',
      role: 'Trainer'
    },
    {
      name: 'Patrick',
      role: 'Trainer'
    },
    {
      name: 'Peter',
      role: 'Trainer'
    },
    {
      name: 'Carolyn',
      role: 'Trainer'
    },
    {
      name: 'Fred',
      role: 'Trainer'
    },
    {
      name: 'Tiffany',
      role: 'Associate'
    },
    {
      name: 'Kemi',
      role: 'Associate'
    },
    {
      name: 'Housely',
      role: 'Associate'
    },
    {
      name: 'Henry',
      role: 'Associate'
    },
    {
      name: 'Kevin',
      role: 'Associate'
    }
  ];
  constructor() { }

  ngOnInit() {
  }

  toggleShow(){
    this.showIf = !this.showIf;
  }

  changeStyle(){
    this.placeholder++;
    // btn btn-primary, btn btn-secondary, etc
    this.buttonClass = `btn btn-${this.classList[this.placeholder%6]}`;
  }

}
