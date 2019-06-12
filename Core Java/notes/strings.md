# strings
* 0 or more characters
* String literal: `"my string"`
* There are important classes to help us represent strings
  * String
  * StringBuilder
  * StringBuffer
    * **deprecated**

# String
* immutable
  * object content's cannot change

# StringBuilder
* mutable
* not synchronized / not thread safe

# StringBuffer
* **deprecated**
* mutable
* synchronized / thread safe

# string pool
* a collection of unique strings
* If the string literal `"dog"` is used then it searches for that string object in the **string pool**
  * if exists, then return that object
  * else create new object in **string pool**
* `new String("dog")` creates a String object **outside** of the **string pool**

# Best to learn by example
* Note: For objects, `==` checks if the memory address is the same  
* common questions
  * which variables point to the same object?
  * how many string objects are created?

```
String one = "dog";
String two = "dog";
```

```
String one = "dog";
String two = new String("dog");
```

```
String one = new String("dog");
```

```
String one = "cat" + "dog";
```

```
String one = new String("cat" + "dog");
```


# What did we learn?
* do not add strings together a lot
  * if you need to, use `StringBuilder` instead
* use `equals` method to determine equality

# [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)
* useful methods
  * `length`
  * `charAt`
  * `contains`
  * `indexOf`
  * `split`
  * `substring`
  * `trim`

# [StringBuilder](https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html)
* useful methods
  * `append`
  * `insert`
  * `delete`
  * `reverse`
  * `substring`

example

```
public static void main(String []args){
   StringBuilder sb = new StringBuilder();
   for(int i = 0; i < 100; i++) {
       sb.append(i);
   }
   String str = sb.toString();
   System.out.println(str);
}
```
