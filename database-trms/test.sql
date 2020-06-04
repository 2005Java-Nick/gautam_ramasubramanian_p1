/********************************************************************
 * Project One Postgres Database Mock Data and Testing Script
 * 
 * Task - Populate database with mock data for testing purposes
 ********************************************************************/

/********************************************************************
 * Insert Samirah Al-Abbas - The Associate Software Developer
 ********************************************************************/
INSERT INTO p1.employee (empFirstName, empLastName, empEmail, empUsername, empPassword, empPosition,
  empHireDate, empBirthDate, empAddress, empCity, empState, empCountry, empPostalCode,
  empPhone, empDirectSup, empDeptHead, empBenCo)
VALUES ('Samirah', 'Al-Abbas', 'samiam@gmail.com', 'samirah', 'valkerie', 'Associate Software Developer',
	'2019-05-04', '1992-08-18', '89 Main Street', 'Boston', 'MA', 'United States', '02101',
	'+1 (812)-734-1240', NULL, NULL, NULL);

/********************************************************************
 * Insert Magnus Chase - The Lead Software Developer
 ********************************************************************/
INSERT INTO p1.employee (empFirstName, empLastName, empEmail, empUsername, empPassword, empPosition,
  empHireDate, empBirthDate, empAddress, empCity, empState, empCountry, empPostalCode,
  empPhone, empDirectSup, empDeptHead, empBenCo)
VALUES ('Magnus', 'Chase', 'magnus@gmail.com', 'magnus-of-frey', 'valhalla', 'Lead Software Developer',
	'2017-05-04', '1995-01-13', null, 'Boston', 'MA', 'United States', '02111',
	'+1 (545)-723-1345', null, null, null);

/********************************************************************
 * Insert Percy Jackson - The Benefits Coordinator
 ********************************************************************/
INSERT INTO p1.employee (empFirstName, empLastName, empEmail, empUsername, empPassword, empPosition,
  empHireDate, empBirthDate, empAddress, empCity, empState, empCountry, empPostalCode,
  empPhone, empDirectSup, empDeptHead, empBenCo)
VALUES ('Percy', 'Jackson', 'percy.jackson@gmail.com', 'percy', 'poseidon04', 'Benefits Coordinator',
	'2015-05-04', '1995-08-18', '231 65th Street', 'New York', 'NY', 'United States', '10044',
	'+1 (801)-723-1234', NULL, NULL, NULL);

/********************************************************************
 * Insert Annabeth Chase - The Department Head
 ********************************************************************/
INSERT INTO p1.employee (empFirstName, empLastName, empEmail, empUsername, empPassword, empPosition,
  empHireDate, empBirthDate, empAddress, empCity, empState, empCountry, empPostalCode,
  empPhone, empDirectSup, empDeptHead, empBenCo)
VALUES ('Annabeth', 'Chase', 'chase_ann@outlook.com', 'annabeth', 'athena4life', 'Department Head',
	'2015-05-04', '1995-07-21', '21 Quiet Lane', 'Levittown', 'NY', 'United States', '11756',
	'+1 (123)-456-7890', NULL, NULL, null);

/********************************************************************
 * Set Magnus, Annabeth and Percy as Samirah's Supervisor, 
 * 	Dept Head and BenCo respectively
 ********************************************************************/
update p1.employee set empDirectSup = 2, empDeptHead = 4, empBenCo = 3 where empId = 1;

/********************************************************************
 * Set Annabeth and Percy as Magnus's 
 * 	Dept Head and BenCo respectively
 ********************************************************************/
update p1.employee set empDirectSup = 4, empDeptHead = 4, empBenCo = 3 where empId = 2;

/********************************************************************
 * Set Percy as Annabeth's BenCo
 ********************************************************************/
update p1.employee set empBenCo = 3 where empId = 4;

/********************************************************************
 * Test function - Should get back full info about
 * 	Samirah, Magnus, Annabeth and Percy in that order
 ********************************************************************/
select p1.loginUser('samirah', 'valkere');
select * from p1.getRequestHierarchy(p1.loginUser('samirah', 'valkerie'));

