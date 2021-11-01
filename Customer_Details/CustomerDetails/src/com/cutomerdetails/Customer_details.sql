create table customer_details(
cid int primary key,
firstname VARCHAR2(20),
lastname varchar(20),
street varchar(20),
city varchar(20),
state varchar(20),
zipcode int,
product_name varchar(20),
created_by varchar(20),
created_on date,
updated_by varchar2(20),
updated_on date);

select * from customer_details;
