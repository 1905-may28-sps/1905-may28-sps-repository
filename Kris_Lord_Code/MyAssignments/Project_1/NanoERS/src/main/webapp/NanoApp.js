window.onload = function(){
	console.log('NanoApp.js loaded');
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
				//do stuff w user if you want
//				$('#name').html(user.firstName);
				if(user.userRoleId==1) loadManagerHomePage();
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
	console.log('load home function');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				getUserData();
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}
	xhr.open('GET', 'employeehome.view');
	xhr.send();

}

function loadManagerHomePage(){
	console.log('load home function');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				getMgrData();
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}
	xhr.open('GET', 'managerhome.view');
	xhr.send();

}

function getUserData(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				console.log(xhr.responseText);
				$('#name').html(info.user.firstName);
				$('#esubmit').on('click', esubmit);
				$('#epast').on('click', epast);
				$('#epending').on('click', epending);
				$('#logout').on('click', logout);
//				if(info.accounts.length == 0){
//					//no accounts, hide table, ask user to create accounts
//				}
//				else{
					const formatter = new Intl.NumberFormat('en-US', {
						  style: 'currency',
						  currency: 'USD',
						  minimumFractionDigits: 2
						})
					for(let acc of info.accounts){
						var row = $(`<tr class="account" id=${acc.id}> </tr>`);
						var cell1 = $(`<td>${acc.id}</td>`);
						var cell2= $(`<td>${formatter.format(acc.balance)}</td>`);
						var cell3= $(`<td>${acc.resolverfn}</td>`);
						var cell4 = $(`<td>${acc.resolverln}</td>`);
						var cell5= $(`<td>${acc.submitted}</td>`);
						var cell6= $(`<td>${acc.resolved}</td>`);
						var cell7= $(`<td>${acc.description}</td>`);
						var cell8 = $(`<td>${acc.receipt}</td>`);
						var cell9= $(`<td>${acc.rstatus}</td>`);
						var cell10= $(`<td>${acc.rtype}</td>`);
						var cell11= $(`<td>${acc.author}</td>`);
						var cell12= $(`<td>${acc.resolver}</td>`);
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
						row.append(cell11);
						row.append(cell12);
						$('#accountTable').append(row);
					}
					 //add on click function to rows to select 
		            $('#accountTable').on('click', 'tr', function(){
		                var id = $(this).attr('id');
		                console.log(id);
		                //now allow user to update balance for selected element
		            });
//				}

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

function esubmit(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				$('#doESubmit').on('click', getESubmit);
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}
	xhr.open('GET', 'employeesubmit.view');
	xhr.send();
}

function getESubmit(){
	var eadd = {
			balance: $('#eamount').val(),
			description: $('#edescription').val(),
			type: $('#emptype').val()
//			,receipt: $('#ereceipt').val()
	}
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				console.log('add to user' );
				var eadd = JSON.parse(xhr.responseText);
				//do stuff w user if you want
//				if(user.userRoleId==1) loadManagerHomePage();
//				else loadEmployeeHomePage();
			}
			else if(xhr.status == 204){
//				$('#message').html('Sorry, invalid credentials! Please try again');
			}
		}
	}
	xhr.open('POST', 'esubmit');
	xhr.send();
}

function epast(){
	
}

function epending(){
	
}

function getMgrData(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				console.log(xhr.responseText);
				$('#name').html(info.user.firstName);
				$('#munresolved').on('click', munresolved);
				$('#mpast').on('click', mpast);
				$('#logout').on('click', logout);
//				if(info.accounts.length == 0){
//					//no accounts, hide table, ask user to create accounts
//				}
//				else{
					const formatter = new Intl.NumberFormat('en-US', {
						  style: 'currency',
						  currency: 'USD',
						  minimumFractionDigits: 2
						})
					for(let acc of info.accounts){
						var row = $(`<tr class="account" id=${acc.id}> </tr>`);
						var cell1 = $(`<td>${acc.id}</td>`);
						var cell2= $(`<td>${formatter.format(acc.balance)}</td>`);
						var cell3= $(`<td>${acc.authorfn}</td>`);
						var cell4 = $(`<td>${acc.authorln}</td>`);
						var cell5= $(`<td>${acc.resolverfn}</td>`);
						var cell6 = $(`<td>${acc.resolverln}</td>`);
						var cell7= $(`<td>${acc.submitted}</td>`);
						var cell8= $(`<td>${acc.resolved}</td>`);
						var cell9= $(`<td>${acc.description}</td>`);
						var cell10= $(`<td>${acc.receipt}</td>`);
						var cell11= $(`<td>${acc.rstatus}</td>`);
						var cell12= $(`<td>${acc.rtype}</td>`);
						var cell13= $(`<td>${acc.author}</td>`);
						var cell14= $(`<td>${acc.resolver}</td>`);
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
						row.append(cell11);
						row.append(cell12);
						row.append(cell13);
						row.append(cell14);
						$('#accountTable').append(row);
					}
					 //add on click function to rows to select 
		            $('#accountTable').on('click', 'tr', function(){
		                var id = $(this).attr('id');
		                console.log(id);
		                //now allow user to update balance for selected element
		            });
//				}

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

function munresolved(){
	
}

function mpast(){
	
}

function logout(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				console.log('logging out');
				loadLoginView();
			}
		}
	}
	xhr.open('GET', 'logout');
	xhr.send();
}
