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

	
