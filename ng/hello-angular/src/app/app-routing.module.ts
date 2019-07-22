import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { DataBindingComponent } from './components/data-binding/data-binding.component';
import { HttpComponent } from './components/http/http.component';
import { PhoneAppComponent } from './components/phone-app/phone-app.component';

const routes: Routes = [
  //list of route objects, these will correlate a component w a URL path
  { path: '', redirectTo: '/home', pathMatch: 'full'},//without a path where do i go
  { path: 'home', component: HomeComponent },
  { path: 'directives', component: DirectivesComponent },
  { path: 'binding', component: DataBindingComponent },
  { path: 'http', component: HttpComponent },
  { path: 'phone', component: PhoneAppComponent }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
