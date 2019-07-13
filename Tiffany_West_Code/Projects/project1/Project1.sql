CREATE TABLE ERS_REIMBURSEMENT(
  REIMB_ID NUMBER(10) PRIMARY KEY,
  REIMB_AMOUNT NUMBER(6,2),
  REIMB_SUBMITTED TIMESTAMP,
  REIMB_RESOLVED TIMESTAMP,
  REIMB_DESCRIPTION VARCHAR(250),
  REIMB_RECEIPT BLOB,
  REIMB_AUTHOR NUMBER(10),
  REIMB_RESOLVER NUMBER(10),
  REIMB_STATUS_ID NUMBER(10),
  REIMB_TYPE_ID NUMBER(10),
   FOREIGN KEY(REIMB_AUTHOR) REFERENCES ERS_USERS(ERS_USERS_ID),
   FOREIGN KEY(REIMB_RESOLVER) REFERENCES ERS_USERS(ERS_USERS_ID),
   FOREIGN KEY(REIMB_STATUS_ID) REFERENCES ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID),
   FOREIGN KEY(REIMB_TYPE_ID) REFERENCES ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID)
);

CREATE TABLE ERS_USERS (
  ERS_USERS_ID NUMBER(10) PRIMARY KEY,
  ERS_USERNAME VARCHAR2(50)  NOT NULL,
  ERS_PASSWORD VARCHAR2(50) NOT NULL,
  USER_FIRST_NAME VARCHAR2(100) NOT NULL,
  USER_LAST_NAME  VARCHAR2(100) NOT NULL,
  USER_EMAIL VARCHAR2(150) ,
  USER_ROLE_ID NUMBER(10),
     FOREIGN KEY(USER_ROLE_ID) REFERENCES ERS_USER_ROLES(ERS_USER_ROLE_ID)
);

CREATE TABLE ERS_USER_ROLES(
ERS_USER_ROLE_ID NUMBER(10) PRIMARY KEY,
USER_ROLE VARCHAR2(10)
);

CREATE TABLE ERS_REIMBURSEMENT_TYPE(
REIMB_TYPE_ID NUMBER(10) PRIMARY KEY,
REIMB_TYPE VARCHAR2(10)
);

CREATE TABLE ERS_REIMBURSEMENT_STATUS(
REIMB_STATUS_ID NUMBER(10) PRIMARY KEY,
REIMB_STATUS VARCHAR2(10)
);
--sequences and triggers
create sequence ers_req start with 1000;

 CREATE OR REPLACE TRIGGER REIMB_TRIGGER -- Create [or replace] trigger triggerName -- declare and name
   BEFORE INSERT ON ERS_REIMBURSEMENT -- [before/after] [dml command] on [table] -- when will this execute
   FOR EACH ROW -- necessary to change table row values 
   BEGIN
      -- here is where we write what we want to do when trigger is fired 
      SELECT ers_req.NEXTVAL --  ++GENRE_SEQ
      INTO :NEW.REIMB_ID-- : represents a placeholder value
      FROM DUAL;
   END;
/

create sequence ers_users_seq start with 1000;

 CREATE OR REPLACE TRIGGER USERS_TRIGGER -- Create [or replace] trigger triggerName -- declare and name
   BEFORE INSERT ON ERS_USERS -- [before/after] [dml command] on [table] -- when will this execute
   FOR EACH ROW -- necessary to change table row values 
   BEGIN
      -- here is where we write what we want to do when trigger is fired 
      SELECT ers_users_seq.NEXTVAL --  ++GENRE_SEQ
      INTO :NEW.ERS_USERS_ID-- : represents a placeholder value
      FROM DUAL;
   END;
/
--insert some sample data


select * from ers_user_roles;
insert into ers_user_roles (ers_user_role_id, user_role) values (1,'Owner');
insert into ers_user_roles (ers_user_role_id, user_role) values (2,'Manager');
insert into ers_user_roles (ers_user_role_id, user_role) values (3,'Employee');

