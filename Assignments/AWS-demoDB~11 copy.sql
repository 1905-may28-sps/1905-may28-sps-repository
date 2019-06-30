--Revature SQL WORKBOOK


--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

--Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE lastname = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' and reportsto is null;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
select * from album order by title desc;

--Task – Select first name from Customer and sort result set in ascending order by city
select firstname from customer order by city asc;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
select * from genre;
insert into genre (genreid, name) values(26, 'Go-go');
insert into genre (genreid, name) values(27, 'Trap Music');

--Task – Insert two new records into Employee table

select * from employee;
insert into employee (employeeid, lastname, firstname, title, 
reportsto, birthdate, hiredate, address, city, state, country, postalcode, 
phone, fax, email) 
values (9, 'Smith', 'Mike', 'Sales Manager', 1, '1-APR-88',
'12-MAY-05', '3333 Zion Dr', 'New Yor', 'NY', 'United States', '12549','+1(123) 345-7890',
'+1(301) 937-7519', 'sfas@gmail.com');     

insert into employee (employeeid, lastname, firstname, title, 
reportsto, birthdate, hiredate, address, city, state, country, postalcode, 
phone, fax, email) values (10, 'Steve', 'Jones', 'CTO', null, '10-AUG-83', '23-JAN-04', 
'897 Trinity lane', 'Secaucus', 'NJ', 'United States', '13432', '+1(432) 342-3432', '+1(437) 879-4354',
'dsfas@gmail.com');


--Task – Insert two new records into Customer table
select * from customer;

insert into customer (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE,
PHONE, FAX, EMAIL, SUPPORTREPID) 
VALUES (60, 'Brian', 'Johnson', 'Google', '234 Google drive', 'San Francisco', 'CA', 'United States', '34556',
'+1(897) 786-5676', '+1(897) 324-2314', 'asdfa@gmail.com', 8);

insert into customer (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE,
PHONE, FAX, EMAIL, SUPPORTREPID) 
VALUES (61, 'Keith', 'Morris', 'Apple', '344 Apple way', 'San Francisco', 'CA', 'United States', '34554',
'+1(897) 765-3423', '+1(897) 324-6578', 'gfhgjd@gmail.com', 5);


--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
Update Customer set firstname = 'Robert', lastname= 'Walter' 
where firstname = 'Aaron' and lastname = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
select * from artist where name = 'Creedence Clearwater Revival';
Update Artist set name = 'CCR' where name = 'Creedence Clearwater Revival';
select * from artist where name = 'CCR';


--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
select * from invoice where billingaddress like 'T%';


--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
select * from invoice where total >15 and total<50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004

select * from employee where hiredate > '1-Jun-03' and hiredate <'1-MAR-04';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints
--that rely on this, find out how to resolve them).

ALTER TABLE Invoice drop CONSTRAINT FK_InvoiceCustomerId;

ALTER TABLE Invoice ADD CONSTRAINT FK_InvoiceCustomerId
FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId)
on delete cascade;


ALTER TABLE InvoiceLine drop CONSTRAINT FK_InvoiceLineInvoiceId;
ALTER TABLE InvoiceLine ADD CONSTRAINT FK_InvoiceLineInvoiceId
    FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId)
    on delete CASCADE;
    
DELETE FROM CUSTOMER where firstname ='Robert' and lastname = 'Walter';
select * from Customer where firstname = 'Robert' and lastname = 'Walter';
select * from invoice where customerid = 32;


--3.0 SQL Functions----------------------------------------------------------------------------
--In this section you will be using the Oracle system functions, as well as your own functions, to perform
--various actions against the database


--3.1 System Defined Functions
--Task – Create a function that returns the current time.

create or replace function getCurrentdate
return TIMESTAMP WITH TIME ZONE is

  testCurrentTime TIMESTAMP WITH TIME ZONE;

begin

 SELECT CURRENT_DATE
    into testCurrentTime
    from dual;

  return testCurrentTime;

end;
/

select getCurrentdate() from dual;
-------------------------------------------------------------------------------
create or replace function getCurrentTime
return TIMESTAMP is

  testCurrentTime TIMESTAMP;

begin

 SELECT CURRENT_TIMESTAMP 
    into testCurrentTime
    from dual;

  return testCurrentTime;

