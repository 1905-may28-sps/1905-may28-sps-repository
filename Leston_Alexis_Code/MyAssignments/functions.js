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
- functions (NOT IN JS, BUT IN GENERAL) can be overriden and overloaded.
to override a function means to make a function with the same name, params, and 
return type, BUT different functionality as another
to overload a function means to make a function with the same name but different
parameters and/or return type as another
*/

function printSomething(){
    console.log("This is a JavaScript function printSomething()");
    console.log(returnSomething());
}

function returnSomething(){
    return 'return something();';
}

var func = function(){
    console.log("beginning func()");
    printSomething();
    console.log("end func()");
};

//func(); 

function sum(a, b){
    console.log('this is sum with 2 vars');
    return a + b;
}

function sum(a, b){
    return a-b;
}
//once we define a second sum() function, the first one is ignored
function sum(a, b, c){
    console.log('this is sum with 3 vars');
    return a + b + c;
}

sum(1, 2); //this invokes the second sum function even though the parameters dont match

function arrLoop(arr){
    for(let item of arr){
        console.log(item);
    }  
}

function regularFor(arr){
    for(let i = 0; i < arr.length; i++){
        console.log(arr[i]);
    }
}

function sumArray(arr){
    //return sum of every number in the array
    let sum = 0;
    for(let i = 0; i < arr.length; i++){
        sum+=arr[i];
    }
    return sum;
}

function sumArray(arr){
    //same thing w for each loop
    let sum = 0;
    for(let num of arr){
        sum+=num;
    }
    return sum;
} 

var person = {
    name: 'Genesis', 
    favoriteFood: 'empanadas',
    talk: function(){
        console.log('I have to talk a lot at work');
    }
};





function sumArray(arr){
    //return the sum of every item in the array
    let sum =0;
    for(var i=0; i<arr.length;i++){
 sum+= arr[i]}
    return sum;
}

function sumArray2(arr){
    //same thing with for each loop
    let sum =0;
    for(let num of arr){
 sum+=num;}
    return sum;
}