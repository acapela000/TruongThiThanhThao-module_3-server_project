create database if not exists student_ss12_jdbc;
use student_ss12_jdbc;

create table student(
id int primary key,
`name` varchar(50),
gender boolean,
`point` float,
class_id int 
);

insert into student (id,`name`,gender,`point`,class_id) 
values 
(1,'John',true,5,1),
(2,'Jack',true,6,1),
(3,'Jane',false,7,1),
(4,'Julie',false,8,1),
(5,'James',true,9,1)
;