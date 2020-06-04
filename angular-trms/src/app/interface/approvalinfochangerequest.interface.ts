export interface ApprovalInfoChangeRequest {
  aicId : number;
  aicRF : number;
  aicOrder : number;
  aicFrom : number;
  aicTo : number;
  aicType : string;
  aicStatus : string;
  aicMessage : string;
  aicInitDateTime : string;
  aicDoneDateTime : string;
}
