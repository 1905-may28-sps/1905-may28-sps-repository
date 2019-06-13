# Generics
* allows us to write code to handle many types of objects AND have compile time safety
* Java 1.5

*generic* code **without generics feature**
* possible problem at **runtime**

```
public static void main(String[] args) {
  Person john = new Person();
  Person anotherJohn = (Person) someMethod(john); //possible ClassCastException
}


public static Object someMethod(Object o) {
  return o;
}
```

*generic* code **with generics feature**
* it is always better to know about issues at compile time

```
public static void main(String[] args) {
  Person john = new Person();
  Person anotherJohn = someMethod(john); //Awesome! compile time safety!!
}


public static <T> T someMethod(T dog) {
  return dog;
}

```

# <>
* we can make **classes** and **methods** generic by using `<>`
* define 1 or more *placeholders*: `<T>`, `<E>`, `<K,V>`, `<Cat, DOG, sheep>`
* Generics ensures that types are used correctly at compile time

# erasure
* the type information is erased (does not exist at runtime)

# generic classes
* let's see a generic class example
