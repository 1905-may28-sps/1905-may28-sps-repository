window.onload = function () {
    //for home view create a link to get to order view
          
        document.getElementById('orderButton').addEventListener('click',login);
        totalLiqCost=0;
        totalJuiCost=0;
        totalSodCost=0;
        totalTyCost=0;
        total=0;
        liquor();
        juice();
        soda();
        type();
        startOver();
        order();
        document.getElementById('submitForm').addEventListener('click',contact);

    }
    //secret login... look for something fun
    function login() {
    //button listener
    
        var name = document.getElementById('logUser').value;
        var pass = document.getElementById('logPass').value;
    
        if (name == null || name.trim() == '' || pass == null || pass.trim() == '') {
            // must fill out form, add message to dom
            document.getElementById('messagelog').innerHTML =
            'No codename, no password no Access! ';
        }
        else{
    
            var xhr = new XMLHttpRequest();
    
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4) {
                    //get patron
                    var patrons = JSON.parse(xhr.responseText);
                    if (patrons.length == 0) {
                        document.getElementById('messagelog').innerHTML= 'Wrong codename';
                    }
                    else{

                        if (patrons[0].password ==pass) {

                           document.getElementById('modalLoginForm').remove();
                           document.getElementById('loginBut').remove();
                            document.getElementById('carouselExampleSlidesOnly').remove();
                           document.getElementById('mixTable').removeAttribute("hidden");
                        }
                        else{
                        document.getElementById('messagelog').innerHTML= "What's the password?";
                        }
                    }            
                }            
            }
                xhr.open('GET', `http://localhost:3000/patrons?codeName=${name}`);
                xhr.send();
        }
    }


    function liquor() {
    
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var liquors = JSON.parse(xhr.responseText);
                console.log(liquors);
                for (let liq of liquors) {
                    var li = $(`<li id="liquor${liq.id}" cost=${liq.price}>${liq.type}</li>`);
                    //then append to list
                    $('#liquor').append(li);
                }
                //after you create list items
                $('#liquor').on('click', 'li', function () {
                    $('.drink').append(this);
                    var id = $(this).attr('id');
                    var cost = $(this).attr('cost');
                    console.log(id);
                    console.log(cost);
                    //this will be your liquor ID
                    currCostL = $('#liquorCost').html();
                    let total = Math.floor(currCostL) + Math.floor(cost); //make this a number, not a string
                    console.log(total);
                    $('#liquorCost').html(total);
                    totalLiqCost=total;
                })
            }
        }
        xhr.open('GET', `http://localhost:3000/liquor`);
        xhr.send();
    }
    
    function juice() {
    
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var juice = JSON.parse(xhr.responseText);
                console.log(juice);
                for (let jui of juice) {
                    var li = $(`<li id="juice${jui.id}" cost=${jui.price}>${jui.name}</li>`);
                    //then append to list
                    $('#juice').append(li);
                }
                //after you create list items
                $('#juice').on('click', 'li', function () {
                    $('.drink').append(this);
                    var id = $(this).attr('id');
                    var cost = $(this).attr('cost');
                    console.log(id);
                    console.log(cost);
                    //this will be your juice ID
                    currCostJ = $('#juiceCost').html();
                    let total = Math.floor(currCostJ) + Math.floor(cost); //make this a number, not a string
                    console.log(total);
                    $('#juiceCost').html(total);
                    totalJuiCost=total;
                })
            }
        }
        xhr.open('GET', `http://localhost:3000/juice`);
        xhr.send();
    }
    
    function soda() {
    
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var soda = JSON.parse(xhr.responseText);
                console.log(soda);
                for (let sod of soda) {
                    var li = $(`<li id="soda${sod.id}" cost=${sod.price}>${sod.name}</li>`);
                    //then append to list
                    $('#soda').append(li);
                }
                //after you create list items
                $('#soda').on('click', 'li', function () {
                    $('.drink').append(this);
                    var id = $(this).attr('id');
                    var cost = $(this).attr('cost');
                    console.log(id);
                    console.log(cost);
                    //this will be your soda ID
                    currCostS = $('#sodaCost').html();
                    let total = Math.floor(currCostS) + Math.floor(cost); //make this a number, not a string
                    console.log(total);
                    $('#sodaCost').html(total);
                    totalSodCost=total;
                })
            }
        }
        xhr.open('GET', `http://localhost:3000/soda`);
        xhr.send();
    }
    
    function type() {
    
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var type = JSON.parse(xhr.responseText);
                console.log(type);
                for (let ty of type) {
                    var li = $(`<li id="type${ty.id}" cost=${ty.price} photo=${ty.img} name=${ty.name}>${ty.name}</li>`);
                    //then append to list
                    $('#type').append(li);
                }
                //after you create list items
                $('#type').on('click', 'li', function () {
                    $('.drink').append(this);
                    var id = $(this).attr('id');
                    var cost = $(this).attr('cost');
                    photoType = $(this).attr('photo');
                    photoName = $(this).attr('name');
                    console.log(id);
                    console.log(cost);
                    console.log(photoType);
                    //this will be your type ID
                    currCostT = $('#typeCost').html();
                    let total = Math.floor(currCostT) + Math.floor(cost); //make this a number, not a string
                    console.log(total);
                    $('#typeCost').html(total);
                    totalTyCost=total;
                })
            }
        }
        xhr.open('GET', `http://localhost:3000/type`);
        xhr.send();
    }
    
    function startOver() {
    document.getElementById("reset").addEventListener('click',reset);
    }
    
    function reset(){
        // location.href = "mix.html";
        $(".refreshTable").empty();
        $("#removeDrink").empty();
        $("#orderSummary").attr("hidden","true");
        totalLiqCost=0;
        totalJuiCost=0;
        totalSodCost=0;
        totalTyCost=0;
        total=0;
        currCostL = $('#liquorCost').html(0);
        liquorRefresh();
        currCostJ = $('#juiceCost').html(0);
        juiceRefresh();
        currCostS = $('#sodaCost').html(0);
        sodaRefresh();
        currCostT = $('#typeCost').html(0);
        typeRefresh();
    }
    
    function order(){
        document.getElementById("order").addEventListener('click',orderSummary);
    }
    
    function orderSummary(){
        //right here
        document.getElementById("orderSummary").removeAttribute("hidden");
        document.getElementById("photoType").src=photoType;
        document.getElementById("totalCost").innerHTML=totalLiqCost+totalJuiCost+totalSodCost+totalTyCost;
    }

    function liquorRefresh() {
    
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var liquors = JSON.parse(xhr.responseText);
                console.log(liquors);
                for (let liq of liquors) {
                    var li = $(`<li id="liquor${liq.id}" cost=${liq.price}>${liq.type}</li>`);
                    //then append to list
                    $('#liquor').append(li);
                }
            }
        }
        xhr.open('GET', `http://localhost:3000/liquor`);
        xhr.send();
    }
    
    function juiceRefresh() {
    
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var juice = JSON.parse(xhr.responseText);
                console.log(juice);
                for (let jui of juice) {
                    var li = $(`<li id="juice${jui.id}" cost=${jui.price}>${jui.name}</li>`);
                    //then append to list
                    $('#juice').append(li);
                }
            }
        }
        xhr.open('GET', `http://localhost:3000/juice`);
        xhr.send();
    }
    
    function sodaRefresh() {
    
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var soda = JSON.parse(xhr.responseText);
                console.log(soda);
                for (let sod of soda) {
                    var li = $(`<li id="soda${sod.id}" cost=${sod.price}>${sod.name}</li>`);
                    //then append to list
                    $('#soda').append(li);
                }
            }
        }
        xhr.open('GET', `http://localhost:3000/soda`);
        xhr.send();
    }
    
    function typeRefresh() {
    
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var type = JSON.parse(xhr.responseText);
                console.log(type);
                for (let ty of type) {
                    var li = $(`<li id="type${ty.id}" cost=${ty.price} photo=${ty.img} name=${ty.name}>${ty.name}</li>`);
                    //then append to list
                    $('#type').append(li);
                }
            }
        }
        xhr.open('GET', `http://localhost:3000/type`);
        xhr.send();
    }

    //testing contact page
    //testing contact page

window.onload=function(){

    

}

    function contact() {





        var user = {

            firstName: document.getElementById('firstname').value,

        middleName: document.getElementById('middlename').value,

        lastName: document.getElementById('lastname').value,

        age: document.getElementById('age').value,

        email: document.getElementById('email').value,

        gender: document.getElementById('gender').value,

    

    

        }

        var empty = false;

        for (let prop in user) {

            if (user[prop] == null || user[prop].trim() == '') {

                empty = true;

                document.getElementById('contactMessage').innerHTML =

                    'Sorry, please fill out form completely';

                // document.getElementById('register').setAttribute('disabled', "true");

    

            }

    

    

        }

        if (empty == false) {

            //send request and clear message field

            //document.getElementById('message').innerHTML = '';

    

            var xhr = new XMLHttpRequest();

            xhr.onreadystatechange = function () {

                //process response

    

                if (xhr.readyState == 4) {

                    console.log(xhr.status);

                    //showLoginView();

    

                }

            }

            xhr.open('POST', 'http://localhost:3000/contact');

    

            xhr.setRequestHeader('content-Type', 'application/json');

    

            //this method is sending our user as a JSON string in POST req body

            xhr.send(JSON.stringify(user));

    

        }

        console.log(JSON.stringify(user));

    }
