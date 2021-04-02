create table USERS(sl_no int auto_increment,username varchar(20),password varchar(20),phone varchar(15),email_id varchar(50));
insert into USERS(username,password,phone,email_id) values('user','user','9483621844','gowthamhm002@gmail.com');
insert into USERS(username,password,phone,email_id) values('admin','admin','8095642067','lionmonkey001@gmail.com');
select * from users;
create table folders(sl_no int auto_increment,folder_name varchar(30),creator varchar(30),Date varchar(20),Time varchar(20));
select * from folders;
drop table folders;