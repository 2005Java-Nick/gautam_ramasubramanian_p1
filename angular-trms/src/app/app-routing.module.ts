import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginFormComponent } from './component/login-form/login-form.component'; 
import { RflistComponent } from './component/rflist/rflist.component';

const routes: Routes = [
  { path: "forms", component: RflistComponent },
  { path: "login", component: LoginFormComponent },
  { path: "", redirectTo: "/login", pathMatch: "full" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
