# Control statements
* if
* switch
* for
* while
* do while
* break
* continue

# if

runs block of code if true

```
if(true) {
  System.out.println("hello world"); //executes
}
```

```
if(false) {
  System.out.println("hello world"); //does not execute
}
```

what is the output?
```
if(true) {
  System.out.println("hello world");
}

if(true) {
  System.out.println("hello world");
}
```

use `else if` to write mutually exclusive blocks of code
* either 0 or 1 will execute

```
if(false) {

} else if(true) {

} else if(false) {

}
```

```
if(false) {

} else if(false) {

} else if(false) {

}
```

`else` will execute if nothing else did
* must be last

```
if(false) {

} else if(false) {

} else if(false) {

} else {

}
```

# switch
* useful if you are checking a variable against a lot of values

```
int x = 3;

switch (x) {
  case 0:
    System.out.println("zero");
    break;
  case 1:
    System.out.println("one");
    break;
  case 2:
    System.out.println("two");
    break;
  default:
    System.out.println("not zero, one, or two");
}
```

you should definitely specify the `break` statement at the end of each *case*
* what is the output?

```
int x = 1;

switch (x) {
  case 0:
    System.out.println("zero");
  case 1:
    System.out.println("one");
  case 2:
    System.out.println("two");
  default:
    System.out.println("not zero, one, or two");
}
```

# loops
* `for`, `while`, and `do while` are all types of loops
* in each case, you loop until *something* evaluates to `false`
* each is a little different

# for
* typically used when you know how long you want to loop

loop 10 times
```
for(int i = 1; i <= 10; i++) {

}
```

`for` loops have 3 parts
* first
  * define 0, 1 or many variables
  * those variables only exist inside the `for` loop
* second
  * define expression that will evaluate to `true` or `false`
  * `for` loop will run until this expression evaluates to `false`
* third
  * define 0, 1, or many expressions
  * will be evaluated at the end of each loop

how many times does this loop?

```
for(int i = 5; i == 7; i++) {

}
```

how many times does this loop?

```
for(int i = 1; i < 2; i++) {

}
```

loop over indexes in array
* common idiom

```
for(int i = 0; i < myArray.length; i++) {

}
```

# while
* typically used when you do not know how long you want to loop

```
while (true) {
  //infinite loop
}
```

common idiom

```
boolean running = true;

while(running) {

}
```


# do while
* same as while, but will definitely run at least once

```
do {

}while(false);
```

# break
* end loop
* can only be in **loops** and **switch** statements

what is the output?

```
for(int i = 0; i < 5; i++) {
  System.out.println(i);
}
```

what is the output?

```
for(int i = 0; i < 5; i++) {
  if(i == 2) {
    break;
  }

  System.out.println(i);
}
```

what is the output?

```
for(int i = 0; i < 5; i++) {
  System.out.println(i);

  if(i == 2) {
    break;
  }
}
```

# continue
* go to end of loop and start next iteration
* can only be in **loops**

what is the output?

```
for(int i = 0; i < 5; i++) {
  System.out.println(i);
}
```

what is the output?

```
for(int i = 0; i < 5; i++) {
  if(i == 2) {
    continue;
  }

  System.out.println(i);
}
```

what is the output?

```
for(int i = 0; i < 5; i++) {
  System.out.println(i);

  if(i == 2) {
    continue;
  }
}
```
