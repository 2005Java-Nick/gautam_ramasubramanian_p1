import { Message } from "./message.interface";
import { ReimbursementForm } from "./reimbursementform.interface";

export interface RFMessage extends Message {
  forms : ReimbursementForm[]; 
}
