//this is JavaScript! right in our HTML page...    
window.onload = function () {
    //this window.onload ensures that the script waits until page is ready to execute
    //window.onload = function() {    JavaScript code to execute on page load; }
    //Make sure everything is loaded before

    document.getElementById('palArraySubmit').addEventListener('click', findPalindrome);

    document.getElementById('fibArraySubmit').addEventListener('click', findFibonacci);
    document.getElementById('doObjectButton').addEventListener('click', doObject);
    document.getElementById('doObjectButton').addEventListener('click', doLiteral);
    document.getElementById('revStrIn').addEventListener('click', revStr);
    document.getElementById('facNumInIt').addEventListener('click', factorialize);
    document.getElementById('evenNumInIt').addEventListener('click', isEven);
    isDate();
    document.getElementById('desNumInIt').addEventListener('click', Descend);
    document.getElementById('sortArraySubmit').addEventListener('click', bubble_Sort);
}



//Question 1
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

//Question 2
// function findSort() {

function bubble_Sort(arr) {
    // var arr = document.getElementById('arrSort').value;
    var len = arr.length, i, j, stop;
    for (i = 0; i < len; i++) {
        for (j = 0, stop = len - i; j < stop; j++) {
            if (arr[j] > arr[j + 1]) {
                var temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    return arr;
    // document.getElementById('sortOutput').innerHTML=arr; 
}
// document.getElementById('sortOutput').innerHTML=bubble_Sort([3, 0, 2, 5, -1, 4, 1]);
document.getElementById('sortOutput').innerHTML = bubble_Sort([3, 0, 2, 5, -1, 4, 1]);
// console.log(bubble_Sort([3, 0, 2, 5, -1, 4, 1]));
// console.log(arr);

// }
// console.log(bubble_Sort([3, 0, 2, 5, -1, 4, 1]));
// var x = new Array();
// var y = document.getElementById('arrSort').value;
// var y2 = y.split(",");
// for(i=0; i<y.length; i+=2){
//     x+=Number(y[i])+"<br>";
// }
// var z = [bubble_Sort(x)];
// document.getElementById('sortOutput').innerHTML=z;
// var sortedArray = 
// sortedArray;


//Question 3

function revStr() {
    var str = document.getElementById('strIn').value;
    var y = "";
    for (var i = str.length - 1; i >= 0; i--) {
        y += str.charAt(i);
    }
    // console.log(y);
    document.getElementById('findReverse').innerHTML = y;
}

//Question 4
function factorialize() {
    var xNum = document.getElementById('facNumIn').value;
    if (xNum === 1)
        xNum == 1;
    if (xNum <= 0)
        xNum == 1;
    for (i = xNum - 1; i >= 1; i--)
        xNum *= i;
    document.getElementById('findFactorial').innerHTML = xNum;
}

//Question 6
function isEven() {
    var evenNum = document.getElementById('evenNumIn').value;
    if ((evenNum & 1) == 0)
        document.getElementById('findEven').innerHTML = "even number";
    else
        document.getElementById('findEven').innerHTML = "odd number";
}


//Question 7
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




//Question 12
function doObject() {
    function Person(name, age) {
        this.pName = name;
        this.pAge = age;
    }
    var john = new Person(document.getElementById('Q12name').value, document.getElementById('Q12age').value);
    document.getElementById("objectOut").innerHTML = john.pName + " " + john.pAge;
}

//Question 13
function doLiteral() {
    function getPerson(name, age) {
        return { pName: name, pAge: age };
    }
    var john = getPerson(document.getElementById('Q12name').value, document.getElementById('Q12age').value);
    document.getElementById("objectOut2").innerHTML = john.pName + " " + john.pAge;
}

//Question 14

function isDate() {
    var today = new Date();
    document.getElementById('dateOutput').innerHTML = today;
    var refresh = 1000;
    mytime = setTimeout('isDate()', refresh)
}

//Question 15
function Descend() {
    var points = document.getElementById('desNum').value;
    points = points.split("");
    document.getElementById("findDes").innerHTML = points;
    points.sort(function (a, b) { return b - a });
    document.getElementById("findDes").innerHTML = points;
}
