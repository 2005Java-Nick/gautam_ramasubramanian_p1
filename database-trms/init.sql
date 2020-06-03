/********************************************************************
 * Project One Postgres Database Initialization Script
 * 
 * Task - Set up all schemas, tables, and constraints 
 *          needed for project one
 * 
 ********************************************************************/

/********************************************************************
 * Create Project 1 Schema
 ********************************************************************/
create schema if not exists p1;

/********************************************************************
 * Create an Employee Table inside Project 1 Schema
 ********************************************************************/
create table if not exists p1.employee ( 
  empId bigserial primary key,
  empFirstName varchar(20) not null,
  empLastName varchar(30) not null,
  empEmail varchar(50) not null,
  empUsername text not null,
  empPassword text not null,
  empPosition varchar(50) not null,
  empHireDate date not null,
  empBirthDate date,
  empAddress varchar(50),
  empCity varchar(20),
  empState varchar(20),
  empCountry varchar(20),
  empPostalCode varchar(10),
  empPhone varchar(20) not null,
  empDirectSup int,
  empDeptHead int,
  empBenCo int
);

/********************************************************************
 * Set Email, Phone Number and Username to be unique entries
 ********************************************************************/
alter table p1.employee add constraint u_empEmail unique(empEmail);
alter table p1.employee add constraint u_empPhone unique(empPhone);
alter table p1.employee add constraint u_username unique(empUsername);


/********************************************************************
 * Every Employee has a Direct Supervisor, a Department Head
 * 	and a Benefits Coordinator
 ********************************************************************/
alter table p1.employee add constraint fk_empDirectSup foreign key (empDirectSup) 
  references p1.employee(empId) on delete no action on update no action;
alter table p1.employee add constraint fk_empDeptHead foreign key (empDeptHead)
  references p1.employee(empId) on delete no action on update no action;
alter table p1.employee add constraint fk_empBenCo foreign key (empBenCo)
  references p1.employee(empId) on delete no action on update no action;

/********************************************************************
 * Create a Event Table in the Project 1 Schema
 ********************************************************************/
create table if not exists p1.reimbursedEvent (
  eventId bigserial primary key,
  eventType varchar(30) not null,
  eventName text not null,
  eventDescription text,
  eventAddress varchar(50),
  eventCity varchar(20),
  eventState varchar(20),
  eventCountry varchar(20),
  eventPostalCode varchar(10),
  eventStart date,
  eventEnd date,
  eventWorkDaysMissedStart date,
  eventWorkDaysMissedEnd date,
  eventCost money,
  eventReimbursementPercent numeric(2,0)
);

/********************************************************************
 * Create a Reimbursement Request Table in Project 1 Schema
 ********************************************************************/
create table if not exists p1.reimbursementForm ( 
  rfId bigserial primary key,
  rfRequester int,
  rfDateTimeOfRequest timestamp with time zone,
  rfEvent int,
  rfReimbursementAmount money,
  rfUrgent boolean,
  rfStatus varchar(20),
  rfStatusMessage text,
  rfGradingFormat varchar(20),
  rfGrade text
);

/********************************************************************
 * Every Reimbursement Request is tied to an employee and an event
 ********************************************************************/
alter table p1.reimbursementForm add constraint fk_rfRequester foreign key (rfRequester)
  references p1.employee(empId) on delete no action on update no action;

alter table p1.reimbursementForm add constraint fk_rfEvent foreign key (rfEvent)
  references p1.reimbursedEvent(eventId) on delete no action on update no action;

/********************************************************************
 * Create a File Table for all uploaded binary files 
 * 	They will be stored as hexadecimal strings
 ********************************************************************/
create table if not exists p1.file (
  fileId bigserial primary key,
  fileName text,
  fileContent bytea,
  fileUploadDateTime timestamp with time zone,
  fileRF int
);

/********************************************************************
 * Make foreign key in File table to Reimbursement Request table
 ********************************************************************/
alter table p1.file add constraint fk_fileRF foreign key (fileRF)
  references p1.reimbursementForm(rfId) on delete no action on update no action;

/********************************************************************
 * Create Table for Approval, Info and Change "Requests"
 * 	(I call them requests but they are not the same as 
 * 		reimbursement requests)
 * An Approval Request is an entry that states that an employee
 * 	requested the direct supervisor (or Dept Head or Benefits Coordinator) 
 * 	to look over his/her reimbursement request and approve it
 * An Info Request is an entry that states that the supervisor
 * 	(or Dept Head or Benefits Coordinator) requested the employee
 * 	for more information before he/she could approve the reimbursement request
 * A Change Request is an entry that states that the supervisor
 * 	(or Dept Head or Benefits Coordinator) requested the employee
 * 	to change something in his/her reimbursement request before approval
 ********************************************************************/
create table if not exists p1.approvalInfoChangeRequest (
  aicId bigserial primary key,
  aicRF int,
  aicOrder int,
  aicFrom int,
  aicTo int,
  aicType varchar(30),
  aicStatus varchar(20),
  aicMessage text,
  aicInitDateTime timestamp with time zone,
  aicDoneDateTime timestamp with time zone
);

/********************************************************************
 * Every AIC (Approval Request, Info Request, Change Request) 
 * 	is attached to a Reimbursement Request.
 * It is initiated by an employee and is directed to another employee
 ********************************************************************/
alter table p1.approvalInfoChangeRequest add constraint fk_aicRF foreign key (aicRF)
  references p1.reimbursementForm(rfId) on delete no action on update no action;

alter table p1.approvalInfoChangeRequest add constraint fk_aicFrom foreign key (aicFrom)
  references p1.employee(empId) on delete no action on update no action;

alter table p1.approvalInfoChangeRequest add constraint fk_aicTo foreign key (aicTo)
  references p1.employee(empId) on delete no action on update no action;
