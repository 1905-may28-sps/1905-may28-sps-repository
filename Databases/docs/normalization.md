# Database normalization
* good database design
* consists of rules called **normal forms**
  * 3NF is generally considered good enough

# 1NF
* make values atomic

### problem 1

**person**

| p_id | p_name |             p_address            |
|:----:|:------:|:--------------------------------:|
|   1  |  john  | 123 main street, Tempe, AZ 85283 |

### solution 1
* create more columns

**person**

| p_id | p_name |     p_street    | p_city | p_state | p_zip |
|:----:|:------:|:---------------:|:------:|:-------:|:-----:|
|   1  |  john  | 123 main street |  Tempe |    AZ   | 85283 |

### problem 2

**person**

| p_id | p_name |    p_phone_numbers    |
|:----:|:------:|:---------------------:|
|   1  |  john  | 1117770000,1234567890 |

### solution 2
* create new table
* make use of FK

**person**

| p_id | p_name |
|:----:|:------:|
|   1  |  john  |

**phone_number**

| phone_id |  phone_num | dog |
|:--------:|:----------:|:---:|
|    100   | 1117770000 |  1  |
|    200   | 1234567890 |  1  |

# 2NF
* must be in 1NF
* remove partial dependencies
  * a partial dependency is when you depend on *part of the PK*

### problem

**author**

| a_id | a_name |
|:----:|:------:|
|   1  |  john  |
|   2  |   amy  |
|   3  | austin |

**book**

| b_id |       b_name      |
|:----:|:-----------------:|
|  100 |  Head First Java  |
|  200 |     Structures    |
|  300 | Superintelligence |

**author_book**
* *join* table to describe relationship between authors and books

| a_id | b_id | author_number | year_published |
|:----:|:----:|:-------------:|:--------------:|
|   1  |  100 |       1       |      2015      |

### solution
* remove column causing problem and put in proper place


# 3NF
* must be in 2NF
* remove transitive dependencies

# problem

**review**

| r_id |        review        | num_stars | star_meaning |
|:----:|:--------------------:|:---------:|:------------:|
|   1  | worst day of my life |     3     |      ok      |
|   2  |    it was amazing    |     5     |     great    |

# solution
* remove columns causing problem and put in proper place

**review**

| r_id |        review        | star_id |
|:----:|:--------------------:|:-------:|
|   1  | worst day of my life |   300   |
|   2  |    it was amazing    |   500   |

**stars**

| s_id | num_stars | star_meaning |
|:----:|:---------:|:------------:|
|  100 |     1     |      bad     |
|  200 |     2     |     poor     |
|  300 |     3     |      ok      |
|  400 |     4     |     good     |
|  500 |     5     |     great    |
