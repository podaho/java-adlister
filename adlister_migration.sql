use adlister_db;

drop table if exists users;
drop table if exists ads;

create table users (
  id int(11) not null AUTO_INCREMENT primary key,
  username varchar(32) not null,
  email varchar(64) not null,
  password varchar(32) not null
);

create table ads (
  id int(11) not null AUTO_INCREMENT PRIMARY KEY,
  user_id int(11) not null,
  title varchar(256) not null,
  description varchar(512),
  foreign key (user_id) REFERENCES users(id)
);