window.onload = function () {
    document.getElementById('formSubmit').addEventListener('click', register);
    document.getElementById('username').addEventListener('blur', validation);
    document.getElementById('goToLogin').addEventListener('click', showLoginPage);
    document.getElementById('login').addEventListener('click', showBattlePage);
}




function register() {
    console.log("something");

    var trainerObj = {
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        town: document.getElementById('town').value,
        userName: document.getElementById('username').value,
        password: document.getElementById('password').value,
    }
    var empty = false;
    for (let prop in trainerObj) {
        if (trainerObj[prop] == null || trainerObj[prop].trim() == '') {
            empty = true;
            window.alert('Sorry, please fill out form completely');
        }
    }
    if (empty == false) {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                console.log(xhr.status);
                showLoginPage();
            }
        }
        xhr.open('POST', 'http://localhost:3020/trainers');

        xhr.setRequestHeader('Content-Type', 'application/json');

        xhr.send(JSON.stringify(trainerObj));

    }
}

function showBattlePage() {


    var trainer1Success = false;
    var trainer2Success = false;
    var trainer1 = document.getElementById('logTrainer1').value;
    var trainer2 = document.getElementById('logTrainer2').value;
    var password1 = document.getElementById('logPassword1').value;
    var password2 = document.getElementById('logPassword2').value;

    localStorage.trainer1 = JSON.stringify(trainer1);
    localStorage.trainer2 = JSON.stringify(trainer2);

    if (trainer1 == null || trainer1.trim() == '' || password1 == null || password1.trim() == '') {
        window.alert('Trainer 1 username or password needs to be filled out correctly!');
    } else if (trainer2 == null || trainer2.trim() == '' || password2 == null || password2.trim() == '') {
        window.alert('Trainer 2 username or password needs to be filled out correctly!');
    } else {
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var userArr = JSON.parse(xhr.responseText);

                for (var i = 0; i < userArr.length; i++) {
                    if (userArr[i].username == trainer1) {
                        if (userArr[i].password == password1) {
                            trainer1Success = true;
                            break;
                        }
                        trainer1Success = false;
                    }
                }

                for (var i = 0; i < userArr.length; i++) {
                    if (userArr[i].username == trainer2) {
                        console.log(userArr[i].username);
                        if (userArr[i].password == password2) {
                            trainer2Success = true;
                            console.log(trainer2 + 'is ready');
                            break;
                        }
                        trainer2Success = false;
                    }
                }

                if (trainer1Success == false && trainer2Success == false) {
                    window.alert('Both Trainers username and or password is incorrect!');
                }
                else if (trainer2Success == false && trainer1Success == true) {
                    window.alert('Sorry, Trainer 2 username and or password is incorrect!');
                } else if (trainer1Success == false && trainer2Success == true) {
                    window.alert('Sorry, Trainer 1 username and or password is incorrect!');
                } else if (trainer2Success == true && trainer1Success == true) {
                    window.location = '/Users/housleydankwah/Desktop/Spark/Pokemon Revature/Pewter_Gym.html';
                }
            }
        }

        xhr.open('GET', `http://localhost:3020/trainers`);
        xhr.send();


    }
}

// function savetoLocalStorage(){
//     localStorageTrainer1 = document.getElementById('')
// }

function showLoginPage() {
    document.getElementById('registerationForm').remove();
    document.getElementById('loginForm').removeAttribute('hidden');
}

// function showBattlePage() {
//     window.location = '/Users/housleydankwah/Spark_Projects1/Pewter_Gym.html'
// }

function validation() {
    var username = document.getElementById('username').value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        console.log(xhr.readyState);
        if (xhr.readyState == 4) {
            console.log(xhr.status);
            var data = JSON.parse(xhr.responseText);
            console.log(data);
            console.log(data.length);
            if (data.length == 0) {
                console.log(data);
                document.getElementById('formSubmit').removeAttribute('disabled');
            } else {
                window.alert('This username is not available, Try another username!');
                document.getElementById('formSubmit').setAttribute('disabled', 'true');
            }
        }
    }

    xhr.open('GET', `http://localhost:3020/trainers?username=${username}`);
    xhr.send();
}
