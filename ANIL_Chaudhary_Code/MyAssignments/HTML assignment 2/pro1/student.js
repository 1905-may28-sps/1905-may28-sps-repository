window.onload = function () {
    document.getElementById('register').addEventListener('click', register);
    document.getElementById('username').addEventListener('blur', validateUsername);
    document.getElementById('login').addEventListener('click', login)
}



function validateUsername() {
    var username = document.getElementById('username').value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        console.log(xhttp.readyState)
        if(xhttp.readyState == 4){
            console.log(xhttp.status);
            var userArr = JSON.parse(xhttp.responseText);
            if(userArr.length == 0){
                document.getElementById('message').innerHTML = '';
                document.getElementById('register').removeAttribute('disabled');
            }
            else{
                document.getElementById('message').innerHTML = 
                    'Sorry, that username is taken! Please try again!';
                document.getElementById('register').setAttribute('disabled', "true");
            }
        }
    }
    xhttp.open("GET", `http://localhost:3000/users?username=${username}`);
    xhttp.send();

}

function register() {

    var userObj = {
        firstName: document.getElementById('firstname').value,
        lastName: document.getElementById('lastname').value,
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    }

    //validate that fields are not empty 
    var empty = false;
    for (let prop in userObj) {
        if (userObj[prop] == null || userObj[prop].trim() == '') {
            empty = true;
            document.getElementById('message').innerHTML =
                'Sorry, please fill out form completely';
        }
    }
    if (empty == false) {
        document.getElementById('message').innerHTML = '';
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
                if (xhr.readyState == 4) {
                console.log(xhr.status);
                document.getElementById('message').innerHTML =
                'Registration Successful';
                
            }
        }

        xhr.open('POST', 'http://localhost:3000/users');

        xhr.setRequestHeader('Content-Type', 'application/json');

        //this send method is sending our user as a JSON string in the POST req body
        xhr.send(JSON.stringify(userObj));
        document.getElementById('register').setAttribute('disabled', "true");
    }
}



function showLoginView() {
    document.getElementById('registrationForm').remove();
    document.getElementById('loginForm').removeAttribute('hidden');
    //add listener for login button
    document.getElementById('login').addEventListener('click', login);
}

function login() {
    var name = document.getElementById('logUser').value;
    var pass = document.getElementById('logPass').value;

    if (name == null || name.trim() == '' || pass == null || pass.trim() == '') {
        // must fill out form, add message to dom

    }

    else {
        //send request 
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                                var userArr = JSON.parse(xhr.responseText);
                if (userArr.length == 0) {
                    document.getElementById('message1').innerHTML = 'User not found';
                } else {
                    console.log("username found");
                }
                       if (userArr[0].password == pass) {
                        showWelcome();
                        document.getElementById("welcomeMsg").innerHTML = userArr[0].firstName + userArr[0].lastName;
                        console.log('Login successful');

                    }
                    else {
                        document.getElementById('message1').innerHTML = 'Wrong password';
                    }
                }
            }
            function showWelcome(user){
            document.getElementById('loginForm').remove();
            document.getElementById('welcome').removeAttribute('hidden');
            console.log(user)
            document.getElementById("welcomeMsg").innerHTML = user.firstName +" " + user.lastName;
        }
        
        
        
        
        xhr.open('GET', `http://localhost:3000/users?username=${name}`);
        xhr.send();
    }
}
