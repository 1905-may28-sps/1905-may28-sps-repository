--populate database
--upload hw and assignments
--sql workbook, save in git DB

select  * from store_author;
select * from store_genre
insert into store_author (first_name, last_name, bio) values ('Michelle', 'Obama','former first lady')

SELECT * FROM store_book;

select * from store_book_author
CREATE SEQUENCE book_SEQ;

 CREATE OR REPLACE TRIGGER book_TRIGGER -- Create [or replace] trigger triggerName -- declare and name
   BEFORE INSERT ON STORE_book -- [before/after] [dml command] on [table] -- when will this execute
   FOR EACH ROW -- necessary to change table row values 
   BEGIN
      -- here is where we write what we want to do when trigger is fired 
      SELECT book_SEQ.NEXTVAL --  ++GENRE_SEQ
      INTO :NEW.book_ID -- : represents a placeholder value
      FROM DUAL;
   END;
   
   insert into store_book (isbn, title, price,genre_id) values (014878354, 'Formulas of the Moral Law',15.00,26)
select * from store_book_author

   insert into store_book_author (book_id, author_id) values (7,2)
   commit;
