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
- functoins (NOT in JS, but in ) 
*/

function printSomething(){
    console.log("This is a JavaScript function  printSomthing()");
    console.log(returnSomething);
}

function returnSomething(){
    //return 'This is a JavaScript function that is returning a string value';
    return 'return something()';
}

var func = function(){
    console.log("beginning func()");
    printSomething;
    console.log("end func()");
    //console.log("this is another function");
    //console.log("im doing something else");
};

//func();

function sum(a,b) {
    console.log('this is the sum w/ 2 vars');
return  a +b;
    
}
function sum(a,b,c) {
console.log('this is the sum w/ 3 vars');
return a +b+c;    
}

sum(1,2);

function arrLoop(arr) {
    for (let item of arr){
        console.log(item);
    }
    
}
function regularFor(arr) {
    for (let i = 0; i < arr.length; i++) {
    console.log(arr[i]);        
    }
    
}

function sumArray(arr) {
    //returns sum of every number in the array
    let sum =0;
    for (let i = 0; i < arr.length; i++) {
            sum+=[i];    
    }
    return sum; 
}

function sumArray(arr) {
    let sum =0;
    for (let num of arr) {
    sum+=num;        
    }
    return sum;
}

var person = {
name: 'Genesis',
favfood: 'empanadas',
talk: function(){
    console.log('I have to talk a lot at work');
}
};

