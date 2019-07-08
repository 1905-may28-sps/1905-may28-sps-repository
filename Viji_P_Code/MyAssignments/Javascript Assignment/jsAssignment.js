window.onload = function (){
    document.getElementById("ct").addEventListener('click', display_ct); 
    document.getElementById("btnFib").addEventListener('click', findFibonacci);
    document.getElementById("btnFact").addEventListener('click', findFactorial);
    document.getElementById("btnEven").addEventListener('click', isEven);
    document.getElementById("removeChild").addEventListener('click', removeElement);
    document.getElementById("person").addEventListener('click', personCreation);
    document.getElementById("object").addEventListener('click', getPerson);
    document.getElementById("traverse").addEventListener('click', traverseObject);
    document.getElementById("btndel").addEventListener('click', deleteAnElementArr);
    document.getElementById("btnSplice").addEventListener('click', spliceElement);
    document.getElementById("btnRev").addEventListener('click', reverseString);
}


/* Display the current time on the top right of your HTML page, 
updating every second */

function display_ct() {
  var x = new Date()
  document.getElementById('ct').innerHTML = x;
  display_c();
   }

/*
* Fibonacci 
* Define function: fib(n) 
* Return the nth number in the fibonacci sequence.
*/

function findFibonacci(){
var num = document.getElementById('fib').value;
var n1=0;
var n2;
var temp;
 if(num>=1){
     n2=n1;
     n1=1;
     if(num>=2){
         for (let i =2; i<num; i++)
         {   
             temp=n2+n1;
             n2=n1;
             n1=temp;
          }
     }
 }
 document.getElementById('fibOutput').innerHTML = n1;
}

/*
*4. Factorial
*Define function: factorial(someNum)
*Use recursion to compute and return the factorial of someNum.
*/

function findFactorial(){
  var num = document.getElementById('fact').value;
    if (num === 0 || num === 1) {
    return 1;
  }
   for (let i = num-1; i >= 1; i--){
      num *= i;
    }  
    document.getElementById('factOutput').innerHTML = num;
  }
  
//function findFactorial(){
//   var num = document.getElementById('fact').value;
//   var result = 1;
//    if (num === 0 || num === 1) {
//     return result;
//   }
//    while(num > 1){
//       num--;
//       result *= num;
//     }  
//     document.getElementById('factOutput').innerHTML = result;
//   }


  /*
  *6. Even Number
*Define function: isEven(someNum)
*Return true if even, false if odd.
*Do not use % operator.
  */

function isEven(){
  var num = document.getElementById('even').value;
  // var a = "True";
  // var b = "False";
  //var c =  ((num/2)* 2);
  // var d = (c == num) ? a : b;
  // document.getElementById('evenOutput').innerHTML = d;
  if ((num/2)*2 == num){
    alert("Even");
  }
  else{
    alert("Odd");
  }
  }
  
function isEven(num){
  var newNum = (num/2)*2;
  if (num == newNum){
    console.log("True");
  }else{
    console.log("False")
  }
}(13);

function removeElement(){
  var el = document.querySelector('div');
  el.parentNode.removeChild(el);
}
/*12. Defining an object using a constructor
      Define a function Person(name, age)
      The following line should set a Person object to the variable john:
      var john = new Person("John", 30); */
      var name;
      var age;

function person(pname, page)
{  
  this.name = pname;
  this.age = page;  
}

function personCreation()
{
  var john = new person("John",30);
  document.getElementById('personSpanObj').innerHTML = "Person name is " + john.name + "." + " Age: "+ john.age;
}
 /*13. Defining an object using an object literal
  Define function getPerson(name, age)
  The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);
  */
 function getPerson(){
  var john = {name: "John",
              age: 30};
  document.getElementById('getPerson').innerHTML = "Person name is " + john.name + "." + " Age: "+ john.age;
}



/*9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.*/

function traverseObject(){
  var obj = {fname : 'Viji',
             lname : 'Laxman',
              age : 15,
             favFood : 'Pizza'};
  document.getElementById('traverseObj').innerHTML = "FirstName: "+ obj.fname + ", " + "Lastname: " + obj.lname +
                                                      ", " + "Age: " + obj.age +", " +"Favorite Food: " + obj.favFood;
}

/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.*/


function deleteAnElementArr(){
  var numString =  document.getElementById('delElement').value;
  var arr = numString.split(' ');
  alert(arr);
  alert("Length of an array before deletion: " + arr.length);
  delete arr[2];
  alert(arr);
  newLength = arr.length;
  alert("Length of an array after deletion: " + newLength);
  document.getElementById('deleteElement').innerHTML = newLength;
}

/*
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.*/

// arr = [45, 67, 89, 21, 34];
// console.log(arr.length);
// arr.splice(2,1);
// arr.length;
// console.log(arr);

function spliceElement(){
  var numString = document.getElementById('splElement').value;
  var arr = numString.split(' ');
  alert(arr);
  alert("Length of an array before removal: " + arr.length);
  arr.splice(2,1);
  alert(arr);
  newLength = arr.length;
  alert("Length of an array after removal: " + newLength);
  document.getElementById('spliceElement').innerHTML = newLength;
}
/*
Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/

// var string = 'king';
// var splitStr = string.split("");
// console.log(splitStr);
// var revStr = splitStr.reverse();
// console.log(revStr);
// var newStr = revStr.join("");
// console.log(newStr);

function reverseString(){
  var str = document.getElementById('revString').value;
  var splitStr = str.split("");
  alert(splitStr);
  var revStr = splitStr.reverse();
  alert(revStr);
  var newStr = revStr.join("");
  document.getElementById('reverseString').innerHTML = newStr;
}