window.onload = function () {



    document.getElementById('portBut').addEventListener('click', portfolio);
    document.getElementById('portViewBut').addEventListener('click',getPortfolio);
    
    

    document.getElementById('nah').addEventListener('click',getBasicPort);


    //document.getElementById('mainPort').addEventListener('click',showPort);
    document.getElementById('username').addEventListener('mouseout',validateUsername);
    ///
    document.getElementById('dropdownMenuButton').addEventListener('click',greeting);
    document.getElementById('netb').addEventListener('click',netf);
    

    document.getElementById('addToPort').addEventListener('click', addToPort);
    document.getElementById('addStock').addEventListener('click',addStock); 
    document.getElementById('refresh').addEventListener('click', refresh);




}
var user2="";
var addProfile=false;

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
                document.getElementById('message').innerHTML = 'Username Valid';
            }
            else{
                //username is taken. must let user know and disable our button
                document.getElementById('message').innerHTML = 'Sorry, that username is taken! Please try again!'; 
                    
                document.getElementById('portBut').setAttribute('disabled', "true");
            }
        }
    }
    xhr.open("GET", `http://localhost:3000/portfolio?username=${username}`);
    xhr.send();
}
function portfolio(){
    //geting my variables from profile
    var portObj={
        name : document.getElementById('name').value,
        username : document.getElementById('username').value,
         password :document.getElementById('password').value,
        stock:{
        stockName : document.getElementById('stockName').value,
        stockSymbol : document.getElementById('stockSymbol').value,
        numShare: document.getElementById('numShare').value,
        pps : document.getElementById('pps').value,
        net: document.getElementById('net').value,
        
        }
      
        };
       
        var xhr=new XMLHttpRequest();
        xhr.onreadystatechange=function(){
            if(xhr.readyState==4){
              var arr=JSON.parse(xhr.responseText); 
              alert("Welcome, your profile has been created, please log in");
                     
              
            }
    
        }

    
    xhr.open("POST",'http://localhost:3000/portfolio');
    xhr.setRequestHeader('Content-Type','application/json');
    xhr.send(JSON.stringify(portObj));



}

function getPortfolio(){
    
    var user= document.getElementById('logName').value;
    var pass= document.getElementById('logPass').value;
    
    var xhrs = new XMLHttpRequest();
            xhrs.onreadystatechange = function(){
                if(xhrs.readyState == 4){
                    var userArr = JSON.parse(xhrs.responseText);
                    if(userArr.length >= 1){
        
                        if(pass==userArr[0].password){
                            console.log("WHooo");
                            portView();
                         
                         console.log(userArr[0].stock.stockSymbol+"getPortfolio");
                         
                         addProfile=true;
                         
                        }else{
                            alert("Invalid Password");
                        }
                    }    
               else{
                        
                        alert( 'Sorry, that username is does not exsist try again or create account.');
                        
                  
                        }
                     }
user2=user;
                     console.log(user2);
            }



    xhrs.open("GET",`http://localhost:3000/portfolio?username=${user}`);
    xhrs.send();
    
}
function getBasicPort(){
    document.getElementById('portFill').remove();
    document.getElementById('portLog').remove();
    document.getElementById('portView').removeAttribute('hidden');
    document.getElementById('stockInfo').removeAttribute('hidden');


}

function greeting(){
    document.getElementById('heading').removeAttribute('hidden');
     document.getElementById('heading').innerHTML="Hello, "+user2;
     console.log(user2);
}

function netf(){
    document.getElementById('netv').removeAttribute('hidden');
    document.getElementById('netv').innerHTML="Your net gain since is: "+net2;
     console.log(net2+"in netunct");
}


function portView(){
    
    getBasicPort();
    addFromPort();

   
   
}


function addFromPort() {
    
            console.log(user2);
            let user3=user2;
            console.log(user3+"3");

    
        var xhrsh = new XMLHttpRequest();
        
                xhrsh.onreadystatechange = function(){
                    if(xhrsh.readyState == 4){

                        console.log("WHooo portyyy");
                        var userArr = JSON.parse(xhrsh.responseText);
                       
                                
                            
                             var row = document.createElement("tr");
                    
                             var cella = document.createElement("td");
                             var cellb = document.createElement("td");
                             let cellc=document.createElement("td");
                             let celld=document.createElement("td")
                             let celle=document.createElement("td");
                             let cellf=document.createElement("td");
                     
                     
                     
                             cella.innerHTML = userArr[0].stock.stockName.toUpperCase();
                             cellb.innerHTML =userArr[0].stock.stockSymbol.toUpperCase();
                            cellc.innerHTML = userArr[0].stock.numShare;
                             celld.innerHTML =userArr[0].stock.pps;
                             celle.innerHTML =userArr[0].stock.numShare*userArr[0].stock.pps;
                             cellf.innerHTML =userArr[0].stock.net;
                            
                             row.appendChild(cella);
                             row.appendChild(cellb);
                             row.appendChild(cellc);
                             row.appendChild(celld);
                             row.appendChild(celle);
                             row.appendChild(cellf);
                     
                     
                             document.getElementById('stockTable2').appendChild(row);
                            }else{
                                console.log("not ready");
                            }
                        }
    
    
        xhrsh.open("GET",`http://localhost:3000/portfolio?username=${user3}`);
        xhrsh.send();
                
                    }       
       
    


                    
