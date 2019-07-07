CREATE Table Bank_User(
--colName dataType optionalConstrains
User_id number(10) Primary Key,
first_name varchar2(50) NOT NULL,
last_name varchar2(50) NOT NULL,
ss number(10) unique Not null,
username varchar2(50)UNIQUE NOT NULL
);

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
Create Table Bank_TYPE(
TYPE_id number(10) Primary Key,
TYPE_name varchar(50) UNIQUE Not Null
);

insert into BaNK_TYPE (TYPE_id,TYPE_NAME) VALUES (2,'SAVINGS') ;
commit;
--sequence stuff

create sequence account_seq;
commit;
/*trigger stuff*/
Create or replace Trigger account_Trigger
before insert on bank_account
for each row
begin
  Select account_seq.nextVal--++Genre_seq
  into :New.account_id---:col represents a placeholder value
  from dual;
end;
/
CREATE OR REPLACE PROCEDURE DEPOSIT (USER IN VARCHAR2,ID IN NUMBER,BAL IN NUMBER) -- CREATE [OR REPLACE]
IS
BEGIN
UPDATE BANK_ACCOUNT
  SET ACCOUNT_BALANCE=(ACCOUNT_BALANCE+BAL)
  WHERE USERNAME=USER AND ACCOUNT_ID=ID;
  COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE WITHDRAW (USER IN VARCHAR2,ID IN NUMBER,BAL IN NUMBER) -- CREATE [OR REPLACE]
IS
BEGIN
UPDATE BANK_ACCOUNT
  SET ACCOUNT_BALANCE=(ACCOUNT_BALANCE-BAL)
  WHERE USERNAME=USER AND ACCOUNT_ID=ID;
  COMMIT;
END;
/

select password From Bank_User WHERE lower(USERNAME)='e';
commit;

insert into BaNK_ACCOUNT (ACCOUNT_TYPE,ACCOUNT_NAME,ACCOUNT_BALANCE,USERNAME) VALUES ('CHECKING','GROCERY',0.90,'e') ;

insert into BANK_USER (FIRST_NAME,LAST_NAME,Password,username) Values('w','w','w','w');


SELECT * FROM BANK_ACCOUNT;
SELECT * FROM BANK_user;
SELECT MAX(ACCOUNT_ID) FROM BANK_ACCOUNT;
Delete FRom BANK_User where username='d';
Delete FRom BANK_ACCOUNT where username='d';
commit;