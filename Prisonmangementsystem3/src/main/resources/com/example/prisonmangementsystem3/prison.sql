create database prison;
use prison; 
create table people (
pid int Not NUll Primary Key,
pfirstname Varchar(250) ,
plastname varchar(250) ,
pmiddlename varchar(250) ,
pDOB date,
SSN varchar(250) not Null,
Address varchar(250) ,
createdby varchar(250) ,
createddate date,
modifedby varchar(250),
modifeddate date,
isdeleted boolean

);
use prison;
create table crime (
cid int Not Null primary key,
pid int Not Null references people(pid) ,
intakedate date,
releasedate date,
CrimeDescription varchar(250),
crimejudgement int,
jurisdiction varchar(250),
isparole boolean,
createdby varchar(250) ,
createddate date,
modifedby varchar(250),
modifeddate date,
isdeleted boolean
 );
 use prison;
 create table personalinfo(
 personalid int Not Null primary key,
 pid int Not null references people(pid),
 personname varchar(250),
 personaddress varchar(250),
 personphonenum varchar(250),
 createdby varchar(250) ,
createddate date,
modifedby varchar(250),
modifeddate date,
isdeleted boolean
 );
 use prison;
 create table health (
 hid int not null primary key,
 pid int not null references people(pid),
 height varchar(250),
 weight int,
 bloodpressure int,
 temp int,
 createdby varchar(250) ,
createddate date,
modifedby varchar(250),
modifeddate date,
isdeleted boolean
 
 );
 use prison ;
 create table prisoncellinfo (
 cellid int not null primary key ,
 cid int not null references crime(cid),
 cellnum int,
 prisonfname Varchar(250),
 prisonlname varchar(250),
 prisonmname varchar(250),
 createdby varchar(250) ,
createddate date,
modifedby varchar(250),
modifeddate date,
isdeleted boolean
);
use prison;
create table intake (
intakeid int primary key,
cid int  not null references crime(cid),
personalartifacts Varchar(250),
 money decimal,
  createdby varchar(250) ,
createddate date,
modifedby varchar(250),
modifeddate date,
isdeleted boolean
 );
 create table tasks(
 Tid int not null primary key,
 ttitle varchar(250),
 tdesc Varchar(250),
 pay decimal,
  createdby varchar(250) ,
createddate date,
modifedby varchar(250),
modifeddate date,
isdeleted boolean
 );
 use prison;
 create table persontask(
 ptid int not null primary key,
 cid int not null references crime(cid),
 tid int not null references tasks(tid),
createdby varchar(250) ,
createddate date,
modifedby varchar(250),
modifeddate date,
isdeleted boolean
 );
Delimiter //
use prison;
 create procedure insertingvistors(
 begin 
 personalid int,
 pid int,
 pname varchar(250),
 paddress varchar(250),  
 pphone varchar(250),
 createdby varchar(250),
 createddate date ,
 modifiedby varchar(250),
 modifieddate date,
 isdeleted boolean)
 insert into personalinfo(personalid,pid,personname,personphone,createdby,createddate,modifedby,modifeddate,isdeleted)
 values (personalid,pid,pname,paddress,pphone,createdby,createddate,modifiedby,modifieddate,isdeleted)
End // 
Delimiter ; 


