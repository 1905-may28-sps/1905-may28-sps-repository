# Object
* root of inheritance hierarchy
* useful methods
  * toString
  * equals
  * hashCode

# toString
* method that gets called when you *print* an object
* by default, prints memory address
* should override

# equals
* returns `boolean`
* test equality between objects
* for objects, `==` tests if memory addresses are the same
* by default, `equals` uses memory address
* should override

# hashCode
* returns `int`
* by default, returns memory address
* must override if you override `equals`
* used in *hash based* collections: `HashSet`, `HashMap`
* contract of an object - Joshua Bloch
  * `hashCode` should return the same int over and over, as long as I do not change anything in the equals method
  * objects that are *equal* must have the same hash code
  * objects that are not *equal* may have the same hash code

<br/>

* Usually people mess up on the 2nd bullet point
* In the Hash Table data structure, we call the 3rd bullet point a **hash collision**
