window.onload = function(){
    document.getElementById('signup').addEventListener('click', signup);
    document.getElementById('empUsername').addEventListener('blur', validateUsername);
    document.getElementById('gotoLogin').addEventListener('click', showLoginView);
  }

function validateUsername(){
    var username = document.getElementById('empUsername').value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        console.log(xhttp.readyState);
        if (xhttp.readyState == 4){
            var userArr = JSON.parse(xhttp.responseText);
            console.log(userArr.length);
            if (userArr.length == 0 || userArr == null){
                document.getElementById('message').innerHTML = "";
                document.getElementById('signup').removeAttribute('disabled');
            }
            else {
                document.getElementById('message').innerHTML =
                    'Sorry, the username is already taken';
                document.getElementById('signup').setAttribute('disabled', "true");
            }
        }
    }
    xhttp.open('GET', `http://localhost:3000/employees?empUsername=${username}`);
    xhttp.send();
}

function signup(){
    var employeeObj = {
        empFirstname: document.getElementById('empFirstname').value,
        empLastname: document.getElementById('empLastname').value,
        empUsername: document.getElementById('empUsername').value,
        empPassword: document.getElementById('empPassword').value,
        email: document.getElementById('email').value,
        contact: document.getElementById('contact').value
    }
    //validate that fields are not empty
    var empty = false;
    for (let prop in employeeObj){
        if (employeeObj[prop] == null || employeeObj[prop].trim() == ""){
            empty = true;
            document.getElementById('message').innerHTML = 
            "Sorry, please fill out all the fields";
         } 
        }
    if(empty == false){
        document.getElementById('message').innerHTML = "";
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function(){
            if(xhr.readyState == 4){
                console.log(xhr.status);
                showLoginView();
            }
        }
            xhr.open('POST', 'http://localhost:3000/employees'); //Please use single quotes and do not use backtick.
            xhr.setRequestHeader('content-Type', 'application/json');
            xhr.send(JSON.stringify(employeeObj));
            //this send method is sending our user as a JSON string in the POST req body.
            console.log(JSON.stringify(employeeObj));
    }
}

    function showLoginView(){
       // $('#signUpForm').remove();
        document.getElementById('signUpForm').remove();
        document.getElementById('loginForm').removeAttribute('hidden');
        document.getElementById('login').addEventListener('click', login);
    }

    function login(){
        var name = document.getElementById('logusername').value;
        var pass = document.getElementById('logpassword').value;
        if(name == null || name.trim() =='' || pass == null || pass.trim() ==''){
            document.getElementById('message1').innerHTML = 
            "Must fill out both fields";
        }
        else{
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function(){
                if (xhr.readyState == 4){
                    var userArr = JSON.parse(xhr.responseText);
                    if(userArr.length == 0) {
                        console.log("Not a valid user");
                        document.getElementById('message1').innerHTML =
                         "Not a Valid User";
                    }
                    else{
                    if(userArr[0].empPassword == pass) {
                        console.log("Logged in Successfully");
                       // console.log(userArr[0].empFirstname);
                       // console.log(userArr[0].empLastname);
                        var fname = userArr[0].empFirstname;
                        var lname = userArr[0].empLastname;
                        document.getElementById('message1').innerHTML = "Logged in Successfully";
                        location.href = 'employeepage.html?name='+fname+'&lastname='+lname;  
                    }
                    else 
                       // console.log("Login Failed");
                        document.getElementById('message1').innerHTML = "Login Failed";
                }
            }
            }
        xhr.open('GET', `http://localhost:3000/employees?empUsername=${name}`);
        xhr.send();
    }
}
    



