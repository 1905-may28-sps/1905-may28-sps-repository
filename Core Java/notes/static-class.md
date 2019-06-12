# Static nested classes

```
public class One {

  public static class Two {

  }

}
```

```
public static void main(String[] args) {
  One.Two temp = new One.Two();
}
```

Static classes are especially useful in the Builder Design Pattern
