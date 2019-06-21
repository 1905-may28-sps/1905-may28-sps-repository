//this is JavaScript! right in our HTML page...    
window.onload = function () {
    //this window.onload ensures that the script waits until page is ready to execute
    //window.onload = function() {    JavaScript code to execute on page load; }
    //Make sure everything is loaded before
    document.getElementById('sumArraySubmit')
        .addEventListener('click', findSum);
    //document.getElementById( v alue ) Locates the element whose ID name is v alue so that you can manipulate that element with JavaScript 
    //the sumArraySubmit is a button that I made in the html document.
    //Attach a click event to the sumArraySubmit <button> element. When the user clicks on the button,the findSum function executes But, must define the findSum function.
    document.getElementById('avgArraySubmit')
        .addEventListener('click', findAverage);
    document.getElementById('palArraySubmit')
        .addEventListener('click', findPalindrome);
    document.getElementById('anaArraySubmit')
        .addEventListener('click', findAnagram);
    document.getElementById('fibArraySubmit')
        .addEventListener('click', findFibonacci);
    document.getElementById('sortArraySubmit')
        .addEventListener('click', findSort);
        // document.getElementById('doFizz').addEventListener('click',fizzbuzz);
        document.getElementById('intToBin').addEventListener('click',findIntToBin);
}

function findSum() {

    var numString = document.getElementById('arrNums').value;
    //the findSum function must first locate the input box which is named arrNums and Get the value of the input text.
    console.log(numString);//this is unneccessary, just here to check that I have found the value input into the input box.
    /*
    The split function is a native JS function for strings 
    which allows us to split a string into an array based 
    on a delimeter(character to serve as breakpoint)
    In order to split with multiple delimeters, we must 
    use regular expressions. see this site for more info:
    http://classyfunction.com/javascript-split-with-multiple-delimiters/
    For multiple delimeters place the following between the (), / | | / place a character or \n or \t or space in between there like so: var arr = numString.split(/o|\n|\t| /)
    */
    var arr = numString.split(' ');//create a variable arr to contain the newly acquired string array. numString is merely the name I named the string that I acquired above.
    console.log(arr);//this is unneccessary, just here to check that I have split the string up into an array as I intended.
    var sum = 0;
    for (var num of arr) {//for each loop saying for every element that we will name num in the arr array.
        //https://gomakethings.com/converting-strings-to-numbers-with-vanilla-javascript/
        sum += Number(num);//Number() turns strings of array into numbers and then sum += adds each number of array together.
    }
    document.getElementById('arrOutput').innerHTML = sum;//arrOutput was defined in html file as a span which is an inline element located after the sumArraySubmit button. Here we locate the span element named arrOutput. using the innerHTML DOM we change the HTML content of the <span> element and make it equal to sum.

}

// function fizzbuzz(){

//     var n = document.getElementById('fizzIn').value;
//     for(let i=0;i<n,i++){
//         var item = document.createElement('li');
//         if(i%15 ==0)
//     }
// }

function findAverage() {
    var numString2 = document.getElementById('arrNums').value;
    var arr2 = numString2.split(' ');
    var sum2 = 0;
    for (var num2 of arr2) {
        (sum2) += Number(num2);
        var avg = sum2 / (arr2.length);
    }
    document.getElementById('arrOutput').innerHTML = avg;
}

function findPalindrome() {
    var palString = document.getElementById('arrPal').value;
    palString = palString.toLowerCase();
    var arr3 = palString.split("");
    var arr4 = [];
    for (let i = arr3.length - 1; i >= 0; i--) {
        arr4.push(arr3[i]);
    }
    var arrCount1 = 0;
    for (let i = 0; i < arr3.length; i++) {
        if (arr3[i] == arr4[i]) {
            arrCount1++;
        }
    }
    if (arrCount1 == arr3.length) {
        var isPalindrome = true;
        document.getElementById('palindromeOutput').innerHTML = isPalindrome;
    }
    else {
        isPalindrome = false;
        document.getElementById('palindromeOutput').innerHTML = isPalindrome;
    }
}


