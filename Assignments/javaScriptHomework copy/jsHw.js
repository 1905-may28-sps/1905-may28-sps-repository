window.onload = function () {
    document.getElementById('fibArraySubmit').addEventListener('click', findFibonacci);
    document.getElementById('sortArraySubmit').addEventListener('click', bubbleSort);
    document.getElementById('reverseStrSubmit').addEventListener('click', reverseString);
    document.getElementById('factorialSubmit').addEventListener('click', factorialize);
    document.getElementById('subStrSubmit').addEventListener('click', subString);
    document.getElementById('evenNumberSubmit').addEventListener('click', evenNumCheck);
    document.getElementById('palindromeSubmit').addEventListener('click', isPalindrome);
    doDate();
    document.getElementById('spliceSubmit').addEventListener('click', spliceElement);
    document.getElementById('personSubmit').addEventListener('click', newPerson);
    document.getElementById('person1Submit').addEventListener('click', newPers);

}

/* 1. Fibonacci 
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function findFibonacci() {
    var fib = [0, 1,];
    var num = document.getElementById('fibNums').value;
    for (let i = 2; i < num + 1; i++) {
        fib.push(fib[i - 2] + fib[i - 1]);
    }
    document.getElementById('fibOutput').innerHTML = fib[num];
}

/*2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/

function bubbleSort() {
    var num = document.getElementById('sortNums').value;
    var inputArr = num.split(/[ ,]+/);
    let len = inputArr.length;
    for (let i = 0; i < len; i++) {
        for (let j = 0; j < len; j++) {
            if (inputArr[j] > inputArr[j + 1]) {
                let tmp = inputArr[j];
                inputArr[j] = inputArr[j + 1];
                inputArr[j + 1] = tmp;
            }
        }
    }
    document.getElementById('sortOutput').innerHTML = inputArr;
}




/* 3. Reverse String
Define function: reverseStr(someStr)
 Reverse and return the String.
*/

// function reverseString() {
//     var string = document.getElementById('inputStr').value;
//     console.log(string);
//     str = string.replace(" "," -")
//     var revStr = str.split("").reverse().join("");
//     newStr = revStr.replace("-", " "); 
//     console.log(revStr);
//     console.log(newStr)
//     document.getElementById('reverseStrOutput').innerHTML = newStr;
// }

function reverseString() {
    var str = document.getElementById('inputStr').value;
    var revStr = str.split("").reverse().join("");
    document.getElementById('reverseStrOutput').innerHTML = revStr;
}

function reverseString() {
    var str = document.getElementById('inputStr').value;
    var newString = "";
    for (var i = str.length - 1; i >= 0; i--) {
        newString += str[i];
    }
    document.getElementById('reverseStrOutput').innerHTML = newString;
}

/*4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/


function factorialize() {
    var num = document.getElementById('factorialInput').value;
    if (num <= 1) {
        num = 0;
    } else if (num > 2) {
        for (var i = num - 1; i >= 1; i--) {
            num *= i;
        }
    }
    document.getElementById('factorialOutput').innerHTML = num;
}

/*5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/

function subString() {
    var str = document.getElementById('inputString').value;
    var start = document.getElementById('start').value;
    var end = document.getElementById('end').value;
    var outStr = []

    var newStr = str.split(' ');
    var iStart = newStr.indexOf(start);
    var iEnd = newStr.indexOf(end);
    console.log(newStr);
    console.log(newStr.indexOf(start));
    console.log(newStr.indexOf(end));
    if (iStart == -1) {
        window.alert(start + 'does not exist in this string!')
    }
    if (iEnd == -1) {
        window.alert(end + 'does not exist in this string!')
    }
    for (var i = iStart; i < iEnd + 1; i++) {
        outStr.push(newStr[i]);
        console.log(outStr);
        console.log(outStr.join(' '));
        document.getElementById('subStrOutput').innerHTML = outStr.join(' ');
    }

}


/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/

function evenNumCheck() {
    var num = document.getElementById('numberInput').value
    var value = (num & 1);
    console.log(value);
    if (value == 0) {
        document.getElementById('evenNumberOutput').innerHTML = num + " is an even number";

    } else {
        document.getElementById('evenNumberOutput').innerHTML = num + " is  an odd number";
    }
}

/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/

function isPalindrome() {
    var palNumString = document.getElementById('palInput').value;
    console.log(palNumString);

    var lowerPal = palNumString.toLowerCase();
    var replaced = lowerPal.replace(' ', '')
    var palArr = replaced.split('');
    var reversedPalArr = palArr.reverse();
    var char1 = reversedPalArr.join('');
    if (char1 == replaced) {
        console.log('true');
        document.getElementById('palindromeOutput').innerHTML = 'true';
    } else {
        console.log('false')
        document.getElementById('palindromeOutput').innerHTML = 'false';

    }
}

/*
8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
Example for printShape("Square", 3, "%");
%%%
%%%
%%%
Example for printShape("Triangle", 3, "$");
$
$$
$$$
Example for printShape("Diamond", 5, "*");
  *
 ***
*****
 ***
  *
*/






