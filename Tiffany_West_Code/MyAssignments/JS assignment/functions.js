window.onload = function(){
  
  document.getElementById('fibArraySubmit').addEventListener('click', findFibonacci);


document.getElementById('findPalindrome')
.addEventListener('click', palindrome);

document.getElementById('sortArraySubmit').addEventListener('click', bubbleSort);
    document.getElementById('reverseStrSubmit').addEventListener('click', reverseString);
    document.getElementById('factorialSubmit').addEventListener('click', factorialize);
    document.getElementById('subStrSubmit').addEventListener('click', subString);
    document.getElementById('evenNumberSubmit').addEventListener('click', evenNumCheck);
    document.getElementById('palindromeSubmit').addEventListener('click', isPalindrome);
    doDate();
    document.getElementById('spliceSubmit').addEventListener('click', spliceElement);
   }
   
   
    var dt = new Date();
    document.getElementById("datetime").innerHTML = dt.toLocaleTimeString();
    window.setTimeout("dt()",1000);
   
    function findFibonacci() {
      var fib = [0, 1,];
      var num = document.getElementById('fibNums').value;
      for (let i = 2; i < num + 1; i++) {
          fib.push(fib[i - 2] + fib[i - 1]);
      }
      document.getElementById('fibOutput').innerHTML = fib[num];

   function palindrome(){
    var text = document.getElementById('palindromeInput').value;
    text = text.toLowerCase();
    var isValid = true;
    for(let i = 0; i < text.length/2; i++){
        if(text.charAt(i)!=text.charAt(text.length-1-i)) {
            isValid = false;
        }
    }

    document.getElementById('palindromeOut').innerHTML = isValid;
}
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

    }