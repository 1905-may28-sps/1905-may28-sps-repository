 --2.1 SELECT 
SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';

SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY
SELECT * FROM ALBUM
ORDER BY TITLE DESC;

SELECT * FROM CUSTOMER 
ORDER BY CITY;

--2.3 INSERT INTO
--INSERT TWO NEW RECORDS INTO GENRE TABLE.
INSERT INTO GENRE (GENRE_ID, NAME) VALUES (200, 'VIJI');
INSERT INTO GENRE (GENRE_ID, NAME) VALUES (250, 'PETER');
SELECT * FROM GENRE;

--INSERT TWO NEW RECORDS IN EMPLOYEE TABLE
SELECT * FROM EMPLOYEE;
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (9, 'Viji', 'Lake');
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (10, 'Anil','Kumar');
SELECT * FROM EMPLOYEE;

--INSERT INTO TWO NEW RECORDS INTO CUSTOMER TABLE
SELECT * FROM CUSTOMER;
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (90, 'John', 'Thomas', 'thomas@gmail.com');
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (91, 'Alice', 'King', 'alice@hotmail.com');
SELECT * FROM CUSTOMER;

--2.4 UPDATE
--UPDATE Aaron Mitchell in customer table to 'Robert Walter'
SELECT * FROM CUSTOMER 
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

UPDATE CUSTOMER 
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND  LASTNAME = 'Mitchell' ;
SELECT * FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--UPDATE NAME OF ARTIST IN THE ARTIST TABLE "Creedence Clearwater Revival" to "CCR"
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

SELECT * FROM ARTIST;
COMMIT;
--2.5 LIKE
--SELECT ALL INVOICES WITH A BILLING ADDRESS LIKE "T%"
SELECT * FROM INVOICE 
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--SELECT ALL INVOICES THAT HAVE A TOTAL BETWEEN 15 AND 50
SELECT * FROM INVOICE 
WHERE TOTAL BETWEEN 15 AND 50;
--SELECT ALL EMPLOYEES HIRED BETWEEN 1ST OF JUNE 2003 AND 1ST OF MARCH 2004.
SELECT * FROM EMPLOYEE;
--WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';
SELECT  FIRSTNAME, LASTNAME, HIREDATE, CITY FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-2003' AND '01-MAR-2004';

--2.7 Delete
--Delete a record in Customer table where the name is Robert Walter(There may be 
--Constraints that rely on this, find out how to resolve them).
SELECT * FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME ='Walter';

ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICE_CUSTOMER;
ALTER TABLE INVOICE ADD CONSTRAINT FK_INVOICE_CUSTOMER
FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER (CUSTOMERID)
ON DELETE CASCADE;

ALTER TABLE INVOICELINE DROP CONSTRAINT FK_INVOICELINE_CUSTOMER;
ALTER TABLE INVOICELINE ADD CONSTRAINT FK_INVOICELINE_CUSTOMER
FOREIGN KEY (INVOICEID) REFERENCES CUSTOMER (INVOICEID)
ON DELETE CASCADE;
DELETE FROM CUSTOMER  WHERE FIRSTNAME = 'Robert' AND LASTNAME ='Walter' 

SELECT * FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME ='Walter';

  -- SQL Functions
  --3.1 System Defined Functions
  --Create a function that returns the current time.
  
--Function Example
CREATE OR REPLACE FUNCTION INV_PRICE_AVG --create [or replace] function function name
 RETURN NUMBER
IS
 INV_AVERAGE NUMBER(8,4);
BEGIN
  SELECT AVG(UNITPRICE) INTO INV_AVERAGE FROM INVOICELINE;
  RETURN INV_AVERAGE;
END;
/

SELECT INV_PRICE_AVG() FROM DUAL;
--Create a function that returns the current time.
CREATE OR REPLACE FUNCTION GET_CURRENT_TIME
RETURN TIMESTAMP IS
A_CURRENT_TIME TIMESTAMP;
BEGIN
SELECT CURRENT_TIMESTAMP
INTO A_CURRENT_TIME 
FROM DUAL;
RETURN A_CURRENT_TIME;
END;
/
SELECT GET_CURRENT_TIME FROM DUAL;

--Create a function that returns the length of a mediatype from the mediatype table.
SELECT LENGTH(NAME) AS MEDIATYPE_LENGTH FROM MEDIATYPE;

CREATE OR REPLACE FUNCTION GET_MEDIATYPE_LENGTH
RETURN NUMBER 
IS
MEDIATYPE_LENGTH NUMBER(8,2);
BEGIN
 SELECT LENGTH(NAME) INTO MEDIATYPE_LENGTH FROM MEDIATYPE
 WHERE MEDIATYPEID = 2;
 RETURN MEDIATYPE_LENGTH;
END;
/

SELECT GET_MEDIATYPE_LENGTH() FROM DUAL;
SELECT MEDIATYPEID, NAME FROM MEDIATYPE;

