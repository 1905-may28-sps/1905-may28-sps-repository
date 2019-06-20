   //this is JavaScript! right in our HTML page...    
   window.onload = function(){
    //this window.onload ensures that the script waits until page is ready to execute
    document.getElementById('sumArraySubmit')
        .addEventListener('click', findSum);
    document.getElementById('avgArraySubmit')
        .addEventListener('click', findAverage);
        document.getElementById('sortArraySubmit')
        .addEventListener('click', sortArray);
    document.getElementById('dessortArraySubmit')
        .addEventListener('click', dessortArray);
        document.getElementById('palidromeSubmit')
        .addEventListener('click', palindrome);    
        document.getElementById('anagramSubmit')
        .addEventListener('click', anagram); 
        document.getElementById('doFizz').addEventListener('click', fizzbuzz);
        document.getElementById('DectoHex').addEventListener('click', decToHex);
        document.getElementById('HextoDec').addEventListener('click', hexToDec);
        document.getElementById('DectoBin').addEventListener('click', decToBin);
        document.getElementById('BintoDec').addEventListener('click', binToDec);
}


function fizzbuzz(){
    //clear list each time button is pressed 
    var list = document.getElementById('fizzOut');

    while(list.firstChild){
        list.removeChild(list.firstChild);
    }

    //fizzbuzz functionality 
    var n = document.getElementById('fizzIn').value;
    for(let i = 1; i <= n; i++){
        var item = document.createElement('li');
        if(i % 15 == 0 ) item.innerHTML = 'FizzBuzz';
        else if (i % 3 == 0) item.innerHTML = 'Fizz';
        else if (i % 5 == 0) item.innerHTML = 'Buzz';
        else item.innerHTML = i;
        list.appendChild(item);
    }

}





function findSum(){
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
    for(let num of arr){
        //https://gomakethings.com/converting-strings-to-numbers-with-vanilla-javascript/
        sum+= Number(num);
    }
    document.getElementById('arrOutput').innerHTML = sum;
}


function findAverage(){
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
    var avg = 0;
    for(let num of arr){
        //https://gomakethings.com/converting-strings-to-numbers-with-vanilla-javascript/
        sum+= Number(num);
        avg= Number(sum)/arr.length;
    
}
document.getElementById('arrOutput').innerHTML = avg;
}




function sortArray() {
    var numString = document.getElementById('arrNums5').value;
    
    var arr = numString.split(' ');
    arr = arr.map(Number);
     var len = arr.length;
        for (var i = len-1; i>=0; i--){
          for(var j = 1; j<=i; j++){
            if(arr[j-1]>arr[j]){
                var temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
             }
          }
        }
        console.log(arr); 
    document.getElementById('arrOutput2').innerHTML = arr;    
        return arr;
    
        
    
  }

  function dessortArray() {
    var numString = document.getElementById('arrNums5').value;
    
    
    var arr = numString.split(' ');
    arr = arr.map(Number);
    var len = arr.length;
    for (var i = len-1; i>=0; i--){
      for(var j = 1; j<=i; j++){
        if(arr[j-1]<arr[j]){
            var temp = arr[j-1];
            arr[j-1] = arr[j];
            arr[j] = temp;
         }
      }
    }
    console.log(arr); 
document.getElementById('arrOutput2').innerHTML = arr;    
    return arr;
  }

  

  function palindrome(){
     Str = document.getElementById('arrString').value;
var str = Str.toLowerCase();
str=str.replace(/[^a-z]/g, "");
for(var i = 0; i<Math.floor(str.length/2); i++){
    if(str[i] != str[str.length-i-1]){
        console.log(false);
        document.getElementById('arrOutput3').innerHTML = 'False';
    }
    else{
        console.log(true);
        document.getElementById('arrOutput3').innerHTML = 'True';
    }

 

  }

  }

  function anagram(){
    Str = document.getElementById('arrString1').value;
    Str2 = document.getElementById('arrString2').value;
var str = Str.toLowerCase();
var str2 = Str2.toLowerCase();
 str = str.split("");
 str2 = str2.split("");
if (str.length==str2.length){
        str.sort();
        str2.sort();

        console.log(str);
        console.log(str2);

           for(let i=0; i<str.length-1;i++){
             if(str[i]==str2[i]){
                document.getElementById('arrOutput4').innerHTML = 'This is an Anagram';

             }
             else{
                document.getElementById('arrOutput4').innerHTML = 'This is not an Anagram';
             }

            }
        }
else{

    document.getElementById('arrOutput4').innerHTML = 'The length of these strings are different so this is not an Anagram';
}

  } 



function decToHex(){
    var num = Number(document.getElementById('conIn').value);
    console.log(num);
    var outPut = "";
    while(num>0){
        var rem = num%16;
        if(rem<10) outPut = rem+outPut;
        else{
            switch(rem){
                case 10: outPut = 'a'+ outPut; break;
                case 11: outPut = 'b'+ outPut; break;
                case 12: outPut = 'c'+ outPut; break;
                case 13: outPut = 'd'+ outPut; break;
                case 14: outPut = 'e'+ outPut; break;
                case 15: outPut = 'f'+ outPut; break;
            }
        }
        num = (num-rem)/16;
}
console.log(outPut);
document.getElementById('conOut').innerHTML= outPut;
}



function hexToDec(){
    var hex = document.getElementById("conIn").value;
    var result = 0, digitValue;
    hex = hex.toLowerCase();
    for (var i = 0; i < hex.length; i++) {
        digitValue = '0123456789abcdefgh'.indexOf(hex[i]);
        result = result * 16 + digitValue;
    }
    
    
    console.log(result);
document.getElementById('conOut').innerHTML= result; 
}
//console.log(num);
//document.getElementById('conOut').innerHTML= num;
//}



function decToBin(){

}


function binToDec(){
    var bin = document.getElementById("conIn").value;
    let dec = 0;
    for (let i = 0; i < bin.length; i++) {
        if (bin[bin.length - (i + 1)] === '1') {
            dec += 2 ** i;
        }
    }
    ;
    console.log(dec);
document.getElementById('conOut').innerHTML= dec; 

}