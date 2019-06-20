window.onload = function(){
    //make an event listener for register button
    //call a function that obtains all fields from inputs
    //make an object with these fields. stringify it. print it to console
    document.getElementById('register').addEventListener('click', register);
    document.getElementById('username')
        .addEventListener('blur', validateUsername);
    document.getElementById('goToLogin').addEventListener('click', showLoginView );


    ///GOING TO START USING jQUERY FOR ELEMENT SELECTION! BE AWARE!
}

function validateUsername(){
    var username = document.getElementById('username').value;
    /* Using AJAX -- we are going to send a get request
    to our JSON server to see if any users exist with the username 
    we know that if no user exists, our response body will be 
    an empty array, and if a user exists we will get back 
    an array with a user object
    */

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        console.log(xhttp.readyState)
        if(xhttp.readyState == 4){
            //here, we can process response
            console.log(xhttp.status);
            var userArr = JSON.parse(xhttp.responseText);
            if(userArr.length == 0){
                //no user w username exists. we're good
                document.getElementById('message').innerHTML = '';
                document.getElementById('register').removeAttribute('disabled');
            }
            else{
                //username is taken. must let user know and disable our button
                document.getElementById('message').innerHTML = 
                    'Sorry, that username is taken! Please try again!';
                document.getElementById('register').setAttribute('disabled', "true");
            }
        }
    }
    xhttp.open("GET", `http://localhost:3000/users?username=${username}`);
    xhttp.send();

}

function register(){

    var userObj = {
        firstName : document.getElementById('firstname').value,
        lastName : document.getElementById('lastname').value,
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    }
    
    //validate that fields are not empty 
    var empty = false;
    for(let prop in userObj){
        if(userObj[prop] == null || userObj[prop].trim() == ''){
            empty = true;
            document.getElementById('message').innerHTML = 
            'Sorry, please fill out form completely';
        }
    }
    if(empty == false){
        //send request. and clear message field
        document.getElementById('message').innerHTML = '';

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function(){
            // process response -- after we make sure the user was created, we go to a new page
            if(xhr.readyState == 4){
                console.log(xhr.status);
                showLoginView();
            }
        }

        xhr.open('POST', 'http://localhost:3000/users');

        xhr.setRequestHeader('Content-Type', 'application/json');

        //this send method is sending our user as a JSON string in the POST req body
        xhr.send(JSON.stringify(userObj));

    }
}

function showLoginView(){
    document.getElementById('registrationForm').remove();
    document.getElementById('loginForm').removeAttribute('hidden');
    //add listener for login button
    document.getElementById('login').addEventListener('click', login);
}

  /* This function will retrieve user by username, then compare password 
    if no user w username exists, simply let user know theire credentials are invalid
    if user exists but pw doesnt match, do the same thing
    if user exists and password DOES match, console.log success, we will 
    later make a homepage for the user
*/
function login(){
  

    //get username and password from input fields 
    //make sure fields are not empty 
    //send request to get user by username, then validate the user

    var name = document.getElementById('logUser').value;
    var pass = document.getElementById('logPass').value;

    if(name == null || name.trim() == '' || pass == null || pass.trim() == ''){
        // must fill out form, add message to dom

    }
    
    else{
        //send request
        var xhr = new XMLHttpRequest();
        

        xhr.onreadystatechange = function(){
            if(xhr.readyState == 4){
                //get user 
                //validate to see if exists. if no, incorect login
                //if yes, check password
                var userArr = JSON.parse(xhr.responseText);
                if(userArr.length == 0){
                    $('#logMessage').html('Invalid credentials! Please Try again');
                }
                else{
                    if(userArr[0].password == pass){
                        loadHomePage(userArr[0]);
                    }
                    else{
                        $('#logMessage').html('Invalid credentials! Please Try again');
                    }
                }
            }
        }

        xhr.open('GET', `http://localhost:3000/users?username=${name}`);

        xhr.send();


    }
}

/*
Load user home page function 
- hide/remove login functionality 
- display user name 
- display user accounts 
- allow user to create new accoutns 
*/
function loadHomePage(user){
    $('#homePage').removeAttr('hidden');
    $('#loginForm').remove();
    $('#greeting').html(`Welcome, ${user.firstName} ${user.lastName}`);
    loadUserAccounts(user);


}

function loadUserAccounts(user){

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 ){
            /*
            Must do anything with accounts in this readtstatechange function 
            OR must call other functions from inside of here
            */
            console.log(xhr.status); //debug
            var accounts = JSON.parse(xhr.responseText);
            if(accounts.length == 0){
                $('$accountMessage').html = 'You have no accounts! Get banking!';
            }
            else{
                $('#accounts').removeAttr('hidden');
                //loop through each account
                for(let account of accounts){
                   let row = $(`<tr id=${account.id}>
                        <td> ${account.id}</td>
                        <td> ${account.balance}</td>
                        </tr>`)
                    $('#accounts').append(row);
                }
            }

            //add on click function to rows 
            $('#accounts').on('click', 'tr', function(){
                console.log($(this).attr('id'));
            })
        }
    }
    xhr.open('GET', `http://localhost:3000/accounts?userId=${user.id}`);
    xhr.send();

}