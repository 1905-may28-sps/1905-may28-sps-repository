    

 window.onload = function(){
    setInterval("date()",1000);
   

    document.getElementById('palArraySubmit').addEventListener('click', function(){findPalindrome(document.getElementById('Pal').value)});

    document.getElementById('stringSubmit').addEventListener('click', function(){revString(document.getElementById('astring').value)});
    document.getElementById('stringSubmit').addEventListener('click', function(){subString(document.getElementById('astring').value,document.getElementById('length').value,document.getElementById('offset').value)});
    document.getElementById('fibArraySubmit').addEventListener('click', function(){findFib(document.getElementById('fib').value)});
    document.getElementById('fibArraySubmit').addEventListener('click', function(){findFac(document.getElementById('fib').value)});
    document.getElementById('sortSubmit').addEventListener('click', function(){bubbleSort(document.getElementById('bsort').value)});
    document.getElementById('delSubmit').addEventListener('click', function(){delEl(document.getElementById('del').value)});

    document.getElementById('splSubmit').addEventListener('click', function(){splEl(document.getElementById('spl').value)});
    document.getElementById('desc').addEventListener('click', function(){desc(document.getElementById('desc1').value)});
    document.getElementById('person').addEventListener('click', print());  
    document.getElementById('person').addEventListener('click',getPerson(document.getElementById('name').value,document.getElementById('age').value));


}
//Q12ISH
function print(){
var hold=new Person(document.getElementById('name').value,document.getElementById('age').value);
console.log(hold);
document.getElementById('person2').innerHTML=hold.name+" "+hold.age;
}
//Q1
function findFib(num){
    console.log("in ere");
    console.log(num);
   num=Number(num);

   var n=1;
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
//Q4
function findFac(num){
    console.log("in ere");
    console.log(num);
   num=Number(num);

   var n=1;
 
            for (var a=1; a<=num; a++)
            {   num=n*num;
                n=num;
                
            }
       
    document.getElementById('facOutput').innerHTML = n;
    
}
//Q7
function findPalindrome(palString){
        console.log("top");
        
        var b="true";
       
        for (let i=0;i<palString.length; i++){
            var c=palString.charAt(i);
            var a=palString.charAt(palString.length-1-i);
        
                if (c!=a) b="false";
                
                
        }
           
        
            document.getElementById('palOutput').innerHTML=b;//inner HTML is the space between span tag
}
//Q3
function revString(str){
   
    var suc=false;
    let l="";
    
    for(let p=0;p<=str.length; p++){
        l=l+str.charAt(str.length-p);
    }
    document.getElementById('revOutput').innerHTML = l;
    console.log(l);
}
//Q5
function subString(str, length, offset){
    let l="";
    offset=Number(offset);
    length=Number(length);

    console.log(str.length);
    console.log(offset);
    console.log
    if(offset> str.length){
       alert("Offset exceeds string length");
    }else if(offset+offset+length>str.length){
       alert("Offset+Length exceeds string length");
    }else if (length<0||offset<0){
        alert("Values cannot be negative");
    }else{
       
    for(let p=offset-1;p<=offset-1+length; p++){
        l=l+str.charAt(p);
    }
    document.getElementById('subOutput').innerHTML = l;

}
}

//Q2
function bubbleSort(arr2) {


    var stringArr=arr2.split(' ');
    var arr=[];
    for(let num of stringArr){
        arr.push(Number(num));
    }


    for(var i = 0; i < arr.length; i++) {
      for(var j = 1; j < arr.length; j++) {
        if(arr[j - 1] > arr[j]) {
            temp=arr[j - 1];
            arr[j - 1]=arr[j];
            arr[j]=temp;
        }
      }
    }
    document.getElementById('bSort').innerHTML =arr;
    return arr;
  }
  
//Q11
function splEl(arr2) {


    var stringArr=arr2.split(' ');
    var arr=[];
    var arrn=0;
    for(let num of stringArr){
        if (num=='3'){
            arrn++
        }else{
        arr.push(Number(num));
        arrn++
        }
    }
    document.getElementById('spl2').innerHTML =arrn;
    document.getElementById('spl3').innerHTML =arr.length;
    return arr;
  }
  //Q10
  function delEl(arr2) {


    var stringArr=arr2.split(' ');
    var arr=[];
    var arrn=0
    
    for(let num of stringArr){
        if (num=='3'){
            arr.push(NaN);
            arrn++;
        }else{
        arr.push(Number(num));
        arrn++
        }
    }
    document.getElementById('del2').innerHTML =arrn;
    document.getElementById('del3').innerHTML =arr.length;
    return arr;
  }
//Q15
function desc(str) {
var arr2=str.split("");


var arr=[];
    for(let num of arr2){
        arr.push(Number(num));
    }


    for(var i = 0; i < arr.length; i++) {
      for(var j = 1; j < arr.length; j++) {
        if(arr[j - 1] < arr[j]) {
            temp=arr[j - 1];
            arr[j - 1]=arr[j];
            arr[j]=temp;
        }
      }
    }
    document.getElementById('desc2').innerHTML =arr.join("");
    return arr;
  }
//Q12ISH
function Person(name, age)  {
    this.name = name;
    this.age = age;
  }
//Q9ISH
function getPerson(name, age)  {
    this.name = name;
    this.age = age;
  }
//Q14
function date(){
    var d = new Date();
    document.getElementById("datetime").innerHTML = d.toLocaleString();

}



//////////////////////////////////////////////////////////////


    

