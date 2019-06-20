// GLOBAL VARS
let portfolio;


window.onload = function () {

    getForEx();

    var xhr = new XMLHttpRequest;
    xhr.onreadystatechange = function(portfolioData){

        
        if (xhr.readyState == 4){
            portfolioData = JSON.parse(xhr.responseText);

            console.log('PORTFOLIO DATA', portfolioData);

            lastID = portfolioData[portfolioData.length-1].id;
            
            lastEntry = portfolioData[portfolioData.length-1];

            console.log('LAST DATA', lastEntry);
            console.log('LAST DATA - usd', lastEntry.usd);
            // Display /DOM MANIPULATION TO SHOW PORTFOLIO
            $("#usd").append(lastEntry.usd);
            $("#jpy").append(lastEntry.jpy);
            $("#eur").append(lastEntry.eur); 
            $("#gbp").append(lastEntry.gbp);
            
            // EVENT LISTENERS FOR BUTTONS
            $("#buyJPY").on('click', buyJPY);
            $("#sellJPY").on('click', sellJPY);

            $("#buyEUR").on('click', buyEUR);
            $("#sellEUR").on('click', sellEUR);

            $("#buyGBP").on('click', buyGBP);
            $("#sellGBP").on('click', sellGBP);

            // GET Request to Exchange Rate API (might need to make request within window.onLoad function, not xhr.onreadystate)
            

        }
    }
    xhr.open("GET", "http://localhost:3000/portfolio");
    xhr.send();
    




}


// AJAX GET to Forex API + DOM Manipulation
function getForEx() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            console.log('READY');
            currencyData = JSON.parse(xhr.responseText);

            // console.log(currencyDataJPY);
            // DOM MANIPULATION
            // console.log(currencyData.rates.JPY)
            $("#jpyEx").html(currencyData.rates.JPY.toFixed(4));
            $("#eurEx").html(currencyData.rates.EUR.toFixed(4));
            $("#gbpEx").html(currencyData.rates.GBP.toFixed(4));
        } 

    }
    xhr.open("GET", "https://api.exchangeratesapi.io/latest?base=USD");
    xhr.send();
}


function buyJPY(){
    let buyJPYammount = parseFloat($("#buyOrSellInputJPY").val());
    console.log("buyJPY button clicked");
    console.log("USD Spent = " + buyJPYammount);
    let gbpExRate =  currencyData.rates.JPY
    console.log("USD => JPY = "+ gbpExRate);
    let newUSD = lastEntry.usd - buyJPYammount;
    console.log("New USD = " + newUSD);

    let newJPY = (parseFloat(lastEntry.jpy) + parseFloat((buyJPYammount) * gbpExRate)).toFixed(2);

    console.log('NEW JPY = ' + newJPY);

    // AJAX Post or Put Request to forex.json
    // perform AJAX POST to forEx.json
    // update exchange
    var objJPY = {
        usd: parseFloat(newUSD),
        jpy: parseFloat(newJPY),
        eur: parseFloat(lastEntry.eur),
        gbp: parseFloat(lastEntry.gbp),
        time: new Date().getTime()


    }
    
    console.log('objJPY', objJPY);

    post(objJPY);
    

}

function post(payload) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            console.log(xhr.status);
            console.log("POST request sent");

            //  update dom with response
            if (xhr.status >= 200 && xhr.status < 300) {

                // What do when the request is successful
                let resp =  JSON.parse(xhr.responseText);

                // update DOM
                updateDOM(resp);


            }
           
        } 
    }

    xhr.open("POST", "http://localhost:3000/portfolio");
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(payload));
    clearInputFields()
}

function updateDOM(resp) {
    // update last entry with response
    lastEntry = resp;

    console.log('RESP', resp);
    $("#usd").html('USD ' + resp.usd);
    $("#jpy").html('JPY ' + resp.jpy);
    $("#eur").html('EUR ' + resp.eur);
    $("#gbp").html('GBP ' + resp.gbp);
}

