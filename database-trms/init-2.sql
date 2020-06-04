/********************************************************************
 * Project One Postgres Database Initialization Script
 * 
 * Task - Set up all functions and stored procedures 
 *          needed for project one
 ********************************************************************/

/********************************************************************
 * loginUser Function
 * This takes in a username and password
 * 		and outputs empId if employee with those details exist 
 * 			in the table
 * 		and -1 if employee with those details does not exist
 * 			in the table
 ********************************************************************/
create or replace function p1.loginUser(username text, passwd text)
	returns int
	as $$
		declare
			res int;
		begin
			select e.empId from p1.employee e into res
				where e.empUsername = username and e.empPassword = passwd;
			return res;
		end;
	$$ language plpgsql;

/********************************************************************
 * getRequestOrder Function
 * Helper Function - Not to be called directly but used in another function.
 * This outputs an integer that marks whether the employee id (called id)
 * 	is that of a employee, a supervisor, a department head 
 * 	or a benefits coordinator.
 ********************************************************************/
create or replace function p1.getRequestOrder(id int, eid int, sid int, hId int, bId int) 
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
 * getRequestHierarchy Function
 * 	Takes in as input the employee username and password
 * 	and outputs the details of the employee, his/her supervisor, 
 * 		the department head and the benefits coordinator
 * 		in that order (using the helper function above).
 ********************************************************************/
create or replace function p1.getRequestHierarchy(employeeId int) 
	returns table (empId int, empFirstName varchar(20), empLastName varchar(30), empEmail varchar(50),
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
				where e.empId = employeeId;
			return query select * from p1.employee e 
				where e.empId = eId or e.empId = sId or e.empId = hId or e.empId = bId
				order by p1.getRequestOrder(e.empId, eId, sId, hId, bId) asc;
		end;
	$$ language plpgsql;

/********************************************************************
 * getSupervisedEmployees Function
 * Takes in an employee ID and returns back a table (with one column)
 *  of ids of employees that need his or her approval for reimbursement
 *  Also outputs his or her employee id in that list (i.e. the input)
 ********************************************************************/
create or replace function p1.getSupervisedEmployees(eid int)
  returns table (empId int)
  as $$
    begin
      return query select e.empId from p1.employee e
        where e.empId = eid or e.empDirectSup = eid
          or e.empDeptHead = eid or e.empBenCo = eid;
    end;
  $$ language plpgsql;

/********************************************************************
 * getLastUpdateTimestamp Function
 * Takes in a reimbursementForm ID, looks through the AIC table
 *  and finds the time of last update - i.e. the DoneDateTime
 *  of the last completed AIC request connected to that 
 *  reimbursement Form
 ********************************************************************/
create or replace function p1.getLastUpdateTimestamp(rfid int)
  returns timestamp
  as $$
    declare
      ordernum int;
      res timestamp;
    begin
      select max(aicOrder) from p1.approvalInfoChangeRequest into ordernum
        where aicRF = rfid;
      if ordernum = 1 then
        select aicInitDateTime from p1.approvalInfoChangeRequest into res
          where aicRF = rfid and aicOrder = ordernum;
      else
        ordernum := ordernum - 1;
        select aicDoneDateTime from p1.approvalInfoChangeRequest into res
          where aicRF = rfid and aicOrder = ordernum;
      end if;
      return res;
    end;
  $$ language plpgsql;

/********************************************************************
 * getReimbursementForms Function
 * Takes in an employee id and looks through for reinbursement
 *  forms that you initiated as well as reimbursement forms that
 *  need your approval (initiated by subordinates)
 ********************************************************************/
create or replace function p1.getReimbursementForms(eid int)
  returns table(rfId int, rfRequester int, rfDateTimeOfRequest timestamp with time zone,
  rfEvent int, rfReimbursementAmount money, rfUrgent boolean, rfStatus varchar(20),
  rfStatusMessage text, rfGradingFormat varchar(20), rfGrade text)
  as $$
    begin
      return query select * from p1.reimbursementForm r
        where r.rfRequester in (select * from p1.getSupervisedEmployees(eid))
        order by p1.getLastUpdateTimestamp(r.rfId) desc; 
    end; 
  $$ language plpgsql; 
