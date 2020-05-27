create schema if not exists p1; 

create table if not exists p1.employee (
  id int primary key,
  firstname varchar(20) not null,
  lastname varchar(30) not null,
  email varchar(20) unique not null,
  emp_username text,
  emp_password text,
  emp_type text not null,
  unique not null (emp_username, emp_password)
);

create table if not exists p1.request (
  id int primary key,
  type text not null,
  amount int not null,
  empid references p1.employee(id),
  dsid references p1.employee(id),
  dhid references p1.employee(id),
  bcid references p1.employee(id),
  status text
);

drop table p1.employee;
drop table p1.request;
drop schema p1;
