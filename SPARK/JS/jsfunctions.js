   //this is JavaScript! right in our HTML page...    
   window.onload = function(){
    //this window.onload ensures that the script waits until page is ready to execute
    document.getElementById('sumArraySubmit')
        .addEventListener('click', findSum);
    document.getElementById('avgArraySubmit')
        .addEventListener('click', findAverage);    
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
    
}