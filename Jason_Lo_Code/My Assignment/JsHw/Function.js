window.onload = function () {
  document.getElementById('findPalindrome').addEventListener('click', isPalindrome);
  document.getElementById('doObjectButton').addEventListener('click', doObject);
  document.getElementById('sortArraySubmit').addEventListener('click', bubbleSort);
  document.getElementById('doObjectButton').addEventListener('click', doLiteral);
  document.getElementById('fsButton').addEventListener('click', fib);
  document.getElementById('strButton').addEventListener('click', reverseString);
  document.getElementById('factButton').addEventListener('click', factorialize);
  document.getElementById('evenButton').addEventListener('click', isEven);
}


// 1. Fibonacci 
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.

function fib() {
  var n = document.getElementById('fs_Input').value;
  for (var fibArray = [0, 1], i = 0, j = 1, k = 0; k < n; i = j, j = x, k++) {
    x = i + j;
    fibArray.push(x);
  }
  document.getElementById('fs_Out').innerHTML = fibArray;
}


//Question 2
//Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function getArray() {
  var numString = document.getElementById('arrNums').value;
  console.log(numString);
  var stringArr = numString.split(' ');
  var numArray = [];
  for (let num of stringArr) {
    numArray.push(Number(num));
  }
  return numArray;
}

function bubbleSort() {
  var numArray = getArray();
  var length = numArray.length;
  for (var i = 0; i < length; i++) {
    for (var j = 0; j < (length - i - 1); j++) {
      if (numArray[j] > numArray[j + 1]) {
        var tmp = numArray[j];
        numArray[j] = numArray[j + 1];
        numArray[j + 1] = tmp;
      }
    }
  }
  document.getElementById('arrOutput').innerHTML = numArray;
}

//Question 3
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseString() {
  var str = document.getElementById('str_Input').value;
  var newString = "";
  for (var i = str.length - 1; i >= 0; i--) {
    newString += str[i];
  }

  document.getElementById('strOutput').innerHTML = newString;
}

function factorialize() {
  var someNum = document.getElementById('fact_Input').value;
  var fact = someNum;
  if (someNum === 0 || someNum === 1) 
    fact = 1; 
  while (someNum > 1) { 
    someNum--;
    fact *= someNum;
  }
  document.getElementById('factOutput').innerHTML = fact;

}

function isEven() {
  var num = document.getElementById('even_input').value;
  
  if((num & 1) == 0){
    bool = "Even"
  }else{
  bool = "Odd";
}

  document.getElementById('evenOutput').innerHTML = bool;

}


//Question 12
//   Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);
function doObject() {
  function Person(name, age) {
    this.pName = name;
    this.pAge = age;
  }
  var john = new Person(document.getElementById('Q12name').value, document.getElementById('Q12age').value);
  document.getElementById("objectOut").innerHTML = john.pName + " " + john.pAge;
}

//Question 13
//   Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
function doLiteral() {
  function getPerson(name, age) {
    return { pName: name, pAge: age };
  }
  var john = getPerson(document.getElementById('Q12name').value, document.getElementById('Q12age').value);
  document.getElementById("objectOut2").innerHTML = john.pName + " " + john.pAge;
}


//Question 7
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false
function isPalindrome() {
  var text = document.getElementById('palindromeInput').value;
  text = text.toLowerCase();
  var isValid = true;
  for (let i = 0; i < text.length / 2; i++) {
    if (text.charAt(i) != text.charAt(text.length - 1 - i)) {
      isValid = false;
    }
  }

  document.getElementById('palindromeOut').innerHTML = isValid;
}

