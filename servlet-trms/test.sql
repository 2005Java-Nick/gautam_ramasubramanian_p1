INSERT INTO p1.employee (empFirstName, empLastName, empEmail, empUsername, empPassword, empPosition,
  empHireDate, empBirthDate, empAddress, empCity, empState, empCountry, empPostalCode,
  empPhone, empDirectSup, empDeptHead, empBenCo)
VALUES ('Samirah', 'Al-Abbas', 'samiam@gmail.com', 'samirah', 'valkerie', 'Associate Software Developer',
	'2019-05-04', '1992-08-18', '89 Main Street', 'Boston', 'MA', 'United States', '02101',
	'+1 (812)-734-1240', NULL, NULL, NULL);

INSERT INTO p1.employee (empFirstName, empLastName, empEmail, empUsername, empPassword, empPosition,
  empHireDate, empBirthDate, empAddress, empCity, empState, empCountry, empPostalCode,
  empPhone, empDirectSup, empDeptHead, empBenCo)
VALUES ('Magnus', 'Chase', 'magnus@gmail.com', 'magnus-of-frey', 'valhalla', 'Lead Software Developer',
	'2017-05-04', '1995-01-13', null, 'Boston', 'MA', 'United States', '02111',
	'+1 (545)-723-1345', null, null, null);

INSERT INTO p1.employee (empFirstName, empLastName, empEmail, empUsername, empPassword, empPosition,
  empHireDate, empBirthDate, empAddress, empCity, empState, empCountry, empPostalCode,
  empPhone, empDirectSup, empDeptHead, empBenCo)
VALUES ('Percy', 'Jackson', 'percy.jackson@gmail.com', 'percy', 'poseidon04', 'Benefits Coordinator',
	'2015-05-04', '1995-08-18', '231 65th Street', 'New York', 'NY', 'United States', '10044',
	'+1 (801)-723-1234', NULL, NULL, NULL);

INSERT INTO p1.employee (empFirstName, empLastName, empEmail, empUsername, empPassword, empPosition,
  empHireDate, empBirthDate, empAddress, empCity, empState, empCountry, empPostalCode,
  empPhone, empDirectSup, empDeptHead, empBenCo)
VALUES ('Annabeth', 'Chase', 'chase_ann@outlook.com', 'annabeth', 'athena4life', 'Department Head',
	'2015-05-04', '1995-07-21', '21 Quiet Lane', 'Levittown', 'NY', 'United States', '11756',
	'+1 (123)-456-7890', NULL, NULL, null);


update p1.employee set empDirectSup = 2, empDeptHead = 4, empBenCo = 3 where empId = 1;
update p1.employee set empDirectSup = 4, empDeptHead = 4, empBenCo = 3 where empId = 2;
update p1.employee set empBenCo = 3 where empId = 4;

select * from p1.getRequestHierarchy('annabeth', 'athena4life');

/*
drop function getemployeeid; 
create or replace function getEmployeeId(argUsername text, argPassword text) returns int
	as $$
		declare
			res int;
		begin
			select empid from p1.employee e
				into res
				where e.empUsername = argUsername and e.empPassword = argPassword;
			return res;
		end;
	$$ language plpgsql;

drop function getdirectsupid;
create or replace function getDirectSupId(argUsername text, argPassword text) returns int
	as $$
		declare
			res int;
		begin
			select empDirectSup from p1.employee e
				into res
				where e.empUsername = argUsername and e.empPassword = argPassword;
			return res;
		end;
	$$ language plpgsql;

drop function getDeptHeadId;
create or replace function getDeptHeadId(argUsername text, argPassword text) returns int
	as $$
		declare
			res int;
		begin
			select empDeptHead from p1.employee e
				into res
				where e.empUsername = argUsername and e.empPassword = argPassword;
			return res;
		end;
	$$ language plpgsql;

drop function getBenCoId;
create or replace function getBenCoId(argUsername text, argPassword text) returns int
	as $$
		declare
			res int;
		begin
			select empBenCo from p1.employee e
				into res
				where e.empUsername = argUsername and e.empPassword = argPassword;
			return res;
		end;
	$$ language plpgsql;
	
select getEmployeeId('samirah', 'valkerie');
select getDirectSupId('samirah', 'valkerie');
select getDeptHeadId('samirah', 'valkerie');
select getBenCoId('samirah', 'valkerie');
*/

	
