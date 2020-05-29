import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginFormComponent } from './component/login-form/login-form.component'; 
import { SignupFormComponent } from './component/signup-form/signup-form.component'; 


const routes: Routes = [
  { path: "signup", component: SignupFormComponent },
  { path: "login", component: LoginFormComponent },
  { path: "", redirectTo: "/login", pathMatch: "full" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
