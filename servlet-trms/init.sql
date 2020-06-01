create schema if not exists p1;

create table if not exists p1.employee ( 
	empId bigserial primary key,
	empFirstName varchar(20) not null,
	empLastName varchar(30) not null,
	empEmail varchar(20) not null,
	empUsername text not null,
	empPassword text not null,
	empPosition varchar(50) not null,
  empHireDate date not null,
  empBirthDate date,
  empAddress varchar(30),
  empCity varchar(20),
  empState varchar(20),
  empCountry varchar(20),
  empPostalCode varchar(10),
  empPhone varchar(20) not null,
  empDirectSup int,
  empDeptHead int,
  empBenCo int
);

alter table p1.employee add constraint u_empEmail unique(empEmail);
alter table p1.employee add constraint u_empPhone unique(empPhone);
alter table p1.employee add constraint u_username unique(empUsername);
alter table p1.employee add constraint fk_empDirectSup foreign key (empDirectSup) 
  references p1.employee(empId) on delete no action on update no action;
alter table p1.employee add constraint fk_empDeptHead foreign key (empDeptHead)
  references p1.employee(empId) on delete no action on update no action;
alter table p1.employee add constraint fk_empBenCo foreign key (empBenCo)
  references p1.employee(empId) on delete no action on update no action;

create table if not exists p1.reimbursedEvent (
  eventId bigserial primary key,
  eventType varchar(30) not null,
  eventDescription text,
  eventAddress varchar(30),
  eventCity varchar(20),
  eventState varchar(20),
  eventCountry varchar(20),
  eventPostalCode varchar(10),
  eventWorkDaysMissedStart date,
  eventWorkDaysMissedEnd date,
  eventCost money,
  eventReimbursementPercent numeric(2,0)
);


create table if not exists p1.reimbursementRequest ( 
  rrId bigserial primary key,
  rrRequester int,
  rrDateTimeOfRequest timestamp,
  rrEvent int,
  rrReimbursementAmount money,
  rrUrgent boolean,
  rrStatus varchar(20),
  rrStatusMessage text,
  rrGradingFormat varchar(20),
  rrGrade text
);

alter table p1.reimbursementRequest add constraint fk_rrRequester foreign key (rrRequester)
  references p1.employee(empId) on delete no action on update no action;

alter table p1.reimbursementRequest add constraint fk_rrEvent foreign key (rrEvent)
  references p1.reimbursedEvent(eventId) on delete no action on update no action;

create table if not exists p1.file (
  fileId bigserial primary key,
  fileName text,
  fileContent bytea,
  fileRR int
);

alter table p1.file add constraint fk_fileRR foreign key (fileRR)
  references p1.reimbursementRequest(rrId) on delete no action on update no action;

create table if not exists p1.approvalInfoChangeRequest (
  aicId bigserial primary key,
  aicRR int,
  aicOrder int,
  aicFrom int,
  aicTo int,
  aicType varchar(30),
  aicStatus varchar(20),
  aicMessage text
);

alter table p1.approvalInfoChangeRequest add constraint fk_aicRR foreign key (aicRR)
  references p1.reimbursementRequest(rrId) on delete no action on update no action;

alter table p1.approvalInfoChangeRequest add constraint fk_aicFrom foreign key (aicFrom)
  references p1.employee(empId) on delete no action on update no action;

alter table p1.approvalInfoChangeRequest add constraint fk_aicTo foreign key (aicTo)
  references p1.employee(empId) on delete no action on update no action;
