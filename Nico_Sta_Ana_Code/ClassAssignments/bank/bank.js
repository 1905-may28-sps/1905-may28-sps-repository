window.onload = function () {
    // event listner on btn
    document.getElementById("register").addEventListener('click', submitForm);
    document.getElementById("username").addEventListener('blur', validateUsername);
    document.getElementById("goToLogin").addEventListener('click', showLoginView);
    document.getElementById("login").addEventListener('click', login);

    // call function that obtains all fields from inputs

    // make an object with these fields.  Stringify. Print to console
}


function submitForm() {
    console.log("clicked");
    register();
    validateUsername();
}

function showLoginView() {
    document.getElementById('registrationForm').remove();
    document.getElementById('loginForm').removeAttribute('hidden');
    //add listener for login button
    
}

function showWelcome(user){
    document.getElementById('loginForm').remove();
    document.getElementById('welcome').removeAttribute('hidden');
    console.log(user)
    document.getElementById("welcomeData").innerHTML = user.firstName +" " + user.lastName;


}


function login() {
    /*
    This function will retrieve user by username, then compare password 
    if no user w username exists, simply let user know theire credentials are invalid
    if user exists but pw doesnt match, do the same thing

    if user exists and password DOES match, console.log success, we will 
    later make a homepage for the user
    */

    //get username and password from input fields 
    //make sure fields are not empty 
    //send request to get user by username, then validate the user

    var name = document.getElementById('logUser').value;
    var pass = document.getElementById('logPass').value;

    if (name == null || name.trim() == '' || pass == null || pass.trim() == '') {
        // must fill out form, add message to dom
        document.getElementById('login').setAttribute('disabled', "true");
        console.log("Must fill out form");
        document.getElementById("messageLogin").innerHTML = "Please Fill Out form completely";

    } else {
        //send request 
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                //get user 
                console.log(xhr.status);
                var userArr = JSON.parse(xhr.responseText);
                console.log(userArr);
                //validate to see if exists. if no, incorect login
                if (userArr.length == 0) {
                    alert("No username exists");
                } else {
                    console.log("username found");
                    if (userArr[0].password == pass) {
                        console.log("login success")
                        // insert function to new page here
                        showWelcome(userArr[0]);
                        // document.getElementById("welcomeData").innerHTML = userArr[0].firstName + userArr[0].lastName;

                    } else {
                        console.log("password doesn't match")
                    }
                }

            }
        }

        xhr.open('GET', `http://localhost:3000/users?username=${name}`);

        xhr.send();


    }
}

function register() {
    var firstName = document.getElementById("firstName").value;
    var lastName = document.getElementById("lastName").value;
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    var user = {
        firstName: firstName,
        lastName: lastName,
        username: username,
        password: password
    }

    var empty = false;
    for (let prop in user) {
        if (user[prop] == null || user[prop].trim() == '') {
            empty = true;
            document.getElementById('message').innerHTML =
                'Sorry, please fill out form completely';
            // document.getElementById('register').setAttribute('disabled', "true");
        }
    }
    if (empty == false) {
        // send request and clear message field
        document.getElementById("message").innerHTML = "";
        var xhr = new XMLHttpRequest;
        xhr.onreadystatechange = function () {
            // process request
            if (xhr.readyState == 4) {
                console.log(xhr.status);
                // go to login page
                // document.getElementById("registrationForm").remove();
                showLoginView()
            }
        }
        xhr.open("POST", 'http://localhost:3000/users/');
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.send(JSON.stringify(user))
    }
    console.log(JSON.stringify(user));

}


function validateUsername() {
    var username = document.getElementById('username').value;
    /* Using AJAX -- we are going to send a get request
    to our JSON server to see if any users exist with the username 

    we know that if no user exists, our response body will be 
    an empty array, and if a user exists we will get back 
    an array with a user object
    */

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        console.log(xhttp.readyState)
        if (xhttp.readyState == 4) {
            //here, we can process response
            console.log(xhttp.status);
            var userArr = JSON.parse(xhttp.responseText);
            if (userArr.length == 0) {
                //no user w username exists. we're good
                document.getElementById('message').innerHTML = '';
                document.getElementById('register').removeAttribute('disabled');
            } else {
                //username is taken. must let user know and disable our button
                document.getElementById('message').innerHTML = "Sorry, that username is taken! Please try again!";
                document.getElementById('register').setAttribute('disabled', "true");
            }
        }
    }
    xhttp.open("GET", `http://localhost:3000/users?username=${username}`);
    xhttp.send();

}