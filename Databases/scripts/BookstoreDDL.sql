DROP TABLE STORE_GENRE;
DROP TABLE STORE_BOOK;
DROP TABLE STORE_AUTHOR;
DROP TABLE STORE_BOOK_AUTHOR;

CREATE TABLE STORE_GENRE(
  -- colName dataType optionalConstrains
  GENRE_ID NUMBER(10) PRIMARY KEY,
  NAME VARCHAR2(50) UNIQUE NOT NULL
);

CREATE TABLE STORE_BOOK(
  BOOK_ID NUMBER(10) PRIMARY KEY,
  ISBN VARCHAR2(10) UNIQUE NULL,
  TITLE VARCHAR2(256) NOT NULL,
  PRICE NUMBER(6, 2) NOT NULL,
  GENRE_ID NUMBER(10),
  CONSTRAINT FK_BOOK_GENRE FOREIGN KEY(GENRE)
  REFERENCES STORE_GENRE(GENRE_ID)
);



CREATE TABLE STORE_AUTHOR(
  AUTHOR_ID NUMBER(10) PRIMARY KEY,
  FIRST_NAME VARCHAR2(50) NOT NULL,
  LAST_NAME VARCHAR2(50),
  BIO VARCHAR2(1000)
);

--JUNCTION TABLE - HAS COMPOSITE PK, BOTH COLUMNS ARE FK 
CREATE TABLE STORE_BOOK_AUTHOR(
  BOOK_ID NUMBER(10),
  AUTHOR_ID NUMBER(10),
  PRIMARY KEY (BOOK_ID, AUTHOR_ID),
  FOREIGN KEY (BOOK_ID) REFERENCES STORE_BOOK(BOOK_ID),
  FOREIGN KEY(AUTHOR_ID) REFERENCES STORE_AUTHOR(AUTHOR_ID)
);


insert into store_genre (genre_id, name) values(1,'Romance');

insert into store_genre (name) values('Children');
insert into store_genre (name) values('Mystery');
insert into store_genre (name) values('Sci-Fi');
insert into store_genre (name) values('Fantasy');
insert into store_genre (name) values('Non_Fiction');
insert into store_genre (name) values('Horror');
-- 'Genesis'); DROP TABLE STORE_GENRE;--
select * from store_genre;


insert into STORE_BOOK(book_id, ISBN, TITLE, PRICE, Genre) values (1, '183630328', 'The Lord of the Rings: Two Towers', 19.95, 147);
insert into STORE_BOOK(book_id, ISBN, TITLE, PRICE, Genre) values (2, '833693982', 'The Strange Case of Dr. Jekyll and Mr. Hyde', 9.95, 147);
insert into STORE_BOOK(book_id, ISBN, TITLE, PRICE, Genre) values (3, '818378310', 'Shoe Dog', 29.95, 126);
insert into STORE_BOOK(book_id, ISBN, TITLE, PRICE, Genre) values (4, '838e23992', 'Green Eggs and Ham', 5.95, 144);


Select * from Store_book;

insert into store_author(author_id, FIRST_NAME, LAST_NAME, bio) values(1, 'JRR', 'Tolkien', 'british, author of LOTR');
insert into store_author(author_id, FIRST_NAME, LAST_NAME, bio) values(2, 'George RR', 'Martin', 'author of a Song of Fire and Ice');
insert into store_author(author_id, FIRST_NAME, LAST_NAME, bio) values(3, 'Robert Louis', 'Stevenson', 'cool guy');

select * from store_author;


commit;
/*
A SEQUENCE is an object that lives in the db that serves as a variable 
this can be used for many things, we will increment this variable and 
select it into our PK values upon creating a new row in our table 
with TRIGGERs
*/
CREATE SEQUENCE BOOK_SEQ;


--THE FOLLOWING IS WHAT IS PROCESSED IMPLICITLY W DEFAULT VALUES 
   CREATE SEQUENCE  "DEMO1905MAY28SPS"."GENRE_SEQ"  
   MINVALUE 1 
   MAXVALUE 9999999999999999999999999999 
   INCREMENT BY 1 
   START WITH 1 
   CACHE 20 
   NOORDER  
   NOCYCLE  
   NOPARTITION ;
   /
   select genre_seq.nextval from dual;
   /
   
   /*
   TRIGGER  
   BLOCK OF PL/SQL CODE THAT ALLOWS US TO 'TRIGGER' AN EVENT OR PROCESS 
   UPON A PARTICULAR DML COMMAND 
   */
   CREATE OR REPLACE TRIGGER BOOK_TRIGGER -- Create [or replace] trigger triggerName -- declare and name
   BEFORE INSERT ON STORE_BOOK -- [before/after] [dml command] on [table] -- when will this execute
   FOR EACH ROW -- necessary to change table row values 
   BEGIN
      -- here is where we write what we want to do when trigger is fired 
      SELECT BOOK_SEQ.NEXTVAL --  ++GENRE_SEQ
      INTO :NEW.BOOK_ID -- : represents a placeholder value
      FROM DUAL;
   END;
/
select * from store_genre;

SELECT AUTHOR_SEQ.NEXTVAL FROM DUAL;



--- DUAL TABLE -- dummy table that serves as placeholder for select statements w no table
select * from dual;

INSERT INTO STORE_AUTHOR (FIRST_NAME, LAST_NAME, BIO)
VALUES ('J.K.', 'Rowling', 'Amazing author of the reknown Harry Potter Series and more');

select * from store_author;
commit;

