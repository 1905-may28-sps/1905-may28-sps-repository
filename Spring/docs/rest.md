# Spring REST
* A special case of Spring MVC where we return **data** instead of **views**
* `@RestController`
  * Return values will be data (will **not** be handled by the `ViewResolver`)

### simple example
* return data in response body

```java
@RestController
@RequestMapping(value="/api")
public class RestAPI {

	@RequestMapping(method=RequestMethod.GET, value="/flashcard")
	public FlashCard getFlashCard() {
		FlashCard flashcard = new FlashCard("What's the meaning of life", "42");
		return flashcard;
	}

}
```

### more powerful example
* can set HTTP status code
* can set HTTP headers

```java
@RestController
@RequestMapping(value="/api")
public class RestAPI {

	@RequestMapping(method=RequestMethod.GET, value="/flashcard2")
	public ResponseEntity<FlashCard> getFlashCard2() {
		FlashCard flashcard = new FlashCard("What's the meaning of life", "42");
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(flashcard);
	}

}
```