end;
/

select getCurrentTime() from dual;



--Task – create a function that returns the length of a mediatype from the mediatype table
select * from mediatype;

select name , length(mt.name)
from mediatype mt;

create or replace function getLength
return number is

  mediaTypeLength number;

begin

select length(mt.name)
   into mediaTypeLength
    from mediatype mt
    where mt.mediatypeid = 5;

  return mediaTypeLength;

end;
/

select getLength() from dual;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
SELECT * FROM INVOICE;
select AVG(TOTAL) FROM INVOICE;

create or replace function getAvgInvoice
return number is

  avgInvoice number;

begin

select AVG(total)
   into avgInvoice
    from invoice;

  return avgInvoice;

end;
/
select getAvgInvoice() from dual;
----------------------------------------------------------------------------
--Task – Create a function that returns the most expensive track

select * from track;
select MAX(unitprice) from track;

create or replace function getMaxTrack
return number is

  maxTrack number;

begin

select MAX(unitprice)
   into maxTrack
    from track;

  return maxTrack;

end;
/
select getMaxTrack() from dual;


--3.3 User Defined Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
select * from invoiceline;

create or replace function avgInvoiceline
return number is
avgPrice number;

begin

select AVG(unitprice)
    into avgPrice
    from invoiceline
    where invoiceid = 123;

return avgprice;
end;
/

select avgInvoiceline() from dual;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.


create type employeeTypeRow as object (
    EmployeeId NUMBER,
    LastName VARCHAR2(20),
    FirstName VARCHAR2(20),
    Title VARCHAR2(30),
    ReportsTo NUMBER,
    BirthDate DATE,
    HireDate DATE,
    Address VARCHAR2(70),
    City VARCHAR2(40),
    State VARCHAR2(40),
    Country VARCHAR2(40),
    PostalCode VARCHAR2(10),
    Phone VARCHAR2(24),
    Fax VARCHAR2(24),
    Email VARCHAR2(60)
    );
    
create or replace type employeeTypeTable is TABLE of employeeTypeRow;


create or replace function empBirthdate
return employeeTypeTable 
AS emp employeeTypeTable; 
BEGIN
insert into employeeTypeTable (employeeid, lastname, firstname, title, 
reportsto, birthdate, hiredate, address, city, state, country, postalcode, 
phone, fax, email)  select employeeid, lastname, firstname, title, 
reportsto, birthdate, hiredate, address, city, state, country, postalcode, 
phone, fax, email from employee
where birthdate > '1-JAN-68';
end;
/

select empBirthdate() from dual;










select * from employee
where birthdate > '1-JAN-68' order by birthdate;



-- 4.0 Stored Procedures--------------------------------------------------------
--In this section you will be creating and executing stored procedures. You will be creating various types
--of stored procedures that take input and output parameters.

--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
select firstname, lastname from employee;

CREATE OR REPLACE PROCEDURE testEmployeeName (
p_firstname out varchar2,
p_lastname out varchar2)
IS
BEGIN
select E.firstname, E.lastname INTO
p_firstname,
p_lastname
from employee E;
END;
/

exec testEmployeeName(employee);

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.


--Task – Create a stored procedure that returns the managers of an employee.


--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.




--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.

--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
--rely on this, find out how to resolve them).


--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table


--------------------------------------------------------------------------------------------------------------------
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

   
   CREATE TABLE BackupEmployee
(
    EmployeeId NUMBER NOT NULL,
    LastName VARCHAR2(20) NOT NULL,
    FirstName VARCHAR2(20) NOT NULL,
    Title VARCHAR2(30),
    ReportsTo NUMBER,
    BirthDate DATE,
    HireDate DATE,
    Address VARCHAR2(70),
    City VARCHAR2(40),
    State VARCHAR2(40),
    Country VARCHAR2(40),
    PostalCode VARCHAR2(10),
    Phone VARCHAR2(24),
    Fax VARCHAR2(24),
    Email VARCHAR2(60),
    CONSTRAINT PK_BankupEmployee PRIMARY KEY  (EmployeeId)
);
   
   
   
   CREATE OR REPLACE TRIGGER INSERT_EMPLOYEE_TRIGGER 
   AFTER INSERT ON EMPLOYEE
   FOR EACH ROW 
   
   BEGIN
   
    INSERT INTO BackupEmployee values (:new.employeeid, :new.lastname, :new.firstname, :new.title, 
:new.reportsto, :new.birthdate, :new.hiredate, :new.address, :new.city, :new.state, :new.country, :new.postalcode, 
:new.phone, :new.fax, :new.email);

    DBMS_OUTPUT.PUT_LINE('Record successfully inserted into EMPLOYEE table');
    
   END;
