# Spring
* [spring.io](https://spring.io/)
* Spring is a Java Framework
* Created in 2002 by Rod Johnson
* XML configuration in `beans.xml`
  * We will see Java config later


# Modules
* core, beans, context
  * base modules of Spring
  * contains `BeanFactory` and `ApplicationContext`
* aop
* mvc
* orm
* data
* boot
* security
* test
* There are many more...

# Why Spring?

We can turn this code

```java
public class BeanAImpl implements BeanA {

	private BeanB dog = new BeanBImpl();

}
```

into this code

```java
public class BeanAImpl implements BeanA {

	private BeanB dog;

}
```
