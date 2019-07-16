# `BeanFactory`
* Interface
* Older
* Lazily instantiates Spring Beans

# `ApplicationContext`
* Interface that extends `BeanFactory`
* Newer and has more features
* Eagerly instantiates Spring Beans

# Instantiating the Spring Container
* **note:** these classes all implement `ApplicationContext`

### Standalone container (for java apps)
* `ClassPathXmlApplicationContext`
* `FileSystemXmlApplicationContext`

```java
ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
```

### Web aware container
* `XmlWebApplicationContext`
