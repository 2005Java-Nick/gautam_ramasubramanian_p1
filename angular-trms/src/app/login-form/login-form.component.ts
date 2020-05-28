import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms'

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  header = "Login";

  loginForm = this.formBuilder.group({
    username: [null, Validators.required],
    password: [null, Validators.required]
  });

  constructor(private formBuilder : FormBuilder) { }

  ngOnInit(): void {
  }

  onSubmit() : void {
    console.log(this.loginForm.value);
  }

}
