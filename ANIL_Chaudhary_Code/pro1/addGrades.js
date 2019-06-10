window.onload = function () {
    document.getElementById('submit').addEventListener('click', addGrades);
}
function addGrades() {
    var userObj = {
        userId: document.getElementById('userId').value,
        period: document.getElementById('period').value,
        maths: document.getElementById('maths').value,
        english: document.getElementById('english').value,
        computer: document.getElementById('computer').value
    }
    var empty = false;
    for (let prop in userObj) {
        if (userObj[prop] == null || userObj[prop].trim() == '') {
            empty = true;
            document.getElementById('message').innerHTML =
                'Student Id can not be blank';
        }
    }
    if (empty == false) {
        document.getElementById('message').innerHTML = '';
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
                if (xhr.readyState == 4) {
                console.log(xhr.status);
                document.getElementById('message').innerHTML =
                'Data updated successfully';
                }
            }

    xhr.open('POST', 'http://localhost:3000/grades');

    xhr.setRequestHeader('Content-Type', 'application/json');

    xhr.send(JSON.stringify(userObj));
    document.getElementById('submit').setAttribute('disabled', "true");
}
}

