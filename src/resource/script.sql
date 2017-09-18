create schema pettycash;

use pettycash;


/*User*/

create table User(userName varchar(10) primary key,userPass varchar(20));
insert into User values(?,?); 

/*Product*/

create table product(productId int primary key AUTO_INCREMENT,productName varchar(40));
insert into product values(1,Tea);
insert into product values(2,Coffee);

/*Daily*/

create table daily(did int primary key AUTO_INCREMENT,date1 date,pId int,productPrice int,productQuantity int,productTotal int,foreign key(pId)references product(productId));