CREATE OR REPLACE FUNCTION GET_MEDIATYPE_LEN
RETURN NUMBER 
IS
  MEDIATYPE_LEN NUMBER(8,2);
BEGIN
 SELECT LENGTH(NAME) INTO MEDIATYPE_LEN FROM MEDIATYPE;
 RETURN MEDIATYPE_LEN;
END;
/
SELECT GET_MEDIATYPE_LEN() FROM DUAL;


--Create a function that returns the average total of all invoices.
SELECT INVOICEID,INVOICEDATE, TOTAL FROM INVOICE;
SELECT AVG(TOTAL) AS AVG_TOTAL  FROM INVOICE;


CREATE OR REPLACE FUNCTION GET_AVGERAGE_TOTAL
RETURN NUMBER 
IS
AVGERAGE_TOTAL NUMBER(10,2);
BEGIN
	SELECT AVG(TOTAL) INTO AVGERAGE_TOTAL FROM INVOICE;
	RETURN AVGERAGE_TOTAL;
END;
/

SELECT GET_AVGERAGE_TOTAL FROM INVOICE;

SELECT GET_AVG_TOTAL FROM DUAL;

--Create a function that returns the most expensive track.
SELECT  NAME, TRACKID, UNITPRICE FROM TRACK;
SELECT MAX(UNITPRICE) FROM TRACK;

CREATE OR REPLACE FUNCTION FIND_MAX_PRICE
RETURN NUMBER 
IS
  MAX_PRICE NUMBER(10,2);
BEGIN
SELECT MAX(UNITPRICE) INTO MAX_PRICE FROM TRACK;
RETURN MAX_PRICE;
END;
/

SELECT FIND_MAX_PRICE FROM DUAL;

--3.3 User defined functions:
--Create a function that returns the average price of invoiveline items in the invoiceline table.
SELECT SUM(UNITPRICE)/ SUM(QUANTITY) AS AVGERAGE FROM INVOICELINE;
SELECT AVG(UNITPRICE) FROM INVOICELINE;

CREATE OR REPLACE FUNCTION AVG_PRICE_INVOICELINE
RETURN NUMBER 
IS
AVG_PRICE NUMBER(8,2);
BEGIN
  SELECT AVG(UNITPRICE) INTO AVG_PRICE FROM INVOICELINE;
  RETURN AVG_PRICE;
END;
/

SELECT AVG_PRICE_INVOICELINE FROM DUAL;


--3.4 User defined table valued functions
--Create a function that returns all employees who born after 1968.
SELECT FIRSTNAME, LASTNAME, BIRTHDATE FROM EMPLOYEE;
SELECT FIRSTNAME, LASTNAME, BIRTHDATE FROM EMPLOYEE WHERE BIRTHDATE > DATE '1968-01-01';

CREATE OR REPLACE FUNCTION LIST_EMPLOYEE_BORN_AFTER_1968(@BIRTHDATE DATE)
RETURNS TABLE
AS
RETURN (SELECT FIRSTNAME, LASTNAME, BIRTHDATE 
FROM EMPLOYEE 
WHERE BIRTHDATE > @DATE '1968-01-01');

/

--4.0 Stored Procedure
--Basic Stored Procedure
--Create a stored Procedure that selects the firstname and lastname of all the employees.
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;



CREATE OR REPLACE PROCEDURE GETALL_EMPLOYEES
(E_CURS OUT SYS_REFCURSOR)
IS
BEGIN
 OPEN E_CURS FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

VAR E_CURS REFCURSOR
EXECUTE GETALL_EMPLOYEES(:E_CURS)
PRINT E_CURS


--4.2 Stored Procedure that updates the personal information of an employee

select firstname, lastname, email, employeeid from employee;

CREATE OR REPLACE PROCEDURE UPDATE_LASTNAME(
E_ID IN NUMBER, E_LN IN VARCHAR2)
AS
BEGIN
 UPDATE EMPLOYEE SET
 LASTNAME = E_LN
 WHERE EMPLOYEEID = E_ID;
 COMMIT;
END;
/

EXEC UPDATE_LASTNAME(8, 'Johnson');
/
--Create aStored procedure that returns the manager of an employee
SELECT LASTNAME, FIRSTNAME, REPORTSTO FROM EMPLOYEE;

SELECT  EMP.LASTNAME AS EMPLOYEENAME,
MAN.LASTNAME AS MANAGERNAME
FROM EMPLOYEE EMP JOIN EMPLOYEE MAN
ON EMP.REPORTSTO = MAN.EMPLOYEEID;

CREATE OR REPLACE PROCEDURE DISPLAY_MANAGERS
(E_CUR OUT SYS_REFCURSOR)
IS
BEGIN
OPEN E_CUR FOR SELECT  EMP.LASTNAME AS EMPLOYEENAME, MAN.LASTNAME AS MANAGERNAME
FROM EMPLOYEE EMP JOIN EMPLOYEE MAN ON EMP.REPORTSTO = MAN.EMPLOYEEID;
END;
/
VAR E_CUR REFCURSOR
EXECUTE DISPLAY_MANAGERS(:E_CUR)
PRINT E_CUR

