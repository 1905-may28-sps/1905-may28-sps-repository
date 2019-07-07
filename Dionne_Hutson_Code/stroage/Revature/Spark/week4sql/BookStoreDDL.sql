CREATE Table Store_Genre(
--colName dataType optionalConstrains
Genre_id number(10) Primary Key,
name varchar2(50)UNIQUE NOT NULL
);
Create table store_book(
book_id number(10) primary key,
isbn varchar2(10) unique not null,
title varchar2(256) not null,
price number(6,2) not null,
genre number (10),
constraint FK_BOOK_GENRE Foreign Key(Genre)
references store_genre(genre_id)
);
create table store_author(
author_id number(10) primary key,
first_name varchar2(50) not null,
last_name varchar2(50),
bio varchar2(1000)
);
--junction table has composite primary key both olumn are fk
create table store_book_author(
book_id number(10),
author_id number(10),
primary key (book_id,author_id),
foreign key (book_id)references store_book(book_id),
foreign key (author_id)references store_author(author_id)
);


select*from store_genre;

select*from store_author;
select*from store_book;
insert into store_genre(name)values('Biography');
insert into store_author(first_name, last_name, BIO)values('Robert','Louis','Writes TI');
insert into STORE_BOOK(ISBN,title,price,genre)values('0679804024','Treasure Island',4.99,5);
commit;

--sequence stuff
create sequence book_seq;

CREATE SEQUENCE  "DHUTSON"."GENRE_SEQ"  
MINVALUE 1 
MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 
START WITH 1 
CACHE 20 
NOORDER  
NOCYCLE  
NOPARTITION ;

/*trigger stuff*/
Create or replace Trigger book_Trigger
before insert on store_book
for each row
begin
  Select book_seq.nextVal--++Genre_seq
  into :New.book_id---:col represents a placeholder value
  from dual;
end;
/
--dual table lives in database
select sysdate from dual;
select*from store_genre;


select*from store_genre; 
UPDATE store_genre set name='test' where genre_id=1;
commit;

create or replace procedure Update_Author
(a_id in Number, a_fn in varchar2, a_ln in varchar2, a_bio in varchar2)
as
begin
update store_author set first_name=a_fn,
last_name=a_ln,
bio=a_bio
where
author_id=a_id;
commit;
end;

/
exec update_author(41,'g','g','g');
insert into store_book(isbn,title,price,genre) values (6595485625,'d',19.63,9);

select*from store_author;