window.onload = function () {
    // document.getElementById('male').addEventListener('click',getRadioValue);
    // document.getElementById('female').addEventListener('click',getRadioValue);
    // document.getElementById('others').addEventListener('click',getRadioValue);
    document.getElementById('submitForm').addEventListener('click',contact);
}

// function getRadioValue() {

//     if(document.getElementById('male').checked==true){
//         document.getElementById('male').value;
//     }
//     else if(document.getElementById('female').checked==true){
//         document.getElementById('female').value;
//     }
//     else{
//         document.getElementById('others').value;
//     }

// }

function contact() {

    var user = {

    firstName: document.getElementById('firstname').value,

    // middleName: document.getElementById('middlename').value,

    lastName: document.getElementById('lastname').value,

    age: document.getElementById('age').value,

    email: document.getElementById('email').value,

    // male: document.getElementById('male').value,

    // female: document.getElementById('female').value,

    // others: document.getElementById('others').value,


    // gender: getRadioValue(),

    message: document.getElementById('messageForMe').value,


    }

    var empty = false;

    for (let prop in user) {

        if (user[prop] == null || user[prop].trim() == '') {

            empty = true;

            document.getElementById('contactMessage').innerHTML =

                'Sorry, please fill out form completely';

            // document.getElementById('register').setAttribute('disabled', "true");
        }
    }

    if (empty == false) {

        //send request and clear message field

        //document.getElementById('message').innerHTML = '';

        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function () {

            //process response

            if (xhr.readyState == 4) {

                console.log(xhr.status);

                //showLoginView();
            }

        }

        xhr.open('POST', 'http://localhost:3000/contact');

        xhr.setRequestHeader('content-Type', 'application/json');

        //this method is sending our user as a JSON string in POST req body

        xhr.send(JSON.stringify(user));

    }

    console.log(JSON.stringify(user));

}