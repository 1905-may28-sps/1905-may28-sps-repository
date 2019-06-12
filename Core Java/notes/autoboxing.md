# Autoboxing
* Java 1.5 feature that made it easier to move between primitives and wrapper classess
* **boxing** is primitive to object
* **unboxing** is object to primitive

# primitive to object

boxing

```
int x = 1;
Integer y = Integer.valueOf(x);
```
autoboxing

```
int x = 1;
Integer y = x;
```

# object to primitive

unboxing

```
Integer x = Integer.valueOf(1);
int y = x.intValue();
```

auto-unboxing

```
Integer x = 1;
int y = x;
```

# warning
autoboxing is a nice feature, but if you forget that it is happening then you could run into performance issues - [link](https://effective-java.com/2015/01/autoboxing-performance/)

```java
public Integer[] testIntegerBoxing() {
    Integer[] ints = new Integer[MAX_SIZE];
    for (int i=0; i < MAX_SIZE; i++) {
        //boxing here -> object instantiation
        ints[i] = i;
    }
    return ints;
}
```

