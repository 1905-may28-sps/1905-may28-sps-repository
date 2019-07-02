/*******************************************************************************
   Create Tables for Banking Application
*******************************************************************************/
CREATE TABLE Bank_User(
    UserId NUMBER NOT NULL,
    FirstName VARCHAR2(40) NOT NULL,
    LastName VARCHAR2(40) NOT NULL,
    username varchar2(20) not null unique ,
    Email VARCHAR2(60) NOT null unique,
    Password VARCHAR(64) NOT NULL,
    CONSTRAINT PK_Bank_User PRIMARY KEY (UserId)
);

CREATE SEQUENCE Bank_User_SEQ;

CREATE TRIGGER Bank_User_Trigger
BEFORE INSERT ON Bank_User
FOR EACH ROW
BEGIN
   SELECT Bank_User_SEQ.NEXTVAL
   INTO :NEW.UserId
   FROM DUAL;
END;
/

CREATE TABLE bank_account_type(
  typeid number primary key,
  name varchar2(20) not null unique
);

CREATE TABLE Bank_Account(
    AccountId NUMBER PRIMARY KEY,
    Balance DECIMAL (20,2) NOT NULL,
    UserId NUMBER NOT NULL,
    AccountType number NOT NULL,
    FOREIGN KEY (UserId) REFERENCES Bank_User(UserId),
    foreign key (accountType) references bank_account_type(typeid)
);

CREATE SEQUENCE Bank_Account_SEQ;

CREATE TRIGGER Bank_Account_Trigger
BEFORE INSERT ON Bank_Account
FOR EACH ROW
BEGIN
   SELECT Bank_Account_SEQ.NEXTVAL
   INTO :NEW.AccountId
   FROM DUAL;
END;
/

insert into bank_account_type(typeid, name) values (1, 'Checking');
insert into bank_account_Type(typeid, name) values (2, 'Savings');
insert into bank_account_Type(typeid, name) values (3, 'Credit');


INSERT INTO BANK_USER (FIRSTNAME, LASTNAME, EMAIL, userNAME, PASSWORD)
VALUES ('John', 'Doe', 'johndoe@gmail.com', 'johndoe', 'enter456');

INSERT INTO BANK_USER (FIRSTNAME, LASTNAME, EMAIL, userNAME, PASSWORD)
VALUES ('Genesis', 'Bonds', 'genesis.bonds@revature.com', 'genbo', 'enter456');

INSERT INTO BANK_USER (FIRSTNAME, LASTNAME, EMAIL, userNAME, PASSWORD)
VALUES ('Kris', 'Lord', 'kl@gmail.com', 'kl', 'enter456');

INSERT INTO BANK_ACCOUNT (BALANCE, USERID, ACCOUNTTYPE)
VALUES (5000.89, 1, 1);

INSERT INTO BANK_ACCOUNT (BALANCE, USERID, ACCOUNTTYPE)
VALUES (10.43, 1, 2);

INSERT INTO BANK_ACCOUNT (BALANCE, USERID, ACCOUNTTYPE)
VALUES (34.00, 2,3);

INSERT INTO BANK_ACCOUNT (BALANCE, USERID, ACCOUNTTYPE)
VALUES (1200.98, 2, 1);

INSERT INTO BANK_ACCOUNT (BALANCE, USERID, ACCOUNTTYPE)
VALUES (10453.87, 3, 1);

INSERT INTO BANK_ACCOUNT (BALANCE, USERID, ACCOUNTTYPE)
VALUES (43280.65, 3, 2);


commit;
