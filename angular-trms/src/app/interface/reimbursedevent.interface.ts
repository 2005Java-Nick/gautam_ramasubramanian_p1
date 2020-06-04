export interface ReimbursedEvent {
  eventId : number;
  eventType : string;
  eventName : string;
  eventDescription : string;
  eventAddress : string;
  eventCity : string;
  eventState : string;
  eventCountry : string;
  eventPostalCode : string;
  eventStart : string;
  eventEnd : string;
  eventWorkDaysMissedStart : string;
  eventWorkDaysMissedEnd : string;
  eventCost : string;
  eventReimbursementPercent : number;
}
