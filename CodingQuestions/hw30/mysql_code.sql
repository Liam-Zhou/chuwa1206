create database try1;
use try1;

-- create TABLE mytable(
-- 	id INT,
--     name varchar(20)
-- );

-- insert into mytable(id,name) values
-- (1,'ds'),
-- (2,'dsds'),
-- (3,'eef');

-- drop table mytable;
 
 create table oms_company_address(
	id bigint primary key,
    address_name varchar(200),
    send_status int(1),
    receive_status int(1),
    name varchar(64),
    phone varchar(64),
    province varchar(64),
    city varchar(64),
    region varchar(64),
    detail_address varchar(200)
    );

select * from oms_company_address;

select * from oms_company_address limit 3;

update oms_company_address set phone="666-6666-8888";

delete from oms_company_address where id=1;

