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


