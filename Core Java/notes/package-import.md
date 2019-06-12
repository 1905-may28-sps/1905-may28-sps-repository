# package
* must be first line in a `.java` file
  * if it is not there then your class will be put in the `default` package... that would be bad
* used to resolve naming conflicts
* The package and class name together make up the Fully Qualified Name (FQN)
  * Put class `HelloWorld` in package `com.example`
  * Then the fully qualified name is: `com.example.HelloWorld`
  * There could be another `HelloWorld` class, and we could tell the difference by using the FQN
* By convention, packages should be in all lowercase
* By convention, package names should start general and get more specific
  * `com.revature.training.batches.asu`
* package names are actually represented as directories

# import
* When I use a class, I must use its FQN
* the `import` statement allows me to use a class without specifying its FQN every time
* `java.lang` package is imported by default
* classes in the same package are automatically imported

without import

```
package com.mycompany;

public class Test {
  public static void main(String[] args) {
    com.example.Person john = new com.example.Person();
  }
}
```

with import
* `import com.example.Person;`
* `import com.example.*;`

```
package com.mycompany;

import com.example.Person;

public class Test {

  public static void main(String[] args) {
    Person john = new Person();
  }

}
```

# static import
* used to import static variable and methods

```
package com.example;

import static java.lang.Math.PI;

public class Test {

  public static void main(String[] args) {
    System.out.println(PI);
  }

}
```
