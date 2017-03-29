
drop table authorities;
drop table users;
create table users (
	username	varchar2(50 char) primary key,
	password	varchar2(50 char) not null,
	enabled	 	number(1) 		   not null,
	address  	varchar2(10 char),
	tel 	 	varchar2(10 char)
);

create table authorities(
	username	varchar2(50 char) not null,
	authority	varchar2(50 char) not null,
	constraint 	fk_authorities_users foreign key (username) references users(username)
);


select * from users;
select * from authorities;

insert into users (username, password, enabled) values ('admin', '1234', 1);
insert into users (username, password, enabled) values ('user1', '1234', 1);


insert into authorities values ('admin', 'ROLE_ADMIN');