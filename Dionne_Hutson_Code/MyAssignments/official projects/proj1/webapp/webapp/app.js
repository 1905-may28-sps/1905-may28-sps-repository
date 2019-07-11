window.onload = function(){
	console.log('app.js loaded');
	loadLoginView();
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
				$('#returnLogin').on('click', loadLoginView);
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
			un: $('#ERS_USERNAME').val(),
			pass: $('#ERS_PASSWORD').val()
	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				console.log('logged in user' );
				var user = JSON.parse(xhr.responseText);
				//do stuff w user if you want
				console.log(user);
				if (user.role==1){
				loadEmpPage();
				}if (user.role==2){
				loadManPage();
				}
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

function loadEmpPage(){
	console.log('load emp function');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				getUserDataE();
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}//////////////////////////////////////
	xhr.open('GET', 'employee.view');
	xhr.send();
	
	
}

function loadManPage(){
	console.log('load man function');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				getUserDataM();
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}//////////////////////////////////////
	xhr.open('GET', 'manager.view');
	xhr.send();
}
function getUserDataE(){
	console.log("in user info");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				console.log("info"+info);

				
				$('#name').html(info.user.fn);
				console.log(info.user);
				console.log(info.user.userID);
				if(info.reims.length == 0){
					//no accounts, hide table, ask user to create accounts
					console.log('in null info');
					
				}else if (info.reims.length >=1 ){
					console.log('inelse');
					const formatter = new Intl.NumberFormat('en-US', {
						  style: 'currency',
						  currency: 'USD',
						  minimumFractionDigits: 2
						})
					for(let reim of info.reims){
						var row = $(`<tr class="reim" id=${reim.id}> </tr>`);
						var cell1 = $(`<td>${reim.id}</td>`);
						var cell2= $(`<td>${formatter.format(reim.amount)}</td>`);
						var cell3= $(`<td>${reim.submit}</td>`);
						var cell4= $(`<td>${reim.resolved}</td>`);
						var cell5= $(`<td>${reim.descrip}</td>`);
						var cell6= $(`<td>${reim.man}</td>`);
						var cell7= $(`<td>${reim.status}</td>`);
						var cell8= $(`<td>${reim.type}</td>`);
						
						row.append(cell1);
						row.append(cell2);
						row.append(cell3);
						row.append(cell4);
						row.append(cell5);
						row.append(cell6);
						row.append(cell7);
						row.append(cell8);
						$('#reimTable').append(row);
					}
					 //add on click function to rows to select 
		            $('#reimTable').on('click', 'tr', function(){
		                var ide = $(this).attr('id');
		                console.log(id);
		                //now allow user to update balance for selected element
					});

					console.log(info.user.userID);
					$('#addOpt').on('click', loadAddPage);
					
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
var ide;
function getUserDataM(){
	console.log("in user info");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				console.log(info);

				
				$('#name').html(info.user.fn);
				if(info.reims.length == 0){
					//no accounts, hide table, ask user to create accounts
					console.log('in null info');
					
				}else if (info.reims.length >=1 ){
					console.log('inelse');
					const formatter = new Intl.NumberFormat('en-US', {
						  style: 'currency',
						  currency: 'USD',
						  minimumFractionDigits: 2
						})
						var i=0;
					for(let reim of info.reims){
						var row = $(`<tr class="reim" id=${reim.id}> </tr>`);
						var cell1 = $(`<td>${reim.id}</td>`);
						var cell2= $(`<td>${formatter.format(reim.amount)}</td>`);
						var cell3= $(`<td>${reim.submit}</td>`);
						var cell4= $(`<td>${reim.resolved}</td>`);
						var cell5= $(`<td>${reim.descrip}</td>`);
						var cell6= $(`<td>${reim.emp}</td>`);
						var cell7= $(`<td>${reim.status}</td>`);
						var cell8= $(`<td>${reim.type}</td>`);
						row.append(cell1);
						row.append(cell2);
						row.append(cell3);
						row.append(cell4);
						row.append(cell5);
						row.append(cell6);
						row.append(cell7);
						row.append(cell8);
						$('#reimTable').append(row);
					}
					 //add on click function to rows to select 
		            $('#reimTable').on('click', 'tr', function(){
		               ide = $(this).attr('id');
						console.log(ide);
						updReim();
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

function loadAddPage(){
	console.log('load add page');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				$('#addBut').on('click', addReim);
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}//////////////////////////////////////
	xhr.open('GET', 'addReim.view');
	xhr.send();
}
function addReim(){
	console.log('add function');
	console.log(info.user.userID);
	var reim = {
			descrp: $('#descrpP').val(),
			amount: $('#amountP').val(),
			emp: info.user.userID,
			type: $('#typeP').val(),

	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				console.log('added reim' );
				console.log(info.user.userID);
				var reim= JSON.parse(xhr.responseText);
				//do stuff w user if you want
				console.log(reim);
				console.log("suscess");
						}
			else if(xhr.status == 204){
				$('#message').html('Sorry, invalid credentials! Please try again');
			}
		}
	}
	xhr.open('POST', 'add');
	xhr.send(JSON.stringify(reim));
}
function updReim(){
	console.log('add function');
	console.log(info.user.userID);
	var obj = {
			id: ide,
			status: $('#status').val(),
			man: info.user.userID,
			

	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				console.log('up reim' );
				console.log(info.user.userID);
				var reim= JSON.parse(xhr.responseText);
				//do stuff w user if you want
				console.log(reim);
				console.log("suscess");
						}
			else if(xhr.status == 204){
				$('#message').html('Sorry, invalid credentials! Please try again');
			}
		}
	}
	xhr.open('POST', 'upd');
	xhr.send(JSON.stringify(obj));
}
