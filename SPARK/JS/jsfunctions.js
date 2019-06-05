   //this is JavaScript! right in our HTML page...    
   window.onload = function(){
    //this window.onload ensures that the script waits until page is ready to execute
    document.getElementById('sumArraySubmit')
        .addEventListener('click', findSum);
    document.getElementById('avgArraySubmit')
        .addEventListener('click', findAverage);    
    document.getElementById('sortArraySubmit')
        .addEventListener('click', sortArray); 
    document.getElementById('findPalindrome')
        .addEventListener('click', palindrome);
    document.getElementById('doFizz').addEventListener('click', fizzbuzz);
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

function getArray(){
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
    var stringArr = numString.split(' ');
    var arr = [];
    for(let num of stringArr){
        //https://gomakethings.com/converting-strings-to-numbers-with-vanilla-javascript/
        arr.push(Number(num));
    }
    return arr;
}


function findSum(){
    var arr = getArray();
    var sum = 0;
    for(let num of arr){
        //https://gomakethings.com/converting-strings-to-numbers-with-vanilla-javascript/
        sum+= num;
    }
    document.getElementById('arrOutput').innerHTML =
     `<i>The sum of the elements in this array is <b>${sum}</b></i>`;
}


function findAverage(){
    var arr = getArray();
    var sum = 0;
    for(let num of arr){
        //https://gomakethings.com/converting-strings-to-numbers-with-vanilla-javascript/
        sum+= num;
    }
    document.getElementById('arrOutput').innerHTML =
    `<i>The average of the elements in this array is 
    <b>${sum/arr.length}</b></i>`;

}

function sortArray(){ // 1 5 34 5  -> 100 101 340 500
    var arr = getArray();
    arr.sort(function(a, b) {
        return a - b;
    }); 
    console.log(arr);
}

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