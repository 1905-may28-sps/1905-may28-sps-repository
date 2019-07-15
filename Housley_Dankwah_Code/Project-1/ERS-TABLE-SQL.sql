CREATE TABLE ERS_REIMBURSEMENT
( 
REIMB_ID        NUMBER NOT NULL,
REIMB_AMOUNT    NUMBER(8,2) NOT NULL,
REIMB_SUBMITTED TIMESTAMP NOT NULL,
REIMB_RESOLVED  TIMESTAMP NOT NULL,
REIMB_DESCRIPTION VARCHAR2(400) NOT NULL,
REIMB_RECEIPT   BLOB,
REIMB_AUTHOR    NUMBER NOT NULL,
REIMB_RESOLVER  NUMBER,
REIMB_STATUS_ID NUMBER,
REIMB_TYPE_ID   NUMBER,
CONSTRAINT PK_ERS_REIMBURSMENT PRIMARY KEY (REIMB_ID),
CONSTRAINT FK_ERS_USERS_AUTH FOREIGN KEY (REIMB_AUTHOR) REFERENCES ERS_USERS (ERS_USERS_ID),
CONSTRAINT FK_ERS_USERS_RESLVR FOREIGN KEY (REIMB_RESOLVER) REFERENCES ERS_USERS (ERS_USERS_ID),
CONSTRAINT FK_ERS_REIMBURSMENT_STATUS FOREIGN KEY (REIMB_STATUS_ID) REFERENCES ERS_REIMBURSEMENT_STATUS (REIMB_STATUS_ID),
CONSTRAINT FK_ERS_REIMBURSMENT_TYPE FOREIGN KEY (REIMB_TYPE_ID) REFERENCES ERS_REIMBURSEMENT_TYPE (REIMB_TYPE_ID)
);

CREATE TABLE ERS_USERS 
(
ERS_USERS_ID    NUMBER NOT NULL,
ERS_USERNAME    VARCHAR2(50)UNIQUE,
ERS_PASSWORD    VARCHAR2(50),
USER_FIRST_NAME VARCHAR2(100),
USER_LASTNAME   VARCHAR2(100),
USER_EMAIL      VARCHAR2(150) UNIQUE,
USER_ROLE_ID    NUMBER,
CONSTRAINT PK_ERS_USERS PRIMARY KEY (ERS_USERS_ID),
CONSTRAINT FK_USERS_ROLES FOREIGN KEY (USER_ROLE_ID) REFERENCES ERS_USER_ROLES (ERS_USER_ROLE_ID)
);

CREATE TABLE ERS_REIMBURSEMENT_STATUS
(
REIMB_STATUS_ID  NUMBER NOT NULL,
REIMB_STATUS    VARCHAR2(10)NOT NULL,
CONSTRAINT PK_REIMB_STATUS PRIMARY KEY (REIMB_STATUS_ID)
);

CREATE TABLE ERS_REIMBURSEMENT_TYPE 
(
REIMB_TYPE_ID   NUMBER NOT NULL,
REIMB_TYPE       VARCHAR2(10) NOT NULL,
CONSTRAINT PK_REIM_TYPE PRIMARY KEY (REIMB_TYPE_ID)
);

CREATE TABLE ERS_USER_ROLES
(
ERS_USER_ROLE_ID    NUMBER NOT NULL,
USER_ROLE           VARCHAR2(10) NOT NULL,
CONSTRAINT PK_ERS_USER_ROLE PRIMARY KEY (ERS_USER_ROLE_ID)
);

----------------------------------------------------------------------------------------------------------------------------
--
--SEQUENCES AND TRIGGERS FOR ID FIELD
--
----------------------------------------------------------------------------------------------------------------------------
------------------ ERS_USERS-SEQUENCE
CREATE SEQUENCE ERS_USERS_SEQ;
SELECT ERS_USERS_SEQ.NEXTVAL FROM DUAL;

   CREATE OR REPLACE TRIGGER ERS_USERS_TRIGGER 
   BEFORE INSERT ON BANK_USER
   FOR EACH ROW 
   BEGIN
     
      SELECT ERS_USERS_SEQ.NEXTVAL 
      INTO :NEW.ERS_USERS_ID 
      FROM DUAL;
   END;
/

------------------ERS_REIMBURSEMENT_SEQ

CREATE SEQUENCE ERS_REIMBURSEMENT_SEQ;
SELECT ERS_USERS_SEQ.NEXTVAL FROM DUAL;

   CREATE OR REPLACE TRIGGER ERS_REIMBURSEMENT_SEQ_TRIGGER 
   BEFORE INSERT ON ERS_REIMBURSEMENT
   FOR EACH ROW 
   BEGIN
     
      SELECT ERS_REIMBURSEMENT_SEQ.NEXTVAL 
      INTO :NEW.REIMB_ID 
      FROM DUAL;
      
   END;
/




----------------------------------------------------------------------------------------------------------------------------
--
--insert into table
--
----------------------------------------------------------------------------------------------------------------------------
-- USERS 
SELECT * FROM ERS_USERS;
insert into  ERS_USERS (ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LASTNAME, USER_EMAIL, USER_ROLE_ID)
VALUES (1, 'MSMITH', 'MS123', 'MIKE', 'SMITH', 'MSMITH@GMAIL.COM',1);

insert into  ERS_USERS (ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LASTNAME, USER_EMAIL, USER_ROLE_ID)
VALUES (2,'BCLINTON', 'BC123', 'WILLIAM', 'CLINTON', 'WILLIAMCLINTON@GMAIL.COM',1);

