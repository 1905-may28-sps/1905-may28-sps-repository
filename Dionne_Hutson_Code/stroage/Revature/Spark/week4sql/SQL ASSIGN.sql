-- DIONNE HUTSON


--2.1
select * from Employee;
select* from Employee WHERE LASTNAME='King';
select * from Employee where firstName='Andrew' and Reportsto is Null;

--2.2
select * from ALBUM ORDER BY TITLE DESC;
SELECT firstname from Customer order by CITY;
--2.3
Insert into genre(genreid, name) values(26,'disco');
Insert into genre(genreid, name) values(27,'Folk');


INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Bobby', 'Bob', 'General Manager', TO_DATE('1963-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2018-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11121 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9481', '+1 (780) 428-3451', 'bob@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'Cather', 'Cath', 'Sales Manager', TO_DATE('1970-3-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2019-2-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11122 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9581', '+1 (780) 428-3481', 'cat@chinookcorp.com');
select * from customer;
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
  VALUES (60, 'Luís', 'Castro', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 'Av. Brigadeiro Faria Lima, 2177', 'São José dos Campos', 'SP', 'Brazil', '12228-000', '+55 (12) 3923-5557', '+55 (12) 3923-5567', 'luisc@embraer.com.br', 7);
  
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, Country, PostalCode, Phone, Fax, Email, SupportRepId) 
  VALUES (61, 'Anfisa', 'Wichterlová', 'JetBrains s.r.o.', 'Klanova 9/516', 'Prague', 'Czech Republic', '14710', '+420 2 4172 5515', '+420 2 4172 5155', 'frantisekw@jetbrains.com', 2);  
--2.4

