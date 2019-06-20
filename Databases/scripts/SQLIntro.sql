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

select count(name) AS Numgenres from genre;


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

/*  A join is a means for combining columns from one or more tables
by using values common to each
There are lots of types of joins - full joins, inner joins, left joins, 
right joins, cross joins, natural joins, self joins, and more 
*/
select * from invoiceline;
select * from track;

-- inner join 
select al.title AS album, art.name as "ARTIST NAME"
from album al
join artist art
on al.artistid = art.artistid;


select art.id as "ARTISTS ARTID", al.artistid as "ALBUMS ART ID", art.artist,  al.title
from special_artist art
full outer join special_album al
on al.artistid = art.id
WHERE al.artistid is null;

select * from special_album;
select * from special_artist;



--Natural join - where Oracle attempts to match columns based on names
select * from artist natural join album;

-- Cross join - cartesian product of two tables 
select al.title, art.name 
from album al, artist art;


--joining more than two tables
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



-- self join -- join column from one table to another column in the same table 
select minion.lastname as minion, boss.lastname as boss
from employee minion
join employee boss 
on minion.reportsto = boss.employeeid;

select * from employee;


----------------- aggregate functions with joins and group by
select  genre.name, count(track.trackid)
from track 
join genre
on track.genreid = genre.genreid
where length(genre.name) < 6 -- individual conditions of tables
group by genre.name
having count(track.trackid) > 100; -- for aggregate function


-- count songs in each album 
select album.title, count(track.trackid) as Numsongs 
from album
join track on track.albumid = album.albumid
group by album.title
order by album.title;


