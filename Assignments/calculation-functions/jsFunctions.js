// window.onload = function(){
//     // this
//     document.getElementById('sumArraySubmit').addEventListener('click', findSum);
// }

// function findSum(){
//     var numString = document.getElementById('arrNums').value;
//     console.log(numString);
//     var arr = numString.split(' ');
//     console.log(arr);

// var sum = 0;
// for (let num of arr){
//     sum+= Number(num);
// }
// console.log(sum);
// }

//this is JavaScript! right in our HTML page...    
window.onload = function () {
    //this window.onload ensures that the script waits until page is ready to execute

    document.getElementById('sumArraySubmit').addEventListener('click', findSum);

    document.getElementById('avgArraySubmit').addEventListener('click', findAverage);

    document.getElementById('palArraySubmit').addEventListener('click', findPalindrome);

    document.getElementById('anagArraySubmit').addEventListener('click', findAnagram);

    document.getElementById('fibArraySubmit').addEventListener('click', findFibonacci);

    document.getElementById('sortArraySubmit').addEventListener('click', sortFunc);

    document.getElementById('doFizz').addEventListener('click', fizzbuzz);

    document.getElementById('doConversion').addEventListener('click', intToHex);
}

function findSum() {
    var numString = document.getElementById('arrNums').value;
    console.log(numString);
    /*
    The split function is a native JS function for strings 
    which allows us to split a string into an array based 
    on a delimeter(character to serve as breakpoint)
    In order to split with multiple delimeters, we must 
    use regular expressions. see this site for more info:
    http://classyfunction.com/javascript-split-with-multiple-delimiters/
    */
    var arr = numString.split(' ');
    console.log(arr);
    var sum = 0;
    for (let num of arr) {
        //https://gomakethings.com/converting-strings-to-numbers-with-vanilla-javascript/
        sum += Number(num);
    }
    document.getElementById('arrOutput').innerHTML = sum;
}


function findAverage() {
    var avgNumString = document.getElementById('avgNums').value;
    console.log(avgNumString);
    var avgArr = avgNumString.split(' ');
    console.log(avgArr);
    var sum = 0
    for (let num of avgArr) {
        sum += Number(num);
        var avg = sum / avgArr.length
    }

    document.getElementById('avgOutput').innerHTML = avg;

}

function findPalindrome() {
    var palNumString = document.getElementById('palNums').value;
    console.log(palNumString);

    var lowerPal = palNumString.toLowerCase();
    var replaced = lowerPal.replace(' ', '')
    var palArr = replaced.split('');
    var reversedPalArr = palArr.reverse();
    var char1 = reversedPalArr.join('');
    if (char1 == replaced) {
        console.log('true');
        document.getElementById('palOutput').innerHTML = 'true';
    } else {
        console.log('false')
        document.getElementById('palOutput').innerHTML = 'false';

    }
}



function findAnagram() {
    var word1 = document.getElementById('anaWord1').value;
    var word2 = document.getElementById('anaWord2').value;

    var lowWord1 = word1.toLowerCase();
    var lowWord2 = word2.toLowerCase();
    var word1Array = lowWord1.split('');
    var word2Array = lowWord2.split('');
    var sortWord1 = word1Array.sort();
    var sortWord2 = word2Array.sort();
    var joinWord1 = sortWord1.join();
    var joinWord2 = sortWord2.join();

    if (joinWord1 == joinWord2) {
        console.log('true');
        document.getElementById('anagOutput').innerHTML = 'true';
    } else {
        console.log('false');
        document.getElementById('anagOutput').innerHTML = 'false';
    }
}

function findFibonacci() {
    var fib = [0, 1,];
    var num = document.getElementById('fibNums').value;
    console.log(num);
    for (let i = 2; i < num + 1; i++) {
        fib.push(fib[i - 2] + fib[i - 1]);
        console.log(fib[num]);
    }
    console.log(fib[num]);
    document.getElementById('fibOutput').innerHTML = fib[num];
}

function sortFunc() {
    var arr = getArray();
    arr.sort(function (a, b) {
        return a - b
    });
    console.log(arr);
    document.getElementById('arrOutput').innerHTML = [num];
}


function fizzbuzz() {

    var list = document.getElementById('fizzOut');

    var n = document.getElementById('fizzIn').value;
    for (let i = 0; i <= n; i++) {
        var li = document.createElement('li');
        if (i % 15 == 0) iterm.innerHTML = 'FizzBuzz';
        else if (i % 3 == 0) item.innerHTML = 'Fizz';
        else if (i % 5 == 0) item.innerHTML = 'Buzz';
    }



}

function intToHex() {
    var num = Number(document.getElementById('conversion').value);
    console.log(num);
    {
        if (num < 0) {
            num = 0xFFFFFFFF + num + 1;
        }
        console.log(num.toString(16).toUpperCase())
        var out = num.toString(16).toUpperCase();
        console.log(out);
    }
}


// function intToHex (){
//     var num = Number(document.getElementById('conversion').value);
//     console.log(num);
//     var out = "";

//     while(num > 0){

//         var rem = num%16;
//         console.log(rem);
//         if(rem<10) out = rem+out;
//         else {
//             switch(rem){
//                 case 10: out = 'a'+ out; break;
//                 case 11: out = 'b'+ out; break;
//                 case 12: out = 'c'+ out; break;
//                 case 13: out = 'd'+ out; break;
//                 case 14: out = 'e'+ out; break;
//                 case 15: out = 'e'+ out; break;
//             }
//         }
//         num = (num -rem)/16;
//         console.log(out);
//         console.log(num);
//     }
//     console.log(out);
// document.getElementById('conversion').innerHTML = out;
// }












// function sortFunc() {

//     var num = document.getElementById('sortNums').value
//     var arr = num.split(' ');
//     arr = arr.map(Number)
//     for (let i = 0; i < arr.length-1; i++) {
//             if (arr[i]>arr[i+1]) {
//                 var temp=arr[i];
//                 arr[i]=arr[i+1];
//                 arr[i+1]=temp;
//                 newArr.push
//             }            
//         }
//         console.log(arr);
//     } 

