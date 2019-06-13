# abstract
* can be used on **classes** and **methods**
* cannot be used on variables

# Abstract class
* cannot be instantiated
* can have abstract methods and concrete methods

```
public abstract class Test {

}
```

# Abstract methods
* no implementation
* must be implemented by subclasses

```
public abstract void someMethod();
```

# Abstraction
* fundamental concept of OO
* hide complexity

this is abstraction because it allows me to think in general terms: **I know a Shape can calculate its area**

```
abstract class Shape {
  public abstract double calculateArea();
}

class Rectangle extends Shape {
  private double length;
  private double width;

  public Rectangle(double length, double width) {
    this.length = length;
    this.width = width;
  }

  public double calculateArea() {
    return length * width;
  }
}

public class Main {

  public static void main(String[] args) {
    Shape s = new Rectangle(3,4);
    double area = s.calculateArea();

    System.out.println(area);
  }

}
```

# Method overriding
* when a method exists in a parent class and you redefine it in a subclass
* form of **polymorphism**
* the method that will be called is determined at **runtime**, which is why method overriding is called **runtime polymorphism**
* **method overloading** is **compile time polymorphism**

# Polymorphism
* the ability for an object to take on many forms
* method overloading
* method overriding
* the above example is using polymorphism

`s` is a `Shape` and which `calculateArea()` method is called depends on the implementing object that `s` happens to point to

```
double area = s.calculateArea();
```

example

```
Shape[] shapeArray = new Shape[3];

shapeArray[0] = new Rectangle(3,4);
shapeArray[1] = new Circle(5);
shapeArray[2] = new Square(6);

for(int i = 0; i < shapeArray.length; i++) {
  double area = shapeArray[i].calculateArea();
}
```
