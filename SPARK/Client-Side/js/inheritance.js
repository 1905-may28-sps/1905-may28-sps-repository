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
console.log(a.wat);
