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
insert into store_genre(name)values('Education');
commit;

--sequence stuff
create sequence genre_seq;

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
Create or replace Trigger Gen_Trigger
before insert on store_Genre
for each row
begin
  Select genre_seq.nextVal--++Genre_seq
  into :New.genre_id---:col represents a placeholder value
  from dual;
end;
/
--dual table lives in database
select sysdate from dual;
select*from store_genre;
