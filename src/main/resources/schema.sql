create table WORDS
(
   id integer not null,
   word varchar(255) not null,
   category varchar(255) not null,
   primary key(id)
);

create table SENTENCES
(
   id integer not null,
   sentence varchar(255) not null,
   primary key(id)
);

