/********************************************************************
 * Project One Postgres Database Mock Data and Testing Script
 * 
 * Task - Populate database with mock data for testing purposes
 ********************************************************************/

/********************************************************************
 * Insert Algorithms Course under events
 ********************************************************************/
insert into p1.reimbursedEvent (eventType, eventName, eventDescription, eventAddress, 
	eventCity, eventState, eventCountry, eventPostalCode, eventStart, eventEnd, 
	eventWorkDaysMissedStart, eventWorkDaysMissedEnd, eventCost, eventReimbursementPercent)
values ('Course', 'CSC 211 (CCNY)', 'Algorithms Course in City College of New York', '160 Convent Ave',
	'New York', 'NY', 'United States', '10031', '2020-09-05', '2020-12-23', null, null, '$6125.00', 80);
	
/********************************************************************
 * Insert DockerCon under events
 ********************************************************************/
insert into p1.reimbursedEvent (eventType, eventName, eventDescription, eventAddress, 
	eventCity, eventState, eventCountry, eventPostalCode, eventStart, eventEnd, 
	eventWorkDaysMissedStart, eventWorkDaysMissedEnd, eventCost, eventReimbursementPercent)
values ('Conference', 'DockerCon', 'Docker Conference', '747 Howard Street', 'San Francisco', 
	'CA', 'United States', '94103', '2020-06-15', '2020-06-18', '2020-06-15', '2020-06-18', '$2000.00', 30);

/******************************************************************************************************************/

/********************************************************************
 * Insert a reimbursement form created by Samirah
 * 	in order to get reimbursed for DockerCon
 ********************************************************************/
insert into p1.reimbursementForm (rfRequester, rfDateTimeOfRequest, rfEvent, rfReimbursementAmount, 
	rfUrgent, rfStatus, rfStatusMessage, rfGradingFormat, rfGrade)
values (1, '2020-06-05', 2, '$600.00', true, 'Pending', 'Approved', 'Presentation', null);

/********************************************************************
 * Insert Samirah asking Magnus for approval for DockerCon
 ********************************************************************/
insert into p1.approvalInfoChangeRequest (aicRF, aicOrder, aicFrom, aicTo, aicType, aicStatus,
	aicMessage, aicInitDateTime, aicDoneDateTime)
values (1, 1, 1, 2, 'Approval', 'Done', '', '2020-06-05 10:05:06 EST', '2020-06-05 11:55:06 EST');

/********************************************************************
 * Insert Samirah asking Annabeth for approval for DockerCon
 ********************************************************************/
insert into p1.approvalInfoChangeRequest (aicRF, aicOrder, aicFrom, aicTo, aicType, aicStatus,
	aicMessage, aicInitDateTime, aicDoneDateTime)
values (1, 2, 1, 4, 'Approval', 'Done', '', '2020-06-05 11:55:06 EST', '2020-06-05 14:44:06 EST');

/********************************************************************
 * Insert Samirah asking Percy for approval for DockerCon
 ********************************************************************/
insert into p1.approvalInfoChangeRequest (aicRF, aicOrder, aicFrom, aicTo, aicType, aicStatus,
	aicMessage, aicInitDateTime, aicDoneDateTime)
values (1, 3, 1, 3, 'Approval', 'Done', '', '2020-06-05 14:44:06 EST', '2020-06-05 17:01:06 EST');

/******************************************************************************************************************/

/********************************************************************
 * Insert a reimbursement form created by Magnus
 * 	in order to get reimbursed for DockerCon
 ********************************************************************/
--insert into p1.reimbursementForm (rfRequester, rfDateTimeOfRequest, rfEvent, rfReimbursementAmount, 
--	rfUrgent, rfStatus, rfStatusMessage, rfGradingFormat, rfGrade)
--values (2, '2020-06-05', 2, '$600.00', true, 'Pending', 'Approved', 'Presentation', null);

/******************************************************************************************************************/

/********************************************************************
 * Insert a reimbursement form created by Samirah
 * 	in order to get reimbursed for the Algorithms Course 
 ********************************************************************/
--insert into p1.reimbursementForm (rfRequester, rfDateTimeOfRequest, rfEvent, rfReimbursementAmount, 
--	rfUrgent, rfStatus, rfStatusMessage, rfGradingFormat, rfGrade)
--values (1, '2020-06-05', 1, '$4900.00', false, 'Pending', 'Waiting for the approval of Benefits Coordinator', 
--	'Letter Grade', null);

select * from p1.getReimbursementForms(1);

