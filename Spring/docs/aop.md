# Spring AOP
* Aspect Oriented Programming
* inject code
* affect many methods without having to change them
* [good reference](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/aop.html)

# Aspect / Cross Cutting Concern (CCC)
* the code to inject
* good examples
  * transactions
  * security
  * logging

# Join point
* where you **can** inject
* method execution

# Pointcut
* where you **will** inject
* AspectJ pointcut expression

```java
execution(* com.example.service.EventService.play*(..))
```

# Advice
* **when** you will inject
* before
* after
* after-returning
* after-throwing
* around

# AspectJ annotations
* `@Before`
* `@After`
* `@AfterReturning`
* `@AfterThrowing`
* `@Around`

# Example

# AOP Timer Challenge
* Write an aspect to time methods
