import { Message } from "./message.interface.ts";
import { ReimbursementForm } from "./reimbursementform.interface.ts";

export interface RFMessage extends Message {
  forms : ReimbursementForm[]; 
}