/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/

/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/







/**
 11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
 */

 function spliceElement (){
     var someArray = document.getElementById('spliceInput').value;
     var num = document.getElementById('spliceElementNum').value;
     document.getElementById('originalArr').innerHTML = someArray;
     
     var spliceArr = someArray.split('');
     console.log(spliceArr);
     var newArray1= spliceArr.splice(num,1);
     console.log(spliceArr.join(''));
     document.getElementById('spliceOutput').innerHTML = spliceArr.join('');
    
 }




/**
12. Defining an object using a constructor
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
var john = getPerson("John", 30);
*/

function newPers() {

var Person1 = {
    firstName : document.getElementById('person1First').value,
    lastName : document.getElementById('person1Last').value,
    age : document.getElementById('person1Age').value
}

document.getElementById('person1Output').innerHTML = 'Hi ' + Person1.firstName + ' ' +
Person1.lastName + ' you are ' + Person1.age + ' years old.';

}




/**
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
var john = getPerson("John", 30);
*/

function Person(firstname, lastname, age){
    this.firstName = firstname;
    this.lastName = lastname;
    this.age = age;
}

function newPerson(){
    var personFirst = document.getElementById('personFirst').value;
    var personLast = document.getElementById('personLast').value;
    var personAge = document.getElementById('personAge').value;

    var john = new Person(personFirst, personLast, personAge);

    document.getElementById('personOutput').innerHTML = 'Welcome ' + john.firstName + ' ' +
    john.lastName + ' you are ' + john.age + ' years old.';
}




/*14. Display the current time on the top right of your HTML page, 
updating every second
*/

function doDate() {
    var str = "";

    var days = new Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
    var months = new Array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

    var now = new Date();

    str += "14. Today is: " + days[now.getDay()] + ", " + now.getDate() + " " + months[now.getMonth()] + " " + now.getFullYear() + " " + now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();
    document.getElementById("timeInput").innerHTML = str;
}

setInterval(doDate, 1000);




/*
15.  Descending order
Your task is to make a function that can take any non-negative 
integer as a argument and return it with its digits in descending 
order. Essentially, rearrange the digits to create the highest possible number.
*/

function descOrder() {
    var a = document.getElementById('descInput').value;
    var inputArr = a.split('');
    let len = inputArr.length;
    for (let i = 0; i < len; i++) {
        for (let j = 0; j < len; j++) {
            if (inputArr[j] > inputArr[j + 1]) {
                let tmp = inputArr[j];
                inputArr[j] = inputArr[j + 1];
                inputArr[j + 1] = tmp;
                newNum = inputArr.join('').reverse;
            }
        }
    }
    var newNum = inputArr.reverse().join('');
    console.log(newNum);
    document.getElementById('descOrderOutput').innerHTML = newNum;
}

