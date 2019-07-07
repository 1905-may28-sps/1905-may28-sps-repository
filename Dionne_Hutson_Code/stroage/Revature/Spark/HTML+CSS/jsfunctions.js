 //this is JavaScript! right in our HTML page...    

 window.onload = function(){

    //this window.onload ensures that the script waits until page is ready to execute

    document.getElementById('sumArraySubmit').addEventListener('click', findSum);

    document.getElementById('avgArraySubmit').addEventListener('click', findAverage); 

    document.getElementById('palArraySubmit').addEventListener('click', findPalindrome);

    document.getElementById('anaArraySubmit').addEventListener('click', findAna);
    document.getElementById('fibArraySubmit').addEventListener('click', findFib);
    document.getElementById('sortArraySubmit').addEventListener('click', findSort);
    document.getElementById('doFizz').addEventListener('click',fizzBuzz);

    document.getElementById('iB').addEventListener('click',iB);
    document.getElementById('bI').addEventListener('click',bI);
    


}
function fizzBuzz(){
    var n=document.getElementById.value;
    while(list.firstChild){
        list.removeChild(list.firstChild);
    }
    for(let i=1; i<=n;i++){
        var li=document.createElement('li');
        if(i%15==0)li.innerHTML='FizzBuzz';
        else if(i%3==0)li.innerHTML='Fizz';
        else if(i%5==0)li.innerHTML='Buzz';
        else li.innerHTML=i;
        list.appendChild(li)


    }
}
function getArray(){
    var numString = document.getElementById('arrNums').value;

    var stringArr=numString.split(' ');
    var arr=[];
    for(let num of stringArr){
        arr.push(Number(num));
    }
    return arr;
}


function findSum(){
var arr=getArray();
var sum=0;

    

    /*

    The split function is a native JS function for strings 

    which allows us to split a string into an array based 

    on a delimeter(character to serve as breakpoint)

    In order to split with multiple delimeters, we must 

    use regular expressions. see this site for more info:

    http://classyfunction.com/javascript-split-with-multiple-delimiters/

    */


    var sum = 0;

    for(let num of arr){

        //https://gomakethings.com/converting-strings-to-numbers-with-vanilla-javascript/

        sum+= num;

    }

    document.getElementById('arrOutput').innerHTML = sum;
return sum;
}

function findAna(){
    
    var arr= document.getElementById('arrPal').value;
    var arr2 = document.getElementById('arrPal2').value;
    var suc=false;
    var a=0;
    for(let p=0;p<arr.length; p++){
        for(let l=0;l<arr2.length; l++){
            if(arr.charAt(p)==arr2.charAt(l)){
                if(p==l){
                    a++;
                }
            }
        }
    }
    if (a!==arr2.length){
        suc=true;
    }

    document.getElementById('anaOutput').innerHTML = suc;
}

function findSort(){
    var arr=getArray();
    arr.sort(function(a , b) {return a - b;});
    
    document.getElementById('sortOutput').innerHTML = arr;
    

}

function findFib(){
    

    var num = document.getElementById('fibPal').value;
   var n=0;
   var temp;
   var b;
    if(num>=1){
        b=n;
        n=1;
        if(num>=2){
            console.log("biggie for loop");
            for (var a=2; a<num; a++)
            {   console.log("biggie for loop");
                temp=b+n;
                b=n;
                n=temp;
                
            }
        }

        
    }
    document.getElementById('fibOutput').innerHTML = n;
    

}


function findAverage(){
    var arr=getArray();
    var sum=0;

    for(let num of arr){

        sum+= Number(num);

    }

    document.getElementById('avgOutput').innerHTML=sum/ arr.length;//inner HTML is the space between span tag
}

    
function findPalindrome(){
        console.log("top");
        var palString=document.getElementById('arrPal').value;
        
        var b="true";
       
        for (let i=0;i<palString.length; i++){
            var c=palString.charAt(i);
            var a=palString.charAt(palString.length-1-i);
        
                if (c!=a) b="false";
                
                
        }
           
        
            document.getElementById('palOutput').innerHTML=b;//inner HTML is the space between span tag
}

function iH(){
    var n=document.getElementById("numIn").value;
    //find the remainder of n/16 and save it
    //find the re

    var div;
    var rem;
    let arr=[];

    n/16;
    n%16;
    

}
function  iB(){
    var n=Number(document.getElementById("numIn").value);
    var div;
    var rem;
    var arr=[];
    console.log("in here");
do{
    console.log(n);
    div=Math.floor(n/2);
    rem=n % 2;
    console.log(rem);
    arr.push(rem);
    console.log(arr);
    n=div;
    console.log(div+"div");

console.log("in here do");

}while(div>0);
var a=arr.reverse();
document.getElementById('numOut').innerHTML = a.join("");
}

function bI(){
    var n=document.getElementById("numIn").value;
    var c=0;
    var m;
    

    for (let k=n.length-1; k>=0; k--) {
        
        m=Number( n.charAt(k));
        m=m*Math.pow(2,(n.length-k-1));
        c+=m;
    }
    document.getElementById('numOut').innerHTML = c;
    

}
