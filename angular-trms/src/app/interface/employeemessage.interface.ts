import { Message } from "./message.interface.ts";
import { Employee } from "./employee.interface.ts";

export interface EmployeeMessage extends Message {
  requestHierarchy : Employee[]; 
}
