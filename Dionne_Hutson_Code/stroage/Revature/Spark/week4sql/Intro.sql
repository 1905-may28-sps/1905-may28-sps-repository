
update artist
set name = (select upper(name) from artist where lower(name)='buddy guy')
where lower(name)='buddy guy';
select * from artist where lower(name)='buddy guy';

select name,length(name)from genre;
select count(*) as "num genres" from genre;


create view special_artist as
select artistid AS ID, name as ARTIST 
from artist where lower(name) like '%v%' AND artistid > 200;
select * from special_artist;
create view special_album as 
select * from album where length(title) > 40;

create view jonveiw as
select al.title AS album, art.name as "Artist Name"
from album al
join artist art
on al.artistid=art.artistid; 


select art.id as "Artist id", al.artistid as "album art id", art.artist,al.title
from special_artist art
full outer join special_album al
on al.artistid=art.id;
select count(*) from special_album;


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

select minion.lastname as minio, boss.lastname as boss
from employee minion
join employee boss
on minion.reportsto=boss.employeeid;


select genre.name,count(track.trackid)
from track 
join genre
on track.genreid=genre.genreid
where length(genre.name)<6
group by genre.name
having count(track.trackid)>100;

--number of songs in eack clbum
select album.title,count(track.trackid)
from track
join album
on track.albumid=album.albumid
group by album.title
order by count(track.trackid);

select*from employee;
select * from employee where title like'S%' 
UNION select *from employee where birthdate>'01-jan-70'
Minus(
select *from employee where birthdate>'01-jan-70'
Intersect select * from employee where title like'S%');



