# Bean Wiring
* Specify dependencies in `beans.xml`


### setter injection example

```xml
<bean name="beanAImpl" class="com.example.beans.BeanAImpl">
  <property name="dog" ref="beanBImpl"/>
</bean>

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

### constructor injection example

```xml
<bean name="beanAImpl" class="com.example.beans.BeanAImpl">
  <constructor-arg ref="beanBImpl"/>
</bean>

<bean name="beanBImpl" class="com.example.beans.BeanBImpl"/>
```

```java
public class BeanAImpl implements BeanA {

	private BeanB dog;

	public BeanAImpl(BeanB dog) {
		super();
		this.dog = dog;
	}
}
```
