create schema if not exists p1;

create table if not exists p1.employee ( id int primary key,
firstname varchar(20) not null,
lastname varchar(30) not null,
email varchar(20) unique not null,
emp_username text not null,
emp_password text not null,
emp_type text not null,
unique (emp_username, emp_password) );

create table if not exists p1.request ( id int primary key,
type text not null,
amount int not null,
empid int references p1.employee(id),
dsid int references p1.employee(id),
dhid int references p1.employee(id),
bcid int references p1.employee(id),
status text );

insert into employee values (1, 'g', 'g', 'g', 'g', 'g', 'employee');