# Hibernate
* **Object Relational Mapping (ORM)**
  * Map Java classes to Relational Database tables
* Abstracts away JDBC
* No more sql (which is database specific)
* Hibernate generates the *correct* sql syntax based on the **Hibernate Dialect**

# Hibernate Exceptions
* `HibernateException` is the base `Throwable` type for Hibernate
* It extends `RuntimeException`
* Hibernate wraps all JDBC exceptions (`SQLException`)


# Configuration
* Main configuration in `hibernate.cfg.xml`
* Mapping configuration either in xml or annotations

# `hibernate.cfg.xml`
* username
* password
* url
* driver
* dialect
* where the mapping configuration is
* and much more...

example

```
<hibernate-configuration>
    <session-factory>

      <property name="hibernate.connection.username">taylor</property>
      <property name="hibernate.connection.password">p4ssw0rd</property>
      <property name="hibernate.connection.url">jdbc:oracle:thin:@<public-dns-name>:1521:orcl</property>
	    <property name="hibernate.connection.driver_class">oracle.jdbc.driver.OracleDriver</property>
      <property name="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</property>

      <property name="hibernate.show_sql">true</property>

      <mapping class="com.example.domain.FlashCard"/>    

    </session-factory>
</hibernate-configuration>
```

# Mapping Configuration

Assume we are mapping a java class `FlashCard` to a database table `FLASH_CARD`

### XML config
* We obviously need the java class and the database table
* The mapping configuration is done in a separate xml file called a **Hibernate Mapping File (HBM)**
* So for class `FlashCard`, we would have an hbm called `FlashCard.hbm.xml`

### Annotation config
* We can do the mapping right inside the `FlashCard` class
* Hibernate follows a standard called Java Persistence API (JPA) and both have their own annotations
* By convention, we use JPA annotations

example

```
package com.example.domain;

import javax.persistence.*;

@Entity
@Table(name="flash_card")
public class FlashCard {

	@Id
	@Column(name="fc_id")
	private Integer id;

	@Column(name="fc_question")
	private String question;

	@Column(name="fc_answer")
	private String answer;


  // no arg constructor

  // getters and setters

}
```

# Important Interfaces
* `Configuration`
  * this is a class
* `SessionFactory`
* `Session`
* `Transaction`
* `Query`
* `Criteria`

# Configuration
* Used to create a `SessionFactory`
* Specify location of `hibernate.cfg.xml`

```
SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
```

# SessionFactory
* Used to create `Session` objects
* Only need one


# Session
* Not to be confused with `HttpSession`
* Represents your session with a database
* methods
  * `save`
  * `get`
  * `update`
  * `delete`
  * `beginTransaction`
  * `createQuery`
  * `createCriteria`

```
Session session = sessionFactory.openSession();

//stuff

session.close();
```

# Transaction
* In Hibernate, `autoCommit` is `false` by default
  * In JDBC, it was `true` by default
* This means, you must **begin** and **commit** a transaction if you modify anything

```
Transaction tx = session.beginTransaction();

//stuff

tx.commit();
```

# Query
* Can do more complicated CRUD than the `Session` methods
* Use **Hibernate Query Language (HQL)**
  * It's like SQL, but database agnostic

retrieve

```
Query query = session.createQuery("from BankUser where username = :usernameVar");
query.setString("usernameVar", username);
List<BankUser> bankUsers = query.list();
```

modify

```
String hql = "update BankUser set password=:pwdVar where username=:usrVar";

Query query = session.createQuery(hql);
query.setString("usrVar", username);
query.setString("pwdVar", password);

int numAffected = query.executeUpdate();
```

# Criteria
* **Can only retrieve from database**
* Cannot modify anything
* It's nice because you can create complicated queries

```
Criteria criteria = session.createCriteria(BankUser.class);

// add as many Restrictions as you want

List<BankUser> bankUsers = criteria.list();
```
