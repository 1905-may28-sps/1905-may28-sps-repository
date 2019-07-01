-- 2.1 SELECT
-- Select all records from employee table
select * from employee;
-- populate employee rows
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (1, 'Adams', 'Andrew', 'General Manager', TO_DATE('1962-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9482', '+1 (780) 428-3457', 'andrew@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (2, 'Edwards', 'Nancy', 'Sales Manager', 1, TO_DATE('1958-12-8 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-5-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), '825 8 Ave SW', 'Calgary', 'AB', 'Canada', 'T2P 2T3', '+1 (403) 262-3443', '+1 (403) 262-3322', 'nancy@chinookcorp.com');
-- Select all records from the employee table where last name is King
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (3, 'Peacock', 'Jane', 'Sales Support Agent', 2, TO_DATE('1973-8-29 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-4-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), '1111 6 Ave SW', 'Calgary', 'AB', 'Canada', 'T2P 5M5', '+1 (403) 262-3443', '+1 (403) 262-6712', 'jane@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (4, 'Park', 'Margaret', 'Sales Support Agent', 2, TO_DATE('1947-9-19 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2003-5-3 00:00:00','yyyy-mm-dd hh24:mi:ss'), '683 10 Street SW', 'Calgary', 'AB', 'Canada', 'T2P 5G3', '+1 (403) 263-4423', '+1 (403) 263-4289', 'margaret@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (5, 'Johnson', 'Steve', 'Sales Support Agent', 2, TO_DATE('1965-3-3 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2003-10-17 00:00:00','yyyy-mm-dd hh24:mi:ss'), '7727B 41 Ave', 'Calgary', 'AB', 'Canada', 'T3B 1Y7', '1 (780) 836-9987', '1 (780) 836-9543', 'steve@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (6, 'Mitchell', 'Michael', 'IT Manager', 1, TO_DATE('1973-7-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2003-10-17 00:00:00','yyyy-mm-dd hh24:mi:ss'), '5827 Bowness Road NW', 'Calgary', 'AB', 'Canada', 'T3B 0C5', '+1 (403) 246-9887', '+1 (403) 246-9899', 'michael@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (7, 'King', 'Robert', 'IT Staff', 6, TO_DATE('1970-5-29 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-1-2 00:00:00','yyyy-mm-dd hh24:mi:ss'), '590 Columbia Boulevard West', 'Lethbridge', 'AB', 'Canada', 'T1K 5N8', '+1 (403) 456-9986', '+1 (403) 456-8485', 'robert@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (8, 'Callahan', 'Laura', 'IT Staff', 6, TO_DATE('1968-1-9 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '923 7 ST NW', 'Lethbridge', 'AB', 'Canada', 'T1H 1Y8', '+1 (403) 467-3351', '+1 (403) 467-8772', 'laura@chinookcorp.com');
commit;

select * from EMPLOYEE where firstname  = 'Andrew';
select * from EMPLOYEE where lastname = 'King';

--select all records from the Employee table where first name is Andrew and REPORTSTO is null
select firstname,REPORTSTO from EMPLOYEE where firstname = 'Andrew' OR REPORTSTO IS NULL; -- Does zero represent null ?

--2.2 ORDER BY
--select all albums in album table and sort result set in descending order by title
select * from album;
INSERT INTO Album (AlbumId, Title, ArtistId) VALUES (1, 'For Those About To Rock We Salute You', 1);
INSERT INTO Album (AlbumId, Title, ArtistId) VALUES (2, 'Balls to the Wall', 2);
INSERT INTO Album (AlbumId, Title, ArtistId) VALUES (3, 'Restless and Wild', 2);
INSERT INTO Album (AlbumId, Title, ArtistId) VALUES (4, 'Let There Be Rock', 1);
INSERT INTO Album (AlbumId, Title, ArtistId) VALUES (5, 'Big Ones', 3);
select * from album order by title DESC; -- descends based on alphebetical order
--select firstname from customer and sort result set in ascending order by city
select * from customer;
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (1, 'Luís', 'Gonçalves', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (2, 'Leonie', 'Köhler', 'Theodor-Heuss-Straße 34', 'Stuttgart', 'Germany', '70174', '+49 0711 2842222', 'leonekohler@surfeu.de', 5);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, State, Country, PostalCode, Phone, Email, SupportRepId) VALUES (3, 'François', 'Tremblay', '1498 rue Bélanger', 'Montréal', 'QC', 'Canada', 'H2G 1A7', '+1 (514) 721-4711', 'ftremblay@gmail.com', 3);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (4, 'Bjørn', 'Hansen', 'Ullevålsveien 14', 'Oslo', 'Norway', '0171', '+47 22 44 22 22', 'bjorn.hansen@yahoo.no', 4);
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (5, 'Frantiek', 'Wichterlová', 'JetBrains s.r.o.', 'Klanova 9/506', 'Prague', 'Czech Republic', '14700', '+420 2 4172 5555', '+420 2 4172 5555', 'frantisekw@jetbrains.com', 4);
select firstname,city from customer order by city asc;
--2.3 INSERT INTO
--insert two new records into Genre table
select * from Genre;
INSERT INTO Genre (GenreId, Name) VALUES (1, 'Rock');
INSERT INTO Genre (GenreId, Name) VALUES (2, 'Jazz');
INSERT INTO Genre (GenreId, Name) VALUES (3, 'Metal');
INSERT INTO Genre (GenreId, Name) VALUES (4, 'Alternative '||chr(38)||' Punk');
INSERT INTO Genre (GenreId, Name) VALUES (5, 'Rock And Roll');
INSERT INTO Genre (GenreId, Name) VALUES (6, 'Blues');
INSERT INTO Genre (GenreId, Name) VALUES (7, 'Latin');
INSERT INTO Genre (GenreId, Name) VALUES (8, 'Reggae');
INSERT INTO Genre (GenreId, Name) VALUES (9, 'Pop');
INSERT INTO Genre (GenreId, Name) VALUES (10, 'Soundtrack');
INSERT INTO Genre (GenreId, Name) VALUES (11, 'Bossa Nova');
INSERT INTO Genre (GenreId, Name) VALUES (12, 'Easy Listening');
INSERT INTO Genre (GenreId, Name) VALUES (13, 'Heavy Metal');
INSERT INTO Genre (GenreId, Name) VALUES (14, 'R'||chr(38)||'B/Soul');
INSERT INTO Genre (GenreId, Name) VALUES (15, 'Electronica/Dance');
INSERT INTO Genre (GenreId, Name) VALUES (16, 'World');
INSERT INTO Genre (GenreId, Name) VALUES (17, 'Hip Hop/Rap');
INSERT INTO Genre (GenreId, Name) VALUES (18, 'Science Fiction');
INSERT INTO Genre (GenreId, Name) VALUES (19, 'TV Shows');
INSERT INTO Genre (GenreId, Name) VALUES (20, 'Sci Fi '||chr(38)||' Fantasy');
INSERT INTO Genre (GenreId, Name) VALUES (21, 'Drama');
INSERT INTO Genre (GenreId, Name) VALUES (22, 'Comedy');
INSERT INTO Genre (GenreId, Name) VALUES (23, 'Alternative');
INSERT INTO Genre (GenreId, Name) VALUES (24, 'Classical');
INSERT INTO Genre (GenreId, Name) VALUES (25, 'Opera');
--insert two new reocords into Employee table
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Cruz', 'Angel', 'IT Staff', 6, TO_DATE('1970-5-29 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-1-2 00:00:00','yyyy-mm-dd hh24:mi:ss'), '590 Columbia Boulevard West', 'Lethbridge', 'AB', 'Canada', 'T1K 5N8', '+1 (403) 456-9986', '+1 (403) 456-8485', 'robert@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'Jesus', 'Andres', 'IT Staff', 6, TO_DATE('1968-1-9 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '923 7 ST NW', 'Lethbridge', 'AB', 'Canada', 'T1H 1Y8', '+1 (403) 467-3351', '+1 (403) 467-8772', 'laura@chinookcorp.com');
--insert two new records into Customer
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (6, 'Helena', 'Holý', 'Rilská 3174/6', 'Prague', 'Czech Republic', '14300', '+420 2 4177 0449', 'hholy@gmail.com', 5);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (7, 'Astrid', 'Gruber', 'Rotenturmstraße 4, 1010 Innere Stadt', 'Vienne', 'Austria', '1010', '+43 01 5134505', 'astrid.gruber@apple.at', 5);
select * from customer;

--2.4 UPDATE
-- update Aaron Mitchell in Customer table to Robert Walter
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, State, Country, PostalCode, Phone, Email, SupportRepId) VALUES (8, 'Aaron', 'Mitchell', '696 Osborne Street', 'Winnipeg', 'MB', 'Canada', 'R3L 2B9', '+1 (204) 452-6452', 'aaronmitchell@yahoo.ca', 4);
select firstname,lastname from customer;
UPDATE customer
SET firstname = 'Robert', lastname = 'walter'
where customerid = 8;
select firstname,lastname from customer;

-- update name of artist in the Artist table "Greedence Clear water Revival" to "CCR"
INSERT INTO Artist (ArtistId, Name) VALUES (6, 'Creedence Clearwater Revival');
update artist
set name = 'CCR' where artistid = 6;
SELECT * FROM ARTIST;

--2.5 LIKE
-- select all invoices with a billing address like "T%"
select * from invoice;
INSERT INTO Invoice (InvoiceId, CustomerId, InvoiceDate, BillingAddress, BillingCity, BillingCountry, BillingPostalCode, Total) VALUES (1, 2, TO_DATE('2009-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), 'Theodor-Heuss-Straße 34', 'Stuttgart', 'Germany', '70174', 1.98);
INSERT INTO Invoice (InvoiceId, CustomerId, InvoiceDate, BillingAddress, BillingCity, BillingCountry, BillingPostalCode, Total) VALUES (2, 4, TO_DATE('2009-1-2 00:00:00','yyyy-mm-dd hh24:mi:ss'), 'Ullevålsveien 14', 'Oslo', 'Norway', '0171', 3.96);
INSERT INTO Invoice (InvoiceId, CustomerId, InvoiceDate, BillingAddress, BillingCity, BillingCountry, BillingPostalCode, Total) VALUES (3, 8, TO_DATE('2009-1-3 00:00:00','yyyy-mm-dd hh24:mi:ss'), 'Grétrystraat 63', 'Brussels', 'Belgium', '1000', 5.94);
INSERT INTO Invoice (InvoiceId, CustomerId, InvoiceDate, BillingAddress, BillingCity, BillingState, BillingCountry, BillingPostalCode, Total) VALUES (4, 14, TO_DATE('2009-1-6 00:00:00','yyyy-mm-dd hh24:mi:ss'), '8210 111 ST NW', 'Edmonton', 'AB', 'Canada', 'T6G 2C7', 8.91);
INSERT INTO Invoice (InvoiceId, CustomerId, InvoiceDate, BillingAddress, BillingCity, BillingState, BillingCountry, BillingPostalCode, Total) VALUES (5, 23, TO_DATE('2009-1-11 00:00:00','yyyy-mm-dd hh24:mi:ss'), '69 Salem Street', 'Boston', 'MA', 'USA', '2113', 13.86);

INSERT INTO Invoice (InvoiceId, CustomerId, InvoiceDate, BillingAddress, BillingCity, BillingCountry, BillingPostalCode, Total) VALUES (4, 2, TO_DATE('2009-2-11 00:00:00','yyyy-mm-dd hh24:mi:ss'), 'Theodor-Heuss-Straße 34', 'Stuttgart', 'Germany', '70174', 13.86);

select customerid,billingaddress,billingcity 
from invoice 
where billingaddress like 'T%';
commit;
--2.6 BETWEEN
--select all invoices that have a total between 15 and 50
select * from invoice
where total between 15 and 50;
 
--select all employees hired between 1st of june 2003 and 1st of march 2004
select * from employee
where hiredate between
'01-JUN-03' and '01-MAR-04';
--2.7 DELETE 
--delete a record in customer table where the name is robert walter(There may be constraints that
--rely on this, find out how to resolve them).




--
select * from artist;
INSERT INTO Artist (ArtistId, Name) VALUES (1, 'AC/DC');
INSERT INTO Artist (ArtistId, Name) VALUES (2, 'Accept');
INSERT INTO Artist (ArtistId, Name) VALUES (3, 'Aerosmith');
INSERT INTO Artist (ArtistId, Name) VALUES (4, 'Alanis Morissette');
INSERT INTO Artist (ArtistId, Name) VALUES (5, 'Alice In Chains');
commit;
--2.7 Delete
--Delete a record with constraints 
DROP TABLE customer where customer id=8 CASCADE CONSTRAINTS;



-- 4.1 Basic Stored Procedures 

CREATE OR REPLACE PROCEDURE GET_FNLNEMP(FLEMP_CURS OUT SYS_REFCURSOR)
IS
BEGIN
OPEN FLEMP_CURS FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/
VAR RC REFCURSOR
EXECUTE GET_FNLNEMP(:RC)
PRINT RC;

-- 4.3 Stored Procedure Output Parametes 

CREATE OR REPLACE PROCEDURE VIEW_CUSTNMCOMP(CUSTNMCOMP_CURS OUT SYS_REFCURSOR, C_ID IN NUMBER)
IS
BEGIN
OPEN CUSTNMCOMP_CURS FOR SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER WHERE CUSTOMERID = C_ID;
END;
/
VAR RC2 REFCURSOR
EXECUTE VIEW_CUSTNMCOMP(:RC2, 1)
PRINT RC2;


-- 5 Transactions

START TRANSACTION;
DELETE FROM INVOICE WHERE INVOICEID=60; 
COMMIT;

5.2 might not work/error ->
select* from customer;
create or replace procedure Insert_customer
(c_id in number, fnm in varchar2,lnm in varchar2, cp in varchar2, addre in varchar2, ct in varchar2, st in varchar2, cty in varchar2,
zp in varchar2, phn in varchar2, fx in varchar2, eml in varchar2, sri in number)
as
begin
  START TRANSACTION;
 insert into customer(CUSTOMERID, FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
 VALUES(C_ID, FNM, LNM, CP, ADDRE,CT,ST,CTY,ZP,PHN,FX,EML,SRI);
 COMMIT;
end;
/