function sellJPY(){
    let sellJPYammountStr = parseFloat($("#buyOrSellInputJPY").val());
    console.log(sellJPYammountStr);
    console.log("sellJPY button clicked");
    console.log("JPY sold = " + sellJPYammountStr);
    let gbpExRate =  currencyData.rates.JPY
    console.log("JPY => USD "+ gbpExRate);
    let newJPY = lastEntry.jpy - sellJPYammountStr;

    console.log("New JPY = " + newJPY);
    // let newJPY = (parseFloat(lastEntry.jpy) + parseFloat((buyGBPammount) * gbpExRate)).toFixed(2);
    let newUSD = (parseFloat(lastEntry.usd) + parseFloat((sellJPYammountStr) / gbpExRate)).toFixed(2);

    // AJAX Post or Put Request to forex.json
    // perform AJAX POST to forEx.json
    // update exchange
    var objJPY = {
        usd: parseFloat(newUSD),
        jpy: parseFloat(newJPY),
        eur: parseFloat(lastEntry.eur).toFixed(2),
        gbp: parseFloat(lastEntry.gbp),
        time: new Date().getTime()

    }
    
    post(objJPY);

}


// Payload 

function buyEUR(){
    let buyEURammount = parseFloat($("#buyOrSellInputEUR").val());
    console.log("buyEUR button clicked");
    console.log("USD Spent = " + buyEURammount);
    let gbpExRate =  currencyData.rates.EUR;
    console.log("USD => EUR = "+ gbpExRate);
    let newUSD = lastEntry.usd - buyEURammount;
    console.log("New USD = " + newUSD);

    let newGBP = (parseFloat(lastEntry.eur) + parseFloat((buyEURammount) * gbpExRate)).toFixed(2);

    console.log('NEW JPY = ' + newGBP);

    var objJPY = {
        usd: parseFloat(newUSD),
        jpy: parseFloat(lastEntry.jpy),
        eur: parseFloat(newGBP),
        gbp: parseFloat(lastEntry.gbp),
        time: new Date().getTime()


    }
    
    console.log('objJPY', objJPY);
    post(objJPY);     

}


function sellEUR(){
    let sellEURammounts = parseFloat($("#buyOrSellInputEUR").val());
    // console.log(sellJPYammountStr);
    console.log("sellJPY button clicked");
    
    console.log("EUR sold = " + sellEURammounts);
    let gbpExRate =  currencyData.rates.EUR
    console.log("EUR => USD "+ gbpExRate);
    let newEUR = lastEntry.eur - sellEURammounts;

    console.log("New EUR = " + newEUR);
    // let newJPY = (parseFloat(lastEntry.jpy) + parseFloat((buyGBPammount) * gbpExRate)).toFixed(2);
    let newUSD = (parseFloat(lastEntry.usd) + parseFloat((sellEURammounts) / gbpExRate)).toFixed(2);

    // AJAX Post or Put Request to forex.json
    // perform AJAX POST to forEx.json
    // update exchange
    var objJPY = {
        usd: parseFloat(newUSD),
        jpy: parseFloat(lastEntry.jpy),
        eur: parseFloat(newEUR),
        gbp: parseFloat(lastEntry.gbp),
        time: new Date().getTime()

    }
    
    post(objJPY);

}



function buyGBP(){
    let buyGBPammount = parseFloat($("#buyOrSellInputGBP").val());
    console.log("buyJPY button clicked");
    console.log("USD Spent = " + buyGBPammount);
    let gbpExRate =  currencyData.rates.GBP
    console.log("USD => GBP = "+ gbpExRate);
    let newUSD = lastEntry.usd - buyGBPammount;
    console.log("New USD = " + newUSD);

    let newGBP = (parseFloat(lastEntry.gbp) + parseFloat((buyGBPammount) * gbpExRate)).toFixed(2);

    // console.log('NEW JPY = ' + newJPY);

    // AJAX Post or Put Request to forex.json
    // perform AJAX POST to forEx.json
    // update exchange
    var objJPY = {
        usd: parseFloat(newUSD),
        jpy: parseFloat(lastEntry.jpy),
        eur: parseFloat(lastEntry.eur),
        gbp: parseFloat(newGBP),
        time: new Date().getTime()


    }
    
    console.log('objJPY', objJPY);

    post(objJPY);
    

}