insert into  ERS_USERS (ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LASTNAME, USER_EMAIL, USER_ROLE_ID)
VALUES(3, 'MJORDAN', 'MJ23', 'MICHAEL', 'JORDAN','MJORDAN23@GMAIL.COM',2);

insert into  ERS_USERS (ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LASTNAME, USER_EMAIL, USER_ROLE_ID)
VALUES (4,'PBARNS','PB987','PETER', 'BARNS', 'PBARNS@HOTMAIL.COM',2);

-- ROLES
SELECT * FROM ers_user_roles;
INSERT INTO ERS_USER_ROLES (ERS_USER_ROLE_ID, USER_ROLE) 
VALUES (1, 'MANAGER');

INSERT INTO ERS_USER_ROLES (ERS_USER_ROLE_ID, USER_ROLE)
VALUES(2,'COACH');

---TYPES
SELECT * FROM ers_reimbursement_type;
INSERT INTO ers_reimbursement_type (reimb_type_id, REIMB_TYPE)
VALUES (1, 'SUPPLIES');

INSERT INTO ers_reimbursement_type (reimb_type_id, REIMB_TYPE)
VALUES (2, 'EDUCATION');

INSERT INTO ers_reimbursement_type (reimb_type_id, REIMB_TYPE)
VALUES (3, 'TRAVEL');

---STATUS
SELECT * FROM ers_reimbursement_status;
INSERT INTO ers_reimbursement_status (reimb_status_id, REIMB_STATUS)
VALUES (1, 'PENDING');

INSERT INTO ers_reimbursement_status (reimb_status_id, REIMB_STATUS)
VALUES (2, 'APPROVED');

INSERT INTO ers_reimbursement_status (reimb_status_id, REIMB_STATUS)
VALUES (3, 'DECLINED');

-- ERS REIMBURSEMENT
SELECT * FROM ers_reimbursement;
INSERT INTO ERS_REIMBURSEMENT (REIMB_ID,REIMB_AMOUNT,REIMB_SUBMITTED, REIMB_RESOLVED,REIMB_DESCRIPTION,REIMB_RECEIPT,
REIMB_AUTHOR,REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID) 
VALUES (1, 100.00, TO_TIMESTAMP('2019-04-22 06:14:00.742000000', 'YYYY-MM-DD HH24:MI:SS.FF'),
TO_TIMESTAMP('2019-06-12 09:34:00.742000000', 'YYYY-MM-DD HH24:MI:SS.FF'), 'TRANSPORTATION TO SCOUT HS GAMES',
NULL, 3, 2, 2, 3 );

INSERT INTO ERS_REIMBURSEMENT (REIMB_ID,REIMB_AMOUNT,REIMB_SUBMITTED, REIMB_RESOLVED,REIMB_DESCRIPTION,REIMB_RECEIPT,
REIMB_AUTHOR,REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID) 
VALUES (2, 300.00,TO_TIMESTAMP('2019-05-10 03:34:00.564000000', 'YYYY-MM-DD HH24:MI:SS.FF'), 
TO_TIMESTAMP('2019-06-29 13:45:00.675000000', 'YYYY-MM-DD HH24:MI:SS.FF'),'FLIGHT TO MIAMI HEATS STADIUM',
NULL, 4, 1, 1, 3 );



INSERT INTO ERS_REIMBURSEMENT (REIMB_ID,REIMB_AMOUNT,REIMB_SUBMITTED, REIMB_RESOLVED,REIMB_DESCRIPTION,REIMB_RECEIPT,
REIMB_AUTHOR,REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID) 
VALUES (2, 600.00,TO_TIMESTAMP('2019-05-10 03:34:00.564000000', 'YYYY-MM-DD HH24:MI:SS.FF'), 
TO_TIMESTAMP('2019-06-29 13:45:00.675000000', 'YYYY-MM-DD HH24:MI:SS.FF'),'FLIGHT TO MIAMI HEATS STADIUM',
NULL, 4, 1, 1, 3 );


INSERT INTO ERS_REIMBURSEMENT (REIMB_ID,REIMB_AMOUNT,REIMB_SUBMITTED, REIMB_RESOLVED,REIMB_DESCRIPTION,REIMB_RECEIPT,
REIMB_AUTHOR,REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID) 
VALUES (2, 50.00,TO_TIMESTAMP('2019-05-10 03:34:00.564000000', 'YYYY-MM-DD HH24:MI:SS.FF'), 
TO_TIMESTAMP('2019-06-29 13:45:00.675000000', 'YYYY-MM-DD HH24:MI:SS.FF'),'athletic paraphernalia for James Dawson',
NULL, 4, 1, 1, 3 );

COMMIT;


select * from ers_users;

select * from ERS_USERS  where lower(ERS_USERNAME) = 'mjordan';

select rm.reimb_id , us.user_first_name, us.user_lastname, rm.reimb_amount, 
rm.reimb_description, rm.reimb_submitted,  
rt.reimb_type, rs.reimb_status
from ers_users us
join ers_reimbursement rm
on us.ers_users_id = rm.reimb_author
join ers_reimbursement_status rs
on rm.reimb_status_id = rs.reimb_status_id
join ers_reimbursement_type rt
on rm.reimb_type_id = rt.reimb_type_id
where us.ers_users_id = 3;



