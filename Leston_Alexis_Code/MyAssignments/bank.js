window.onload = function(){
    document.getElementById('register').addEventListener('click', register)
    document.getElementById('userName').addEventListener('blur', validateusername)
    document.getElementById('goToLogin').addEventListener('click', showLoginView );
}


function validateusername(){
    var username = document.getElementById( 'userName').value
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(xhttp.readyState == 4){
            console.log(xhttp.status);
            var userArr = JSON.parse(xhttp.responseText);
            if(userArr.length ==0){
                document.getElementById('message').innerHTML='';
                document.getElementById('register').removeAttribute('disabled');
            }
            else{ 
                document.getElementById('message').innerHTML='Sorry that username is taken, Please try again';
                document.getElementById('register').setAttribute('disabled', 'true');

            }
        }
    }
    xhttp.open("GET", `http://localhost:3000/users?userName=${username}`);
    xhttp.send();
}




function register(){
    
    
    var user= {
        firstName : document.getElementById('firstName').value,
        lastName : document.getElementById('lastName').value,
        userName : document.getElementById('userName').value,
        passWord : document.getElementById('passWord').value
    }
    var empty = false;
    for(let prop in user){
        if(user[prop] == null || user[prop].trim() == ''){
            empty = true;
            document.getElementById('message').innerHTML = 
            'Sorry, please fill out form completely';
            
        }
    }
    if(empty == false){
        document.getElementById('message').innerHTML = '';
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function(){
            if(xhr.readyState == 4){
                console.log(xhr.status);
                document.getElementById(registrationForm)
                showLoginView();
            }

        }

        xhr.open('POST', 'http://localhost:3000/users');

        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.send(JSON.stringify(user))
    }
console.log(JSON.stringify(user));
}


function showLoginView(){
    document.getElementById('registrationForm').remove();
    document.getElementById('loginForm').removeAttribute('hidden');
    //add listener for login button
    document.getElementById('login').addEventListener('click', login)
}

function login(){
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
                if(userArr.length ==0){
                    document.getElementById('message2').innerHTML='User does Not Exist';
                }
            else if(userArr[0].passWord == pass && userArr[0].userName ==name){
                     
                    console.log('login Success', userArr[0].firstName, userArr[0].lastName);
                }
            
        
            else{ document.getElementById('message3').innerHTML='login failed';}
            }
        }

        xhr.open('GET', `http://localhost:3000/users?username=${name}`);

        xhr.send();
    

}
}