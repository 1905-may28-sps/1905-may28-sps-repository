# PL/SQL
* Procedural Language / SQL
* created by Oracle
* SQL is not turing complete
  * basically it is not a *full* language
* features
  * variables
  * functions
  * exception handling
  * looping / conditional constructs

# example table

```
create table flash_card(
  fc_id integer primary key,
  fc_question varchar2(2000),
  fc_answer varchar2(2000)
);
```

# Sequences
* pattern

```
create sequence fc_id_sequence
  start with 1
  increment by 1;
```

# Triggers
* block of code that is automatically executed when events happen

```
CREATE OR REPLACE TRIGGER fc_insert_trigger
BEFORE INSERT ON flash_card
FOR EACH ROW --required if you want to see/manipulate the row's data
BEGIN
      SELECT fc_id_sequence.nextval INTO :new.fc_id FROM DUAL;
      --DUAL is a dummy table, typically used when you don't require a table
      --but you still need the syntax of a sql statement to be correct
END;
/
```

let's test it out

```
insert into flash_card(fc_question, fc_answer) values('what is java?', 'awesome');
insert into flash_card(fc_question, fc_answer) values('who is Douglas Crockford?', 'the man');
insert into flash_card(fc_question, fc_answer) values('who is Moby Dock?', 'Docker''s mascot');
```

# Functions
* block of code that you can execute
  * can call from `select`, `insert`,
* 0 or many parameters
* must return 1 value

function

```
CREATE OR REPLACE FUNCTION get_max_id
RETURN NUMBER
IS
  max_id NUMBER;
BEGIN

  SELECT MAX(fc_id) INTO max_id FROM flash_card;
  RETURN max_id;

END;
/
```

invoke function

```
DECLARE
  dog NUMBER;
BEGIN

  dog := get_max_id();

  DBMS_OUTPUT.PUT_LINE('max id is: ' || dog);

END;
/
```

# Stored Procedure
* block of code that you can execute
* 0 or many IN parameters
* 0 or many OUT parameters

stored procedure

```
CREATE OR REPLACE PROCEDURE insert_flash_card(new_question IN VARCHAR2, new_answer IN flash_card.fc_answer%TYPE)
IS
BEGIN
  INSERT INTO flash_card(fc_question, fc_answer) VALUES(new_question, new_answer);
  COMMIT;
END;
/
```

invoke stored procedure

```
BEGIN
  insert_flash_card('what is the answer to life, the universe, and everything', '42');
END;
/
```
