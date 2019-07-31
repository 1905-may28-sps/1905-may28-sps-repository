import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import {SplashpageComponent} from './components/splashpage/splashpage.component';
import * as $ from 'jquery';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { ArtistListComponent } from './components/artist-list/artist-list.component';
import { TestmeComponent } from './testme/testme.component';
import { MainDashboardComponent } from './components/main-dashboard/main-dashboard.component';
import { AlbumpageComponent } from './components/albumpage/albumpage.component';
import { ShortdashboardComponent } from './components/shortdashboard/shortdashboard.component';
import {CommentsComponent} from './components/comments/comments.component';
import { ProfilelistsComponent } from './components/profilelists/profilelists.component';
import { CreatePlaylistComponent } from './components/create-playlist/create-playlist.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    RegistrationComponent,
    SignInComponent,
    DashboardComponent,
    SplashpageComponent,
    ProfilePageComponent,
    ArtistListComponent,
    TestmeComponent,
    MainDashboardComponent,
    AlbumpageComponent,
    ShortdashboardComponent,
    CommentsComponent,
    ProfilelistsComponent,
    CreatePlaylistComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
