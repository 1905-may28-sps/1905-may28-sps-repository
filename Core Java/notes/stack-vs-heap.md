# Stack vs Heap
* These are types of data structures
* They are also important parts of the Java Memory Model (JMM)

# Heap
* Where all objects are stored

# Stack
* Allows us to have methods
  * parameters
  * where to return to
* Stores local variables
* Last in first out (LIFO)
  * think of a stack of plates

```
public static void main(String[] args) {
  methodOne();
}

static void methodOne() {
  methodTwo();
}

static void methodTwo() {
  Person john = new Person();
  int x = 5;
}
```
