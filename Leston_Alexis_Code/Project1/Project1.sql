/********************************************
Creating User Tables
********************************************/

create table users(
    user_id number primary key,
    username varchar2(50) unique not null,
    password varchar2(100) not null,
    first_name varchar2(100) not null,
    last_name varchar2(100) not null,
    email varchar2(150) unique not null,
    role_id number not null,
    constraint user_roles_fk foreign key (role_id) references user_roles(role_id)
);



create table user_roles(
    role_id number primary key,
    user_role varchar2(20) not null
);



/********************************************
Creating Reimbursement Tables
********************************************/

create table reimbursement (
    reimb_id number primary key,
    reimb_amount number not null,
    reimb_submitted timestamp not null,
    reimb_resolved timestamp,
    reimb_description varchar2(250),
    reimb_receipt blob,
    reimb_author number not null,
    reimb_resolver number not null,
    reimb_status_id number not null,
    reimb_type_id number not null,
    constraint users_fk_auth foreign key (reimb_author) references users(user_id),
    constraint users_fk_reslvr foreign key (reimb_resolver) references users(user_id),
    constraint reimbursement_status_fk foreign key (reimb_status_id) references reimbursement_status(reimb_status_id),
    constraint reimbursement_type_fk foreign key (reimb_type_id) references reimbursement_type(reimb_type_id)
);



create table reimbursement_status(
    reimb_status_id number primary key,
    reimb_status varchar2(30) not null
);
 
create table reimbursement_type(
    reimb_type_id number primary key,
    reimb_type varchar2(30) not null
);

commit;

/********************************************
Insert Reimbursement Status & Type Values
        & User Role Values
********************************************/

insert into reimbursement_status values(1, 'Pending');
insert into reimbursement_status values(2, 'Approved');
insert into reimbursement_status values(3, 'Denied');


insert into reimbursement_type values(1, 'Travel');
insert into reimbursement_type values(2, 'Equipment');
insert into reimbursement_type values(3, 'Housing');
insert into reimbursement_type values(4, 'Other');


insert into user_roles values(1, 'Manager');
insert into user_roles values(2, 'Employee');


/********************************************
Inserting Users into the User Table
********************************************/

insert into users values(1, 'Leston.a', 'leo123', 'Leston', 'Alexis', 'Leston.alexis@mail.com', 1);

insert into users values(2, 'leston06', 'leo321', 'lest', 'alex', 'leo.alex@mail.com', 2);
insert into users values(3, 'elston.a', 'els321', 'Elston', 'Alexis', 'ealexis@mail.com', 2);
insert into users values(4, 'john.j', 'jhn321', 'John', 'Jerome', 'jjerome@mail.com', 2);
insert into users values(5, 'chloe.t', 'chl321', 'Chloe', 'Thomas', 'cthomas@mail.com', 2);
insert into users values(6, 'kadeem.j', 'kad321', 'Kadeem', 'James', 'kjames@mail.com', 2);

insert into reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author,
reimb_type_id, reimb_status_id) values(500.0, '14-DEC-2016', 'Equipment needed to complete job', 2, 2, 1);

insert into reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author,
reimb_type_id, reimb_status_id) values(85.0, '29-DEC-2016', 'Travel expenses to seminar', 3, 1, 1);

insert into reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author,
reimb_type_id, reimb_status_id) values(225.0, '2-NOV-2016', 'Hotel for CEO of partner company', 4, 3, 1);

insert into reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author,
reimb_type_id, reimb_status_id) values(405.0, '6-SEP-2016', 'New Equipment', 3, 2, 1);

insert into reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author,
reimb_type_id, reimb_status_id) values(55.0, '13-NOV-2016', 'Lunch for office', 6, 4, 1);

insert into reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author,
reimb_type_id, reimb_status_id) values(375.0, '19-OCT-2016', 'Freezer for office', 5, 2, 1);


/*******************************************
Sequences & Triggers
********************************************/     

CREATE SEQUENCE REIMB_SEQ 
 START WITH 1
 INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER REIMB_TRIGGER
 BEFORE INSERT ON REIMBURSEMENT
 FOR EACH ROW
 DECLARE 
   TEMP NUMBER;
 BEGIN
   SELECT REIMB_SEQ.NEXTVAL
   INTO   TEMP
   FROM   DUAL;
   :NEW.REIMB_ID := TEMP;
END;
/
commit;
select * from REIMBURSEMENT;

CREATE OR REPLACE PROCEDURE GET_ALL_REIMBURSEMENTS(REIMBURSEMENT OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN REIMBURSEMENT FOR
SELECT REIMB_ID, REIMB_AMOUNT,
s.REIMB_STATUS_ID, s.REIMB_STATUS, 
t.REIMB_TYPE_ID, t.REIMB_TYPE,
REIMB_DESCRIPTION, REIMB_SUBMITTED, REIMB_RESOLVED,
u.USER_ID AS AUTHOR_ID, 
u.USERNAME AS AUTHOR_USERNAME, 
u.FIRST_NAME AS AUTHOR_FIRST_NAME, 
u.LAST_NAME AS AUTHOR_LAST_NAME, 
u.EMAIL AS AUTHOR_EMAIL
FROM REIMBURSEMENT r
  JOIN REIMBURSEMENT_TYPE t
  ON r.REIMB_TYPE_ID = t.REIMB_TYPE_ID
    JOIN REIMBURSEMENT_STATUS s
    ON r.REIMB_STATUS_ID = s.REIMB_STATUS_ID
      Left JOIN USERS u
      ON r.REIMB_AUTHOR = u.USER_ID;
END;
/
COMMIt;
select * from users where username = 'leston06';