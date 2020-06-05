import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginMessage } from '../interface/loginmessage.interface';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  completeUrl : string = environment.trmsUrl + environment.loginUrl;

  loginUser(username : string, password : string) : Observable<LoginMessage>  {
    let body : string = "username=" + username + "&password=" + password;
    return this.httpClient.post<LoginMessage>(this.completeUrl, body, {
      headers : {
        'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
      },
      withCredentials: true
    });

  }

  constructor(private httpClient : HttpClient) { }
}
