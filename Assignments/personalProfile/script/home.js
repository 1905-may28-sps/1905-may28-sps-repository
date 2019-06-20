// // const url="http://quotes.rest/quote/random.json";
// const url="http://api.icndb.com/jokes/random"

// var btn=document.querySelector("#new-joke-button");

// getQuote();

// function getQuote(){
// var xhr=new XMLHttpRequest();// AJAX object
// xhr.open('GET',url,true);

// //3. write a function to handle server response gracefully
// xhr.onreadystatechange= function(){
//     console.log(`Ready State- ${xhr.readyState}`);
//     if(xhr.readyState==4)
//     {
//         //JSON.parse - converts JSON string to JS object
//         // JSON.stringify - converts JS object to Json string
//        var data=JSON.parse(xhr.responseText);
//        console.log(data);
//        addQuote(data);
//     }
// };
// //4. Send the request to server
// xhr.send();//GET requests to recieve data
// //xhr.send(data);//POST
// }

// function addQuote(data){
//     var quoteField=document.getElementById("quoteField");
//     quoteField.innerHTML=data.value.joke;
// }



//console.log('first run');
//create a constant (const is block scope like let)
const url="http://api.icndb.com/jokes/random";
//url=10; //this will give error becuse values cannot be re-asssigned
//call the getJoke on button click
var btn=document.querySelector("#new-joke-button");
//wire the event with event handler
btn.addEventListener('click',getJoke);


function getJoke(){
//1. create an object for creating Ajax Request
var xhr=new XMLHttpRequest();// AJAX object
//2. Open the request
xhr.open('GET',url,true);//3rd argument is optional true means asynchronous request

//3. write a function to handle server response gracefully
xhr.onreadystatechange= function(){
    console.log(`Ready State- ${xhr.readyState}`);
    if(xhr.readyState==4)
    {
        //JSON.parse - converts JSON string to JS object
        // JSON.stringify - converts JS object to Json string
       var data=JSON.parse(xhr.responseText);
       console.log(data);
       addJoke(data);
    }
};
//4. Send the request to server
xhr.send();//GET requests to recieve data
//xhr.send(data);//POST
}

function addJoke(data){
    var jokefield=document.getElementById("jokefield");
    jokefield.innerHTML=data.value.joke;
}


// -------------------------------------------------------------------------------------------------------------------------
var btn2=document.getElementById("new-joke-button2");
btn2.addEventListener('click',getJokeByNumber);


// function jokeNumberInput(){
//     var jokenumber2 = Number(document.getElementById("jokenumber").value);
//     return jokenumber2

// }

function getJokeByNumber(){
   var jokenumber2 = document.getElementById("jokeNumber").value;
    var url2 = "http://api.icndb.com/jokes/"+jokenumber2
    var xhr=new XMLHttpRequest();
    xhr.open('POST',url2,true);//3rd argument is optional true means asynchronous request
    
    xhr.onreadystatechange= function(){
        console.log(`Ready State- ${xhr.readyState}`);
        if(xhr.readyState==4)
        {
            
           var data=JSON.parse(xhr.responseText);
           console.log(data);
           addJokebyNum(data);
        }
    };
    //4. Send the request to server
    xhr.send();//GET requests to recieve data
    //xhr.send(data);//POST
    }
    
    function addJokebyNum(data){
        var jokefieldByNumber=document.getElementById("jokefieldByNumber");
        jokefieldByNumber.innerHTML=data.value.joke;
    }

    function truthyFalsly(x){
        if (x == truthy){
            console.log( x + " " + " is truthy")
        }else if (x == falsy){
            console.log(x + " "+" is falsy")
        }
    }

    document.write(truthyFalsly(null));