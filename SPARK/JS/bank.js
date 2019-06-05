window.onload = function(){
    //make an event listener for register button
    //call a function that obtains all fields from inputs
    //make an object with these fields. stringify it. print it to console
    document.getElementById('register').addEventListener('click', register);
    document.getElementById('username')
        .addEventListener('blur', validateUsername);

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
            }
        }

        xhr.open('POST', 'http://localhost:3000/users');

        xhr.setRequestHeader('Content-Type', 'application/json');

        //this send method is sending our user as a JSON string in the POST req body
        xhr.send(JSON.stringify(userObj));

    }
}
