/*
ABOUT JS FUNCTIONS
- functions inherit from objects and may be passed as variables 
or stored just like any other value 
- no function overloading in JS -- last function is used 
missing parameters are set to undefined 
extra parameters are ignored
- this keyword. "this" represents what the function is bound to 
at invocation time 

*/

function func(){
    console.log("inside of regular function");
}
func();

/*
A function expression is very similar to and has almost the same 
syntax as a function declaration, however the main difference is 
that a function declaration has a name, which can be ommitted in 
function expressions to create anonumous functions and function 
expressions cen be used to create IIFE's which run as soon as they
are defined
*/
var functionExpression = function(){
    console.log("inside of regular function expression");
}
functionExpression();

//IIFE - Immmediately invoked function expressions 
//execute as soon as they are defined 
//IIFE's are a design pattern, also known as self-executing anonymous functions
(function(){
    console.log("this is an immediately invoked function expression");
})(); //parenthesis at the end invoke function 

var person = (function(){
    var name = "Genesis";
    return name;
})();

person;
//immediately returned "Genesis"



/*
CLOSURES
Because JS does not have access mods/support encapsulation natively, 
we use closures (nested functions) to emulate encalpsulation
*/

var counter = (function(){
    var privateCounter = 0;
    function changeBy(val){
        privateCounter += val; //pc = pc + val;
    }
    return {
        increment: function(){
            changeBy(1);
        },
        decrement: function(){
            changeBy(-1);
        },
        value: function(){
            return privateCounter;
        }
    }
})();

counter.privateCounter; //will return undefined. do NOT have access to counter vars globally
counter.value(); //return 0
counter.increment();
counter.increment();
counter.increment();
counter.value(); //return 3

///////////////////////////////////////////////////////////////


var makeCounter = function(){
    var privateCounter = 0;
    
        function changeBy(val){
            privateCounter += val; //pc = pc + val;
        }
    
        return {
            increment: function(){
                changeBy(1);
            },
            decrement: function(){
                changeBy(-1);
            },
            value: function(){
                return privateCounter;
            }
        }
};

makeCounter.increment(); //will not work 
var counter1 = makeCounter();
counter1.increment();
var counter2 = makeCounter();
counter2.decrement();

/*
different ways to call functions
call() - invoked immediately. 
       - takes any number of arguments: this, args for function
apply() - invoked immediately
        - takes 2 args: this, and array of args for functions
bind() - not invoked immediately 
       - returns a function with the context of this bound
       - useful when you dont know arguments up front
       - more advance dont worry too much about this
       
more info:
https://codeburst.io/javascript-the-keyword-this-for-beginners-fb5238d99f85
http://adripofjavascript.com/blog/drips/invoking-javascript-functions-with-call-and-apply.html


*/

function addThisProperties(c, d){
    console.log(this.a + this.b + c + d);
}

addThisProperties(1, 2); //prints NaN

var thisObj = { a: 10, b: 20};

addThisProperties.call(thisObj, 30, 40 );

addThisProperties.apply(thisObj, [30, 40]);