select  * from ers_reimbursement_type;
insert into ers_reimbursement_type (reimb_type_id, reimb_type) values (1,'Clothing');
insert into ers_reimbursement_type (reimb_type_id, reimb_type) values (2,'Food');
insert into ers_reimbursement_type (reimb_type_id, reimb_type) values (3,'Gas');
insert into ers_reimbursement_type (reimb_type_id, reimb_type) values (4,'Lodging');
insert into ers_reimbursement_type (reimb_type_id, reimb_type) values (5,'Oil');
insert into ers_reimbursement_type (reimb_type_id, reimb_type) values (6,'Other');
insert into ers_reimbursement_type (reimb_type_id, reimb_type) values (7,'Tires');

select  * from ers_reimbursement_status;
insert into ers_reimbursement_status (reimb_status_id, reimb_status) values (1,'Approved');
insert into ers_reimbursement_status (reimb_status_id, reimb_status) values (2,'Denied');
insert into ers_reimbursement_status (reimb_status_id, reimb_status) values (3,'Pending');


select * from ers_users;
insert INTO ers_users(ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id) VALUES('tiffyw','pass123','Tiffany','West','tiffyw@imanitransports.com',1);
insert INTO ers_users(ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id) VALUES('melanb','pass1234','Melanie','Bowden','melanb@imanitransports.com',2);
insert INTO ers_users(ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id) VALUES('milans','pass1235','Milan','Sealy','milans@imanitransports.com',3);

select * from ers_reimbursement;

insert into ers_reimbursement (reimb_amount,reimb_submitted,reimb_description,REIMB_AUTHOR,reimb_type_id) 
values (15,CURRENT_TIMESTAMP,'had to get tires',1002,7);

--select for username 
select * from ers_users where lower(ers_username);

--getting the user data
select   main.REIMB_ID, main.reimb_amount, main.reimb_submitted, main.reimb_resolved, main.reimb_description, rtype.reimb_type, status.reimb_status
from ers_reimbursement main
inner join  ers_reimbursement_type     rtype     on main.reimb_type_id = rtype.reimb_type_id
inner join ers_reimbursement_status  status     on main.reimb_status_id = status.reimb_status_id
where main.reimb_author =1002;

select  acc.account_id , acc.balance, type.type
from bank_account_ acc
inner join bank_account_type type
on acc.type_id = type.type_id
where acc.user_id = 70







--if the employee wants to make a 'ticket' they will use this... with a where
insert into ers_reimbursement (reimb_amount,reimb_submitted,reimb_description,REIMB_AUTHOR,reimb_resolver,reimb_status_id,reimb_type_id) 
values (100,CURRENT_TIMESTAMP,'test2',1002,3,5);

-- for the managers to update the 'ticket' maybe maje this a stored procedure
update ers_reimbursement
set reimb_resolved = CURRENT_TIMESTAMP,  reimb_status_id =1
where reimb_id =1116;

--so the emp can see the updated status maybe make this a stored procedure
select reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description,reimb_receipt, reimb_status_id
from ers_reimbursement
where reimb_author= 1002

select *
from ers_reimbursement
where reimb_resolver= 1001

DELETE FROM ers_reimbursement WHERE reimb_description IS NULL;

select * from ers_users;
select * from ers_reimbursement
--
select   main.REIMB_ID,  ers_users.user_first_name, main.reimb_amount, main.reimb_submitted, main.reimb_resolved, main.reimb_description, rtype.reimb_type, status.reimb_status
from ers_reimbursement main
inner join ers_users                                  on main.reimb_author = ers_users.ers_users_id
inner join  ers_reimbursement_type     rtype     on main.reimb_type_id = rtype.reimb_type_id
inner join ers_reimbursement_status  status     on main.reimb_status_id = status.reimb_status_id
/
commit;


select * from ers_reimbursement_status