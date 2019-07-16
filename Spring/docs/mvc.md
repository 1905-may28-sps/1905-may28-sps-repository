# Spring MVC
* Abstracts Servlets

# Important components
* Only one servlet called `DispatcherServlet`
  * **Front Controller** Design Pattern - single point of entry for all requests
* `HandlerMapping` - maps requests to correct controller
* `@Controller` - handles requests
* `ViewResolver` - helps render views

# ViewResolver
* Especially useful for server-side HTML rendering
* Can use any view technology
  * FreeMarker
  * Thymeleaf
  * JSPs
  * Velocity

```xml
<bean id="viewResolver" class="org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver">
  <property name="cache" value="true"/>
  <property name="prefix" value=""/>
  <property name="suffix" value=".html"/>
</bean>
```

# Controllers
* `@Controller`
  * Defines Spring Bean
  * Says this class will handle requests
* `@RequestMapping`
  * Specifies what request this method will handle

```java
@Controller
public class TestController {

	@RequestMapping(method=RequestMethod.GET, value="/cat")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("name", "John");
		return "dog";
	}

}
```
