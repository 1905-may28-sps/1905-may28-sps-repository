----SQL Assignenment
--
--Part I – Working with an existing database 
--1.0 Setting up Oracle Chinook 
--In this section you will begin the process of working with the Oracle Chinook database 
--Task – Open the Chinook_Oracle.sql file and execute the scripts within. 
--2.0 SQL Queries 
--In this section you will be performing various queries against the Oracle Chinook database. 
--2.1 SELECT 
--Task – Select all records from the Employee table. 
select * from employee;
--Task – Select all records from the Employee table where last name is King. 
select* from employee where lastname='King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL. 
select * from employee where firstname='Andrew' and REPORTSTO IS NULL;
--2.2 ORDER BY 
--Task – Select all albums in Album table and sort result set in descending order by title. 
SELECT * FROM ALBUM ORDER BY TITLE DESC;
--Task – Select first name from Customer and sort result set in ascending order by city 
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY;
--2.3 INSERT INTO 
--Task – Insert two new records into Genre table 
SELECT * FROM GENRE;
INSERT INTO GENRE (GENREID, NAME)
SELECT 28,'GENRE 3'FROM DUAL
UNION ALL SELECT 29, 'GENRE 4' FROM DUAL;
--Task – Insert two new records into Employee table 
SELECT * FROM EMPLOYEE;
delete from employee where employeeid=10;
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTStO, BIRTHDAte, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE,PHONE, FAX, EMAIL)
SELECT 9,'Zhang','Franklin','Minion',6,'29-Apr-92','25-May-19','25 Foxcroft Rd', 'Manhasset', 'NY', 'USA', '11030', '646-457-7701', '646-457-7701', 'Franklinjzhang@gmail.com' from dual
union all SELECT 10,'Zhang','ji','Minion',6,'02-Apr-92','25-May-19','25 Foxcroft Rd', 'Manhasset', 'NY', 'USA', '11030', '646-457-7701', '646-457-7701', 'spam@gmail.com' from dual;
--Task – Insert two new records into Customer table 
select * from customer;
delete from customer where customerid= 61;

insert into customer(CUSTOMERID, FIRSTNAME, LASTNAME, ADDRESS, CITY,PHONE,EMAIL, SUPPORTREPID)
SELECT 60,'Dan', 'Brown','Somewhere','NYC','123-123-1234','db@db.com',10 from dual
union all SELECT 61,'Luke', 'Skywalker','Far Far Away', 'Galaxy','123-123-1233','LS@force.org',10 from dual;

--2.4 UPDATE 
--Task – Update Aaron Mitchell in Customer table to Robert Walter 
select * from customer where firstname='Robert';
update customer set firstname='Robert', lastname='Walter'
where firstname='Aaron' and  lastname='Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR” 
select * from artist;
update artist set name='CCR'
where name='Creedence Clearwater Revival';
--2.5 LIKE 
--Task – Select all invoices with a billing address like “T%” 
select * from invoice where billingaddress like 'T%';

--2.6 BETWEEN 
--Task – Select all invoices that have a total between 15 and 50 
select * from invoice
where total between 15 and 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004 
select * from employee
where hiredate between '01-Jun-03' and '01-Mar-04';
--2.7 DELETE 
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them). SQL Work Book 

delete from customer where firstname='Robert' and lastname='Walter';
--
--3.0 SQL Functions 
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database 
--3.1 System Defined Functions 
--Task – Create a function that returns the current time. 
SELECT CURRENT_TIMESTAMP from dual;
--Task – create a function that returns the length of a mediatype from the mediatype table 
select * from mediatype;
select length(name) from mediatype;
--3.2 System Defined Aggregate Functions 
--Task – Create a function that returns the average total of all invoices 
select * from invoice;
select avg(total) from invoice;
--Task – Create a function that returns the most expensive track 
select name from track
where unitprice=(select max(unitprice)from track);
--3.3 User Defined Functions 
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table 
select * from invoiceline;
select avg(unitprice) from invoiceline;
--3.4 User Defined Table Valued Functions 
--Task – Create a function that returns all employees who are born after 1968. 

create or replace function emp_older
return varchar2 as older varchar2(200);
begin
  select count(employeeid) 
  into older from employee
  where
  birthdate>='01-Jan-68';
  return older;
