# Variable scopes in Java
* class
* instance
* parameter
* local

```
public Test {

  static int a; //class variable

  int b; //instance variable

  void someMethod(int c) {
    int d;

    if(true) {
      int e;
    }

  }

}
```

* **a** is in the class scope
* **b** is in the instance scope
* **c** is in the parameter scope
* **d** and **e** are in the local scope
  * not much of a difference between **c** and **d**.  Main difference is parameter scoped variables are guaranteed to be visible throughout the entire method.

It is important to remember that in Java **blocks have scope**, meaning if a variable is defined in an `if` statement, then it does not exist outside of that `if` statement
