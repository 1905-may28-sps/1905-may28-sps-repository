# Comparable
* interface
* natural ordering
* `int compareTo(T o)`
  * negative - `this` is less than `o`
  * positive - `this` is greater than `o`
  * 0 - `this` and `o` are equal

```
class Person implements Comparable<Person> {
  String name;
  int age;

  @Override
  public int compareTo(Person other) {
    return this.age - other.age;
  }
}

public class Main {
  public static void main(String[] args) {
    List<Person> list = new ArrayList<>();
    list.add(new Person("john", 28));
    list.add(new Person("amy", 25));
    list.add(new Person("austin", 33));

    System.out.println(list);

    Collections.sort(list);

    System.out.println(list);

  }
}
```

# Comparator
* interface
* custom ordering
* `int compare(T o1, T o2)`

using `Person` class from above

```
class PersonNameComparator implements Comparator<Person> {
  @Override
  public int compare(Person one, Person two) {
    return one.name.compareTo(two.name);
  }
}

public class Main {
  public static void main(String[] args) {
    List<Person> list = new ArrayList<>();
    list.add(new Person("john", 28));
    list.add(new Person("amy", 25));
    list.add(new Person("austin", 33));

    System.out.println(list);

    Collections.sort(list, new PersonNameComparator());

    System.out.println(list);

  }
}
```
