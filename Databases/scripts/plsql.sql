/*
PL/SQL = Procedural Language extension of SQL 
it is Oracle's database programming language (other DB vendors 
have different ones, like T-SQL)
in PL/SQL, we see executable (non stored) blocks of code, 
triggers, user-defined functions, stored procedures, and more
*/

---------------------------------------- FUNCTIONS----------------------------------------
/*
- executable blocks of code that take in 0 or more parameters and must return 1 value
- cannot perform full DML statements -- only SQL
- typically used to perform some sort of mathematical "function" on data and reutnr output
*/
-- ex 1. find avg price of invoice line unitprice
CREATE OR REPLACE FUNCTION INV_PRICE_AVG  -- create [or replace] function [functionName]
  RETURN NUMBER                                                      -- data type of return value
IS                                                                                    -- IS/AS , syntax indicating youre about to declare var
  INV_AVERAGE NUMBER(8,4);                                            -- declaration of variable to return and its data type
BEGIN 
  SELECT AVG(UNITPRICE) INTO INV_AVERAGE FROM INVOICELINE;
  RETURN INV_AVERAGE;
END;
/

SELECT INV_PRICE_AVG() FROM DUAL;

-- EX 2. NUM OF SONGS BY A PARTICULAR GENRE
CREATE OR REPLACE FUNCTION SONGS_BY_GENRE(G_ID IN NUMBER )
RETURN NUMBER
  IS
TOTAL NUMBER;
BEGIN
  SELECT COUNT(TRACKID) 
  INTO TOTAL
  FROM TRACK 
  WHERE GENREID = G_ID;
  
  RETURN TOTAL;
END; 
/

select * from genre;
select songs_by_genre(1) from dual;


--------------------------------------- STORED PROCEDURES--------------------------------------------------
/*
- executable blocks of code that take in 0 or more IN or OUT parameters 
- do NOT return anything 
- have access to execute all DML and TCL commands
*/

/
-- ex. 1 - delete an invoice by id
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(INV_ID IN NUMBER)
IS
BEGIN
  DELETE FROM INVOICELINE WHERE INVOICEID = INV_ID;
  DELETE FROM INVOICE WHERE INVOICEID = INV_ID;
  COMMIT;
END;
/
select * from invoice;
select * from invoiceline where invoiceid = 11;
execute delete_invoice(11);


---- DBMS OUTPUT - db management system console 
begin
DBMS_OUTPUT.PUT_LINE('hello world!!!!!!');
end;
/

CREATE OR REPLACE PROCEDURE GET_GENRES
(G_CURS OUT SYS_REFCURSOR)
AS
BEGIN 
OPEN G_CURS FOR SELECT * FROM STORE_GENRE;
END;

/


--- exploring explicit cursors 
DECLARE
  GENRE_CURSOR SYS_REFCURSOR;
  G_ID NUMBER(10);
  G_NAME VARCHAR2(25);
BEGIN
  OPEN GENRE_CURSOR FOR SELECT * FROM STORE_GENRE;
  --GET_GENRES(GENRE_CURSOR);
  
  LOOP
    FETCH GENRE_CURSOR INTO G_ID, G_NAME;
    EXIT WHEN GENRE_CURSOR%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(G_ID || ': ' || G_NAME);
  END LOOP;
END;


/




-- EXPLORING CURSORS
CREATE OR REPLACE PROCEDURE SONGS_BY_ARTIST(
      ARTIST_NAME IN VARCHAR2, SONG_LIST OUT SYS_REFCURSOR)
  AS
  BEGIN
  OPEN SONG_LIST FOR 
    SELECT *FROM TRACK WHERE ALBUMID IN
      (SELECT ALBUMID FROM ALBUM  WHERE ARTISTID IN
        ( SELECT ARTISTID FROM ARTIST WHERE NAME = ARTIST_NAME )
      );
  END;
/
SELECT SONGS_BY_ARTIST_FUNCTION('AC/DC') FROM DUAL;
/
CREATE OR REPLACE FUNCTION SONGS_BY_ARTIST_FUNCTION
(ARTIST_NAME IN VARCHAR2)
RETURN SYS_REFCURSOR
AS
SONG_LIST SYS_REFCURSOR;
  BEGIN
  OPEN SONG_LIST FOR 
    SELECT *FROM TRACK WHERE ALBUMID IN
      (SELECT ALBUMID FROM ALBUM  WHERE ARTISTID IN
        ( SELECT ARTISTID FROM ARTIST WHERE NAME = ARTIST_NAME )
      );
      RETURN SONG_LIST;
  END;
  
  
  /
  select NUM_BOOKS_BY_GENRE('Fantasy') from dual;