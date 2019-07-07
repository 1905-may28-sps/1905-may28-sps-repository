/*

JavaScript is a scripting language used for 

client side operations



Do note, however, that there are many frameworks 

that allow the server-side use of JS. It's known 

as a client-side language because it can be 

interpreted from the browser



- loosely typed  - we do not declare variable types, 

  they are dynamically allocated based on the assignment

  of the varable. We declare variables with one of 

  the three keywords

  - let - allows for block scope

  - var - does not distinguish between block and function scope

  - const - does not allow vars to be reassigned

- var scopes 

  - global - accessible throughout the entirety of the script

  and through the console in the browser. Globally scoped

  variables are declared outside of any function or block

  OR they have just never been declared and their declaration

  is "hoisted" to the top of the page, making them global

  - function 

  - block - only with the use of let or const 

- datatypes include number, string, boolean, objects, 

  undefined, NaN (debatable bc typeOf(NaN) = number)

- if..else, returns, switch, try..catch, do..while, 

for, breaks, continue, while 

- TRUTHY AND FALSY

    - because JS is loosely typed, we have to be able to 

    assign everything a true or false identity so that they 

    can be evaluated as conditions in control statements 

    - FALSY - false, null, 0, undefined, NaN, ""

    - TRUTHY - everything else 

- Type coersion - the process that JS takes to bring data

from one type to another to compare the actual value as opposed 

to the datatype 

*/

/*

CONTROL STATEMENTS

- statements/blocks of code that control the flow of execution 

of your program

*/



//IF

if(5>10){

    console.log('success');

}



//IF-ELSE STATEMENT

var condition = 'false';

if(condition){ //if(condition){do something}

    console.log('CONDITION IS TRUE');

}else{ //if condition is false, do this

    console.log('CONDITION IS FALSE');

}



//IF-ELSE IF

var num = 10;

var outcome;

if(num < 0){

    outcome = 'negative';

}

else if (num > 10 && num < 100){

    outcome = 'other';

}



//TERNARY OPERATORS --> returned val = [expression] ? ifTrue : ifFalse

var value = (10>0) ? 'yes' : 'no';

console.log(value);



//same thing as below, just much simpler

if(10>0){

    value = 'yes';

}

else{

    value='no';

}



/* SWITCH

evaluates an expression, matching the expression's value 

to a case clause, and executes the statements associated

with that case, as well as statements matching the following 

case(s) unless it ends with a break; statement

*/

console.log("SWITCH STATEMENTS");

var bestCity = 'Rome';



switch(bestCity){

    case 'Detroit':

        console.log('this is a switch statement without a break'); 

    case 'Montreal':

        console.log('HI');

        break;

    case 'New York City':

        console.log('the city that never sleeps');

        break;

    case 'Houston':

        console.log('another city');

        break;

    default: //acts as the else statement

        console.log('favorite city not entered');

}



/*

LOOPS

structures that allow us to iterate over functionality 

0 or more times based on a condition

*/



//WHILE something is the case, do something

console.log("WHILE LOOP CODE:");

var limit = 10;



while(limit >= 0){

    console.log(limit);

    limit = limit - 2;

}



//DO-WHILE do something at least once, continue while condition is met

console.log("DO WHILE");

limit = 10;

do{

    console.log(limit);

    limit = limit - 2;

} while(limit>=0);



/*

FOR LOOPS

*/

n = 25;

console.log("FOR LOOP");

//for(counter declaration; counter limit; counter increment/decrement)

for(let i = 1; i <= 25; i++){ 

    if(i % 15 == 0) console.log('fizzBuzz');

    else if( i % 3 == 0) console.log('fizz');

    else if(i % 5 == 0) console.log('buzz');

    else console.log(i);

}



console.log("FOR EACH LOOP");

var arr = ["Genesis", "Housley", "Dionne", "Skye", "Viji", "Cristian"];

var count = 0;

for(let x of arr){ //FOR EACH LOOP. for every element in arr

    // console.log(x + ' is AWESOME! Their name has ' 

    //     + x.length + ' characters');

    console.log(`${++count}) ${x} is awesome! Their name has ${x.length} characters`);

}



//FOR IN - iterate over properties of an object

console.log("FOR IN LOOP");

var obj = {

    name : 'Genesis Bonds',

    job : 'Lead Trainer', 

    bio : 'I really like food'

};



for(var prop in obj){

    console.log(obj[prop]);

}