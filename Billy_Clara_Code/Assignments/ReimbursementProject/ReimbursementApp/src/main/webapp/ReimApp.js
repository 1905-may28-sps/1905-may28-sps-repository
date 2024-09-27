window.onload = function () {
	console.log('ReimApp.js.loaded');
	loadLoginView();
}


//WORKING FINE DO NOT TOUCH
function loadLoginView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.log('loaded login view');
				$(`#view`).html(xhr.responseText);
				$('#dologin').on('click', login);

			}
			else if (xhr.status >= 500) {
				console.log('server error');
			}
		}
	}
	xhr.open('GET', 'login.view')
	xhr.send();
}


//WORKING FINE DO NOT TOUCH
function login() {
	console.log('login user function');
	var user = {
		username: $('#username').val(),
		password: $('#password').val()
	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {


				console.log('logged in user');
				var user = JSON.parse(xhr.responseText);
				if (user.userrole <= 2) {
					loadmanager();
				} else {
					loademp();
				}
			}
			else if (xhr.status == 204) {
				alert("Sorry. Wrong Username or Password. Please try again")
				$('#message').html('INVALID CREDENTIALS');
			}

		}
	}

	xhr.open('POST', 'login');
	xhr.send(JSON.stringify(user));

}


//WORKING FINE DO NOT TOUCH
function loadmanager() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.log('loaded login view');
				$(`#view`).html(xhr.responseText);
				$('#logout').on('click', loadLoginView);
				$('#update').on('click', submission);
				$('#refreshM').on('click', loadmanager);


				managerview();
			}

		}
		else if (xhr.status >= 500) {
			console.log('server error');
		}
	}

	xhr.open('GET', 'manager.view')
	xhr.send();

}


function managerview() {
	console.log("view")
	managerdata();
}




function loademp() {
	console.log("Associate Page Under Construction");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				$('#view').html(xhr.responseText);
				$('#refresh').on('click', loademp);
				$('#logout').on('click', loadLoginView);
				$('#newre').on('click', review);
				getEmpData();

			} else if (xhr.status >= 500) {
				console.log('server error');
			}
		}
	}
	xhr.open('GET', 'employee.view');
	xhr.send();
}

function review() {
	document.getElementById('sub').removeAttribute('hidden');
	$('#submit').on('click', newrein);
	$('#submit').on('click', loademp);



}


function newrein() {
	console.log("working rein");
	var reimb = {
		amount: $('#amount').val(),
		description: $('#description').val(),
		typeid: $('#type').val()
	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.log('reimbursement submitted');
				var user = JSON.parse(xhr.responseText);
			} else if (xhr.status >= 500) {
				console.log('server error');
			}
		}
	}
	xhr.open('POST', 'submit');
	xhr.send(JSON.stringify(reimb));

}






function getEmpData() {
	console.log("Employee Data Function")
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				info = JSON.parse(xhr.responseText);
				console.log(info);

				if (info.length == 0) {
					$('#message').html('Sorry, no history available');
				}
				else {
					const formatter = new Intl.NumberFormat('en-US', {
						style: 'currency',
						currency: 'USD',
						minimumFractionDigits: 2
					})
					for (let i of info) {
						var row = $(`<tr class="reimb" id=${i.id}> </tr>`);
						var cell1 = $(`<td>${i.id}</td>`);
						var cell2 = $(`<td>${formatter.format(i.amount)}</td>`);
						var cell3 = $(`<td>${i.submitted}</td>`);
						var cell4 = $(`<td>${i.resolved}</td>`);
						var cell5 = $(`<td>${i.description}</td>`);
						var cell6 = $(`<td>${i.author}</td>`);
						var cell7 = $(`<td>${i.resolver}</td>`);
						var cell8 = $(`<td>${i.statusid}</td>`);
						var cell9 = $(`<td>${i.typeid}</td>`);
						row.append(cell1);
						row.append(cell2);
						row.append(cell3);
						row.append(cell4);
						row.append(cell5);
						row.append(cell6);
						row.append(cell7);
						row.append(cell8);
						row.append(cell9);

						$('#empTable').append(row);
					}

				}

			}
			else if (xhr.status == 403) {
				alert('Invalid credentials');
				loadLoginView();
			}
		}
	}
	xhr.open('GET', 'userInfo');
	xhr.send();
}



function managerdata() {
	console.log("DATA")
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				info = JSON.parse(xhr.responseText);
				console.log(info);
				if (info.length == 0) {
					$('#message').html('Sorry, no history available');
				}
				else {
					const formatter = new Intl.NumberFormat('en-US', {
						style: 'currency',
						currency: 'USD',
						minimumFractionDigits: 2
					})
					for (let i of info) {
						var row = $(`<tr class="reimb" id=${i.id}> </tr>`);

						var cell1 = $(`<td>${i.id}</td>`);
						var cell2 = $(`<td>${i.firstname}</td>`);
						var cell3 = $(`<td>${i.lastname}</td>`);
						var cell4 = $(`<td>${i.email}</td>`);
						var cell5 = $(`<td>${formatter.format(i.amount)}</td>`);
						var cell6 = $(`<td>${i.submitted}</td>`);
						var cell7 = $(`<td>${i.resolved}</td>`);
						var cell8 = $(`<td>${i.description}</td>`);
						var cell9 = $(`<td>${i.status}</td>`);
						var cell10 = $(`<td>${i.type}</td>`)
						row.append(cell1);
						row.append(cell2);
						row.append(cell3);
						row.append(cell4);
						row.append(cell5);
						row.append(cell6);
						row.append(cell7);
						row.append(cell8);
						row.append(cell9);
						row.append(cell10);

						$('#managerta').append(row);
					}

				}

			}
			else if (xhr.status == 403) {
				alert('Invalid credentials');
				loadLoginView(); // or reload index.html
			}
		}
	}
	xhr.open('GET', 'reim');
	xhr.send();
}

function submission(){
	document.getElementById('edit').removeAttribute('hidden');
	$('#editStatus').on('click', updatestatus);
	$('#editStatus').on('click', loadmanager);

}

function updatestatus(){
		console.log("update reimburse working");
		var reimb = {
				statusid: $('#statusdrop').val(),
				id: $('#reimbId').val(),
		}
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if (xhr.readyState == 4){
				if (xhr.status == 200){
					console.log("Editing reimbursement");
					var reimb = JSON.parse(xhr.responseText);
					console.log("posting")
					managerdata();
					}
				else if(xhr.status == 204){
					$('#message2').html("Please fill in all required fields");
				}
			}
		}
		xhr.open('POST','update');
		xhr.send(JSON.stringify(reimb));
	}