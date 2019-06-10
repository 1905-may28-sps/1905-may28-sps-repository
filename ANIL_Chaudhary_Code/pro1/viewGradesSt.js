window.onload = function () {
    //  document.getElementById('getGrades').addEventListener('click', viewGrades)
    document.getElementById('login').addEventListener('click', login)
  //  document.getElementById('agree').addEventListener('click', agree) //agree doesnt exist
}



function validateUsername() {
    var username = document.getElementById('username').value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        console.log(xhttp.readyState)
        if (xhttp.readyState == 4) {
            console.log(xhttp.status);
            var userArr = JSON.parse(xhttp.responseText);
            if (userArr.length == 0) {
                document.getElementById('message').innerHTML = '';
                document.getElementById('login').removeAttribute('disabled');
            }
            else {
                document.getElementById('message').innerHTML =
                    'Sorry, that username is taken! Please try again!';
                document.getElementById('login').setAttribute('disabled', "true");
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
        //send request. and clear message field
        document.getElementById('message').innerHTML = '';

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            // process response -- after we make sure the user was created, we go to a new page
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

    }
}


function showLoginView() {
    //hide login fields
    document.getElementById('viewGrades').removeAttribute('hidden');
    //add listener for login button
    document.getElementById('viewGrades').addEventListener('click', viewGrades);
}

function login() {
    var name = document.getElementById('username').value;
    var pass = document.getElementById('password').value;

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
                    document.getElementById('message').innerHTML = 'User not found';
                } else {
                    console.log("username found");
                }
                if (userArr[0].password == pass) {
                    showWelcome();
                    document.getElementById("welcomeMsg").innerHTML = userArr[0].firstName + " " + userArr[0].lastName;
                    console.log('Login successful');
                    document.getElementById('message').innerHTML = 'Hello !';
                    document.getElementById('dataForm').removeAttribute('hidden');
                    document.getElementById('getGrades').addEventListener('click', viewGrades(userArr[0]));
                }
                else {
                    document.getElementById('message').innerHTML = 'Wrong password';
                }
            }
        }

        
        function showWelcome(user) {
            //document.getElementById('loginFormformData').remove();
            // document.getElementById('welcome').removeAttribute('hidden');
            //console.log(user)
            //document.getElementById("welcomeMsg").innerHTML = user.firstName +" " + user.lastName;
        }




        xhr.open('GET', `http://localhost:3000/users?username=${name}`);
        xhr.send();
    }
}

function viewGrades(user) {

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {

            console.log(xhr.status);
            var grades = JSON.parse(xhr.responseText);
            console.log(grades);

            for (let grade of grades) {
                let row = $(`<tr id=${grade.id}>
                        <td> ${grade.period}</td>
                       <td> ${grade.maths}</td>
                       <td> ${grade.english}</td>
                        <td> ${grade.computer}</td>

                </tr>`)
                $('#grades').append(row);
            }
        }

        //add on click function to rows 
        $('#grades').on('click', 'tr', function () {
            console.log($(this).attr('id'));
        })
    }

xhr.open('GET', `http://localhost:3000/grades?userId=${user.id}`);
xhr.send();

}


