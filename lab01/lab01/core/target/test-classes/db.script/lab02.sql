-- Создание базы данных
create database lab02 default charset utf8;

-- Использование бд
use lab02;

-- Создание таблиц
create table Grooup (
	 id int(11) not null auto_increment primary key,
     groupName varchar(100) not null,
     creationDate date not null,
     curatorName varchar(100) not null
);

create table Student (
	id int(11) not null auto_increment primary key,
    grooupID int(11) not null,
    lastName varchar(100) not null,
	firstName varchar(100) not null,
	birthDate date not null,
    age int(2),
    
    foreign key (grooupID) references Grooup(id) 
);