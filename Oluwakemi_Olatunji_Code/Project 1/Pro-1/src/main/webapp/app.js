window.onload = function(){
	console.log('app.js loaded');
	loadLoginView();
	$('#logout').on('click', function(){
			logout()});
}

function loadLoginView(){

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				console.log('loaded login view');
				$('#view').html(xhr.responseText);

				//ADD EVENT LISTENER TO LOGIN PAGE SO WE CAN DO THINGS WITH IT

				$('#doLogin').on('click', login);
			} else if (xhr.status >= 500){
				console.log('server error');
			}

		}
	}
	xhr.open('GET', 'login.view');
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
				if(user.roleId == 1972) loadManagerHomePage();
				else loadEmployeeHomePage();
			}
			else if(xhr.status == 204){
				$('#message').html('Sorry, invalid credentials! Please try again');
			}
		}
	}
	xhr.open('POST', 'login');
	xhr.send(JSON.stringify(user));
}

function loadEmployeeHomePage(){
	console.log('load emp home function');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				getUserData();
				$('#create').on('click', adding);
				$('#logout').on('click', function(){
					logout()});
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}
	xhr.open('GET', 'EmployeeHome.view');
	xhr.send();

}

function loadManagerHomePage(){
	console.log('load man home function');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				getAllUserData();
				$('#logout').on('click', function(){
					logout()})
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}
	xhr.open('GET', 'ManagerHome.view');
	xhr.send();

}

function getUserData(){
	console.log('TESTING UPDATE');
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				console.log(info);
				$('#name').html(info.user.firstName);
				if(info.reimbursement.length == 0){
					//no accounts, hide table, ask user to create accounts
				}
				else {
					const formatter = new Intl.NumberFormat('en-US', {
						  style: 'currency',
						  currency: 'USD',
						  minimumFractionDigits: 2
						})
					for(let acc of info.reimbursement){
						var row = $(`<tr class="account" id=${acc.id}> </tr>`);
						var cell1 = $(`<td>${acc.id}</td>`);
						var cell2= $(`<td>${formatter.format(acc.amount)}</td>`);
						var cell3= $(`<td>${acc.sumbit}</td>`);
						var cell4= $(`<td>${acc.resolve}</td>`);
						var cell5= $(`<td>${acc.descript}</td>`);
						//var cell6= $(`<td>${acc.employeeFirst} ${acc.employeeLast}</td>`);
						//var cell7= $(`<td>${acc.boss}</td>`);
						var cell8= $(`<td>${acc.status}</td>`);
						var cell9= $(`<td>${acc.type}</td>`);
						
						row.append(cell1);
						row.append(cell2);
						row.append(cell3);
						row.append(cell4);
						row.append(cell5);
						//row.append(cell6);
						//row.append(cell7);
						row.append(cell8);
						row.append(cell9);
						$('#reTable').append(row);
					}
					 //add on click function to rows to select 
		            $('#reTable').on('click', 'tr', function(){
		                var id = $(this).attr('id');
		                console.log(id);
		                //now allow user to update balance for selected element
		            });
				}

			}
			else if(xhr.status == 403){
				alert('Invalid credentials');
				loadLoginView(); //or reload index.html
			}
		}
	}
	xhr.open('GET', 'userInfo');
	xhr.send();
}
 var idMan;
function getAllUserData(){
	console.log('TESTING UPDATE');
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				console.log(info);
				$('#name').html(info.user.firstName);
				if(info.reimbursement.length == 0){
					//no accounts, hide table, ask user to create accounts
				}
				else{
					const formatter = new Intl.NumberFormat('en-US', {
						  style: 'currency',
						  currency: 'USD',
						  minimumFractionDigits: 2
						})
					for(let acc of info.reimbursement){
						var row = $(`<tr class="account" id=${acc.id}> </tr>`);
						var cell1 = $(`<td>${acc.id}</td>`);
						var cell2= $(`<td>${formatter.format(acc.amount)}</td>`);
						var cell3= $(`<td>${acc.sumbit}</td>`);
						var cell4= $(`<td>${acc.resolve}</td>`);
						var cell5= $(`<td>${acc.descript}</td>`);
						var cell6= $(`<td>${acc.employeeFirst} ${acc.employeeLast}</td>`);
						//var cell7= $(`<td>${acc.boss}</td>`);
						var cell8= $(`<td>${acc.status}</td>`);
						var cell9= $(`<td>${acc.type}</td>`);
						
						
						
						row.append(cell1);
						row.append(cell2);
						row.append(cell3);
						row.append(cell4);
						row.append(cell5);
						row.append(cell6);
						//row.append(cell7);
						row.append(cell8);
						row.append(cell9);
						
						$('#manTable').append(row);
					}
					 //add on click function to rows to select 
		            $('#manTable').on('click', 'tr', function(){
		            	
		                idMan = $(this).attr('id');
		                console.log(idMan);
		                update(); 
		                //now allow user to update balance for selected element
		            });
				}

				}
				else if(xhr.status == 403){
					alert('Invalid credentials');
					loadLoginView(); //or reload index.html
				}
			}
		}
		xhr.open('GET', 'userInfo');
		xhr.send();
	}

function update(){
	console.log('updating reimburse');
	console.log(info);
	
	var re  = {
			boss: info.user.id,
			status: $('#Status').val(),
			id: idMan,
	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				console.log('logged in user' );
				var re = JSON.parse(xhr.responseText);
				loadManagerHomePage();
				
			}
		}
	}
	xhr.open('POST', 'update');
	xhr.send(JSON.stringify(re));
}
function adding(){
	console.log('adding reimburse');
	console.log(info);
	if($('#amount').val() == "")
	{alert("PLEASE SET AN AMOUNT")
		return
	}if($('#description').val() == "")
	{
		alert("PLEASE SET A DESCRIPTION")
		return
	}	
	var el = document.getElementById('type');
	var value = el.options[el.selectedIndex].value;
	var reim  = {
			amount: $('#amount').val(),
			descript: $('#description').val(), 
			employee: info.user.id,
			type: value		 
	}
	
	console.log(reim);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				console.log('logged in user' );
				var reim = JSON.parse(xhr.responseText);
				getAllUserData()
				
			}
		}
	}
	xhr.open('POST', 'add');
	xhr.send(JSON.stringify(reim));
}

function logout() {
	console.log('logout');
	loadLoginView();
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
	
			loadLoginView();
			}
			
			xhr.open('GET', 'logout');
			xhr.send();
		}
	}
}