--4.3 Create a stored procedure that returns the name and company of a customer.
SELECT LASTNAME, COMPANY FROM CUSTOMER;

CREATE OR REPLACE PROCEDURE GET_NAME_COMPANY
(C_CUR OUT SYS_REFCURSOR)
IS
BEGIN
OPEN C_CUR FOR SELECT LASTNAME, COMPANY FROM CUSTOMER;
END;
/

VAR C_CUR REFCURSOR
EXECUTE GET_NAME_COMPANY(:C_CUR)
PRINT C_CUR
--5.0 Transaction
-- Create a transcation that given a invoiceid will delete that invoice 
--(there may be constraints that relo on this, find out how to resolve them)

CREATE OR REPLACE PROCEDURE DELETE_INVOICE
(INV_ID IN NUMBER)
IS
BEGIN 

DELETE FROM INVOICELINE WHERE INVOICEID = INV_ID;
DELETE FROM INVOICE WHERE INVOICEID = INV_ID;
COMMIT;
END;
/

SELECT * FROM INVOICELINE WHERE INVOICEID =180

SET SERVEROUTPUT ON
EXEC DELETE_INVOICE (180);

SELECT * FROM INVOICELINE WHERE INVOICEID=180;

--6.0 TRIGGERS
--6.1 Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE TRIGGER EMP_AFTER_INSERT 
AFTER INSERT ON EMPLOYEE 
FOR EACH ROW
DECLARE
 V_FIRSTNAME varchar2(100);
BEGIN
 INSERT INTO EMPLOYEE (EMPLOYEEID,FIRSTNAME, LASTNAME, TITLE, EMAIL,HIREDATE) VALUES (:new.EMPLOYEEID,:new.FIRSTNAME, :new.LASTNAME, :new.TITLE, :new.EMAIL,SYSDATE);
-- SELECT FIRSTNAME INTO V_FIRSTNAME FROM EMPLOYEE;
 DBMS_OUTPUT.PUT_LINE('Record inserted successfully');
 COMMIT;
END;
/
SET SERVEROUTPUT ON ;
INSERT INTO EMPLOYEE (EMPLOYEEID,FIRSTNAME, LASTNAME, TITLE, EMAIL) VALUES (19,'Lakshitha', 'Lakshmanan', 'Employee', 'abc@hotmail.com');
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Lakshitha';
COMMIT;

--Create an after update trigger on the album table that fires after a roq is inserted in the table.

CREATE OR REPLACE TRIGGER UPDATE_ALBUM_TRIGGER
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
DBMS_OUPUT.PUT_LINE('ALBUM TABLE HAS BEEN UPDATED');
END;
/
COMMIT;

UPDATE ALBUM SET TITLE = 'WORLDS'  WHERE ARTISTID = 202;
SELECT artistID, TITLE FROM ALBUM;
--Task � Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER DELETE_CUSTOMER_TRIGGER
AFTER DELETE ON CUSTOMER 
FOR EACH ROW 
BEGIN
DBMS_OUTPUT.PUT_LINE('CUSTOMER ROW WAS DELETED');
END;
/

SELECT * FROM CUSTOMER;

DELETE FROM CUSTOMER WHERE customerid = 32;

--SQL Joins
--7.1 Inner Join
-- Create an Inner Join that joins customers and orders and specifies the name of the 
--customer and the invoice id.
SELECT C.FIRSTNAME, C.LASTNAME, I.INVOICEID 
FROM CUSTOMER C INNER JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;

--7.2 Outer Join
--Create a Outer join that joins the customer and invoice table, specifying the 
--CustomerId, firstname, lastname and total.
SELECT  C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, I.TOTAL 
FROM CUSTOMER C 
FULL OUTER JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;

--7.3 RIGHT JOIN
--Create a right join that joins album and artist specififying artist name and title.
SELECT ARTIST.NAME AS ARTISTNAME, ALBUM.TITLE 
FROM ARTIST RIGHT JOIN ALBUM
ON ARTIST.ARTISTID = ALBUM.ARTISTID;

--7.4 CROSS JOIN
--Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST, ALBUM 
ORDER BY ARTIST.NAME;

--7.5 SELF JOIN
--Perform a self join on the employee table, joining on the reportsto column.
SELECT  EMP.LASTNAME AS EMPLOYEENAME,
MAN.LASTNAME AS MANAGERNAME
FROM EMPLOYEE EMP JOIN EMPLOYEE MAN
ON EMP.REPORTSTO = MAN.EMPLOYEEID;

--7.6 Complicated Join Assignment
--Create an innerjoin between all tables in the chinook database.

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