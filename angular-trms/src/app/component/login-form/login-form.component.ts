import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../../service/login.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  header = "Sign In";

  loginForm = this.formBuilder.group({
    username: [null, Validators.required],
    password: [null, Validators.required]
  });

  constructor(private formBuilder : FormBuilder, private loginService : LoginService, private router : Router) { }

  ngOnInit(): void {
  }

  onSubmit() : void {
    let username : string = this.loginForm.value.username;
    let password : string = this.loginForm.value.password;

    this.loginService.loginUser(username, password).subscribe((message) => {
      console.log(message);
      if (message.successStatus) {
         this.router.navigate(["/forms"]);
      } 
    });
  }

}
