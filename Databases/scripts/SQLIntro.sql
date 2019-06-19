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
select * from artist where artistid < 10;
select * from artist where artistid BETWEEN 5 AND 15; --inclusive 
select * from artist where artistid < 100 AND name like 'T%';


INSERT INTO Genre (Name) VALUES ( 'testing');

UPDATE Genre
SET Name = 'TEST'
WHERE GENREID = 1;

select * from genre;
rollback;
