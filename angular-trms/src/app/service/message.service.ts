import { Injectable } from '@angular/core';
import { Message } from '../interface/message.interface';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
    
  message : Message;
  
  constructor() { }

  setMessage(message : Message) {
    this.message = message;
  }

  

  getMessage(message : Message) {
    return this.message;
  }

}
