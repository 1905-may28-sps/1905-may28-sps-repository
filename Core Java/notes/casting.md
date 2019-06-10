# Casting
* convert one data type to another
* must cast if there might be a problem

### integers and floating point numbers

```
int x = 1;
double y = x; //no cast needed
```

```
double x = 1.5;
int y = (int) x; //must cast
```
* What is the value of `y` in the above example?

### different sizes

```
byte x = 1;
int y = x; //no cast needed
```

```
int x = 128;
byte y = (byte) x; //must cast
```
* Remember that bytes are made up of 8 bits
* This means a byte can store values -128 to 127
* What is the value of `y` in the above example?
