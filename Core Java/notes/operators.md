# Operators
* There are different types of operators
  * arithmetic
  * relational
  * logical
  * ternary

# Arithmetic

```
+	 ADDITION
-	 SUBTRACTION
*	 MULTIPLICATION
/	 DIVISION
%	 MODULUS
++	INCREMENT
--	DECREMENT
+=	ADDITIONASSIGNMENT
-=	SUBTRACTION ASSIGNMENT
%=	MODULUSASSIGNMENT
```


### Modulus %
* divides operand one by operand two and returns the *remainder*

```
double x = 1 % 2;  //x is 1
double y = 3 % 2;  //y is 1
double z = 10 % 4; //z is 2
```

### ++
* incrememnt by 1

```
int x = 1;
x++; //x is now 2
```

### +=

```
int x = 5;
x += 2; //x is 7

// we could also do
x = x + 2;
```

# Relational
* either returns `true` or `false`

```
==	EQUALTO
!=	NOT EQUAL TO
>	 GREATER THAN
<	 LESS THAN
>=	GREATER THAN OR EQUALTO
<=	LESS THAN OR EQUAL TO
```
* examples

```
1 == 1 //true
1 == 2 //false

1 != 1 //false
1 != 2 //true
```

# Logical

```
&	 LOGICAL AND
|	 LOGICAL OR
&&	SHORT-CIRCUIT AND
||	SHORT-CIRCUIT OR
!	 LOGICAL UNARY NOT
```

### and
* if both are true, then return true

```
true  && true  //true
false && true  //false
true  && false //false
false && false //false
```

### or
* if either is true, then return true

```
true  || true  //true
false || true  //true
true  || false //true
false || false //false
```

### not

```
!true  //false
!false //true
```

### short-circuit
* Preferred
* If we know what to return after looking at the first operand, then return
* This is *faster* because we do not have to evaluate the second operand
  * However, this can cause bugs if you are not careful

```
//assume someMethod returns a boolean

true  && someMethod() //evaluates
false && someMethod() //does not evaluate

true  || someMethod() //does not evaluate
false || someMethod() //evaluates
```
  
