  import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { S3Component } from './components/s3/s3.component';
import { Ec2Component } from './components/ec2/ec2.component';
import { Route53Component } from './components/route53/route53.component';
import { JenkinsComponent } from './components/jenkins/jenkins.component';
import { MavenComponent } from './components/maven/maven.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    S3Component,
    Ec2Component,
    Route53Component,
    JenkinsComponent,
    MavenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
