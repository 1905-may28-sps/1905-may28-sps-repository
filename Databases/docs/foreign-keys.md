# more about FK
* FKs allow us to connect tables together

# one to many
* one department has many employees
* an employee belongs to one department

### cool, but not that useful

**employee**

| e_id |  e_name  |
|:----:|:--------:|
|   1  |   john   |
|   2  |    amy   |
|   3  |  austin  |
|   4  |   katie  |
|   5  | courtney |
|   6  |   scout  |

**department**

| d_id |   d_name  |
|:----:|:---------:|
|  100 |   sales   |
|  200 |  finance  |
|  300 | marketing |

### beautiful

**employee**

| e_id |  e_name  |  dog  |
|:----:|:--------:|:-----:|
|   1  |   john   |  100  |
|   2  |    amy   |  100  |
|   3  |  austin  |  200  |
|   4  |   katie  |  200  |
|   5  | courtney |  200  |
|   6  |   scout  |  200  |

**department**

| d_id |   d_name  |
|:----:|:---------:|
|  100 |   sales   |
|  200 |  finance  |
|  300 | marketing |

# many to many
* one class has many students
* one student has many classes

**clazz**

| c_id |  c_name |
|:----:|:-------:|
|  100 |   math  |
|  200 | science |

**student**

| s_id | s_name |
|:----:|:------:|
|   1  |  john  |
|   2  |   amy  |

**clazz_student**
* this is called a *many to many* or *join* table

| cat | dog |
|:---:|:---:|
| 100 |  1  |
| 100 |  2  |
| 200 |  2  |

# Composite PK

```
CREATE TABLE clazz_student(
  cat INTEGER,
  dog INTEGER,
  PRIMARY KEY(cat,dog),
  FOREIGN KEY(cat) REFERENCES clazz(c_id),
  FOREIGN KEY(dog) REFERENCES student(s_id)
);
```

# Alternative solution

**clazz_student**

| cs_id | cat | dog |
|:-----:|:---:|:---:|
|  7777 | 100 |  1  |
|  8888 | 100 |  2  |
|  9999 | 200 |  2  |
