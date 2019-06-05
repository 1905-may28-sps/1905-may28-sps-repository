
   //this is javascript! right in our html page...
   window.onload = function () {
       //this window.onload ensure that the script waits until page is ready
       document.getElementById('sumArraySubmit').addEventListener('click', findSum);
       document.getElementById('avgArraySubmit').addEventListener('click', findAverage); 
       //document.getElementById('PaliArraySubmit').addEventListener('click', findPalindrome); 
       document.getElementById('fiboSubmit').addEventListener('click', fibo);
       document.getElementById('AnaSubmit').addEventListener('click', Anagram); 

       document.getElementById('sortSubmit').addEventListener('click', sort); 

       document.getElementById('doFizz').addEventListener('click', fizzbuzz);

 

       
   }

   function fizzbuzz() {
       
    //cleat list each time button is pressed
    var list= document.getElementById('fizzout');

    while(list.firstChild){
        list.removeChild(list.firstChild);
    }
       var n = document.getElementById('fizzIn').value;
       for (let i = 1; i <= n; i++) {
           var li = document.createElement('li');
           if (i % 15 ==0) li.innerHTML = 'FizzBuzz';
           else if (i % 3==0) li.innerHTML= 'Fizz';
           else if (i% 5== 0) li.innerHTML = 'buzz';
                else li.innerHTML= i;
                document.getElementById('fizzout').appendChild(li); 
                

       }
   }

   function findSum() {
       //console.log('button works')
       var numString = document.getElementById('arrNums').value;
       console.log(numString);
       var arr = numString.split(' ');
       console.log(arr);
       var sum =0;
       for (let num of arr){
           //Number is ParseInt
           sum+= Number(num);

       }
       //console.log(sum);
       document.getElementById('arrOutput').innerHTML = sum;
   }

   function findAverage() {
       var numString = document.getElementById('arrNums').value;
       var arr = numString.split(' ');
       var avg =0;
       
       for (var i = 0; i < count; i++) {
        avg = avg + arr[i];
        avg =   avg/arr.length;
      }
      console.log(avg)       

   }

   function findPalindrome() {
   var pal = document.getElementById('palinput').value
   
   
};
    function Anagram() {
        var ana = document.getElementById('anainput').value
        var arr = numString.split(' ');

        if (ana.length !== s) {
            
        }
    }

function fibo() {
    var fibString = document.getElementById('fibinput').value
    var fib = fibString.split('');
    if (fib <= 2) return 1;

  
    document.getElementById('arrOutput').innerHTML = fib;

}
   

   function sort() {
    var numString = document.getElementById('sortinput').value;
    var arr = numString.split(' ');
    arr.sort();
    
    document.getElementById('arrOutput').innerHTML = arr;

       
   }

 
 