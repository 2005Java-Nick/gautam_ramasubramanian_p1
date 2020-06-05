import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { LoginMessage } from '../interface/loginmessage.interface';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  completeUrl : string = environment.trmsUrl + environment.loginUrl;

  loginUser(username : string, password : string) {
    let body : string = "username=" + username + "&password=" + password;
    let obsMessage : Observable<LoginMessage> = this.httpClient.post<LoginMessage>(this.completeUrl, body, {
      headers : {
        'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
      },
      withCredentials: true
    })

    obsMessage.subscribe((message) => {
      console.log(message.successStatus);
      console.log(message.info);
      console.log(message.employeeId);
    });
 
  }

  constructor(private httpClient : HttpClient) { }
}
