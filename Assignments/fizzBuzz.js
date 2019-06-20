function fizzbuzzRangeSplit(range, divisor1, divisor2) {
    for (var i = 1; i <= range; i++) {
        let number = i;
        if (i % divisor1 == 0 && i % divisor2!==0) {
            console.log('Fizz'.split(""));
            document.write("Fizz".split(""));
            document.write("<br>")
        } else if (i % divisor2 == 0 && i % divisor1 !== 0 ){
            console.log("Buzz".split(""));
            document.write("Buzz".split(""));
            document.write("<br>");
        }else if ( i % divisor1 == 0 && i % divisor2 == 0) {
            console.log("FizzBuzz".split(""));
            document.write("FizzBuzz".split(""));
            document.write("<br>");
        }else if (i % divisor1 !== 0 && i % divisor2 !== 0) {
            console.log(number);
            document.write(number);
            document.write("<br>")
        
        }
    }
}

console.log(fizzbuzzRangeSplit(100, 3, 5));