function sellGBP(){
    let sellGBPammounts = parseFloat($("#buyOrSellInputGBP").val());
    // console.log(sellJPYammountStr);
    console.log("sellJPY button clicked");
    
    console.log("GBP sold = " + sellGBPammounts);
    let gbpExRate =  currencyData.rates.GBP
    console.log("GBP => USD "+ gbpExRate);
    let newGBP = lastEntry.gbp - sellGBPammounts;

    console.log("New GBP = " + newGBP);
    // let newJPY = (parseFloat(lastEntry.jpy) + parseFloat((buyGBPammount) * gbpExRate)).toFixed(2);
    let newUSD = (parseFloat(lastEntry.usd) + parseFloat((sellGBPammounts) / gbpExRate)).toFixed(2);

    // AJAX Post or Put Request to forex.json
    // perform AJAX POST to forEx.json
    // update exchange
    var objJPY = {
        usd: parseFloat(newUSD),
        jpy: parseFloat(lastEntry.jpy),
        eur: parseFloat(lastEntry.eur),
        gbp: parseFloat(newGBP),
        time: new Date().getTime()

    }
    
    post(objJPY);

}








function clearInputFields(){

    $('#buyOrSellInputJPY').val('');
    $('#buyOrSellInputEUR').val('');
    $('#buyOrSellInputGBP').val('');

}

























































































































// // AJAX GET req to our jSON-Server which shows our portfolio
// function getPortfolio() {
//     var xhr = new XMLHttpRequest();
//     xhr.onreadystatechange = function () {
//         if (xhr.readyState == 4) {
//             console.log(xhr.status);
//             userArr = JSON.parse(xhr.responseText)
//             console.log(userArr);
//             // console.log(userArr[userArr.length-1].name);
//             $("#name").append(userArr[0].name);
//             $("#USD").append(userArr[0].usd);
//             $("#jpy").append(userArr[0].jpy);
//             $("#eur").append(userArr[0].eur);
//             $("#gbp").append(userArr[0].gbp);
//         } 
//     }
//     // var i = userArr.length-1;
//     // xhr.open("GET", 'http://localhost:3000/portfolio/?id=1');
//     xhr.open("GET", 'http://localhost:3000/portfolio/?id=1');

//     xhr.send();


// }

// AJAX GET request to ForEx API
// function getForEx() {
//     var xhr = new XMLHttpRequest();
//     xhr.onreadystatechange = function () {
//         if (xhr.readyState == 4) {
//             console.log('READY');
//             currencyData = JSON.parse(xhr.responseText);

//             // console.log(currencyDataJPY);
//             // DOM MANIPULATION
//             // console.log(currencyData.rates.JPY)
//             $("#jpyEx").html(currencyData.rates.JPY);
//             $("#eurEx").html(currencyData.rates.EUR);
//             $("#gbpEx").html(currencyData.rates.GBP);
//         } 

//         $("#buyJPY").on("click", buyJPY)
//         $("#buyEUR").on("click", buyEUR)
//         $("#buyGBP").on("click", buyGBP)
//     }
//     xhr.open("GET", "https://api.exchangeratesapi.io/latest?base=USD");
//     xhr.send();
// }


// function buyJPY() {
//     console.log("buyJPY clicked");
//     let buyGBPammount = $("#buyOrSellInputJPY").val();
//     let buyJPYammountNum = Number(buyGBPammount);
    
//     // Get Request to get new USD balance
//     // var xhr = new XMLHttpRequest;
//     // xhr.onreadystatechange = function(){
//     //     if(xhr.readyState == 4){
//     //         newPortfolio = JSON.parse(xhr.responseText)
//     //         console.log(newPortfolio);
//     //         return 


