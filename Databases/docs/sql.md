# sql
* Structured Query Language
* how we communicate with a relational database
* not case sensitive
  * usually separate words using `_` for example: `BANK_ACCOUNT`
  * note that `BANK_ACCOUNT` and `bank_account` are the same

# problem
* no name
* balance is not a number

```
<account>
  <balance>hello world</balance>
</account>
```

# solution

**BANK_ACCOUNT**

| ba_name | ba_balance |
|:----:|:-------:|
| john |   100.00   |
|  amy |   200.12   |

```
CREATE TABLE bank_account(
  ba_name    VARCHAR2(2000) NOT NULL,
  ba_balance DECIMAL(20,2)  NOT NULL
);
```

```
INSERT INTO bank_account(ba_name, ba_balance) VALUES ('john', 100);
INSERT INTO bank_account(ba_name, ba_balance) VALUES ('amy', 200.12);

```


# DDL
* Data Definition Language
* `CREATE`, `ALTER`, `DROP`, `TRUNCATE`
* `GRANT`, `REVOKE`

# DML
* Data Manipulation Language
* `SELECT`, `INSERT`, `UPDATE`, `DELETE`

# TCL
* Transaction Control Statements
* `COMMIT`, `ROLLBACK`, `SAVEPOINT`,  `SET TRANSACTION`

# Note
* be careful not to use **reserved words** for table and column names

# data types in OracleDB
* `INTEGER`, `DECIMAL`, `NUMBER`
* `VARCHAR2`
* `DATE`, `TIMESTAMP`
* `CLOB`, `BLOB`
  * we can but should we?

this list is not comprehensive

# Spin up AWS RDS instance
* [aws-rds](aws-rds.md)

# Constraints
* **Primary Key**
  * unique and not null
  * one or many columns that identify each row
* **Foreign Key**
  * a column that points to another column
  * usually points to a PK
  * has referential integrity (makes sure that it points to a valid value)
* **Not Null**
* **Unique**
* **Check**
  * further restrict values

# Primary Key

```
CREATE TABLE person(
  p_id NUMBER PRIMARY KEY,
  p_name VARCHAR2(2000)
);

INSERT INTO person(p_id, p_name) VALUES(1, 'john'); /* success */
INSERT INTO person(p_id, p_name) VALUES(1, 'amy');  /* fail - PK must be unique */
INSERT INTO person(p_name) VALUES('austin');        /* fail - PK must not be null */
```

# Foreign Key

```
CREATE TABLE department(
  d_id INTEGER PRIMARY KEY,
  d_name VARCHAR2(2000)
);

CREATE TABLE employee(
  e_id INTEGER PRIMARY KEY,
  e_name VARCHAR2(2000),
  dog INTEGER,
  FOREIGN KEY (dog) REFERENCES department(d_id)
);


INSERT INTO department(d_id, d_name) VALUES(1, 'sales');
INSERT INTO department(d_id, d_name) VALUES(2, 'finance');
INSERT INTO department(d_id, d_name) VALUES(3, 'marketing');

INSERT INTO employee(e_id, e_name, dog) VALUES(1, 'john',     1);
INSERT INTO employee(e_id, e_name, dog) VALUES(2, 'amy',      1);
INSERT INTO employee(e_id, e_name, dog) VALUES(3, 'austin',   2);
INSERT INTO employee(e_id, e_name, dog) VALUES(4, 'katie',    2);
INSERT INTO employee(e_id, e_name, dog) VALUES(5, 'courtney', 2);
INSERT INTO employee(e_id, e_name, dog) VALUES(6, 'scout',    2);


/* stop to look at data */

INSERT INTO employee(e_id, e_name, dog) VALUES(7, 'john doe', 100); /* fail - no value of 100 in department.d_id */

DELETE FROM department WHERE d_name='sales'; /* fail - would violate referential integrity */

DELETE FROM department WHERE d_name='marketing'; /* success */
```

# Check

```
CREATE TABLE person(
  age NUMBER,
  CHECK (age >= 0)
);

INSERT INTO person(age) VALUES(-1); /* fail */
INSERT INTO person(age) VALUES(0);  /* success */
```

# Integrity
* **Domain Integrity**
  * all values in a column are of the same type
  * can use **check** constraint to help make sure values are valid
* **Referential Integrity**
  * FK points to valid values
* **Entity Integrity**
  * should be able to uniquely identify each row *(PK)*
