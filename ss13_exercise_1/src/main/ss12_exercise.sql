create database if not exists ss12_exercise;
use ss12_exercise;

create table users (
 id  int(3) not null auto_increment,
 name varchar(120) not null,
 email varchar(220) not null,
 country varchar(120),
 primary key (id)
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
select * from users;
update users set name = 'Linh', email = '', country = '' where id = 1;