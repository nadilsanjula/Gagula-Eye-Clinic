create database heeeeee;

use gangulaWedaMedura;

create table reception(
                          repId varchar(10) primary key,
                          name varchar(15) not null,
                          email text not null
);

create table attendance(
                           atId varchar(10) primary key,
                           date date,
                           time varchar(10)
);

create table staff(
                      staffId varchar(10) primary key,
                      name text,
                      address text,
                      contactNum varchar(20),
                      jobRole varchar(20)
);

create table salary(
                       salaryId varchar(10) primary key,
                       amount double(10,2),
	atId varchar(10),
	staffId varchar(10),
	foreign key(staffId) references staff(staffId) on update cascade on delete cascade,
	foreign key(atId) references attendance(atId) on update cascade on delete cascade
);


create table doctor(
                       docId varchar(10) primary key,
                       name text not null,
                       email text not null,
                       mrId varchar(10)
);


create table patient(
                        patId varchar(10)primary key,
                        name text,
                        address text,
                        age int,
                        nic varchar(20),
                        contactNum varchar(20),
                        docId varchar(10),
                        foreign key(docId) references doctor(docId) on update cascade on delete cascade
);


create table medicalReport(
                              mrId varchar(10) primary key,
                              docId varchar(10),
                              foreign key(docId) references doctor(docId) on update cascade on delete cascade
);

create table supplier(
                         supId varchar(10) primary key,
                         name text,
                         address text,
                         age int,
                         nic varchar(20),
                         contactNum varchar(20)
);

create table rawMaterial(
                            rawId varchar(10) primary key,
                            name text,
                            type text,
                            qty int,
                            supId varchar(10),
                            foreign key(supId) references supplier(supId) on update cascade on delete cascade
);




create table medicine(
                         medId varchar(10) primary key,
                         name text,
                         description text,
                         patId varchar(10),
                         docId varchar(10),
                         foreign key(patId) references patient(patId) on update cascade on delete cascade,
                         foreign key(docId) references doctor(docId) on update cascade on delete cascade
);

create table bill(
                     billId varchar(10 )primary key,
                     price double(10,2),
	patId varchar(10),
	medId varchar(10),
	foreign key(patId) references patient(patId) on update cascade on delete cascade,
	foreign key(medId) references medicine(medId) on update cascade on delete cascade
);

create table appointments(
                             appId varchar(10) primary key,
                             date date,
                             time varchar(10),
                             purpose text,
                             docId varchar(10),
                             patId varchar(10),
                             foreign key(docId) references doctor(docId) on update cascade on delete cascade,
                             foreign key(patId) references patient(patId) on update cascade on delete cascade
);