//     //     }
//     // }
//     // xhr.open("GET", 'http://localhost:3000/portfolio/?id=1');

//     // xhr.send();


    // // perform AJAX POST to forEx.json
    // var objJPY = {
    //     // WRONG NUMBER
    //     usd: buyJPYammountNum,
    //     // calculate correct exchange ammount
    //     jpy: buyJPYammountNum * currencyData.rates.JPY

    // }

    // var xhr = new XMLHttpRequest();
    // xhr.onreadystatechange = function () {
    //     if (xhr.readyState == 4) {
    //         console.log(xhr.status);
    //         console.log("POST request sent");
    //         getUSD();
    //         // getForEx();           
    //     } 
    // }

    // xhr.open("POST", "http://localhost:3000/portfolio/?id=1");
    // xhr.setRequestHeader('Content-Type', 'application/json');
    // xhr.send(JSON.stringify(objJPY));
    // // getForEx();  

// }

// function getUSD() {
//     var xhr = new XMLHttpRequest();
//     xhr.onreadystatechange = function () {
//         if (xhr.readyState == 4) {
//             // console.log('READY');
//             currencyData = xhr.responseText);
            
//             console.log("getUSD data: " + currencyData);
//             // return currencyData[0].usd;
  
//         } 

 
//     }
    
//     xhr.open("GET", "http://localhost:3000/portfolio/?id=1");
//     // xhr.open("GET", "https://api.exchangeratesapi.io/latest?base=USD");
//     xhr.send();
// }

// // buyEUR Function
// function buyEUR() {
//     console.log("buyJPY clicked");
//     let buyEURammountStr = $("#buyOrSellInputEUR").val();
//     let buyEURammountNum = Number(buyEURammountStr);
//     console.log(buyEURammountNum);

//     // perform AJAX POST to forEx.json
//     var objJPY = {
//         // WRONG NUMBER
//         usd: buyEURammountNum,
//         // calculate correct exchange ammount
//         eur: buyEURammountNum * currencyData.rates.EUR

//     }

//     // Get Request

//     // Post Req

//     var xhr = new XMLHttpRequest();
//     xhr.onreadystatechange = function () {
//         if (xhr.readyState == 4) {
//             console.log(xhr.status);
//             console.log("POST request sent") 
//             // getForEx();           
//         } 
//     }

//     xhr.open("POST", "http://localhost:3000/portfolio/?id=1");
//     xhr.setRequestHeader('Content-Type', 'application/json');
//     xhr.send(JSON.stringify(objJPY));
//     // getForEx();  

// }


// function buyGBP() {
//     console.log("buyGBP clicked");
//     let buyGBPammountStr = $("#buyOrSellInputGBP").val();
//     let buyGBPammountNum = Number(buyGBPammountStr);
//     console.log(buyGBPammountNum);

//     // perform AJAX POST to forEx.json
//     var objJPY = {
//         // WRONG NUMBER
//         usd: buyGBPammountNum,
//         // calculate correct exchange ammount
//         eur: buyGBPammountNum * currencyData.rates.GBP

//     }

//     var xhr = new XMLHttpRequest();
//     xhr.onreadystatechange = function () {
//         if (xhr.readyState == 4) {
//             console.log(xhr.status);
//             console.log("POST request sent")
//             // AJAX PUT REQUEST??? 
                       
//         } 
//     }

//     xhr.open("POST", "http://localhost:3000/portfolio/?id=1");
//     xhr.setRequestHeader('Content-Type', 'application/json');
//     xhr.send(JSON.stringify(objJPY));
//     // getForEx();  

// }






//  LOGIC FOR Buying Forex
// -  x(how much you want to buy in USD) * JPY = y (ammount purchased JPY)
//  New Balance - x = Balance;
// AJAX GET newPortfolio();


// Logic for Selling Forex
// x (how much you want to sell in JPY) * 