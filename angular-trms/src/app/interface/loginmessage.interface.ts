import { Message } from "./message.interface.ts";

export interface LoginMessage extends Message {
  employeeId: number;
}
