# Exceptions
* Exceptions are things that go wrong **at runtime**
* Different from *syntax errors*, which is when your code won't compile
* 3 types
  * Unchecked Exceptions - `RuntimeException`
  * Checked Exceptions - `Exception`
  * Errors - `Error`

# Unchecked Exceptions
* do not have to handle, but can
* programming mistakes
* examples: `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundsException`

# Checked Exceptions
* you have to handle
* examples: `IOException`, `SQLException`

# Errors
* do not have to handle, and shouldn't
* examples: `OutOfMemoryError`, `StackOverflowError`

# Exception Handling
* allows us to handle problems separate from our *normal code*
* keywords: `try`, `catch`, `finally`, `throw`, `throws`
* exception is *thrown* when something goes wrong
* exception can be *caught* to resolve the problem

# try
* try some code
* must be followed by at least one `catch` block or a `finally` block

typical example

```
try {

} catch(Exception e) {

}
```

# catch
* resolve the problem
* must specify exception type

example: only handle `NullPointerException`
* the exception that was *thrown* in the `try` block is *caught* if it **is a** `NullPointerException`

```
try {

} catch(NullPointerException e) {

}
```

`catch` blocks can be chained together

```
try {

} catch(NullPointerException e) {

} catch(ArithmeticException e) {

}
```

java does not compile if you have **unreachable code**

```
try {

} catch(Exception e) {

} catch(NullPointerException e) {

}
```

# finally
* runs no matter what
* must be last block

what's the output?

```
try {
  System.out.println("cat");

  String s = null;
  s.length();

  System.out.println("dog");

} catch(NullPointerException e) {

  System.out.println("catch");

} finally {

  System.out.println("finally");

}
```

what's the output?

```
try {
  System.out.println("cat");

  String s = "hello world";
  s.length();

  System.out.println("dog");

} catch(NullPointerException e) {

  System.out.println("catch");

} finally {

  System.out.println("finally");

}
```

IQ: difference between final, finally, and finalize?

# throw
* say there is a problem
* you can throw anything that **is a** `Throwable`

```
throw new Exception();
```

```
Exception e = new Exception();
throw e;
```

# throws
* pass off responsibility to another method
  * you can specify many exceptions separated by commas
* another way to *handle* a checked exception

```
public void methodOne() {
  try {
    methodTwo();
  }catch(Exception e) {

  }
}

public void methodTwo() throws Exception {
  throw new Exception();
}

```

* when an exception is thrown, the stack unrolls until it is caught
* if it is not caught, then the JVM catches it and terminates the program

# Custom exception
* create a class that **is a** `Throwable`

```
public class DogException extends Exception {

}
```

it is common to pass in a message that explains what went wrong

```
throw new Exception("something went wrong");
```

it is also common to pass in a *cause*, which is another `Throwable`
* this allows us to catch an exception and **wrap** it with a more appropriate exception

```
class BankTransactionException extends Exception {}

class NoMoneyException extends Exception {}

public class Main {

  public static void main(String[] args) throws BankTransactionException {
    runBank();
  }

  public static void runBank() throws BankTransactionException {

    try {
      withdraw();
    } catch(NoMoneyException e) {
      throw new BankTransactionException("no money in the bank", e); //exception wrapping
    }

  }

  public static void withdraw() throws NoMoneyException {
    throw new NoMoneyException();
  }
}
```

for these reasons, this is what my custom exceptions look like

```
public class MyException extends Exception {
  public MyException(){}

  public MyException(String message) {
    super(message);
  }

  public MyException(String message, Throwable cause) {
    super(message, cause);
  }
}
```

The biggest difference between novice and expert programmers is the amount of code reuse.
