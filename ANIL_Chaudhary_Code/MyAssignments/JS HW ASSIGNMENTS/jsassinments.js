window.onload = function(){
  //this window.onload ensures that the script waits until page is ready to execute
  document.getElementById('findNth').addEventListener('click', fibonacci);
  document.getElementById('sortArray').addEventListener('click', bubbleSort);
  document.getElementById('findReverse').addEventListener('click', reverseString);
  document.getElementById('findFact').addEventListener('click', factorialize);
  document.getElementById('findSubstr').addEventListener('click', subString);
  document.getElementById('findEven').addEventListener('click', isEven);
  document.getElementById('findPalindrome').addEventListener('click', isPalindrome);
  document.getElementById('findResult').addEventListener('click', deleteElement);
  document.getElementById('findResult1').addEventListener('click', spliceElement);
  document.getElementById('findPerson').addEventListener('click', findPerson);
  document.getElementById('findTime').addEventListener('click', doTime);
 
}



function fibonacci() {
  var num = Number(document.getElementById ('enterSeq').value);

    var a = 0, b = 1, temp;
  
    while (num >= 0){
      temp = a;
      a = a + b;
      b = temp;
      num--;
    }
  
    
    document.getElementById('result1').innerHTML = 
    `The Fibonacci number of the input squence is 
    <b>${b}</b>`;
  }



function bubbleSort() {
  var arr = getArray();
    let swapped;
    do {
      swapped = false;
      for (let i = 0; i < arr.length; i++) {
        if (arr[i] > arr[i + 1]) {
          let tmp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = tmp;
          swapped = true;
        }
      }
    } while (swapped);

    document.getElementById('sortedArray').innerHTML =
    `The sorted array is <b>${arr}</b>`;
    }




function reverseString (){
  var str = document.getElementById('string').value;

  let reversed = "";    
  
for (var i = str.length - 1; i >= 0; i--){        
    reversed += str[i];
  }    
  document.getElementById('reversedString').innerHTML =
    `The reversed string is <b>${reversed}</b>`;
}


function factorialize() {
  var num = Number(document.getElementById ('enterNum').value);
  if (num === 0 || num === 1)
    return 1;
  for (var i = num - 1; i >= 1; i--) {
    num *= i;
  }
  document.getElementById('factorial').innerHTML = 
  `The Factorial of input number is <b>${num}</b>`;
}

function subString(){
  var string1 = document.getElementById('string1').value;
  var n1 = document.getElementById('n1').value;
  var n2 = document.getElementById('n2').value;
    var result = string1.substring (--n1, ++n2);
    document.getElementById("checkSubstring").innerHTML = `The substring is <b>${result}</b>`;
}




function isEven() {
  var n = Number(document.getElementById ('entEven').value);
      if (n == 0)
      document.getElementById('checkEven').innerHTML = 
      `The input number is <b> EVEN</b>`;
       else if (n == 1)
       document.getElementById('checkEven').innerHTML = 
       `The input number is <b>  NOT EVEN</b>`;
    else if ((n < 0) || ( n % 2 != 0)) 
    document.getElementById('checkEven').innerHTML = 
       `The input number is <b>  NOT EVEN</b>`;

    else
    document.getElementById('checkEven').innerHTML = 
    `The input number is <b> EVEN</b>`;
  }


  function isPalindrome() {
    var text = document.getElementById('palin').value;
    text = text.toLowerCase();
    var isValid = true;
    for(let i = 0; i < text.length/2; i++){
        if(text.charAt(i)!=text.charAt(text.length-1-i)) {
            isValid = false;
        }
    }

    document.getElementById('checkPalindrome').innerHTML = `The input string is  <b>${isValid}</b>`;
}



function deleteElement(){
  var arr1 = getArray1();
  document.getElementById('seeResult').innerHTML = `The array length before deleteElement  is <b>${arr1.length}</b>`;
delete arr1[3];
document.getElementById('seeResult1').innerHTML = `The array length after deleteElement is <b>${arr1.length}</b>`;
}


function spliceElement(){
  var arr2 = getArray2();
  document.getElementById('seeResult2').innerHTML = `The array length before spliceElement (3,1) is <b>${arr2.length}</b>`;
  arr2.splice(3, 1);
document.getElementById('seeResult3').innerHTML = `The array length after spliceElement (3,1) is <b>${arr2.length}</b>`;
}


// Constructor function for Person objects

function findPerson(){
function Person(name, age) 
{
  this.name = name;
  this.age = age;
}
  var john = new Person("John", 30);
  document.getElementById('seePerson').innerHTML = `<b>${  "Name :"  + (john.name)+ "; Age :" + (john.age)}</b>`;
}



 function doTime(){
 var dt = new Date();
document.getElementById("currtime").innerHTML = dt.toLocaleTimeString();
setInterval(doTime, 1000);
 }









function getArray(){
  var numString = document.getElementById('arrNums').value;
  console.log(numString);
  var stringArr = numString.split(' ');
  var arr = [];
  for(let num of stringArr){
  arr.push(Number(num));
  }
  return arr;
}

function getArray1(){
var numString = document.getElementById('char').value;
console.log(numString);
var stringArr = numString.split(' ');
var arr = [];
for(let num of stringArr){
arr.push(Number(num));
}
return arr;
}

function getArray2(){
var numString = document.getElementById('char2').value;
console.log(numString);
var stringArr = numString.split(' ');
var arr = [];
for(let num of stringArr){
arr.push(Number(num));
}
return arr;
}


