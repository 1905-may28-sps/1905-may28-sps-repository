window.onload = function () {
    //this window.onload ensures that the script waits until page is ready
    //to execute 
    document.getElementById("sumArraySubmit").addEventListener("click", findSum);
    document.getElementById("avgArraySubmit").addEventListener("click", findAverage);
    document.getElementById("palind").addEventListener("click", findPalindrome);
    document.getElementById("anagramButt").addEventListener("click", findAnagram);
    document.getElementById("fiboButt").addEventListener("click", findFibonacci);
    document.getElementById("sortButton").addEventListener("click", findSort)
}

function findSum() {
    var numString = document.getElementById("arrNums").value;
    console.log(numString);
    /* the split function is a native JS function for strings 
    that allow us to split a string into an array based on a delimeter 
    In order to split with multiple delimeters, we must use regular expressions.*/
    var arr = numString.split(" ");
    console.log(arr);
    var sum = 0;
    for (let num of arr) {
        sum += Number(num);
    }
    document.getElementById("arrOutput").innerHTML = sum;
}

function findAverage() {
    var numString = document.getElementById("arrNums").value;
    console.log(numString);
    var arr = numString.split(" ");
    console.log(arr);
    var sum = 0;
    for (let num of arr) {
        sum += Number(num) / arr.length;
    }
    document.getElementById("arrOutput").innerHTML = sum;
    console.log(sum);
}

function findPalindrome() {

    var wordRev = document.getElementById("wordBack").value;
    console.log(wordRev);
    var lowered = wordRev.toLowerCase();
    console.log(lowered);
    var replaced = lowered.replace(" ", "");
    var arr = replaced.split("");
    console.log(arr);
    var reversed = arr.reverse();
    console.log(reversed);
    var together = arr.join("");
    console.log(together);
    if (together === replaced) {
        document.getElementById("palOutput").innerHTML = true;
        console.log(true);
    }
    else {
        document.getElementById("palOutput").innerHTML = false;
        console.log(false);
    }
}

function findAnagram() {

    var anagWordOne = document.getElementById("anagEnter").value;
    var anagWordTwo = document.getElementById("anagEnter2").value;

    var loweredOne = anagWordOne.toLowerCase();
    var loweredTwo = anagWordTwo.toLowerCase();

    var splitOne = loweredOne.split("");
    var splitTwo = loweredTwo.split("");
    var sortOne = splitOne.sort();
    var sortTwo = splitTwo.sort();

    var joinOne = sortOne.join("");
    var joinTwo = sortTwo.join("");

    if (joinOne === joinTwo) {
        document.getElementById("anaOutput").innerHTML = true;
    }
    else {
        document.getElementById("anaOutput").innerHTML = false;
    }
}

function findFibonacci() {
    var enteredNum = document.getElementById("fiboInput").value;
    var fib = [0, 1];

    for (var i = 2; i < enteredNum + 1; i++) {
        fib.push(fib[i - 2] + fib[i - 1]);

    }
    console.log(fib[enteredNum]);
    document.getElementById("fiboOutput").innerHTML = fib[enteredNum];
}


function findSort() {
    var enteredNums = document.getElementById("sortInput").value;
    console.log(enteredNums);
    var array = enteredNums.split(" ");
    console.log(array);
    var sortedArray = array.sort(function (a, b) { return a - b; });
    document.getElementById("sortOutput").innerHTML = sortedArray;
}



