window.onload = function () {
    document.getElementById('addToPort')
        .addEventListener('click', function () {
            if (document.getElementById('name').value != "" && document.getElementById('stock').value != "") {
                var shares = prompt("Enter the # of shares");

                var name = document.getElementById('name').value;
                var stock = document.getElementById('stock').value;

                var cell1 = document.createElement("td");
                var cell2 = document.createElement("td");

                cell1.innerHTML = name.toUpperCase();
                cell2.innerHTML = stock.toUpperCase();

                var row = document.createElement("tr");
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
                            $("td").on('dblclick',function(){
                                a=$(this).clone();
                                console.log(a);
                                console.log(typeof a);
                                $('#heading').append(a);
                                console.log(typeof this);
                                console.log(this);
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

                function updateTable(stock) {
                    var cell3 = document.createElement("td");
                    var cell4 = document.createElement("td");
                    var cell5 = document.createElement("td");
                    var cell6 = document.createElement("td");
                    var price = Number(stock["Global Quote"]["05. price"]);
                    cell3.innerHTML = Math.round(price * 100) / 100;
                    cell4.innerHTML = shares;
                    cell5.innerHTML = Math.round(price * 100) / 100 * shares;
                    cell6.innerHTML = 0;
                    row.appendChild(cell3);
                    row.appendChild(cell4);
                    row.appendChild(cell5);
                    row.appendChild(cell6);
                        updateStock(name,stock,shares,price);
                   
                

                }
               
            }
        })



    document.getElementById('addStock')
        .addEventListener('click', function () {
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
        })
    document.getElementById('refresh')
        .addEventListener('click', function () {
            var stockId = document.getElementById("stockTable").rows[1].cells[1].innerHTML
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
                        document.getElementById("stockTable2").rows[i].cells[5].innerHTML = (Math.round((price * shares) *100)/100- cost).toFixed(2);
                    }
                }

            }
        })
      var logName=document.getElementById('logName').value;  
               
    function updateStock(name,stock,share,price){
        
                console.log(logName);
         
             //geting my variables from profile
    let portObj={
    stock:{
    stockName : name,
    stockSymbol : stock,
    numShare: share,
    pps : price
    }
   
    };
    //
    //AJAX
    var xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4){
          console.log("put");       
          
        }

    }
    xhr.open("PUT",`http://localhost:3000/portfolio/?username=${logName}/`);


    xhr.setRequestHeader('Content-Type','application/json');
    xhr.send(JSON.stringify(portObj));
 }


      

                
        
        
        
        
        
        
        







        ////////
    document.getElementById('portBut').addEventListener('click', portfolio);
    document.getElementById('portViewBut').addEventListener('click',getPortfolio);
    
    

    document.getElementById('nah').addEventListener('click',getBasicPort);


    document.getElementById('mainPort').addEventListener('click',showPort);
    document.getElementById('username').addEventListener('mouseout',validateUsername);
    
   
}

///
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
       
        }
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



    xhrs.open("GET",`http://localhost:3000/portfolio?username=${user}`);
    xhrs.send();
}
function getBasicPort(){
    document.getElementById('portFill').remove();
    document.getElementById('portLog').remove();
    document.getElementById('portView').removeAttribute('hidden');
    document.getElementById('stockInfo').removeAttribute('hidden');


}
function portView(portName,portSName,portSym,portNum,portPPS){
    
    getBasicPort();
    let a= Number(portNum);
    let b=Number(portPPS);

    document.getElementById('heading').innerHTML=portName+ " Your primary investment is in: "+(portSName)+" Your cost basis in "+portSym+" is $"+((a*b).toFixed(2));
   
}
function showPort(){
    document.getElementById('heading').removeAttribute('hidden');

}
