# Primitive data types

* Primitives are values natively supported by the programming language
* They are the most basic data types
* We build complicated data types using primitives

# Primitives in Java
* We can group the Java primitives into different categories

|    category    |       primitives       |
|:--------------:|:----------------------:|
|    integer     | byte, short, int, long |
| floating point | float, double          |
|     boolean    | boolean                |
|    character   | char                   |

**integers** must be whole numbers  
```
int x = 1;
int y = -1;
```

**floating point numbers** can represent decimal places
  * remember floating point numbers are never exact. So `0.1 + 0.2 != 0.3`
```
double x = 1.0;
double y = 1.5;
double z = -1.5;
```

**booleans** can either be `true` or `false`
```
boolean x = true;
boolean y = false;
```

**characters** represent a single character
  * remember to use single quotes
```
char x = 'r';
char y = '5';
char z = '@';
```

# Sizes of primitives
| primitive |   size  |
|:---------:|:-------:|
|    byte   |  8 bits |
|   short   | 16 bits |
|    int    | 32 bits |
|    long   | 64 bits |
|   float   | 32 bits |
|   double  | 64 bits |
|  boolean  |   N/A   |
|    char   | 16 bits |
