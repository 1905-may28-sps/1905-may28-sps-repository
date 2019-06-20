
window.onload = function () {
    document.getElementById("register").addEventListener("click", register);
    document.getElementById("username").addEventListener("blur", validateUserName);
    document.getElementById('goToLogin').addEventListener("click", showLoginView)


}
function validateUserName() {
    var username = document.getElementById('username').value;
    /*Using AJAX - we are going to send a get request to our JSON server to see if any
    users exist with the username we know that if no user exists, our respnse body will be an empty
    array, and if a user exists we will get back an array with a user object
    */
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4) {
            console.log(xhttp.status);
            var userArr = JSON.parse(xhttp.responseText);
            if (userArr.length == 0) {
                document.getElementById('message').innerHTML = "";
                document.getElementById('register').removeAttribute('disabled');

            } else {
                //username is taken. Must let user know and disable out button
                document.getElementById("message").innerHTML = "Sorry, username has been taken";
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
        lastName: document.getElementById("lastname").value,
        username: document.getElementById("username").value,
        password: document.getElementById("password").value,

    }

    var empty = false;
    for (let prop in userObj) {
        if (userObj[prop] == null || userObj[prop].trim() == '') {
            empty = true;
            document.getElementById('message').innerHTML =
                'sorry, please fill out form completely'

        }
    }
    if (empty == false) {
        //send request and clear message field
        document.getElementById('message').innerHTML = '';
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            //process response -- after we make sure the user was created, we go
            //to a new page
            if (xhr.readyState == 4) {
                console.log(xhr.status);

                showLoginView();
            }
        }
        xhr.open('POST', 'http://localhost:3000/users');
        xhr.setRequestHeader('Content-Type', 'application/json');

        //This send method is sending out user as a JSON string in the POST req body
        xhr.send(JSON.stringify(userObj));
    }


}
function showLoginView() {
    document.getElementById('registrationForm').remove();
    document.getElementById('loginForm').removeAttribute('hidden');
    document.getElementById("login").addEventListener("click", login);

}

function login() {

    var name = document.getElementById("logUser").value;
    var pass = document.getElementById("logPass").value;

    if (name == null || name.trim() == '' || pass == null || pass.trim() == '') {
        document.getElementById('message1').innerHTML =
            'Please Fill Out All Spaces'
    }
    else {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                console.log(xhr.status);
                var userArr = JSON.parse(xhr.responseText);
                if (userArr.length == 0) {
                    document.getElementById("message1").innerHTML = "Username Not Found";
                    
                }
                else{
                    if(userArr[0].password == pass) {
                        document.getElementById("message1").innerHTML = "Login Success"
                        console.log("login successful");
                    }
                    else{
                        document.getElementById("message1").innerHTML = "Wrong Password";                    }
                    
                    
                }
            }
        }

        xhr.open("GET", `http://localhost:3000/users?username=${name}`);
        xhr.send();
        
    }
}