end emp_older;
/
select emp_older() from dual;
select firstname from employee where birthdate>='01-Jan-68';
--4.0 Stored Procedures 
--In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters. 
--4.1 Basic Stored Procedure 
--Task – Create a stored procedure that selects the first and last names of all the employees.
 drop procedure FIRST_LAST;
CREATE or replace PROCEDURE FIRST_LAST(f_curs out sys_refcursor)
as
  begin
    open f_curs for SELECT FIRSTNAME, lastname FROM EMPLOYEE;
  end;
/
VAR RC  REFCURSOR
EXECUTE FIRST_LAST(:RC)
PRINT RC;

--4.2 Stored Procedure Input Parameters 
--Task – Create a stored procedure that updates the personal information of an employee. 
select* from employee;
create or replace procedure update_employee_info
(lnm in varchar2, fnm in varchar2,addre in varchar2, ct in varchar2, st in varchar2, cty in varchar2,
zp in varchar2, phn in varchar2, fx in varchar2, eml in varchar2)
as
begin
  update employee
  set address=addre, city=ct, state=st, country=cty, postalcode=zp, phone=phn, fax=fx, email=eml
  where firstname=fnm and lastname=lnm;
end;
/
--Task – Create a stored procedure that returns the managers of an employee. 
--4.3 Stored Procedure Output Parameters 
--Task – Create a stored procedure that returns the name and company of a customer. 

create or replace procedure cust_info_by_id (cust_id in number, custinfo_curs out sys_refcursor)
as
begin
open custinfo_curs for select firstname, lastname, company from customer where customerid=cust_id;
end;
/
  var rx refcursor
  execute cust_info_by_id(60,:rx);
  print rx;

--5.0 Transactions 
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. 
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them). 
START TRANSACTION;
DELETE FROM INVOICE WHERE INVOICEID=60; 
COMMIT;
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table SQL Work Book 
--
select* from customer;
create or replace procedure Insert_customer
(c_id in number, fnm in varchar2,lnm in varchar2, cp in varchar2, addre in varchar2, ct in varchar2, st in varchar2, cty in varchar2,
zp in varchar2, phn in varchar2, fx in varchar2, eml in varchar2, sri in number)
as
--i thought begin means begin transaction so every procedure has a nested transaction...
begin
 insert into customer(CUSTOMERID, FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
 VALUES(C_ID, FNM, LNM, CP, ADDRE,CT,ST,CTY,ZP,PHN,FX,EML,SRI);
 COMMIT;
end;
/
--6.0 Triggers 
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table. 
--6.1 AFTER/FOR 
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table. 
create trigger after_employee_insert
after insert on employee
for each row
begin
  commit;
end;
/
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table 
create trigger after_employee_update
after update on employee
for each row
begin
  commit;
end;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table. 
create trigger after_employee_delete
after delete on employee
for each row
begin
  commit;
end;
/
--7.0 JOINS 
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins. 
--7.1 INNER 
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId. 
select* from invoice;
select* from customer;


select customer.firstname,customer.lastname,invoice.invoiceid from customer inner join invoice on customer.customerid=invoice.customerid;
--7.2 OUTER 
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total. 
select customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total from invoice full outer join customer on customer.customerid=invoice.customerid;
--7.3 RIGHT 
--Task – Create a right join that joins album and artist specifying artist name and title. 
select * from artist;
select * from album;
select name, title from album right join artist on artist.artistid=album.artistid;
--7.4 CROSS 
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order. 
select name, title from artist cross join album;
--7.5 SELF 
--Task – Perform a self-join on the employee table, joining on the reportsto column. 
select * from employee;
select empl.employeeid as employee, boss.employeeid as boss from employee empl join employee boss on empl.reportsto = boss.employeeid;
--7.6 Complicated Join assignment 
--Create an inner join between all tables in the chinook database.
select track.name as TRACKNAME, album.title, artist.name, genre.name as genre, 
playlist.NAME as playlist, invoice.BILLINGCITY
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


--9.0 Administration 
--In this section you will be creating backup files of your database. After you create the backup file you will also restore the database. 
--Task – Create a .bak file for the Chinook database SQL Work Book 
--
