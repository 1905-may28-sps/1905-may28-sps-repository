CREATE TABLE STORE_GENRE(
  -- colName dataType optionalConstrains
  GENRE_ID NUMBER(10) PRIMARY KEY,
  NAME VARCHAR2(50) UNIQUE NOT NULL
);

CREATE TABLE STORE_BOOK(
  BOOK_ID NUMBER(10) PRIMARY KEY,
  ISBN VARCHAR2(10) UNIQUE NOT NULL,
  TITLE VARCHAR2(256) NOT NULL,
  PRICE NUMBER(6, 2) NOT NULL,
  GENRE NUMBER(10),
  CONSTRAINT FK_BOOK_GENRE FOREIGN KEY(GENRE)
  REFERENCES STORE_GENRE(GENRE_ID)
);


DROP TABLE BOOK;

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


select * from store_genre;
insert into store_genre(genre_id, name) values(1, "Romance");
insert into store_genre(name) values ("Horror");

/*
A sequence is an object that ives in the db gthat serves as a variable this can be used for manyu things,
we will increment this variable and select it into our PK values upon creating a new row in our table with TRIGGERSs

--variable that lives in your database
*/

CREATE SEQUENCE GENRE_SEQ;


select genre_seq.nextval from dual;

/*
TRIGGER
BLock of PL/SQL code that allows us to 'trigger' an event or process upon a particular DML command
*/

CREATE OR REPLACE TRIGGER GEN_TRIGGER -- create, or replace, trigger TRIGGERNAME
BEFORE INSERT ON STORE_GENRE --[before/after][dml command] on [table] - when will this execute
FOR EACH ROW --necessary to change table row values
BEGIN
 --here is where we write what we want to do when trigger is fired
 SELECT GENRE_SEQ.NEXTVAL --like ++GENRE_SEQ
 INTO :NEW.GENRE_ID
 FROM DUAL;
END;
/ --stop executing
