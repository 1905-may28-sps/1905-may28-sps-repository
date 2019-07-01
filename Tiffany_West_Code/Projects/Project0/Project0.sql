

CREATE TABLE USER_BALANCE(
  BALANCE_ID NUMBER(10) PRIMARY KEY,
 
 
  BALANCE NUMBER(6, 2) NOT NULL,
  ACCOUNT NUMBER(10),
  CONSTRAINT FK_BANK_ACCOUNT FOREIGN KEY(ACCOUNT)
  REFERENCES USER_ACCOUNT(ACCOUNT_ID)
);


CREATE TABLE BANK_USER(
  USER_ID NUMBER(10) PRIMARY KEY,
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
--login creds
select * from bank_user

SELECT * FROM  bank_account_
SELECT * FROM  bank_account_type

--updating account id
insert into bank_account_ (balance, user_id, type_id) values( 1900,22,3);

--bank account info after login
select bank_account.balance,bank_account.account_number,bank_account_type.type
from bank_account
 left join bank_account_type
 on bank_account.type_id = bank_account_type.type_id
 
 --old
 select bank_user.first_name, bank_user.last_name, bank_account.balance,bank_account.account_number,bank_account_type.type\n" + 
						"from bank_account\n" + 
						"join bank_user on bank_user.user_id = bank_account.user_id \n" + 
						"join bank_account_type on bank_account.type_id = bank_account_type.type_id
 
 
 --new
 select bank_user.username, bank_account.balance,bank_account.account_number,bank_account_type.type
from bank_account
 join bank_user on bank_user.user_id = bank_account.user_id 
 join bank_account_type on bank_account.type_id = bank_account_type.type_id
 where  username=  'username' and password = 'pass'


--test
 select bank_user.first_name, bank_user.last_name, bank_account.balance,bank_account.account_number
from bank_account
 join bank_user on bank_user.user_id = bank_account.user_id 

select username , password from bank_user
commit;

--seq and trigger for account number creation then test here

create sequence acc_num_seq;
create sequence acc_seq;

drop trigger acc_num_trigger;

 CREATE OR REPLACE TRIGGER ACC_NUM_TRIGGER -- Create [or replace] trigger triggerName -- declare and name
   BEFORE INSERT ON bank_account_ -- [before/after] [dml command] on [table] -- when will this execute
   FOR EACH ROW -- necessary to change table row values 
   BEGIN
      -- here is where we write what we want to do when trigger is fired 
      SELECT acc_num_SEQ.NEXTVAL --  ++GENRE_SEQ
      INTO :NEW.account_number-- : represents a placeholder value
      FROM DUAL;
   END;
/

 CREATE OR REPLACE TRIGGER ACC_TRIGGER -- Create [or replace] trigger triggerName -- declare and name
   BEFORE INSERT ON bank_account_ -- [before/after] [dml command] on [table] -- when will this execute
   FOR EACH ROW -- necessary to change table row values 
   BEGIN
      -- here is where we write what we want to do when trigger is fired 
      SELECT acc_num_SEQ.NEXTVAL --  ++GENRE_SEQ
      INTO :NEW.account_id-- : represents a placeholder value
      FROM DUAL;
   END;
/

insert into bank_account ()

select * from bank_user
SELECT * FROM  bank_account_type

-- the insert into bank account + bank_user? so we just ask for the user id 
-- and type id but how would we know the id so select the id, and the balance  

insert into bank_account (balance, user_id, type_id) values( 1900,22,3);
-- insert username, type, balance, account_number

insert into bank_account(balance, type_id) values (1000,4)
 select bank_user.username, bank_account.balance, bank_account.account_number,bank_account_type.type
from bank_account
 join bank_user on bank_user.user_id = bank_account.user_id 
 join bank_account_type on bank_account.type_id = bank_account_type.type_id
 where username = 'madDusty'
 
 -- insert balance and type_id
 INSERT INTO bank_account  (balance,user_id, type_id) VALUES (1000,3,2)
 select bank_user.username, bank_user.password, bank_account.balance, bank_account.type_id
 from bank_user
 join bank_account on bank_user.user_id = bank_account.user_id
 
 --
 delete from bank_account
where user_id is null
--
Alter table bank_account
add username varchar(50);

ALTER TABLE bank_account 
ADD CONSTRAINT FK_bank_accountusername
FOREIGN KEY (username)
REFERENCES bank_user (username)  ;
--
rollback;
--
insert into bank_account (balance,user_id, type_id, username) values( 1900,23,3,'madDusty');
insert into bank_account_ (username, balance, account_number,type_id) values( 'madDusty', 1000,10000000,3);


select * from bank_account_


create table bank_account(
account_id number(10) primary key,
username varchar2(50)  not null,
user_id number(10) not null,
account_number number( 10) not null,
balance number (6,2) check (balance >=0),
type_id number(10),
constraint fk_bank_username foreign key (username)
references bank_user(username),
constraint fk_bank_user_id foreign key (user_id)
references bank_user(user_id)
);

CREATE TABLE BANK_ACCOUNT_ (
  account_ID NUMBER(10) PRIMARY KEY,
  username VARCHAR2(50)  NOT NULL,
  user_id VARCHAR2(256) NOT NULL,
  balance NUMBER(6, 2) NOT NULL,
  account_number NUMBER(10),
  CONSTRAINT FK_Bank_username FOREIGN KEY(username)
  REFERENCES bank_user(username)
);

drop table bank_account_;

create table bank_account_table(
account_IDs NUMBER(10) PRIMARY KEY,
  usernames VARCHAR2(50) UNIQUE NOT NULL
);
ALTER TABLE BANK_ACCOUNT_
  ADD type_id number(10);

select * from BANK_ACCOUNT_
DROP SEQUENCE acc_num_seq;
select * from bank_account_
--
ALTER TABLE bank_account_ add  user_id number(10);
drop trigger acc_num_trigger

select  bank_user.user_id, bank_user.username, bank_account_.balance
from bank_user
join bank_account_ on bank_user.username = bank_account_.username

update bank_account_
set account_number = 9876543, user_id = 23
where account_id =4;

select * from bank_user
select * from bank_account_

--change this back to user_id
select bank_user.first_name, bank_user.last_name, bank_account_.balance,bank_account_.account_number, bank_account_type.type
			   		from bank_account_
			   		 join bank_user on bank_user.username = bank_account_.username  
                 join bank_account_type on bank_account_.type_id = bank_account_type.type_id
			   		 where  bank_user.username = 'madDusty'
            
            select * from bank_user         
            --stored procedure    
            
CREATE OR REPLACE PROCEDURE insertUser
( in_fname IN bank_user.first_NAME%TYPE,
  in_lname IN bank_user.last_NAME%TYPE,
 in_username IN bank_user.username%TYPE,
 in_password IN bank_user.password%TYPE,

 out_result OUT VARCHAR2)
AS
BEGIN
  INSERT INTO bank_user (first_name, last_name, username, password) 
  values (in_fname,in_lname,in_username,in_password);
  commit;
  
  out_result := 'TRUE';
  
EXCEPTION
  WHEN OTHERS THEN 
  out_result := 'FALSE';
  ROLLBACK;
END;
/

commit;
--for this deposit leave copy the doa and withdraw method
CREATE OR REPLACE PROCEDURE DEP (acc_num in number, dep IN NUMBER) 
as
BEGIN
UPDATE BANK_ACCOUNT_
  SET BALANCE=(BALANCE+dep)
  WHERE account_number= acc_num; 
  COMMIT;
END;
/
SELECT * FROM bank_user
select * from bank_account_

      CREATE OR REPLACE PROCEDURE WITHDRAW (acc_num in number, dep IN NUMBER) 
as
BEGIN
UPDATE BANK_ACCOUNT_
  SET BALANCE=(BALANCE-dep)
  WHERE account_number= acc_num; 
  COMMIT;
END;
/
SELECT * FROM bank_user
select * from bank_account_

--checking the procedure
execute withdraw (9876543, 1);      

--adding constraint so withdraw won't be less than 0
ALTER TABLE bank_account_
ADD CONSTRAINT CHE_BAL 
CHECK (balance >=0);


            insert into bank_account_ (username, balance, type_id) values (ab, 100,2)
            
            
            
            
     type_id number(10) not null;
            
            ALTER TABLE bank_account_
  ADD        constraint fk_bank_user_id foreign key (user_id)
references bank_user(user_id);
            
            
            
            select * from bank_account_;
            select* from bank_user;
            
       alter table
   bank_account_
modify
(
   user_id    number(10)
);              

insert into bank_account_ ()

alter table bank_account_ modify (user_id null);

commit;




 select * from bank_account_;
 
 
 select* from bank_user;













