window.onload = function () {
    document.getElementById('submitForm').addEventListener('click',contact);
}

function contact() {





    var user = {

        firstName: document.getElementById('firstname').value,

    middleName: document.getElementById('middlename').value,

    lastName: document.getElementById('lastname').value,

    age: document.getElementById('age').value,

    email: document.getElementById('email').value,

    // gender: document.getElementById('gender').value,





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