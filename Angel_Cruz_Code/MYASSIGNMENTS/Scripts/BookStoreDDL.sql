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
insert into store_genre (genre_id, name) values(1,'Romance');

insert into store_genre (name) values('Children');
-- 'Genesis'); DROP TABLE STORE_GENRE;--

commit;
/*
A SEQUENCE is an object that lives in the db that serves as a variable 
this can be used for many things, we will increment this variable and 
select it into our PK values upon creating a new row in our table 
with TRIGGERs
*/
CREATE SEQUENCE AUTHOR_SEQ;


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
   CREATE OR REPLACE TRIGGER AUTH_TRIGGER -- Create [or replace] trigger triggerName -- declare and name
   BEFORE INSERT ON STORE_AUTHOR -- [before/after] [dml command] on [table] -- when will this execute
   FOR EACH ROW -- necessary to change table row values 
   BEGIN
      -- here is where we write what we want to do when trigger is fired 
      SELECT AUTHOR_SEQ.NEXTVAL --  ++GENRE_SEQ
      INTO :NEW.AUTHOR_ID -- : represents a placeholder value
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

SELECT * from store_author;
INSERT INTO STORE_AUTHOR (FIRST_NAME, LAST_NAME, BIO)
VALUES ('RICK','MOFINA','Former journalist who has interviewed murderers on death row');
INSERT INTO STORE_AUTHOR (FIRST_NAME, LAST_NAME, BIO)
VALUES ('Glynnis','Campbell','USA today bestselling of swashbuckling action-adventure romance');

INSERT INTO STORE_AUTHOR (FIRST_NAME, LAST_NAME, BIO)
VALUES ('John','Scalzi','He is best known for writing science fiction, including the New York Times bestseller Redshirts');
INSERT INTO STORE_AUTHOR (FIRST_NAME, LAST_NAME, BIO)
VALUES ('Courtney','Milan','Milan is a New York Times and USA Today bestselling author of historical romance');

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
--select * from store_BOOK;

SELECT BOOK_SEQ.NEXTVAL FROM DUAL; --SELECT AUTHOR_SEQ.NEXTVAL FROM DUAL;

--SELECT * FROM STORE_AUTHOR WHERE AUTHOR_ID = 0;
INSERT INTO BOOK_TRIGGER (ISBN, TITLE, PRICE, GENRE)
VALUES (1234,'The Book of Milan',3,'romance');

--test
select * from store_book;
--test

select * from store_author;

------------------------- New Set of tables ---------------------------------

CREATE Table Bank_ACCOUNT(
user_id number(10) Primary Key,
first_name varchar2(50) NOT NULL,
last_name varchar2(50) NOT NULL,
username varchar2(50)UNIQUE NOT NULL
);
Create Table Bank_USER(
account_id number(10) Primary Key,
account_name varchar(50) Not Null, --eraese account type because we are not doing checking and savings accounts, we nly have one type of account
account_balance number(10,2) Not Null,
username varchar2(50) Not Null,
constraint FK_Account_User Foreign Key(username)
references Bank_User(username)
);

select * from Bank_account;
------------------------- Create sequence -----------------------------------
CREATE SEQUENCE sq_bank
START WITH 1
INCREMENT BY 1
MAXVALUE 10
MINVALUE 1
CYCLE
ORDER;
--CREATE SEQUENCE
CREATE SEQUENCE sq_bank;

SELECT sq_bank.currval FROM dual; -- current value

SELECT sq_bank.NEXTVAL FROM dual; -- increments

------------------------- Insert values -----------------------------------
INSERT INTO BANK_ACCOUNT(ACCOUNT_ID,ACCOUNT_NAME,ACCOUNT_BALANCE,USERNAME) VALUES(sq_bank.NEXTVAL,1,'JOSHUA',700,'CASHMONEY');
select * from bank_account;
--INSERT INTO Bank_account(ACCOUNT_ID,ACCOUNT_NAME,ACCOUNT_BALANCE,USERNAME)
--VALUES(1,JOSHUA,1500,JCASH)

------------------------- Create final table -----------------------------------

CREATE Table Bank_Usertest(
User_id number(10) Primary Key,
first_name varchar2(50) NOT NULL,
last_name varchar2(50) NOT NULL,
password varchar2(40) unique Not null,
username varchar2(50)UNIQUE NOT NULL
);
commit;
create Table Bank_ACCOUNT(
Account_id number(10) Primary Key,
account_type varchar(8) Not Null,
constraint FK_Account_Type Foreign Key(account_type)
references Bank_Type(type_NAME),
account_name varchar(50) Not Null,
account_balance number(10,2) Not Null,
username varchar2(50) Not Null,
constraint FK_Account_User Foreign Key(username)
references Bank_User(username)

);

------------------------- Create final table end -----------------------------------

--UPDATE METHOD
CREATE OR REPLACE PROCEDURE UPDATE_AUTHOR
(A_ID IN NUMBER, A_FN IN VARCHAR2, A_LN IN VARCHAR2, A_BIO IN VARCHAR2)
AS
BEGIN
WHERE AUTHOR_ID = A_ID;
COMMIT;
END;
/

EXEC UPDATE UPDATE_AUTHOR(4,'STEPHEN','KING','AWARD WINNING AUTHOR')
SELECT
--BEST PRACTICE TO UPDATE ENTIRE ROW 
UPDATE STORE_AUTHOR SET
FIRST_NAME = 'TEST',
LAST_NAME = 'TEST',
BIO = 'TEST'
WHERE AUTHOR_ID = 5;
END
/
DROP TABLE invoice;
