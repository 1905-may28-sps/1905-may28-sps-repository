--2.1 Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;
--2.1 Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE UPPER(LASTNAME)='KING';
--2.1 Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL. 
SELECT * FROM EMPLOYEE WHERE UPPER(FIRSTNAME)='ANDREW' AND REPORTSTO IS NULL;
--
--2.2 Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC;
--2.2 Task – Select first name from Customer and sort result set in ascending order by city.
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;
--
--2.3 Task – Insert two new records into Genre table 
CREATE SEQUENCE GENREID_SEQ
START WITH 26;
create or replace TRIGGER GENREID_TRIGGER -- Create [or replace] trigger triggerName -- declare and name
   BEFORE INSERT ON GENRE -- [before/after] [dml command] on [table] -- when will this execute
   FOR EACH ROW -- necessary to change table row values 
   BEGIN
      -- here is where we write what we want to do when trigger is fired 
      SELECT GENREID_SEQ.NEXTVAL --  ++GENRE_SEQ
      INTO :NEW.GENREID -- : represents a placeholder value
      FROM DUAL;
   END;
   /
INSERT INTO GENRE (NAME) VALUES ('GOSPEL');
INSERT INTO GENRE (NAME) VALUES ('CHRISTIAN');
--2.3 Task – Insert two new records into Employee table
CREATE SEQUENCE EMPLOYEEID_SEQ
START WITH 9;
create or replace TRIGGER EMPLOYEEID_TRIGGER -- Create [or replace] trigger triggerName -- declare and name
   BEFORE INSERT ON EMPLOYEE -- [before/after] [dml command] on [table] -- when will this execute
   FOR EACH ROW -- necessary to change table row values 
   BEGIN
      -- here is where we write what we want to do when trigger is fired 
      SELECT EMPLOYEEID_SEQ.NEXTVAL --  ++GENRE_SEQ
      INTO :NEW.EMPLOYEEID -- : represents a placeholder value
      FROM DUAL;
   END;
   /
INSERT INTO EMPLOYEE (LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL) VALUES ('Jones', 'Alan', 'Sales Intern', 3, '08-JAN-00', '28-MAY-19', '4910 46th Street', 'Red Deer', 'AB', 'Canada', 'T4N 1N2', '+1 (403) 346-4512', '+1 (403) 343-1039', 'alan@chinookcorp.com');
INSERT INTO EMPLOYEE (LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL) VALUES ('Zarkowski', 'Samantha', 'Customer Service Specialist', 5, '21-JUN-95', '01-JAN-15', '4415 48 Ave', 'Red Deer', 'AB', 'Canada', 'T4N 3T4', '+1 (403) 342-5092', '+1 (403) 341-5238', 'samantha@chinookcorp.com');
--
--2.3 Task – Insert two new records into Customer table
CREATE SEQUENCE CUSTOMERID_SEQ
START WITH 60;
create or replace TRIGGER CUSTOMERID_TRIGGER -- Create [or replace] trigger triggerName -- declare and name
   BEFORE INSERT ON CUSTOMER -- [before/after] [dml command] on [table] -- when will this execute
   FOR EACH ROW -- necessary to change table row values 
   BEGIN
      -- here is where we write what we want to do when trigger is fired 
      SELECT CUSTOMERID_SEQ.NEXTVAL --  ++GENRE_SEQ
      INTO :NEW.CUSTOMERID -- : represents a placeholder value
      FROM DUAL;
   END;
   /
INSERT INTO CUSTOMER (FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID) VALUES ('Chance', 'Wiggins', 'Texas Instruments', '12500 T I Blvd', 'Dallas', 'TX', 'USA', '75243-0592', '+1 (972) 995-2011', '+1 (972) 995-2012', 'cwiggins@ti.com', 4);
INSERT INTO CUSTOMER (FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID) VALUES ('Sally', 'Raphael', 'Revature', '1600 Pennsylvania Avenue NW', 'Washington', 'DC', 'USA', '20500', '+1 (202) 740-3629', '+1 (202) 823-3280', 'sraphael@revaturellc.com', 5);
--
--2.4 Task – Update Aaron Mitchell in Customer table to Robert Walter 
UPDATE CUSTOMER SET FIRSTNAME='Robert', LASTNAME='Walter' WHERE CUSTOMERID=32;
--2.4 Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST SET NAME='CCR' WHERE ARTISTID=76;
--
--2.5 Task – Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';
--
--2.6 Task – Select all invoices that have a total between 15 and 50 
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
--2.6 Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('JUN-03', 'MON-YY') AND TO_DATE('MAR-04', 'MON-YY');
--
--2.7 Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
SELECT * FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME = 'Walter';
SELECT * FROM INVOICE WHERE CUSTOMERID = 32;
SELECT * FROM INVOICELINE WHERE INVOICEID IN (245, 268, 290, 342, 50, 61, 116);
DELETE FROM INVOICELINE WHERE INVOICEID IN (245, 268, 290, 342, 50, 61, 116);
DELETE FROM INVOICE WHERE CUSTOMERID = 32;
DELETE FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME = 'Walter';
--
--3.1 Task – Create a function that returns the current time. 
SELECT CURRENT_DATE FROM DUAL;
--3.1 Task – create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(NAME) AS "LENGTH_OF_MEDIATYPE" FROM MEDIATYPE;
--
--3.2 Task – Create a function that returns the average total of all invoices 
SELECT AVG(TOTAL) AS AVG_TOTAL FROM INVOICE;
--3.2 Task – Create a function that returns the most expensive track 
SELECT MAX(UNITPRICE) AS MOST_EXPENSIVE_TRACK FROM TRACK;
--
--3.3 Task – Create a function that returns the average price of invoiceline items in the invoiceline table 
CREATE OR REPLACE FUNCTION AVG_PRICE_INV_LINE
RETURN NUMBER
IS
AVG_PRICE_INV_LN NUMBER;
BEGIN
  SELECT AVG(UNITPRICE) INTO AVG_PRICE_INV_LN FROM INVOICELINE;
  RETURN AVG_PRICE_INV_LN;