/

insert into employee (employeeid, lastname, firstname, title, 
reportsto, birthdate, hiredate, address, city, state, country, postalcode, 
phone, fax, email) values (12, 'Steve', 'Jones', 'CTO', null, '10-AUG-83', '23-JAN-04', 
'897 Trinity lane', 'Secaucus', 'NJ', 'United States', '13432', '+1(432) 342-3432', '+1(437) 879-4354',
'dsfas@gmail.com');

insert into employee (employeeid, lastname, firstname, title, 
reportsto, birthdate, hiredate, address, city, state, country, postalcode, 
phone, fax, email) 
values (11, 'Smith', 'Mike', 'Sales Manager', 1, '1-APR-88',
'12-MAY-05', '3333 Zion Dr', 'New Yor', 'NY', 'United States', '12549','+1(123) 345-7890',
'+1(301) 937-7519', 'sfas@gmail.com');   

SELECT * FROM BackupEmployee;


--Task – Create an after update trigger on the album table that fires after a row is inserted in the table

CREATE OR REPLACE TRIGGER UPDATE_ALBUM_TRIGGER 
AFTER UPDATE ON ALBUM
FOR EACH ROW 
BEGIN   
DBMS_OUTPUT.PUT_LINE('ALBUM TABLE HAS JUST BEEN UPDATED');
END;
/

UPDATE ALBUM set title = 'Big Ones Show' where title = 'Big Ones';

SELECT * FROM ALBUM;


--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER DELETE_CUSTOMER_TRIGGER
AFTER DELETE ON CUSTOMER 
FOR EACH ROW 
BEGIN
DBMS_OUTPUT.PUT_LINE('CUSTOMER ROW WAS JUST DELETED');
END;
/

SELECT * FROM CUSTOMER;

DELETE FROM CUSTOMER WHERE customerid = 32;


--------------------------------------------------------------------------------------------------------------------
--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

SELECT * from customer;
select * from invoice;

select c.firstname, c.lastname, i.invoiceid
from customer c 
inner join invoice i
on c.customerid = i.customerid
order by c.customerid;

select c.firstname, c.lastname, i.invoiceid
from customer c 
inner join invoice i
on c.customerid = i.customerid
order by c.lastname;


--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
from customer c
full outer join invoice i
on c.customerid = i.customerid
order by c.lastname;


--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.

select at.name, ab.title
from album ab
right join artist at
on ab.artistid = at.artistid
order by at.name;


--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

select at.name, ab.title
from album ab
cross join artist at
order by at.name asc;

select *
from album ab
cross join artist at
order by at.name asc;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.

select  a. firstname, a.lastname, b.firstname as manager_is, b.lastname  
from employee a join employee b
on a.employeeid = b.reportsto;



--7.6 Complicated Join assignment
--Create an inner join between all tables in the chinook database.

select track.name as TRACKNAME, album.title as ALBUMTITLE, artist.name ARTISTNAME, genre.name as genre, 
playlist.NAME as playlist, invoice.BILLINGCITY, 
from track 
join album on track.albumid = album.albumid 
join artist on artist.artistid = album.artistid
join genre on genre.genreid = track.genreid
join playlisttrack on playlisttrack.TRACKID = track.trackid
join playlist on playlist.PLAYLISTID = playlisttrack.PLAYLISTID
join mediatype on mediatype.MEDIATYPEID = track.MEDIATYPEID
join invoiceline on invoiceline.TRACKID = track.trackid
join invoice on invoice.INVOICEID = invoiceline.INVOICEID
join customer on invoice.CUSTOMERID = customer.CUSTOMERID
join employee on employee.EMPLOYEEID = customer.SUPPORTREPID;
