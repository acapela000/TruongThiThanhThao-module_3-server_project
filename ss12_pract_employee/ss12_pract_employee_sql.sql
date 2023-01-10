drop
database if exists ss12_pract_employee;
create database ss12_pract_employee;
use ss12_pract_employee;

create table ss12_pract_employee(
id int auto_increment primary key,
`name` varchar(50),
email varchar(50),
address varchar(50)
);

insert into ss12_pract_employee values 
(1,'Mike','mike@io.com','Ireland'),
(2,'Miller','miller@io.com','Scotland'),
(3,'Michell','michell@io.com','Findland'),
(4,'Michael','michael@io.com','Porland');

select * from ss12_pract_employee;