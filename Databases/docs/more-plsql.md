# more pl/sql

### basic syntax

```
/*
CREATE [OR REPLACE] PROCEDURE proc_name [list of parameters]
IS
       Declaration section
BEGIN
       Execution section
EXCEPTION
       Exception section
END;
*/
```

### hello world

```
CREATE OR REPLACE PROCEDURE hello_world_procedure
IS
BEGIN

  DBMS_OUTPUT.PUT_LINE('hello word!');

END;
/
```

```
BEGIN
  hello_world_procedure();
END;
/
```

### out parameters

```
CREATE OR REPLACE PROCEDURE get_answer_procedure(some_q IN VARCHAR2, some_a OUT VARCHAR2)
IS
BEGIN

  SELECT fc_answer INTO some_a FROM flash_card WHERE fc_question = some_q;

END;
/
```

```
DECLARE
  answer VARCHAR2(4000);
BEGIN

  get_answer_procedure('what is java?', answer);
  DBMS_OUTPUT.PUT_LINE('answer: ' || answer);

END;
/
```

### if statement

```
CREATE OR REPLACE FUNCTION find_max_num(x IN NUMBER, y IN NUMBER)
RETURN NUMBER
IS
  z NUMBER;
BEGIN

  IF x > y THEN
    z := x;
  ELSE
    z := y;
  END IF;

  RETURN z;

END;
/
```

```
DECLARE
  first_num  NUMBER;
  second_num NUMBER;
  max_num    NUMBER;

BEGIN
  first_num  := 22;
  second_num := 42;

  max_num := find_max_num(first_num, second_num);

  DBMS_OUTPUT.PUT_LINE('Max: ' || max_num);
END;
/
```

# Cursor
* pointer to a **Result Set**

```
CREATE OR REPLACE PROCEDURE get_all_flash_cards(dog OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN dog FOR
  SELECT * FROM flash_card;
END;
/
```

```
DECLARE
  cat SYS_REFCURSOR;
  some_id       flash_card.fc_id%TYPE;
  some_question flash_card.fc_question%TYPE;
  some_answer   flash_card.fc_answer%TYPE;
BEGIN

  get_all_flash_cards(cat);


  LOOP
    FETCH cat INTO some_id, some_question, some_answer;
    EXIT WHEN cat%NOTFOUND;

    DBMS_OUTPUT.PUT_LINE(some_id || ' ' || some_question || ' ' || some_answer);

  END LOOP;

  CLOSE cat;

END;
/
```
