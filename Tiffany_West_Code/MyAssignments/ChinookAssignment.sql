7--2.1 Select

--select all records from the Employee table.

select * from employee;
--Task – Select all records from the Employee table where last name is King.
select * from employee where lastname = 'King';

 --Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
 select * from employee where firstname = 'Andrew' ;
 --2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT *FROM album order by title desc;

--Task – Select first name from Customer and sort result set in ascending order by city--
select firstname  from customer order by city asc;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
select * from genre;
INSERT INTO genre(genreid,name) VALUES(26,'Soca');

INSERT INTO genre(genreid,name) VALUES(27,'Gospel');
--Task – Insert two new records into Employee table
select * from Employee;
INSERT INTO Employee(employeeid, lastname, firstname ,title, reportsto,birthdate,hiredate,address,city,state,country,postalcode,phone,fax,email)
VALUES(9,'Adam', 'Tiffy', 'IT Staff',6, TO_DATE('1997/05/03 ', 'yyyy/mm/dd'), TO_DATE('2013/05/03 ', 'yyyy/mm/dd'),'11121 Jasper Ave NW','Edmonton','AB', 'Canada','T5K 2N1','+1 (403) 262-3453','+1 (403) 262-3413','tiffy@chinookcorp.com');

INSERT INTO Employee(employeeid, lastname, firstname ,title, reportsto,birthdate,hiredate,address,city,state,country,postalcode,phone,fax,email)
VALUES(10,'Parker', 'Major', 'IT Manager',1, TO_DATE('2001/06/05 ', 'yyyy/mm/dd'), TO_DATE('2019/05/09 ', 'yyyy/mm/dd'),'11124 Jasper Ave NW','Edmonton','AB', 'Canada','T5K 2N1','+1 (403) 662-3453','+1 (403) 262-3313','major@chinookcorp.com');

--Task – Insert two new records into Customer table
select * from customer
insert into customer (customerid, firstname,lastname,address, city,state, country,postalcode,phone,email,supportrepid)
values (61, 'Marc', 'Jacobs','124 Street', 'Brooklyn', 'NY', 'USA', '11233','917765483', 'marcj@gmail.com',6);
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
select * from customer where firstname = 'Aaron';

update customer set firstname= 'Robert',
lastname = 'Walter'
where customerid = 32;
select * from customer where firstname= 'Robert';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
select * from artist where  name = 'Creedence Clearwater Revival';
update artist  set name= 'CCR'
where artistid =76;
select * from artist where name = 'CCR';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
select * from invoice;
select billingaddress from invoice
where billingaddress like 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
select * from invoice where total between 15 and 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where lastname = 'Walter'
select *from employee where hiredate  between to_date('2003/06/01', 'yyyy/mm/dd')
AND TO_DATE ('2004/03/01', 'yyyy/mm/dd');

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
delete from customer where lastname = 'walter';
select * from customer where firstname = 'Robert'; 

delete from invoice where customerid =32;
delete from invoiceline 
where exists
( select invoice.customerid
from invoice
where invoice.invoiceid = invoiceline.invoiceid and customerid = 32);
/*
--3.0 SQL Functions
    In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database */
    
  --  3.1 System Defined Functions
    --Task – Create a function that returns the current time.
    select current_timestamp from dual;
    --Task – create a function that returns the length of a mediatype from the mediatype table
    
    select * from mediatype
    
    --3.2 System Defined Aggregate Functions
    
    --Task – Create a function that returns the average total of all invoices
    select round(avg(total)) from invoice;
    --Task – Create a function that returns the most expensive track
    select   max(unitprice) from track ;
    --3.3 User Defined Functions
    --Task – Create a function that returns the average price of invoiceline items in the invoiceline table
    
    select  avg(unitprice) from invoiceline;
    --3.4 User Defined Table Valued Functions
    --Task – Create a function that returns all employees who are born after 1968.
    select birthdate  
    from employee
    where birthdate >= TO_DATE ('1968/01/01', 'yyyy/mm/dd');
    
    --4.0 Stored Procedures
    --In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
    
    --4.1 Basic Stored Procedure
    --Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE GET_Names(N_CURS OUT SYS_REFCURSOR)
AS
BEGIN 
OPEN n_CURS FOR SELECT firstname, lastname FROM employee;
END;

