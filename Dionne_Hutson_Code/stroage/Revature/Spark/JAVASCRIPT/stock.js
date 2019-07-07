

window.onload=function(){
    document.getElementById('portBut').addEventListener('click', portfolio);
    document.getElementById('portViewBut').addEventListener('click',getPortfolio);
    
    

    document.getElementById('nah').addEventListener('click',getBasicPort);


    document.getElementById('icon').addEventListener('click',showPort);
    document.getElementById('stockName').addEventListener('click',validateUsername);
    
    
}

function validateUsername(){
    var username = document.getElementById('username').value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        console.log(xhr.readyState);
        if(xhr.readyState == 4){
            //here, we can process response
            console.log(xhr.status);
            var userArr = JSON.parse(xhr.responseText);
            if(userArr.length == 0){
                //no user w username exists. we're
                
                
                document.getElementById('portBut').removeAttribute('disabled');
            }
            else{
                //username is taken. must let user know and disable our button
                document.getElementById('message').innerHTML = 'Sorry, that username is taken! Please try again!'; 
                    
                document.getElementById('portBut').setAttribute('disabled', "true");
            }
        }
    }
    xhr.open("GET", `http://localhost:4000/portfolio?username=${username}`);
    xhr.send();
}
function portfolio(){
    //geting my variables from profile
    var portObj={
    name : document.getElementById('name').value,
    username : document.getElementById('username').value,
    stockName : document.getElementById('stockName').value,
    stockSymbol : document.getElementById('stockSymbol').value,
    numShare: document.getElementById('numShare').value,
    pps : document.getElementById('pps').value,
    password :document.getElementById('password').value
    }
    //
    //AJAX
    var xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4){
          var arr=JSON.parse(xhr.responseText); 
                 
          
        }

    }
    xhr.open("POST",'http://localhost:4000/portfolio');
    xhr.setRequestHeader('Content-Type','application/json');
    xhr.send(JSON.stringify(portObj));



}
function getPortfolio(){
    alert("Welcome, your profile has been created, please log in");
    var user= document.getElementById('logName').value;
    var pass= document.getElementById('logPass').value;

    var xhrs = new XMLHttpRequest();
            xhrs.onreadystatechange = function(){
                if(xhrs.readyState == 4){
                    var userArr = JSON.parse(xhrs.responseText);
                    if(userArr.length == 1){
        
                        if(pass==userArr[0].password){
                            console.log("WHooo");
                         portView(userArr[0].name,userArr[0].stockName,userArr[0].stockSymbol,userArr[0].numShare,userArr[0].pps);
                            
                        }else{
                            alert("Invalid Password");
                        }
                    }    
               else{
                        
                        alert( 'Sorry, that username is does not exsist try again or create account.');
                        
                  
                        }
                     }
            }



    xhrs.open("GET",`http://localhost:4000/portfolio?name=${user}`);
    xhrs.send();
}
function getBasicPort(){
    document.getElementById('portFill').remove();
    document.getElementById('portLog').remove();
    document.getElementById('portView').removeAttribute('hidden');


}
function portView(portName,portSName,portSym,portNum,portPPS){
    
    getBasicPort();


    document.getElementById('nameView').innerHTML=portName+ " Your primary investment is in: "+(portSName);
    let a= Number(portNum);
    let b=Number(portPPS);
    document.getElementById('stockSymView').innerHTML="Your cost basis in "+portSym+" is $"+((a*b).toFixed(2));
   


}
function showPort(){
    document.getElementById('heading').removeAttribute('hidden');

}