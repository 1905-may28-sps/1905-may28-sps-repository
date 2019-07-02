// 1. Fibonacci 
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.

function fib(n) {
    let newNum = Number(n);
    let a = 1;
    let b = 0;
    let temp;


    if (newNum < 0) {
        document.getElementById("output").innerHTML="Please enter a non-negative number.";
        return 0;
    }

    if (newNum <= 1) {
        document.getElementById("output").innerHTML=newNum;
        return;
    }

    while (newNum >= 0) {
        temp = a;
        a = a + b;
        b = temp;
        newNum = newNum - 1;
    }
    
    // document.getElementById("output").innerHTML=b;
    console.log(output);
}
console.log(fib());