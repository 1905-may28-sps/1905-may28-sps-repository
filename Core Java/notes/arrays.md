# Arrays
* a collection of elements of the same type
* must specify **type** and **size**
  * arrays are allocated a block of memory on the heap
  * arrays have a fixed size

```
int[] myArray = new int[5];
```
Remember when you initialize an array, all elements are set to the **default** value for that data type

### default values

| primitive |           default value           |
|:---------:|:---------------------------------:|
|    byte   |                 0                 |
|   short   |                 0                 |
|    int    |                 0                 |
|    long   |                 0L                |
|   float   |                0.0f               |
|   double  |                0.0d               |
|  boolean  |               false               |
|    char   | ‘\u0000’ //unicode null character |

* default value for all objects is `null`

# Manipulating arrays

arrays have a `length` member

```
myArray.length //returns 5
```

set value in an array
* remember arrays are indexed at 0

```
myArray[0] = 77; //first element is 77
```

retrieve value from array

```
myArray[0] //returns 77
```

loop over array and print its elements

```
for(int i = 0; i < myArray.length; i++) {
  System.out.println(myArray[i]);
}
```
