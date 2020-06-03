/********************************************************************
 * Project One Postgres Database Reset Script
 * 
 * Task - Drop all schemas, tables, functions and stored procedures
 * 			needed for project one. Used for resetting the database
 ********************************************************************/
drop function if exists p1.getReimbursementForms;
drop function if exists p1.getLastUpdateTimestamp;
drop function if exists p1.getSupervisedEmployees;
drop function if exists p1.getRequestHierarchy;
drop function if exists p1.getRequestOrder;
drop table if exists p1.approvalInfoChangeRequest;
drop table if exists p1.file;
drop table if exists p1.reimbursementForm;
drop table if exists p1.reimbursedEvent;
drop table if exists p1.employee;
drop schema if exists p1;