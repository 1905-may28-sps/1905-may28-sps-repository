# Encapsulation
* hide data
* enforce other developers to use class correctly

# Access modifiers
* private
* *default*
* protected
* public

|           | within same class | within same package | subclasses | everyone |
|:---------:|:-----------------:|:-------------------:|:----------:|:--------:|
|  private  |        YES        |          no         |     no     |    no    |
|  default  |        YES        |         YES         |     no     |    no    |
| protected |        YES        |         YES         |     YES    |    no    |
|   public  |        YES        |         YES         |     YES    |    YES   |

# Why?

not using encapsulation
```
public class Person {
  public int age;
}

public class Main {

  public static void main(String[] args) {
    Person john = new Person();
    john.age = -1; //this is the problem
  }

}
```

using encapsulation
```
public class Person {
  private int age;

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    if(age >= 0) {
      this.age = age;
    }
  }
}
```

# Well encapsulated class
* make instance variables private
* provide public *getters* and *setters*

# Plain old java object *(POJO)*
* class with no conventions

# Java Bean
* follows certain conventions
  * should have public *getters* and *setters*
  * should have public no arg constructor
