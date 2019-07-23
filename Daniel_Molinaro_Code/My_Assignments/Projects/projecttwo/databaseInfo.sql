create table dhal_ratings (
  rate_id number primary key,
  rating number not null
  );

create table dhal_users(
  user_id number primary key,
  email varchar2(150) unique not null,
  password varchar2(100) not null,
  first_name varchar2(100) not null,
  last_name varchar2(100) not null
);

--create sequence dhal_users_seq;
--
--create or replace trigger dhal_users_trigger
--before insert on dhal_users
--for each row
--begin
--select dhal_users_seq.nextval
--into : new.user_id
--from dual;
--end;
--/

create table dhal_comments (
  comment_id number primary key,
  author_id number not null,
  post_date timestamp not null,
  comment_s varchar2(1000) not null,
  rate_id number not null,
  constraint dhal_comments_fk_users foreign key (author_id) references dhal_users(user_id),
  constraint dhal_comments_fk_rateting foreign key (rate_id) references dhal_ratings(rate_id)
);


--create sequence dhal_comments_seq;
--
--
--create or replace trigger dhal_comments_trigger
--before insert on dhal_comments
--for each row
--begin
--select dhal_comments_seq.nextval
--into : new.comment_id
--from dual;
--end;
--/

--drop trigger dhal_comments_trigger;

create table dhal_playlists (
  playlist_id number primary key,
  track_id number not null,
  comment_id number,
  constraint dhal_playlist_fk_comments foreign key (comment_id) references dhal_comments(comment_id)
);


--create sequence dhal_playlists_seq;
--
--
--create or replace trigger dhal_playlist_trigger
--before insert on dhal_playlists
--for each row
--begin
--select dhal_playlist_seq.nextval
--into : new.playlist_id
--from dual;
--end;
--/

create table dhal_track_ratings (
  track_id number primary key,
  rate_id number not null,
  rater_id number not null,
  constraint dhal_track_rating_fk_users foreign key (rater_id) references dhal_users(user_id),
  constraint dhal_track_ratings_fk_rating foreign key (rate_id) references dhal_ratings(rate_id)
);

--create sequence dhal_track_ratings_seq;
--
--
--create or replace trigger dhal_track_ratings_trigger
--before insert on dhal_track_ratings
--for each row
--begin
--select dhal_track_ratings_seq.nextval
--into : new.track_id
--from dual;
--end;
--/

create table dhal_trending (
  trend_id number primary key,
  track_id number not null,
  constraint dhal_trending_fk_track_rating foreign key (track_id) references Dhal_track_ratings(track_id)
);

--create sequence dhal_trending_seq;
--select dhal_trending_seq.nextval from dual;
--
--
--create or replace trigger dhal_playlist_trigger
--before insert on dhal_trending
--for each row
--begin
--select dhal_trending_seq.nextval
--into : new.trend_id
--from dual;
--end;
--/