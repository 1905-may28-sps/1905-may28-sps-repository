// Used for client side operations, can be interpreted from the browser
// loosely typed- we do not declare variable types
//let-allows for block scope , var- does not distiniguish between block and function scope, const- does not allow vars to be reassigned 

// global scope - accessible throughout entire script and through console in the browser.
// or their declaration is never declared so automatically global
//function var and even if put into a function is still a function scope 
// block scope - only within the use of let or const 
// falsy = false, null, 0, undefined, NaN, ""
// truthy = everything else 

/*control statements-  statements or blocks of code that control the flow of the execution of your program*/

//if/else statements 
// var num = 10;
// if (num > 100) {
//     console.log("num is greater than 100!")
// }
// else {
//     console.log("num is Not greater than 100!")
// };

//if-elseif 
// var numm = 10;
// var outcome;
// if (numm < 0) {
//     outcome = "negative";
// }
// else if (numm > 10 && numm < 100) {
//     outcome = "other";
// }

// //ternary operators 
// var value = (10 > 0) ? "yes" : "no";
// console.log(value);

/*Switch evaluates an expression, matching expressions value to a case clause
and executes the statemetns associated with that case, as well as 
statements matching the following cases unless it ends with a break; statement*/

// var bestCity = "New York City";
// switch (bestCity) {
//     case "Detroit":
//         console.log("Not Detroit");
//         break;
//     case "Montreal":
//         console.log("Not Montreal");
//         break;
//     case "Miami":
//         console.log("Not Miami");
//         break;
//     case "New York City":
//         console.log("The city that never sleeps");
//         break;

//     default:
//         console.log("Favorite city is not entered");
// }

//A loop is a structure that allows us to iterate ove a functionality more than 
//0 or more times based on condition.

//while something is the case , do something 
// var limit = 10;
// while (limit > 0) {
//     console.log(limit);
//     limit = limit - 2;

// }
// // do-while do something at least once, continue while condition is met 

// do {
//     console.log(limit);
//     limit = limit - 2;
// } while (limit >= 0);


// // for loops go base on iterations,
// //for(counter declaration; counter limit, counter increment/decrement)
// n = 25;

window.onload = function () {
    document.getElementById("doFizzButt").addEventListener("click", findFizz);

}

function findFizz() {

    var arr = document.getElementById("fizzIn").value;

    for (let i = 0; i < arr; i++) {

        if (i % 15 == 0) {
            console.log("fizzbuzz")
        }
        else if (i % 3 == 0) {
            console.log("fizz");
        }
        else if (i % 5 == 0) {
            console.log("buzz");
        }
        else if (i % 15 == 0) {
            console.log("fizzbuzz")
        }
        console.log(arr[i]);
    }
   // console.log("For Loop")
    //print i-n, i divisible by 3 , print fizz
    //if divisible by 5 print buzz
    //if divisible by 15 print fizzbuzz,
}

// var arr = ["Genesis", "Cristian", "housley", "weaner"];
// var count = 0;

// for (let x of arr) {//for each loop for every elelemtn in arr
//     // these below are the same things just the lower one is newer way and cleaner way
//     //console.log(x + " is awesome ! their name has " + x.length + "characters");
//     console.log(`${x} is awesome! their name has ${x.length} characters`);

// }

// var obj = {
//     name: "Genesis Bonds",
//     job: "lead trainer",
//     bio: "I really like food"
// };

// for (var prop in obj) {
//     console.log(obj[prop]); // must use object notation [] = obj[p]
// }


/* JAVASCRIPT FUNCTION
functions inherit from objects and may be passed as variables or stored 
just like any other value 
no function overloading in JS las function is used missing oarameters are set 
to undefined and extra parameters are ignored (what is overloading? what are parameters?)*/
//-functions can have paramters (variables in the function) and return values 
//(at most one variable out of the function). With return values, we can set variables 
//equal to the output of a function as such var x = returnSomething().
/*if we were to set a variable equal to a function with no return statement such as var y = printSomething()
then y would be undefined whereas the x value above is = to the string 
that is returned from returnSomething()*/

/* - functions (Not in JS but in general) can be overriden and overloaded.
to override a function means to make a function with the same name, parameters 
and return type, but different funcionality as another 
to overload a function means to make the function with the same name but different parameters 
and/or return type as another.*/

// function printSomething() {
//     console.log("This is a Javascript function");
// }

// function returnSomething() {
//     return "This is a Javascript function that is returning a string value";

// }

// var func = function () {
//     console.log("beginning func()");
//     printSomething();
//     console.log("end func");
// }

// function sum(a, b) {
//     console.log("This is a sim with 2 vars");
//     return a + b;
// }
// // once you define a second sum() function, the first one is ignored 
// function sum(a, b, c) {
//     console.log("This is a sum with 3 vars");
//     return a + b + c;
// }

// sum(1, 2); //this invokes the second sum function even though the parameters dont match;

//for each loop
/*function arrLoop(arr){
    for(let item of arr){
        console.log(item);
    }
}


function regularFor(arr){
    for(let i = 0; i < arr.length; i++){
        console.log(arr[i]);
    }
}

*/
// function sumArray(arr) {
//     // return sum of every item in the array
//     var total = 0;
//     for (var i = 0; i < arr.length; i++) {
//         total = total + arr[i];
//     }
//     return total;
// };

// var person = {
//     name: "Cristian",
//     favoriteFood: "frijoles wey",
//     talk: function () {
//         console.log("I have to talk alot at work");
//     }
// };

