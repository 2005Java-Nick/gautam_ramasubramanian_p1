export interface ReimbursementForm {
  rfId : number;
  rfRequester : number;
  rfDateTimeOfRequest : string;
  rfEvent : number;
  rfReimbursementAmount : string;
  rfUrgent : boolean;
  rfStatus : string;
  rfStatusMessage : string;
  rfGradingFormat : string;
  rfGrade : string;
}
