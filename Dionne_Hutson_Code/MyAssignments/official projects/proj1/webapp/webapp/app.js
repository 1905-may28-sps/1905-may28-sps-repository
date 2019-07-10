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