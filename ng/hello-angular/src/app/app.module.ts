import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DataBindingComponent } from './components/data-binding/data-binding.component';

/*
Angular provides its own system of organizing code and funtionality. 
This is done with containers called modules 
A module is a cohesive block of code with a related set of capabilites
which have a specific application workflow 

All Angular apps have at least one module, called the root module, 
defined in the file app-module.ts
This module ties together all of our components and defines where
to start up (bootstrap) our application
*/

@NgModule({
  declarations: [
    AppComponent,
    DataBindingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
