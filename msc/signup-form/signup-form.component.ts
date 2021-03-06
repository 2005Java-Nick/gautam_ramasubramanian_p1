import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Option } from '../../interface/option.interface';
import { Employee } from '../../interface/employee.interface';
import { SignupService } from '../../service/signup.service';

@Component({
  selector: 'app-signup-form',
  templateUrl: './signup-form.component.html',
  styleUrls: ['./signup-form.component.css']
})
export class SignupFormComponent implements OnInit {

  header : string = "Create Your Account";

  employeeOptions : Option[] = [
    { name: 'employee', label: 'Regular Employee' },
    { name: 'direct-supervisor', label: 'Supervisor' },
    { name: 'department-head', label: 'Department Head' },
    { name: 'benefits-coordinator', label: 'Benefits Coordinator' }
  ];

  signupForm : FormGroup = this.formBuilder.group({
    firstName: [null, Validators.required],
    lastName: [null, Validators.required],
    email: [null, Validators.required],
    username: [null, Validators.required],
    password: [null, Validators.required],
    empType: [null, Validators.required]
  });

  onSubmit() {
    let employee : Employee = this.signupForm.value;
    this.signupService.registerUser(employee);
  }

  constructor(private formBuilder : FormBuilder, private signupService : SignupService) { }

  ngOnInit(): void {
  }

}
