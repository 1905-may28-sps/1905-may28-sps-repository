/*
JAVASCRIPT FUNCTIONS
- functions inherit from objects and may be passed as variables 
or stored just like any other value 
- no function overloading in JS -- last function is used 
missing parameters are set to undefined and extra parameters are ignored
(what is overloading? what are parameters? )
- functions can have parameters (variables IN to the function) and return
values (at most one variable OUT of the function). With return values, we 
can set variables equal to the output of a function as such 
var x = returnSomething();
if we were to set a variable equal to a function with no return statement 
such as var y = pringSomething();, then y would be undefined, whereas the x
value above is = to the string that is returned from returnSomething
*/

function printSomething(){
    console.log("This is a JavaScript function");
}

function returnSomething(){
    return 'This is a JavaScript function that is returning a string value';
}

var func = function(){
    console.log("this is another function");
    console.log("im doing something else");
};