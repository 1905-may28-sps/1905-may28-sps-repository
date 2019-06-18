# group by
* reduce rows to distinct values

# copy pasta

```
create table person(
  p_id integer primary key,
  p_name varchar(2000),
  p_age integer,
  p_state varchar(2000)
);

/* no need to specify column names if you are going to insert values for all columns */
insert into person values(1, 'john',     28, 'AZ');
insert into person values(2, 'amy',      30, 'AZ');
insert into person values(3, 'austin',   30, 'NY');
insert into person values(4, 'katie',    30, 'NY');
insert into person values(5, 'courtney', 32, 'NY');
insert into person values(6, 'scout',    32, 'NY');
```

**person**

| p_id |  p_name  | p_age | p_state |
|:----:|:--------:|:-----:|:-------:|
|   1  |   john   |   28  |    AZ   |
|   2  |    amy   |   30  |    AZ   |
|   3  |  austin  |   30  |    NY   |
|   4  |   katie  |   30  |    NY   |
|   5  | courtney |   32  |    NY   |
|   6  |   scout  |   32  |    NY   |

```
select p_state from person
group by p_state;
```

**result set**

| p_state |
|:-------:|
|    AZ   |
|    NY   |

# aggregate functions
* functions based on *the whole*
* `count`, `max`, `average`

```
select avg(p_age), p_state from person
group by p_state;
```

**result set**

| avg(p_name) | p_state |
|:-----------:|:-------:|
|      29     |    AZ   |
|      31     |    NY   |
