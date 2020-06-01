/********************************************************************
 * Project One Postgres Database Initialization Script
 * 
 * Task - Set up all schemas, tables, functions and stored procedures
 * 			needed for project one
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
  eventDescription text,
  eventAddress varchar(50),
  eventCity varchar(20),
  eventState varchar(20),
  eventCountry varchar(20),
  eventPostalCode varchar(10),
  eventWorkDaysMissedStart date,
  eventWorkDaysMissedEnd date,
  eventCost money,
  eventReimbursementPercent numeric(2,0)
);

/********************************************************************
 * Create a Reimbursement Request Table in Project 1 Schema
 ********************************************************************/
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

/********************************************************************
 * Every Reimbursement Request is tied to an employee and an event
 ********************************************************************/
alter table p1.reimbursementRequest add constraint fk_rrRequester foreign key (rrRequester)
  references p1.employee(empId) on delete no action on update no action;

alter table p1.reimbursementRequest add constraint fk_rrEvent foreign key (rrEvent)
  references p1.reimbursedEvent(eventId) on delete no action on update no action;

/********************************************************************
 * Create a File Table for all uploaded binary files 
 * 	They will be stored as hexadecimal strings
 ********************************************************************/
create table if not exists p1.file (
  fileId bigserial primary key,
  fileName text,
  fileContent bytea,
  fileRR int
);

/********************************************************************
 * Make foreign key in File table to Reimbursement Request table
 ********************************************************************/
alter table p1.file add constraint fk_fileRR foreign key (fileRR)
  references p1.reimbursementRequest(rrId) on delete no action on update no action;

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
  aicRR int,
  aicOrder int,
  aicFrom int,
  aicTo int,
  aicType varchar(30),
  aicStatus varchar(20),
  aicMessage text
);

/********************************************************************
 * Every AIC (Approval Request, Info Request, Change Request) 
 * 	is attached to a Reimbursement Request.
 * It is initiated by an employee and is directed to another employee
 ********************************************************************/
alter table p1.approvalInfoChangeRequest add constraint fk_aicRR foreign key (aicRR)
  references p1.reimbursementRequest(rrId) on delete no action on update no action;

alter table p1.approvalInfoChangeRequest add constraint fk_aicFrom foreign key (aicFrom)
  references p1.employee(empId) on delete no action on update no action;

alter table p1.approvalInfoChangeRequest add constraint fk_aicTo foreign key (aicTo)
  references p1.employee(empId) on delete no action on update no action;
 

/********************************************************************
 * Helper Function - Not to be called directly but used in another function.
 * This outputs an integer that marks whether the employee id (called id)
 * 	is that of a employee, a supervisor, a department head 
 * 	or a benefits coordinator.
 ********************************************************************/
create or replace function p1.getRequestOrder(id bigint, eid int, sid int, hId int, bId int) 
  returns int
  as $$
    begin
      if id = eid then return 1;
      elsif id = sid then return 2;
      elsif id = hid then return 3;
      elsif id = bid then return 4;
      else return 0;
      end if;
    end;
  $$ language plpgsql;

/********************************************************************
 * Function getRequestHierarchy
 * 	Takes in as input the employee username and password
 * 	and outputs the details of the employee, his/her supervisor, 
 * 		the department head and the benefits coordinator
 * 		in that order (using the helper function above).
 ********************************************************************/
create or replace function p1.getRequestHierarchy(argUsername text, argPassword text) 
	returns table (empId bigint, empFirstName varchar(20), empLastName varchar(30), empEmail varchar(50),
  empUsername text, empPassword text, empPosition varchar(50), empHireDate date, empBirthDate date,
  empAddress varchar(50), empCity varchar(20), empState varchar(20), empCountry varchar(20), empPostalCode varchar(10),
  empPhone varchar(20), empDirectSup int, empDeptHead int, empBenCo int)
	as $$
		declare
			eId int;
			sId int;
			hId int;
			bId int;
		begin
			select e.empId, e.empDirectSup, e.empDeptHead, e.empBenCo from p1.employee e 
				into eId, sId, hId, bId  
				where e.empUsername = argUsername and e.empPassword = argPassword;
			return query select * from p1.employee e 
				where e.empId = eId or e.empId = sId or e.empId = hId or e.empId = bId
				order by p1.getRequestOrder(e.empId, eId, sId, hId, bId) asc;
		end;
	$$ language plpgsql;