END;
/
SELECT AVG_PRICE_INV_LINE FROM dual;
--
--3.4 Task – Create a function that returns all employees who are born after 1968. 
CREATE OR REPLACE FUNCTION BORN_AFTER_1968 
RETURN SYS_REFCURSOR
IS
EMPL_CURS SYS_REFCURSOR;
BEGIN
OPEN EMPL_CURS FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE TO_DATE(BIRTHDATE,'DD-MON-YY') >= TO_DATE('01-JAN-68','DD-MON-YY');
RETURN EMPL_CURS;
END;
/
SELECT BORN_AFTER_1968 FROM DUAL;
--
--4.1 Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE GET_FNLNEMP(FLEMP_CURS OUT SYS_REFCURSOR)
IS
BEGIN
OPEN FLEMP_CURS FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/
VAR RC REFCURSOR
EXECUTE GET_FNLNEMP(:RC)
PRINT RC;
--
--4.2 Task – Create a stored procedure that updates the personal information of an employee.
INSERT INTO EMPLOYEE (LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL) VALUES ('Christie', 'Agatha', 'Engineer', 1, '8-AUG-81', '30-MAY-13', '4996 49th Avenue', 'Red Deer', 'AB', 'Canada', 'T4N 6X2', '+1 (403) 341-7052', '+1 (403) 341-7053', 'agathachristie@chinookcorp.com');
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE(
IDrev IN NUMBER,
LASTNAMErev IN VARCHAR2,
FIRSTNAMErev IN VARCHAR2,
TITLErev IN VARCHAR2,
REPORTSTOrev IN NUMBER,
BIRTHDATErev IN DATE,
HIREDATErev IN DATE,
ADDRESSrev IN VARCHAR2,
CITYrev IN VARCHAR2,
STATErev IN VARCHAR2,
COUNTRYrev IN VARCHAR2,
POSTALCODErev IN VARCHAR2,
PHONErev IN VARCHAR2,
FAXrev IN VARCHAR2,
EMAILrev IN VARCHAR2)
IS 
BEGIN
UPDATE EMPLOYEE 
SET 
LASTNAME = LASTNAMErev,
FIRSTNAME = FIRSTNAMErev,
TITLE = TITLErev,
REPORTSTO = REPORTSTOrev,
BIRTHDATE = BIRTHDATErev,
HIREDATE = HIREDATErev,
ADDRESS = ADDRESSrev,
CITY = CITYrev,
STATE = STATErev,
COUNTRY = COUNTRYrev,
POSTALCODE = POSTALCODErev,
PHONE = PHONErev,
FAX = FAXrev,
EMAIL = EMAILrev
WHERE EMPLOYEEID = IDrev;
END;
/
EXEC UPDATE_EMPLOYEE(29,'Christie Jr.', 'Agathas', 'Senior Engineer', 1, '7-AUG-81', '29-MAY-13', '4996 49th Avenue SW', 'Red Deer', 'AB', 'Canada', 'T4N 6X2', '+1 (403) 341-7052', '+1 (403) 341-7053', 'agathachristiejr@chinookcorp.com');
SELECT * FROM EMPLOYEE WHERE EMPLOYEEID=29;
SELECT * FROM EMPLOYEE;
--
--4.2 Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE VIEW_MANAGERS(MGERNM_CURS OUT SYS_REFCURSOR)
IS
BEGIN
OPEN MGERNM_CURS FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE TITLE LIKE '%Manager';
END;
/
VAR RC1 REFCURSOR
EXECUTE VIEW_MANAGERS(:RC1)
PRINT RC1;
--
--4.3 Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE VIEW_CUSTNMCOMP(CUSTNMCOMP_CURS OUT SYS_REFCURSOR, C_ID IN NUMBER)
IS
BEGIN
OPEN CUSTNMCOMP_CURS FOR SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER WHERE CUSTOMERID = C_ID;
END;
/
VAR RC2 REFCURSOR
EXECUTE VIEW_CUSTNMCOMP(:RC2, 1)
PRINT RC2;
--
--5.0 Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE DELETE_INV(INV_ID IN NUMBER)
IS
BEGIN
DELETE FROM INVOICELINE WHERE INVOICEID = INV_ID;
DELETE FROM INVOICE WHERE INVOICEID = INV_ID;
END;
/
SELECT * FROM INVOICELINE WHERE INVOICEID = 412;
SELECT * FROM INVOICE WHERE INVOICEID = 412;
EXECUTE DELETE_INV(412);
--
--5.0 Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE INSERT_INTO_CUSTOMER(
IDrv IN NUMBER,
FIRSTNAMErv IN VARCHAR2,
LASTNAMErv IN VARCHAR2,
COMPANYrv IN VARCHAR2,
ADDRESSrv IN VARCHAR2,
CITYrv IN VARCHAR2,
STATErv IN VARCHAR2,
COUNTRYrv IN VARCHAR2,
POSTALCODErv IN VARCHAR2,
PHONErv IN VARCHAR2,
FAXrv IN VARCHAR2,
EMAILrv IN VARCHAR2,
SUPPORTREPIDrv IN NUMBER)
IS 
BEGIN
INSERT INTO CUSTOMER
--(FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES
(IDrv, FIRSTNAMErv, LASTNAMErv, COMPANYrv, ADDRESSrv, CITYrv, STATErv, COUNTRYrv, POSTALCODErv, PHONErv, FAXrv, EMAILrv, SUPPORTREPIDrv);
END;
/
EXEC INSERT_INTO_CUSTOMER(0, 'Arnold', 'Schwarzenegger', 'Disney Studios', '3110 Main Street, Suite 300', 'Santa Monica', 'CA', 'USA', '90405-5354', '+1 (310) 396-5910', '+1 (310) 396-5911', 'terminator@schwarzenegger.com', 5);
SELECT * FROM CUSTOMER;
--
--6.1 Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace TRIGGER EMPLOYEE2_TRIGGER -- Create [or replace] trigger triggerName -- declare and name
AFTER INSERT ON EMPLOYEE -- [before/after] [dml command] on [table] -- when will this execute
FOR EACH ROW -- necessary to change table row values 
BEGIN
-- here is where we write what we want to do when trigger is fired 
DBMS_OUTPUT.PUT_LINE('YOU SUCCESFULLY INSERTED AN EMPLOYEE RECORD');
END;
/
--
--6.1 Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER ALBUM_TRIGGER
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE('YOU SUCCESFULLY UPDATED AN ALBUM RECORD');
END;
/
--
--6.1 Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER CUSTOMER_TRIGGER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('YOU SUCCESFULLY DELETED A CUSTOMER RECORD');
END;
/
--
--7.1 Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--
--7.2 Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total. 
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--
--7.3  Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ALBUM RIGHT JOIN ARTIST
ON ALBUM.ARTISTID = ARTIST.ARTISTID;
--
--7.4 Create a cross join that joins album and artist and sorts by artist name in ascending order. 
SELECT ARTIST.NAME FROM ALBUM, ARTIST ORDER BY ARTIST.NAME ASC;
--
--7.5 Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM EMPLOYEE A, EMPLOYEE B WHERE A.REPORTSTO = B.REPORTSTO;
--
--7.6 Create an inner join between all tables in the chinook database. 
SELECT * FROM ALBUM
JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID
JOIN TRACK ON ALBUM.ALBUMID = TRACK.ALBUMID
JOIN PLAYLISTTRACK ON TRACK.TRACKID = PLAYLISTTRACK.TRACKID
JOIN PLAYLIST ON PLAYLISTTRACK.PLAYLISTID = PLAYLIST.PLAYLISTID
JOIN INVOICELINE ON TRACK.TRACKID = INVOICELINE.TRACKID
JOIN INVOICE ON INVOICELINE.INVOICEID = INVOICE.INVOICEID
JOIN CUSTOMER ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID
JOIN EMPLOYEE ON EMPLOYEE.REPORTSTO = CUSTOMER.SUPPORTREPID
JOIN GENRE ON GENRE.GENREID = TRACK.GENREID
JOIN MEDIATYPE ON MEDIATYPE.MEDIATYPEID = TRACK.MEDIATYPEID;

--9.0 Create a .bak file for the Chinook database
BACKUP DATABASE KrisLordDatabase TO DISK = 'C:\KrisLordDatabase.bak';