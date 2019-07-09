select genre.name, count(track.trackid)
from track 
join genre 
on track.genreid=genre.genreid
where length(genre.name) <6
group by genre.name
having count(track.trackid)>100
;
select genre.name, length(track.NAME)
from track
join genre
on track.genreid=genre.genreid
having 
;

(select* from employee where title like 'S%'
minus
select* from employee where birthdate> '01-JAN-70')union
(select* from employee where birthdate> '01-JAN-70' minus select* from employee where title like 'S%')
;