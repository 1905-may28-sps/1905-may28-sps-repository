import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DataBindingComponent } from './components/data-binding/data-binding.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { TestComponent } from './components/test.component';
import { SquarerootPipe } from './pipes/squareroot.pipe';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { HttpComponent } from './components/http/http.component';
import { UserService } from './services/user.service';
import { PhoneAppComponent } from './components/phone-app/phone-app.component';
import { PhoneService } from './services/phone.service';

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

/*
DECORATOR - functions of TS that are used as annotations
that provide the class they decorate with metadata
@NgModule decorator indicates that the class below it is a module
and has very important elements
*/
@NgModule({
  declarations: [
    /*
    declarations array - holds classes that are 
    related to a view. There can be 3 types of classes 
    listed here -  components, directives, pipes
    */
    AppComponent,
    DataBindingComponent,
    DirectivesComponent,
    TestComponent,
    SquarerootPipe,
    NavbarComponent,
    HomeComponent,
    HttpComponent,
    PhoneAppComponent
  ],
  imports: [
    /*
    imports array - holds modules whose classes are needed
    by classes within this current module
    */
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  /**
   * exports: []
   * this array would hold classes that need to be accessible to the 
   * components of other modules. However this is our root module 
   * and we are not building other modules that need to consume
   * this, so it is empty. 
   *  ,*/
  providers: [
    /*
    Providers array holds services. these are classes decorated
    with @Injectable, and should be used thoughout the application 
    in many components
    */
   UserService,
   PhoneService
  ],
  bootstrap: /**
  Refers to the root component - where the bootstrapping 
  process will begin.  */
  [AppComponent]
})
export class AppModule { }
