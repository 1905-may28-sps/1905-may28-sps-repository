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

function login(){
	
}

function loadRegisterView(){
	/*
	 * does same thing as load login view just for register page
	 */
}