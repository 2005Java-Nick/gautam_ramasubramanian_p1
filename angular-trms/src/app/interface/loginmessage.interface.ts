import { Message } from "./message.interface";

export interface LoginMessage extends Message {
  employeeId: number;
}
