/*
SELECT [col name(s)]
FROM  [table]
WHERE [condition]
[qualifiers];
*/
-- SELECT 
select * from artist;
select name from artist;
select * from artist order by name desc; -- sort by column 

-- SELECT with clauses 
select * from artist where artistid = 10;
select * from artist where artistid BETWEEN 5 AND 15; --inclusive 
select * from artist where name like 'T__ %';

--INSERTS 
INSERT INTO Genre (genreid, Name) VALUES ( 50, 'try delete');

-- the following will not work... why?
INSERT INTO Genre (Name) VALUES ( 'testing');

-- update 
UPDATE Genre
SET Name = 'TEST'
WHERE GENREID = 1;

-- delete 
delete from genre 
where genreid = 2;

-- delete with no where clause will delete everything in the table 
-- question: what is the difference between this and truncate?
delete from genre;

select * from genre;
rollback;


/*
FUNCTIONS
- in SQL there exist system defined functions, and functions that 
we create ourselves. the user-defined functions are considered to 
be a part of PL/SQL, which is the prodecural language extension 
to SQL 
- regarding system-defined functions, these are functions we can 
use to provide meaning to our data, like max(), min(), count(), round()
- there are two categories of these functions: aggregate and scalar
- Scalar functions - functions that operate on single values ie upper(), lower(), length()
- Aggregate functions - functions that operate on multiple rows of data - min(), max(), count()
*/

select * from artist where lower(name) = 'buddy guy';

update artist 
set name = (select upper(name) from artist where  lower(name) = 'buddy guy' )
where  lower(name) = 'buddy guy';

select length(name) from genre;

select count(name)  from genre;


/*  VIEW
- a view is known as a "virtual table" that will allow us to store the output of a 
query as an object in our database
- we cannot insert/update/delete rows in views that take information from 
multiple tables and expect it to affect our tables themselves 
- think of a view as simply a fast way to access frequently queried data 
*/
create view special_artist as
select artistid AS ID, name as ARTIST 
from artist where lower(name) like '%v%' AND artistid > 200;

select * from special_artist;

create view special_album as 
select * from album where length(title) > 40;


