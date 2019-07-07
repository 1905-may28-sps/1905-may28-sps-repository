
// This is javascript right in our HTML Page...
// Button Event Listener
window.onload = function(){
    // this window.onload ensures that the script waits until page is ready to execute
    document.getElementById('sumArraySubmit').addEventListener('click', findSum);

    document.getElementById('averageArraySubmit').addEventListener('click', findAve);

    document.getElementById('palindromeSubmit').addEventListener('click', palindromes);

    document.getElementById("anagramSubmit").addEventListener('click', anagram);

    document.getElementById('fibonacciSubmit').addEventListener('click', fibonacci);

    document.getElementById('sortArray').addEventListener('click', sortArr);

    document.getElementById('doFizz').addEventListener('click', fizzbuzz);

    

}


function fizzbuzz(){
    var n = document.getElementById("fizzIn").value;
    for(let i = 1; i <= n; i ++){
        var li = document.createElement("li");
        if (i % 15 == 0) li.innerHTML = "fizzbuzz"
        else if ( i % 3 ==0) li.innerHTML = "fizz"
        else if (i % 5 == 0) li.innerHTML="buzz"
        else li.innerHTML = i;
        document.getElementById("fizzOut").appendChild(li);
    }
}

function findSum(){
    console.log("button works!");
    var numString = document.getElementById("arrNums").value;
    console.log(numString);
    /*s
    the split function is a native JS function for strings which allows us to split a string into an array based on a
    delimiter (character to serve as breakpoint).  In order to split with multiple delimeters, we must use regular expressions.
    see this site for more info:
    http://classyfunction.com/javascript-split-with-multiple-delimiters/
    */
//    set variable for splitting string and creating an array
    var arr = numString.split(' ');
    console.log(arr);
//   for of loop to sum up items in array.
    var sum = 0;
    for(let num of arr){
//   convert strings to a number and sums items
        sum+= Number(num);
    }
    console.log(sum);
// creates 
    document.getElementById("arrOutput").innerHTML = sum; 
}


function findAve(){
    console.log("button works!")
    var arrNums = document.getElementById("arrNums").value;
    console.log(arrNums); 

    var arr = arrNums.split(' ');
    console.log(arr);
    var sum = 0;
    for(let num of arr){
        sum += Number(num);
    }
    console.log(sum);
    
    var average = sum / arr.length;
    console.log(average);

    document.getElementById("arrOutput").innerHTML = sum; 
}

function palindromes(){
    console.log("button works");
    var palindromeString = document.getElementById("palindromes").value;
    console.log(palindromeString);

    let char1=[];
    let char2=[];
    var isPalindrome=false;
    var falseCounter=0;
    char1= stringtoCharArr(palindromeString);
    char2= reverseStringtoCharArr(palindromeString);
    if (char1.length == char2.length) {
        for (let i = 0; i < char1.length; i++) {
                if(char1[i]==char2[i]){
                    isPalindrome=true;
                }   
                else {                    
                    isPalindrome=false;
                    falseCounter++;
                }                        
        }
    }
    if(falseCounter>0){
        isPalindrome=false;
    }
        
    console.log(isPalindrome);
    document.getElementById("palindromeOutput").innerHTML = isPalindrome;  
    return isPalindrome;


}

function stringtoCharArr(str) {
    let char1 = [];
    for (let i = 0; i < str.length; i++) {
        //check if string has punctuations
        if (str[i] != '\' ' && str[i] != " " && str[i] != ',' && str[i] != '.') {
            char1.push(str[i].toLowerCase());
        }
    }
    console.log(char1.toString());//to test if string get rid of punctuations
    return char1;
}
function reverseStringtoCharArr(str) {
    let char2 = [];

    for (let i = str.length - 1; i >= 0; i--) {
        if (str[i] != '\' ' && str[i] != " " && str[i] != ',' && str[i] != '.') {
            char2.push(str[i].toLowerCase());
        }
    } 
    console.log(char2.toString());// print the reverse of string.
    return char2;
}

// Anagram Function
function anagram(){
    console.log("button works");

    var isAnagram = false;
    var falseCounter=0;
    var stringOne = document.getElementById("anagramOne").value;
    var stringOne = stringOne.toLowerCase();
    console.log("AnagramStringOne is "+ stringOne);
    var arrOne = stringOne.split('');
    console.log(arrOne);
    var arrSortedOne = arrOne.sort();
    console.log(arrSortedOne);

    // Input 2
    var stringTwo = document.getElementById("anagramTwo").value;
    var stringTwo = stringTwo.toLowerCase();
    console.log("AnagramStringTwo is "+ stringTwo);
    var arrTwo = stringTwo.split('');
    console.log(arrTwo);
    var arrSortedTwo = arrTwo.sort();
    console.log(arrSortedTwo);


    for(var i = 0; i <= arrSortedOne.length; i++){
        if(arrSortedOne[i] == arrSortedTwo[i]){
            isAnagram = true;
            // console.log(isAnagram);
        } else {
            isAnagram = false;
            falseCounter++;
            // console.log(isAnagram);
        }
        
    }
    if(falseCounter>0){
    isAnagram=false;
    }
    document.getElementById("anagramOutput").innerHTML = isAnagram;

}





function fibonacci(){
    console.log("button works");
    var num = document.getElementById("fibonacciVal").value;
    var a = 0, b = 1, f = 1;
    for(var i = 2; i <= num; i ++){
        f=a+b;
        a = b;
        b = f;
    }
    console.log(f);
    document.getElementById("fibonacciOutput").innerHTML = f;
 
   }

function sortArr(){
    console.log("button works")
    var arrNums = document.getElementById("arrSort").value;
    console.log(arrNums);

    var arr = arrNums.split(' ');
    console.log(arr);
    for (var i = 0; i < arr.length; i ++){
        arr[i] = parseInt(arr[i], 10);
    }
    var solvedArr= arr.sort(function (a, b){
        return a - b;
    });
    console.log(solvedArr);
    document.getElementById("arrSortOutput").innerHTML = solvedArr;

}