UPDATE CUSTOMER C SET C.FIRSTNAME='Robert', C.LASTNAME='Walter' WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';
UPDATE ARTIST A SET A.NAME='CCR' WHERE NAME='Creedence Clearwater Revival';
--2.5
Select * From INVOICE where BILLINGADDRESS like 'T%';
--2.6
Select * From INVOICE where TOTAL>15 AND TOTAL<50;
SELECT * FROM EMPLOYEE WHERE hiredate between '01-JUN-03' AND '01-MAR-04'  ;
--2.7
DELETE FROM INVOICELINE WHERE INVOICEID IN (SELECT INVOICEID FROM INVOICE WHERE customerid IN (SELECT customerid FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter'));
 Delete from Invoice Where customerid = (SELECT customerid FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter');
DELETE FROM CusTOmer WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';
--3.1
CREATE OR REPLACE FUNCTION CURRTIME
RETURN TIMESTAMP
IS CT TIMESTAMP;
BEGIN
SELECT CURRENT_TIMESTAMP INTO CT FROM DUAL;
RETURN CT;
END;
/
CREATE OR REPLACE FUNCTION MEDLENGTH(id in number)
RETURN NUMBER
IS LEN NUMBER;
BEGIN
SELECT LENGTH(NAME)INTO LEN FROM MEDIATYPE where MEDIATYPEID=id ;
RETURN LEN;
END;
/
--3.2
create OR REPLACE FUNCTION AVG_INV
RETURN NUMBER
IS AVGINV NUMBER(8,4);
BEGIN
SELECT AVG(TOTAL) INTO AVGINV FROM INVOICE;
RETURN AVGINV;
END;
/
creATE OR REPLACE FUNCTION EXP_TRK
RETURN sys_Refcursor
AS TRACKID2 SYS_REFCURSOR;
BEGIN
OPEN TRACKID2 FOR
SELECT Trackid FROM TRACK WHERE unitPrice IN (SELECT MAX(UNITPRICE) FROM TraCK);
RETURN TRACKID2;
END;
/
--3.3
create OR REPLACE FUNCTION AVG_INVLINE
RETURN NUMBER
IS AVG_INVL NUMBER(8,4);
BEGIN
SELECT AVG(UNITPRICE) INTO AVG_INVL FROM INVOICELINE;
RETURN AVG_INVL;
END;
/
--3.4
CREATE OR REPLACE FUNCTION EMP_LIST
RETURN SYS_REFCURSOR
AS EMP SYS_REFCURSOR;
BEGIN
OPEN EMP FOR 
SELECT EMPLOYEEID FROM EMPLOYEE WHERE BIRTHDATE>=(TO_DATE('1969-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss'));
RETURN EMP;
END;
/
--4.1
DECLARE
  NAME_CURSOR SYS_REFCURSOR;
  F_NAME VARCHAR2(20);
 L_NAME VARCHAR2(20);
BEGIN
  OPEN NAME_CURSOR FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
  --GET_GENRES(GENRE_CURSOR);
  LOOP
    FETCH NAME_CURSOR INTO F_NAME, L_NAME;
    EXIT WHEN NAME_CURSOR%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE( F_NAME || ' ' || L_NAME);
  END LOOP;
END;
/

CREATE OR REPLACE PROCEDURE EMP_NAME(NAMES OUT SYS_REFCURSOR)
AS
BEGIN
OPEN NAMES FOR
SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE;
END;
/
--4.2
CREATE OR REPLACE PROCEDURE UP_PERS(
EID IN NUMBER, LN IN VARCHAR2, FN IN VARCHAR2,ttle IN varchar2,REPTO IN NUMBER,
AD IN VARCHAR2, CT IN VARCHAR2,ST IN VARCHAR2, CNTRY IN VARCHAR2, POST IN VARCHAR2,
PH IN VARCHAR2, FX IN VARCHAR2, EML IN VARCHAR2)
AS
BEGIN
UPDATE  EMPLOYEE SET LASTNAME= LN, FIRSTNAME= FN, TITLE=ttle, REPORTSTO=REPTO, ADDRESS=AD, CITY=CT,STATE=ST, COUNTRY=CNTRY, 
POSTALCODE=POST, PHONE=PH, FAX=FX, EMAIL=EML WHERE  EMPLOYEEID=EID;
COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE EMP_MAN(
EID IN NUMBER, MANG OUT VARCHAR2)
AS
BEGIN
SELECT REPORTSTO INTO MANG FROM EMPLOYEE WHERE  EMPLOYEEID=EID;
COMMIT;
END;
/
--VARIABLE MANGL NUMBER;
--EXEC EMP_MAN(2,:MANGL);
--PRINT MANGL;
--4.3
CREATE OR REPLACE PROCEDURE CUST_INFO(
CID IN NUMBER, FN OUT VARCHAR2, LN OUT VARCHAR2,COMP OUT VARCHAR2)
AS
BEGIN
SELECT FIRSTNAME,LASTNAME, COMPANY INTO FN,LN,COMP FROM CUSTOMER WHERE  CUSTOMERID=CID;
COMMIT;
END;
/
--VARiable FN VARCHAR2 ;
--VAR LN VARCHAR2 (20);
--VAR COMP VARCHAR2 (80);
--EXEC CUST_INFO(5,:FN,:LN,:COMP);
--PRINT FN;

--5.0
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(
IID IN NUMBER)
AS
BEGIN
DELETE FROM INVOICELINE WHERE INVOICEID=IID;
DELETE FROM INVOICE WHERE INVOICEID=IID;
END;
/
--EXEC DELETE_INVOICE(1);
--SELECT * FROM INVOICE;
CREATE OR REPLACE PROCEDURE INSERT_CUSTOMER(CusTId NUMBER, FN VARCHAR2, LN VARCHAR2, Comp VARCHAR2, Ad VARCHAR2, Cty VARCHAR2, 
Cntry VARCHAR2, Post VARCHAR2, PHN VARCHAR2, Fx VARCHAR2, EMl VARCHAR2, RepId NUMBER) 
 AS
 BEGIN
 INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, Country, PostalCode, Phone, Fax, Email, SupportRepId) 
  VALUES (CUSTID, FN, LN, COMP, AD, CTY, CNTRY, POST, PHN, FX, EML, REPID ); 
  END;
  /
--6.1

   CREATE SEQUENCE CUST_SEQ;
  
CREATE OR REPLACE TRIGGER ALBUM_TRIGGER -- Create [or replace] trigger triggerName -- declare and name
   AFTER INSERT ON ALBUM-- [before/after] [dml command] on [table] -- when will this execute
   FOR EACH ROW -- necessary to change table row values 
   BEGIN
   END;
/

 CREATE OR REPLACE TRIGGER CUST_TRIGGER -- Create [or replace] trigger triggerName -- declare and name
   AFTER DELETE ON CUSTOMER-- [before/after] [dml command] on [table] -- when will this execute
   FOR EACH ROW -- necessary to change table row values 
  
   BEGIN
    SELECT*FROM CUSTOMER INTO DUAL;
   END;
/
--7.1
SELECT CUSTOMER.FIRSTNAME, INVOICE.INVOICEID
FROM CUSTOMER
JOIN INVOICE
ON INVOICE.CUSTOMERID=CUSTOMER.CUSTOMERID;
--7.2
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER 
FULL OUTER JOIN INVOICE
ON INVOICE.CUSTOMERID=CUSTOMER.CUSTOMERID;
--7.3
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ALBUM
RIGHT JOIN ARTIST
ON ALBUM.ARTISTID=ARTIST.ARTISTID;
--7.4
SELECT * 
FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME; 
--7.5
select minion.lastname as minion, boss.lastname as boss
from employee minion
join employee boss 
on minion.reportsto = boss.employeeid;
--7.6
select track.name as TrackName,album.title as album,artist.name as artist,PLAYLISTTRACK.PLAYLISTID as playlisttrack, PLAYLIST.NAME as playlist,Genre.Name as genre,invoiceline.invoicelineid as invoiceline,invoice.invoiceid as invoiceid,customer.firstname as customer,mediatype.name as mediatype,employee.lastname as employee
from track
join album on track.albumid=album.albumid
join PLAYLISTTRACK on track.albumid=PLAYLISTTRACK.TRACKID
join GENRE on track.genreid=genre.genreid
join PLAYLIST on PLAYLISTTRACK.PLAYLISTID=PLAYLIST.PLAYLISTID
join Invoiceline on track.trackid=invoiceline.trackid
join mediatype on track.mediatypeid=mediatype.mediatypeid
join invoice on invoiceline.invoiceid=invoice.invoiceid
join customer on invoice.customerid=customer.customerid
join employee on customer.supportrepid=employee.employeeid
join artist on artist.artistid=album.artistid;





  