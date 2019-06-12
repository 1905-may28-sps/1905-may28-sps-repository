# String Parsing

### Regular Expressions *(regex)*
* A regular expression is a **search pattern**
* Commonly used for validating specific string formats
  * email
  * phone number
  * address
* [Regex in Java](https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html)
  * `^` beginning of a line
  * `$` end of a line
  * `abc` the characters *abc*
  * `[abc]` *a*, *b*, or *c*
  * `[^abc]` any character except *a*, *b*, or *c*
  * `.` any character

### [split](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#split-java.lang.String-)
* String's `split` method is a simple way to parse a string using regex

```
public static void main(String []args){

   String str = "red,green,blue";

   String[] array = str.split(",");

   for(String temp : array) {
       System.out.println(temp);
   }

}
```

```
public static void main(String []args){

   String str = "abc1def2ghi3jkl4mno5pqr6stu7vwx8yz";

   String[] array = str.split("[0-9]");

   for(String temp : array) {
       System.out.println(temp);
   }

}
```

### [StringTokenizer](https://docs.oracle.com/javase/8/docs/api/java/util/StringTokenizer.html)

> StringTokenizer is a legacy class that is retained for compatibility reasons although its use is discouraged in new code. It is recommended that anyone seeking this functionality use the split method of String or the java.util.regex package instead.
