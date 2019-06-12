# JUnit
* unit test our code
* a unit test focuses on a really small part of the codebase: a single method
* tests should not care what order they are run in

# Test Driven Development (TDD)
* write unit tests first
* watch them fail
* write code to satisfy tests

# JUnit Annotations
* `@Test` - unit test
* `@Ignore` - ignore a unit test
* `@Before` - runs before each unit test
* `@@BeforeClass` - runs **once** before all unit tests in the class
* `@After`
* `@AfterClass`

### `@Test`
* `@Test`
* `@Test(expected=NullPointerException.class)`
* `@Test(timeout=5000)`

# JUnit Assert class
* [docs](http://junit.sourceforge.net/javadoc/org/junit/Assert.html)
* Many useful static methods
  * `assertEquals`
  * `assertTrue`
  * `assertFalse`
  * `assertArrayEquals`

### `assertEquals`

```
String failureMessage = "";
int expected = 0;
int actual = someMethod();

Assert.assertEquals(failureMessage, expected, actual);
```

# Unit testing idiom
* Arrange
* Act
* Assert
