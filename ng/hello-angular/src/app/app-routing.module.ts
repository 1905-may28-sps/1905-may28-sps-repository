import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  //list of route objects, these will correlate a component w a URL path
  { path: '', redirectTo: '/home', pathMatch: 'full'},//without a path where do i go
  { path: 'home', component: HomeComponent }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