function addToPort() {
    if (addProfile){
            if (document.getElementById('name').value != "" && document.getElementById('stock').value != "") {
                var shares = prompt("Enter the # of shares");
                    var row = document.createElement("tr");
                var name = document.getElementById('name').value;
                var stock = document.getElementById('stock').value;

                var cell1 = document.createElement("td");
                var cell2 = document.createElement("td");

                cell1.innerHTML = name.toUpperCase();
                cell2.innerHTML = stock.toUpperCase();

               
                row.appendChild(cell1);
                row.appendChild(cell2);

                document.getElementById('stockTable2').appendChild(row);

                var stockId = document.getElementById('stock').value;
                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4) {
                        if (xhr.status == 200) {
                            var stockText = xhr.responseText;
                            var stock = JSON.parse(stockText);
                            console.log(stock);
                            updateTable(stock)
                            $("tr").on('dblclick',function(){
                               /*  a=$(this).clone();
                                console.log(a);
                                console.log(typeof a); */
                                $(this).remove();
                                alert("SOLD!")
                            })

                        }
                        else if (xhr.status == 400) {
                            //client error
                            console.log("ERROR");
                        }
                    }
                }
                //STEP 3 - open request (configure it)
                xhr.open('GET', `https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=${stockId}&apikey=CP82O83O6KD742JD`);
                //STEP 4 - send request
                xhr.send();
                var price;

                function updateTable(stock) {
                    var cell3 = document.createElement("td");
                    var cell4 = document.createElement("td");
                    var cell5 = document.createElement("td");
                    var cell6 = document.createElement("td");
                    price = Number(stock["Global Quote"]["05. price"]);
                    cell3.innerHTML = Math.round(price * 100) / 100;
                    cell4.innerHTML = shares;
                    cell5.innerHTML = Math.round(price * 100) / 100 * shares;
                    cell6.innerHTML = 0;
                    row.appendChild(cell3);
                    row.appendChild(cell4);
                    row.appendChild(cell5);
                    row.appendChild(cell6);
                        
                   
                

                }
               // updateStock(name,stock,shares,price);
               
                    }
                }else{alert("Signup to add to portfolio");}
            }


    function addStock() {
            if (document.getElementById('name').value != "" && document.getElementById('stock').value != "") {
                var name = document.getElementById('name').value;
                var stock = document.getElementById('stock').value;

                document.getElementById('sN').innerHTML = name.toUpperCase();
                document.getElementById('sS').innerHTML = stock.toUpperCase();

                var stockId = document.getElementById('stock').value;
                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4) {
                        if (xhr.status == 200) {
                            var stockText = xhr.responseText;
                            var stock = JSON.parse(stockText);
                            console.log(stock);
                            updateTable(stock)

                        }
                        else if (xhr.status == 400) {
                            //client error
                            console.log("ERROR");
                        }
                    }
                }
                //STEP 3 - open request (configure it)
                xhr.open('GET', `https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=${stockId}&apikey=CP82O83O6KD742JD`);
                //STEP 4 - send request
                xhr.send();

                function updateTable(stock) {
                    //var cell3 = document.createElement("td");
                    var price = Number(stock["Global Quote"]["05. price"]);
                    document.getElementById('sP').innerHTML = Math.round(price * 100) / 100;
                    //cell3.innerHTML = price;
                    //row.appendChild(cell3);
                }
            } else
                window.alert("Enter 'Stock Name' and 'Stock ID'")
    }
var net2=0;
    function refresh() {
        

            var stockId = document.getElementById("stockTable").rows[1].cells[1].innerHTML;
            console.log(document.getElementById("stockTable").rows[1].cells[1].innerHTML+"row");
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4) {
                    if (xhr.status == 200) {
                        var stockText = xhr.responseText;
                        var stock = JSON.parse(stockText);
                        console.log(stock);
                        updateTable(stock)
                    }
                    else if (xhr.status == 400) {
                        //client error
                        console.log("ERROR");
                    }
                }
            }
            //STEP 3 - open request (configure it)
            xhr.open('GET', `https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=${stockId}&apikey=CP82O83O6KD742JD`);
            //STEP 4 - send request
            xhr.send();
            

            function updateTable(stock) {
                var price = Number(stock["Global Quote"]["05. price"]);
                document.getElementById("stockTable").rows[1].cells[2].innerHTML = (Math.round(price * 100) / 100).toFixed(2);
                for (let i = 1; i < document.getElementById("stockTable2").rows.length; i++) {
                    if (document.getElementById("stockTable2").rows[i].cells[1].innerHTML == stockId) {
                        var cost = document.getElementById("stockTable2").rows[i].cells[4].innerHTML
                        var shares = document.getElementById("stockTable2").rows[i].cells[3].innerHTML
                        var a=Number((Math.round((price * shares) *100)/100- cost).toFixed(2));
                        document.getElementById("stockTable2").rows[i].cells[5].innerHTML = a;
                        console.log(net2+"anet");
                        net2+=a;
                        console.log(net2+"a");
                        

                    }
                }

            }
        }

        
              
  
