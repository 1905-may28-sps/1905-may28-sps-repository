//This is JavaScript! right in our HTML page...
window.onload = function () {
    //this window.onload ensures that the script waits until page is 
    //ready to execute
    document.getElementById('sumArraySubmit').addEventListener('click', findSum);
    document.getElementById('palindromeSubmit').addEventListener('click', palindrome);
    document.getElementById('fibonacciSubmit').addEventListener('click', fibonacci);
    document.getElementById('anagramSubmit').addEventListener('click', anagram);
    document.getElementById('sortSubmit').addEventListener('click', sortArr);
}

function findSum() {
    var numString = document.getElementById('arrNums').value;
    console.log(numString);
    
    /* the split function is a native JS function for strings which allows us to split
    a string into an array based on a delimeter(character to serve as breakpoint)
    In order to split with multiple delimeters, we must use regular expressions. see this
    site for more info...
    */

    var arr = numString.split(' ');
    console.log(arr);
    var sum = 0;
    for (let num of arr) {
        sum += Number(num);
    }
    document.getElementById('arrOutput').innerHTML = sum;
}

/*function palindrome(){
    var numString = document.getElementById('palText').value;
    console.log(numString);
    var str1 = numString.toLowerCase()
    console.log(str1);
    var str2 = str1.replace(" ", "");
    console.log(str2);
    var str3 = str2.split("");
    console.log(str3);
    var str4 = str3.reverse();
    console.log(str4);
    var str5 = str4.join("");
    console.log(str5);
        if (str5 == str2) {
            document.getElementById('palOutput').innerHTML = "True";
        } else{
            document.getElementById('palOutput').innerHTML = "False";
        }
} */

function fibonacci(n){
    var numString = document.getElementById('fiboText').value;{
        var arr = [0,1];
        for (var i = 2; i < n + 1; i++) {
            arr.push(arr[i-2] + arr[i-1]);
        }
        document.getElementById('fiboOutput').innerHTML = arr;
    }
}

function anagram(){
var numString = document.getElementById("anaText").value;
var numString2= document.getElementById("anaText2").value;
var numStr1=numString.toLowerCase();
var numStr2=numString2.toLowerCase();
var numStr1a=numStr1.replace(" ", "");
var numStr2a=numStr2.replace(" ","");
console.log(numStr1a);
console.log(numStr2a);
}

function sortArr(){
var numString = document.getElementById("sortText").value;
var arr = numString.split(' ');
arr.sort(function(a, b){return a-b});
  document.getElementById("sortOutput").innerHTML = arr;

}
function palindrome(){
var text = document.getElementById('palText').value;
text = text.toLowerCase();
var isValid = false;
for(let i = 0; i< text.length; i++);{
    if(text.charAt(i) != text.charAt(text.length-1-i)) return false;
}
isValid = true
}