/
    
    --4.2 Stored Procedure Input Parameters
    --Task – Create a stored procedure that updates the personal information of an employee.
    select * from employee
    create or replace procedure update_employee(e_id in number,e_ln in varchar2, e_fn in varchar2, e_ti in varchar2,e_rp in number)
    as begin
    update employee set
    lastname = e_ln,
    firstname = e_fn,
    title = e_ti,
    reportsto = e_rp
    where   employeeid = e_id;
    commit;
    end;
    /
    --Task – Create a stored procedure that returns the managers of an employee.
    select * from employee
  create procedure getManEmp
  (
  e_id as number,
  e_ln as varchar2,
  e_rp as number
  )
  as
  begin
        select employee.lastname as employee, manager.lastname as manager
from employee employee
join employee manager
on employee.reportsto = manager.employeeid;
end;
  
  
  
    --4.3 Stored Procedure Output Parameters
    --Task – Create a stored procedure that returns the name and company of a customer.
    select * from customer
    
    create procedure CustName_Com
    (
    c_id in number,
    c_fn out varchar2,
    c_ln out varchar2,
    c_com out varchar2
    )
    as begin
    select firstname, lastname , company
    from customer
    where customer.customerid = c_id;
    end;
    /
    
    --5.0 Transactions
    --In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
   -- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
   CREATE OR REPLACE PROCEDURE DELETE_INVOICE(INV_ID IN NUMBER)
IS
BEGIN
  DELETE FROM INVOICELINE WHERE INVOICEID = INV_ID;
  DELETE FROM INVOICE WHERE INVOICEID = INV_ID;
  COMMIT;
END;
/
    --Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
    select * from customer;
      CREATE OR REPLACE PROCEDURE NEW_CUSTOMER(cus_ID IN NUMBER,c_fn in varchar2, c_ln in varchar2, com in varchar2, add in varchar2,
      ct in varchar2, st in varchar2, cnt in varchar2, pc in varchar2, ph in number, fx in number, em in varchar2, s_id in number) 
IS
BEGIN
 insert into customer  set
 customerid= cusid,
 firstname = c_fn,
 lastname = c_ln,
 company = com,
 address = add,
 city = ct,
 state = st,
 country = cnt,
 postalcode = pc,
 phone = ph,
 fax = fx,
 email  = em,
 supportrepid = s_id
 
 WHERE customerid = c_ID;
  
  COMMIT;
END;
   /
    --  6.0 Triggers
    --In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
   
   -- 6.1 AFTER/FOR
    --Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
    CREATE OR REPLACE TRIGGER EMP_NEW  
   BEFORE INSERT ON employee
   FOR EACH ROW
   BEGIN
      
      SELECT emp.NEXTVAL
      INTO :NEW.employeeid
      FROM DUAL;
   END;
/
    --Task – Create an after update trigger on the album table that fires after a row is inserted in the table
        CREATE OR REPLACE TRIGGER EMP_NEW  
   after update ON employee
   FOR EACH ROW
   BEGIN
      
      SELECT emp.NEXTVAL
      INTO :NEW.employeeid
      FROM DUAL;
   END;
/
    --Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
        CREATE OR REPLACE TRIGGER EMP_NEW  
   after delete ON employee
   FOR EACH ROW
   BEGIN
      
      SELECT emp.NEXTVAL
      INTO :NEW.employeeid
      FROM DUAL;
   END;
/
    --7.0 JOINS
    --In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
    --7.1 INNER
    --Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
    select    cus.firstname, cus.lastname,   inv.billingaddress, inv.total
    from customer cus
    join invoice inv
    on cus.customerid = inv.customerid
    --7.2 OUTER
    --Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
      select  cus.customerid,  cus.firstname, cus.lastname,   inv.invoiceid, inv.total
    from customer cus
   full outer join invoice inv
    on cus.customerid = inv.customerid
    --7.3 RIGHT
    --Task – Create a right join that joins album and artist specifying artist name and title.
  select al.title AS album, art.name as "ARTIST NAME"
from album al
right join artist art
on al.artistid = art.artistid;
    --7.4 CROSS
    --Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
    
    select al.title, art.name 
from album al, artist art 
order by art.name asc;
    
    --7.5 SELF
    
    --Task – Perform a self-join on the employee table, joining on the reportsto column.
      select employee.lastname as employee, manager.lastname as manager
from employee employee
join employee manager
on employee.reportsto = manager.employeeid;
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
