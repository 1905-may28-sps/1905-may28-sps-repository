window.onload = function(){
    console.log('app.js loaded');
    loadLoginView();
}

function loadLoginView(){
    /*
    This function will send a request to our load view servlet 
    and the responsetext will be the HTML partial view of our 
    login page. 

    Inside of the onreadystatechange function, we will make the 
    innerHTML of the #view div to be the response text, making 
    our page complete with our login view 

    After we set the innerHTML, we then add event listeners to the 
    view so that we can have dynamic functionality 
    */

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 ){
            if(xhr.status == 200){
                console.log('loaded login view');
                $('#view').html(xhr.responseText);
               
                //ADD EVENT LISTENER TO LOGIN PAGE SO WE CAN DO THINGS WITH IT
                
                $('#doLogin').on('click', login);
                $('#goToRegister').on('click', loadRegisterView);
            } else if (xhr.status >= 500){
                console.log('server error');
            }

        }
    }
    xhr.open('GET', 'login.view');
    xhr.send();
}


function loadRegisterView(){
	/*
	 * does same thing as load login view just for register page
	 */
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 ){
            if(xhr.status == 200){
                $('#view').html(xhr.responseText);
                $('#addUser').on('click', register);
                $('#goToLogin').on('click', loadLoginView);
            } else if (xhr.status >= 500){
                console.log('server error');
            }

        }
    }
    xhr.open('GET', 'register.view');
    xhr.send();
}


function login(){
	console.log('login user function');
	var user = {
			username: $('#username').val(),
			password: $('#password').val()
	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				console.log('logged in user' );
				var user = JSON.parse(xhr.responseText);
				//do stuff w user if you want
				loadHomePage();
			}
			else if(xhr.status == 204){
				$('#message').html('Sorry, invalid credentials! Please try again');
			}
		}
	}
	xhr.open('POST', 'login');
	xhr.send(JSON.stringify(user));
}

function register(){
	console.log('register user function');
}

function loadHomePage(){
	console.log('load home function');
	
}