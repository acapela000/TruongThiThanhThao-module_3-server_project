drop database if exists  ss12_pract_customer;
create database ss12_pract_customer;
use ss12_pract_customer;

create table ss12_pract_customer (
	id INT primary key,
	customer_type_id int(50),
	name VARCHAR(50),
	date_of_birth varchar(50),
	gender boolean,
	id_card varchar(50),
	phone_number VARCHAR(50),
	email VARCHAR(50),
	address VARCHAR(50)
);
insert into ss12_pract_customer 
(id, customer_type_id, name, date_of_birth, gender, id_card, phone_number, email, address) 
values 
(1, 1, 'Tommie', '9/27/2022', '0', 1, '704-635-6817', 'tdundendale0@about.me', 'Golopau'),
(2, 2, 'Luther', '1/26/2022', '0', 2, '258-440-4878', 'ldeniske1@technorati.com', 'Nangzan'),
(3, 3, 'Sam', '7/29/2022', '0', 3, '336-330-5335', 'sgrahlman2@smugmug.com', 'New Delhi'),
(4, 4, 'Darcy', '9/23/2022', '1', 4, '916-555-2722', 'dlyle3@marriott.com', 'Pervomayskiy'),
(5, 5, 'Quintina', '9/6/2022', '1', 5, '218-531-4982', 'qbartot4@paypal.com', 'Yogyakarta');
select * from ss12_pract_customer;
SET SQL_SAFE_UPDATES = 0;
drop table ss12_pract_customer;
truncate ss12_pract_customer;
update ss12_pract_customer set customer_type_id = 5, name = 'Quintina', date_of_birth = '9/6/2022', gender = 'Female', id_card = 5, phone_number = '218-531-4982', email = 'qbartot4@paypal.com', address = 'YogyaKARTA' where id = 5;