function findAnagram() {
    var anaString1 = document.getElementById('arrAna1').value;
    var anaString2 = document.getElementById('arrAna2').value;
    var arr5 = anaString1.split("");
    var arr6 = anaString2.split("");
    if (arr5.length !== arr6.length) {
        var isAnagram = false;
        document.getElementById('anagramOutput').innerHTML = isAnagram;
    }
    var arrSort5 = arr5.sort();
    var arrSort6 = arr6.sort();
    var arrCount = 0;
    for (var i = 0; i < arrSort5.length; i++) {
        if (arrSort5[i] == arrSort6[i]) {
            arrCount++;
        }
    }
    if (arrCount == arrSort5.length) {

        isAnagram = true;
        document.getElementById('anagramOutput').innerHTML = isAnagram;
    } else {

        isAnagram = false;
        document.getElementById('anagramOutput').innerHTML = isAnagram;
    }
}





// function findPalindrome(){
//     var palindromeString = document.getElementById('arrPal').value;
//     console.log(palindromeString);
//     let char1=[];
//     let char2=[];
//     var isPalindrome=false;
//     var falseCounter=0;
//     char1=stringToCharArr(palindromeString);
//     char2=reverseStringToCharArr(palindromeString);
//     if(char1.length==char2.length){
//         for(let i=0; i<char1.length;i++){
//             if(char1[i]==char2[i]){
//                 isPalindrome=true;
//             }
//             else{
//                 isPalindrome=false;
//                 falseCounter++;
//             }
//         }
//     }

//     if(falseCounter>0){
//         isPalindrome=false;
//     }

//     console.log(isPalindrome);
//     document.getElementById('palindromeOutput').innerHTML = isPalindrome;
//     return isPalindrome;
// }

// function stringToCharArr(str){
//     let char1 =[]
//     for (let i=0; i< str.length;i++) {
//         if (str[i] != '\' ' && str[i] != " " && str[i] != ',' && str[i] != '.') {
//             char1.push(str[i].toLowerCase());
//         }
//     }
//     console.log(char1.toString());//to test if string get rid of punctuations
//     return char1;
// }
// function reverseStringToCharArr(str) {
//     let char2 = [];

//     for (let i = str.length - 1; i >= 0; i--) {
//         if (str[i] != '\' ' && str[i] != " " && str[i] != ',' && str[i] != '.') {
//             char2.push(str[i].toLowerCase());
//         }
//     } 
//     console.log(char2.toString());// print the reverse of string.
//     return char2;
// }

// function findAnagram(){
//     console.log("button works");
//     // let arrSortedOne;
//     // let arrSortedTwo;
//     var isAnagram = false;
//     var falseCounter=0;
//     var stringOne = document.getElementById("anagramOne").value;
//     var stringOne = stringOne.toLowerCase();
//     console.log("AnagramStringOne is "+ stringOne);
//     var arrOne = stringOne.split('');
//     console.log(arrOne);
//     var arrSortedOne = arrOne.sort();
//     console.log(arrSortedOne);

//     // Input 2
//     var stringTwo = document.getElementById("anagramTwo").value;
//     var stringTwo = stringTwo.toLowerCase();
//     console.log("AnagramStringTwo is "+ stringTwo);
//     var arrTwo = stringTwo.split('');
//     console.log(arrTwo);
//     var arrSortedTwo = arrTwo.sort();
//     console.log(arrSortedTwo);

//     // if(arrSortedOne.length !== arrSortedTwo){
//     //     isAnagram = false;
//     //     console.log(isAnagram);
//     // }

//     for(var i = 0; i <= arrSortedOne.length; i++){
//         if(arrSortedOne[i] == arrSortedTwo[i]){
//             isAnagram = true;
//             // console.log(isAnagram);
//         } else {
//             isAnagram = false;
//             falseCounter++;
//             // console.log(isAnagram);
//         }

//     }
//     if(falseCounter>0){
//     isAnagram=false;
//     }
//     document.getElementById("anagramOutput").innerHTML = isAnagram;

// }


function findFibonacci() {
    var fibonacciString = document.getElementById('arrFib').value;
    console.log(fibonacciString);
    var a = 0, b = 1, f = 1;
    for (var i = 2; i <= fibonacciString; i++) {
        f = a + b;
        a = b;
        b = f;
    }
    document.getElementById('FibonacciOutput').innerHTML = f;
}

function findSort() {
    var sortString = document.getElementById('arrSort').value;
    console.log(sortString);
    var array4 = sortString.split('');
    var sortedArray = array4.sort();
    document.getElementById('sortOutput').innerHTML = sortedArray;
}

function findIntToBin() {
    var intVal = document.getElementById('inputVal').value;
    var out = "";
    while(intVal >= 1){
        var rem = intVal%2;
        out = rem + out;
        intVal= Math.trunc(intVal/2);
    }
    document.getElementById('valOut').innerHTML=out;
}