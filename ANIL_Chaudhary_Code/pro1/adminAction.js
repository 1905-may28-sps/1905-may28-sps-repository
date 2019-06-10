window.onload = function () {
    document.getElementById('submit').addEventListener('click', addGrades);
    document.getElementById('login').addEventListener('click', adminAction);
}
function addGrades() {
    var userObj = {
        usesrId: document.getElementById('userId').value,
        period: document.getElementById('period').value,
        maths: document.getElementById('maths').value,
        english: document.getElementById('english').value,
        computer: document.getElementById('computer').value
    }
    
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            console.log(xhr.status);
            document.getElementById('message').innerHTML =
                'Data updated successfully';

            xhr.open('POST', 'http://localhost:3000/grades');

            xhr.setRequestHeader('Content-Type', 'application/json');

            xhr.send(JSON.stringify(userObj));
        }
    }
}

function viewAdminGrades() {

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {

            console.log(xhr.status);
            var grades = JSON.parse(xhr.responseText);
            console.log(grades);

            for (let grade of grades) {
                let row = $(`<tr id=${grade.id}>
                        <td> ${grade.userId}</td>
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
}

    function adminAction()
    {
document.getElementById="adminAction".removeAttribute('hidden');

    }