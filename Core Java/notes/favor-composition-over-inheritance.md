# Favor composition over inheritance
* once you inherit a `class` or `interface` you are locked in to that dependency

people overuse inheritance
* `Square` **is a** `Rectangle` makes sense... right?
* `Square` inherits 2 variables
* `Square` will probably have to override the *setters* so when length changes, width also changes
* Doesn't the user of `Rectangle` have a reasonable guarantee that when length changes, width should be unaffected?
  * what if you pass in a `Square`

```
class Rectangle {
  private double length;
  private double width;

  public double calculateArea() {
    return length * width;
  }

  //getters and setters

}

class Square extends Rectangle {

}
```

# Composition
* **has a** relationship

`Car` **has a** `Engine`

```
public class Car {
  private Engine engine;
}
```

# Delegation
* delegate tasks to another object

```
public class Car {
  private Engine engine;

  public void startEngine() {
    engine.start();
  }
}
```

# Composition vs Inheritance
* both can *reuse code*
* one isn't necessarily better than the other
* pick the correct one for your situation
* be aware that sometimes people overuse inheritance
