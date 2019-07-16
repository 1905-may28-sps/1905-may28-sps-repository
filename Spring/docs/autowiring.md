# Autowiring
* Let Spring figure out dependencies automagically
* types
  * default (no autowiring)
  * byName
  * byType
  * constructor

### Note
* The autowiring types **byName** and **byType** use *setter injection*

# XML Example
* Define beans in `beans.xml`
* Do not define dependencies

```xml
<bean name="beanAImpl" class="com.example.beans.BeanAImpl" autowire="byType"/>

<bean name="beanBImpl" class="com.example.beans.BeanBImpl"/>
```

```java
public class BeanAImpl implements BeanA {

	private BeanB dog;

	public void setDog(BeanB dog) {
		this.dog = dog;
	}

}
```

# Annotations example
* No longer need to define beans in `beans.xml`
* `@Component`
  * defines spring bean
  * allows it to be considered for auto-detection

```xml
<context:component-scan base-package="com.example"/>
```

```java
@Component
public class BeanAImpl implements BeanA {

	@Autowired
	private BeanB dog;

}
```
