window.onload = function () {
    //make an event listener for register button
    document.getElementById('register').addEventListener('click', register);
    document.getElementById('username').addEventListener('blur', validateUsername);
    document.getElementById('goToLogin').addEventListener('click', showLoginView);
    
}

function validateUsername() {
    var username = document.getElementById('username').value;



    //Using AJAX --
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4) {
            console.log(xhttp.status);
            var user = JSON.parse(xhttp.responseText);
            if (user.length == 0) {
                document.getElementById('message').innerHTML =
                    '';
                document.getElementById('register').setAttribute('disabled')
            }
            else {
                document.getElementById('message').innerHTML =
                    "Sorry this username is already taken, try again.";
                document.getElementById('register').setAttribute('disabled', "true")
            }

        }
    }
    xhttp.open("GET", `http://localhost:3000/users?username=${username}`);
    xhttp.send();


}

//call a function that obtains all fields from input
function register() {


    var user = {
        firstName: document.getElementById('firstname').value,
        lastName: document.getElementById('lastname').value,
        username: document.getElementById('username').value,
        password: document.getElementById('password').value


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
        //send request and clear message field
        document.getElementById('message').innerHTML = '';

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            //process response

            if (xhr.readyState == 4) {
                console.log(xhr.status);
                showLoginView();

            }
        }
        xhr.open('POST', 'http://localhost:3000/users');

        xhr.setRequestHeader('content-Type', 'application/json');

        //this method is sending our user as a JSON string in POST req body
        xhr.send(JSON.stringify(user));

    }
    console.log(JSON.stringify(user));
}


function showLoginView() {
    document.getElementById('registrationForm').remove();
    document.getElementById('loginForm').removeAttribute('hidden');
    //add listener for login buttom
    document.getElementById('login').addEventListener('click', login);

}

function login() {
         /*
        This function will retrieve user by username, then compare password 
        if no user w username exists, simply let user know theire credentials are invalid
        if user exists but pw doesnt match, do the same thing
        if user exists and password DOES match, console.log success, we will 
        later make a homepage for the user

        */ var name = document.getElementById('logUser').value;
    var pass = document.getElementById('logPass').value;
                
    if (name == null || name.trim() == '' || pass == null || pass.trim() == '') {
        // must fill out form, add message to dom
        document.getElementById('messagelog').innerHTML =
        'Sorry blah blah';

    }

    else {
        //send request 
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                //get user 
                //validate to see if exists. if no, incorect login
                //if yes, check password     console.log(xhttp.status);
          
            }
        }

        xhr.open('GET', `http://localhost:3000/users?username=${name}`);

        xhr.send();


    }
}
