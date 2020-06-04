import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Message } from '../interface/message.interface';
import { Employee } from '../interface/employee.interface';
import { MessageService } from './message.service'; 
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SignupService {
  
  completeURL : string = environment.trmsUrl + environment.registerUrl;

  registerUser(employee : Employee) {
    let body : string = "firstname=" + employee.firstName + "&lastname=" + employee.lastName +
      "&email=" + employee.email + "&username=" + employee.username + "&password=" + employee.password + 
      "&type=" + employee.empType;
    let obsMessage : Observable<Message> = this.httpClient.post<Message>(this.completeURL, body, {
      headers : {
        'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
      }
    }).pipe(
      catchError(this.handleHttpClientError)
    )

    obsMessage.subscribe((message) => {
      this.messageService.setMessage(message);
    });
    
  }

  handleHttpClientError(error : HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      return of({
        successStatus: false,
        info: error.error.message
      });
    } else {
      return of({
        successStatus: false,
        info: `Error Code: ${error.status}, Error Body: ${error.error}`
      });
    }
  }

  constructor(private httpClient : HttpClient, private messageService : MessageService) { 
    
  }
}
