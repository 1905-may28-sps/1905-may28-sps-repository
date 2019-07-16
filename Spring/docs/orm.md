# Spring ORM
* [good reference](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/orm.html)
* Integrate with ORM
  * Hibernate
  * JPA
  * JDO
* Benefits
  * Easier testing
  * Easier transaction management
  * Less boilerplate code
  * many more...
* No more `hibernate.cfg.xml` - all config will be in `beans.xml`

# Contextual Sessions
* [good reference](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/orm.html#orm-hibernate-straight)
* Hibernate code has no knowledge of spring
* Can still leverage DI, AOP, and other Spring features
* session which executes within the application context
* session is managed by spring (unless you configure JTA - Java Transaction API)


# Overview of integration with Hibernate
* Define 3 Spring Beans
  * DataSource
  * SessionFactory
  * TransactionManager
* Inject DataSource into SessionFactory
* Inject SessionFactory into TransactionManager
* Inject SessionFactory into all DAOs
* Use `@Transactional` to manage transactions
  * commonly used in business logic layer

# Result

### DaoImpl

```java
@Component
public class DaoImpl implements Dao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public FlashCard getFlashCard(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return (FlashCard) session.get(FlashCard.class, id);
	}

  @Override
	public FlashCard updateFlashCard(FlashCard flashCard) {
		Session session = sessionFactory.getCurrentSession();
		session.update(flashCard);
		return flashCard;
	}

}
```

### BusinessLogicImpl

```java
@Service
public class BusinessLogicImpl implements BusinessLogic {

	@Autowired
	private Dao dao;

	@Override
	@Transactional(readOnly=false, isolation=Isolation.READ_COMMITTED)
	public FlashCard updateAnswer(Integer id, String newAnswer) {
		FlashCard flashCard = dao.getFlashCard(id);
		flashCard.setAnswer(newAnswer);
		dao.updateFlashCard(flashCard);
		return flashCard;
	}

}
```

# Configuration

### Enable `@Transactional` annotation

```xml
<tx:annotation-driven/>
```

### DataSource

```xml
<bean id="mydataSource" class="org.apache.commons.dbcp.BasicDataSource">  
    <property name="driverClassName"  value="oracle.jdbc.driver.OracleDriver"></property>  
    <property name="url" value="#{systemEnvironment['URL']}"></property>  
    <property name="username" value="#{systemEnvironment['USERNAME']}"></property>  
    <property name="password" value="#{systemEnvironment['PASSWORD']}"></property>  
</bean>  
```

### SessionFactory

```xml
<bean id="mySessionFactory"  class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">  
    <property name="dataSource" ref="mydataSource"></property>  

    <property name="packagesToScan" value="com.example.domain"/>

    <property name="hibernateProperties">  
        <props>  
            <prop key="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</prop>  
            <prop key="hibernate.show_sql">true</prop>    
        </props>  
    </property>  
</bean>  
```

### TransactionManager

```xml
<bean id="transactionManager" class="org.springframework.orm.hibernate4.HibernateTransactionManager">  
  <property name="sessionFactory" ref="mySessionFactory"/>  
</bean>  
```



## Transactions
`@Transactional` indicates that a persistence method takes place in a transactional context (i.e. on DAO methods)

<br>

### Transaction Propagation <hr>
<br>
#### REQUIRED
`@Transactional(propagation=Propagation.REQUIRED)`
- same physical transaction will be used if one already exists, otherwise a new transaction will be opened

#### REQUIRES_NEW
`@Transactional(propagation=Propagation.REQUIRES_NEW)`
- indicates a new physical transaction will be created for @Transactional method -- inner transaction can commit or rollback independently of the outer transaction

#### NESTED
`@Transactional(propagation=Propagation.NESTED)`
- inner and outer use same physical transaction, but are separated by savepoints (JDBC drivers only)

#### MANDATORY
`@Transactional(propagation=Propagation.MANDATORY)`
- existing transaction must already be opened or container will throw an error

#### NEVER
`@Transactional(propagation=Propagation.NEVER)`
- container will throw an error if a session is open (oppostite of mandatory)

#### NOT_SUPPORTED
`@Transactional(propagation=Propagation.NOT_SUPPORTED)`
- executes outside any existing transaction, current existing transaction will be paused

#### SUPPORTS
`@Transactional(propagation=Propagation.SUPPORTS)`
- executes within the scope of existing transaction
- otherwise, executes non-transactionally 

