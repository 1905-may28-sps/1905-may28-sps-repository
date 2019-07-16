# Spring Bean
* A Java object that is managed by the Spring IoC container

# How to define a Spring Bean

### xml

```xml
<bean name="beanAImpl" class="com.example.beans.BeanAImpl">

</bean>
```

### annotation
* Other annotations can be used: `@Bean`, `@Controller`, `@Service`, `@Repository`

```java
@Component
public class BeanAImpl implements BeanA {

}  
```


# Spring Bean Lifecycle
* [comprehensive reference](http://howtodoinjava.com/spring/spring-core/spring-bean-life-cycle/)

### Set up
* Object is instantiated
* Handle dependencies *(assign values to instance variables)*
* custom **init-method**
* Spring Bean is Ready!

### Tear down
* custom **destroy-method**

# Spring Bean Scopes
Determines how long a Spring Bean stays in scope

* singleton *(default)*
* prototype
* request
* session
* global-session *(only available in Portlet applications)*
