import { Component } from '@angular/core';

/*
Components in Angular are TS classes used to model
and provide functionality for small parts of an application 

Components, when created using the CLI, consist of 4 parts:
x.component.ts - the actual component class. Here is where 
functionality is provided 
x.component.spec.ts - unit tests for component. written in jasmine
x.component.html - TEMPLATE file for a component or the related 
HTML file that will serve as the view for the data provided in the component
x.component.css - style sheet for component

*/
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  //template: `<h1> This is my title {{ title }} </h1>`,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Genesis App';
}
