window.onload = function(){
    //make an event listener for register button
    //call a function that obtains all fields from inputs
    //make an object with these fields. stringify it. print it to console
    document.getElementById('register').addEventListener('click', register);

}

function register(){

    var userObj = {
        firstName : document.getElementById('firstname').value,
        lastName : document.getElementById('lastname').value,
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    }
    console.log(JSON.stringify(userObj));
}