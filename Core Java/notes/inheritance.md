# Inheritance
* keyword `extends` for classes
  * you can only extend one class
* keyword `implements` for interfaces
  * you can implement many interfaces
* Inheritance is when a class acquires **state** and **behavior** from another class
* **is-a** relationship
* `Object` is the root of the inheritance hierarchy

Square **is a** Shape  
Shape **is a** Object
```
class Shape {

}

class Square extends Shape {

}
```

parent constructor is always called first
* what is the output?

```
class Shape {

  public Shape() {
    System.out.println("Shape");
  }

}

class Square extends Shape {

  public Square() {
    System.out.println("Square");
  }

}

class Main {

  public static void main(String[] args) {
    Square s = new Square();
  }

}
```

the first line of every constructor must be either `super();` or `this();` *(you can pass in arguments)*
* if not specified, `super();` is inserted

what is the result of this code?

```
class Shape {

  private String color;

  public Shape(String color) {
    this.color = color;
  }

}

class Square extends Shape {

  public Square() {

  }

}

class Main {

  public static void main(String[] args) {
    Square s = new Square();
  }

}
```
