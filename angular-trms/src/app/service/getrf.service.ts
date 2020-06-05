import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RFMessage } from '../interface/rfmessage.interface';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GetrfService {

  completeUrl : string = environment.trmsUrl + environment.getrfUrl

  getRFs() : Observable<RFMessage> {
    return this.httpClient.post<RFMessage>(this.completeUrl, "", {
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
      },
      withCredentials: true
    });
  }

  constructor(private httpClient : HttpClient) { }



}
