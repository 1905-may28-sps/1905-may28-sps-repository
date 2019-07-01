 /*
 var name =prompt("hello whats your name?");
 var age = prompt("How old are you")
 var days = age *365.25;
 alert("your name is " + name + " and you are "+ age + " years old. And " + days+ " days old.");

 //for loop again
 var str = "hello";
 for (var i= 0; i<str.length; i++){
     console.log(str[i]);
 }

 for (let i = -10; i < 19; i++) {
     console.log(i);
     
 }
 for (let i = 10; i < 40; i+2) {
     console.log(i);
     
 }
 */
 
 /**
  *         JS
  * closure
  * callback function
  * immediately invoked function expression
  * prototypal inheritance
  * arrow notation
  * this keyword
  * hoisting
  * scopes
  * Software development lifecycle
  * agile
  * scrum
  * truthy falsy
  * invocation forms
  * Http
  * ajax
  *         HTML
  * doc type
  * tags
  * h1-h5
  * src
  * paths (relative path)
  *         CSS
  * 3 ways to add
  * selectors
  * box model
  */

  //_________________SCOPES____________________

  //function scope
 function doMath() {
     var x = 40;
     console.log(x);
 }


  //global scope
  var y = 99;

  function doMoreMath() {
      y = 100;
      console.log(y);
      //this will print 100 
  }  //can use the global variable

// if we call y again it will be 100
//_____________Functions ___________________________
// inherit from objects and may be passed as variables or stored just like any other value
function func() {
    console.log("inside the regular function");
}
func();

//----function expression
//--- has a name which can be used to create anonymous  functions and expressions can be used to create IIFE's which run 
//--- which run as soon as they are defined

var functionExpression = function () {
    console.log("inside of regular function expression");
}
functionExpression();
//-----IIFE - Immediately invoked function expressions
//execute as soon as they are defined--- are a design pattern, also knows as self-executing anonymous functions
(function () {
    console.log("this is an immediately invoked function expression");
})();

var person = (function(){
    var name = "Genesis";
    return name;
})();
person;  //console this

//_______Closures______
//because JS doesn't have access mods/support encapsulation natively, 
//we use closures (nested functions) to emulate encapsulation.

var counter = (function () {
    var privateCounter =0;
    function changeBy(val) {
        privateCounter += val;

    }
    return{
        increment:function () {
            changeBy(1);
        },
        decrement:function () {
            changeBy(-1);
        },
        value: function () {
            return privateCounter;
            
        }
    }
})();

/*
different ways to call functions
call()  - invoked immediately.
        - takes any number of arguments: this, args for function
apply() - invoked immediately.
        - takes 2 args: this, and array of args for functions
bind()  - not invoked immediately.
        - returns a function with the context of this bound
        - more advance (don't worry about this)
*/
function addThisProperties(c,d) {
    console.log(this.a + this.b + c+ d);
}
addThisProperties();
var thisObj = {a:10, b:20};

addThisProperties.call(thisObj,30,40);

//takes in 2 args
addThisProperties.apply(thisObj, [30,40]);
/*
JavaScript supports prototypal inheritance, 
meaning that objects inherit directly from other objects 
the parent object is called the prototype 
every object has a property called __proto__ that points to its prototype
ie. all strings inherit from String.prototype
helpful links: https://medium.com/javascript-scene/master-the-javascript-interview-what-s-the-difference-between-class-prototypal-inheritance-e4cd0a7562e9
https://blog.bitsrc.io/understanding-javascripts-prototypal-inheritance-354292253bcb
*/


var str = "dog";
var pto = str.__proto__; // String object

let obj1 = { a: 5, b: 10, c:'hello'};
let obj2 = { a: 2, d: 'sure'};
obj2.__proto__ = obj1;
console.log(obj2.a);
console.log(obj2.d);
console.log(obj2);
console.log(obj2.c);
let obj3 = {}; // empty object
obj3.__proto__.wat = 'wat'; // wat is assigned to the object object
console.log(obj2.wat);
let a = 5;
a.test = 'test'; // this doesn't seem to work
console.log(a);
console.log(a.test);
console.log(a.wat)

/*
ECMAScript is a scripting language specification
It was created to standardize JavaScript, as well as
to foster multiple independent implementations 
ECMAScript 6 (ES6) is the current release of the standard 
with lots of new features such as constants (const), the
use of block scope (let), arrow notation, template literals, 
enhanced regular expressions, modules, and more. 
Check out this site for hands on review:
http://es6-features.org/#Constants
implement one example of each of the following:
- let
- const
- promise
- for of operator 
- template literal
- this 
*/


/*
Arrow functions in JS
- Arrow functions are a syntactically compact alternative to regular 
function expressions. 
- The main difference with arrow functions is that the this, arguments, 
super, and new.target keywords are not bound to the function as they
would be with a stand alone function 
- first, what does it mean to bind this
https://gist.github.com/zcaceres/2a4ac91f9f42ec0ef9cd0d18e4e71262
- here for more info:
https://codeburst.io/javascript-arrow-functions-for-beginners-926947fc0cdc
syntax
(parameters) => {code to execute}
*/

let arr = [1, 2, 3];
let arrowArr = arr.map(i => i + 10); // 11, 12, 13
console.log(arrowArr);

//without arrow notation:
let es5 = arr.map(function(i) {
    return i + 10;
});
 

//_____Data tables test_________

$(document).ready(function() {
    $('#example').DataTable();
} );