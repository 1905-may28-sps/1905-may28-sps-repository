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

				// ADD EVENT LISTENER TO LOGIN PAGE SO WE CAN DO THINGS WITH IT

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
				// do stuff w user if you want
				if(user.roleId==300)
				loadManPage();
				else loadEmpPage();
			}
			else if(xhr.status == 204){
				
				$('#message').html('Sorry, invalid credentials! Please try again');
			}
		}
	}
	xhr.open('POST', 'login');
	xhr.send(JSON.stringify(user));
}


function loadManPage(){
	console.log('load manager function');
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				//$('#manager').html(user.firstName);
				getEmpData();
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}
	xhr.open('GET', 'mHome.view');
	xhr.send();

}

function eHomePage(){
	console.log('load emoployee homepage');
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				//$('#manager').html(user.firstName);
				getReimbData();
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}
	xhr.open('GET', 'eHome.view');
	xhr.send();

}

function loadEmpPage(){
	console.log('load employee reimbursement submit page');
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				
				$('#addReimb').on('click', submitRe, eHomePage);
				$('#viewPast').on('click', eHomePage);
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}
	xhr.open('GET', 'reimb.view');
	xhr.send();

}

function submitRe(){
	console.log('reimbusement submittal');
	var reimb = {
			amount: $('#amount').val(),
			description: $('#description').val(),
			author: $('#id').val(),
			typeId: $('#type').val()
	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				console.log('reimbursement submitted' );
				var user = JSON.parse(xhr.responseText);
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}
	xhr.open('POST', 'submit');
	xhr.send(JSON.stringify(reimb));

}

function getEmpData(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				//$('#manager').html(info.user.firstName);
				console.log(info);
				if(info.length == 0){
					$('#message').html('Sorry, no history available');
				}
				else{
					const formatter = new Intl.NumberFormat('en-US', {
						  style: 'currency',
						  currency: 'USD',
						  minimumFractionDigits: 2
						})
					for(let i of info){
						var row = $(`<tr class="reimb" id=${i.id}> </tr>`);
						var cell1 = $(`<td>${i.id}</td>`);
						var cell2= $(`<td>${formatter.format(i.amount)}</td>`);
						var cell3= $(`<td>${i.submitted}</td>`);
						var cell4= $(`<td>${i.resolved}</td>`);
						var cell5= $(`<td>${i.description}</td>`);
						var cell6= $(`<td>${i.author}</td>`);
						var cell7= $(`<td>${i.resolver}</td>`);
						var cell8= $(`<td>${i.status}</td>`);
						var cell9= $(`<td>${i.typeId}</td>`);
						row.append(cell1);
						row.append(cell2);
						row.append(cell3);
						row.append(cell4);
						row.append(cell5);
						row.append(cell6);
						row.append(cell7);
						row.append(cell8);
						row.append(cell9);
					
						$('#manTable').append(row);
					}
					 // add on click function to rows to select
		            $('#manTable').on('click', 'tr', function(){
		                var id = $(this).attr('id');
		                console.log(id);
		                // now allow user to update balance for selected element
		            });
				}

			}
			else if(xhr.status == 403){
				alert('Invalid credentials');
				loadLoginView(); // or reload index.html
			}
		}
	}
	xhr.open('GET', 'empInfo');
	xhr.send();
}

function getReimbData(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				console.log(info);
				//$('#employee').html(info.user.firstName);
				if(info.length == 0){
					$('#message').html('Sorry, no history available');
				}
				else{
					const formatter = new Intl.NumberFormat('en-US', {
						  style: 'currency',
						  currency: 'USD',
						  minimumFractionDigits: 2
						})
					for(let i of info){
						var row = $(`<tr class="reimb" id=${i.id}> </tr>`);
						var cell1 = $(`<td>${i.id}</td>`);
						var cell2= $(`<td>${formatter.format(i.amount)}</td>`);
						var cell3= $(`<td>${i.submitted}</td>`);
						var cell4= $(`<td>${i.resolved}</td>`);
						var cell5= $(`<td>${i.description}</td>`);
						var cell6= $(`<td>${i.author}</td>`);
						var cell7= $(`<td>${i.resolver}</td>`);
						var cell8= $(`<td>${i.status}</td>`);
						var cell9= $(`<td>${i.typeId}</td>`);
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
					 // add on click function to rows to select
		            $('#empTable').on('click', 'tr', function(){
		                var id = $(this).attr('id');
		                console.log(id);
		                // now allow user to update balance for selected element
		            });
				}

			}
			else if(xhr.status == 403){
				alert('Invalid credentials');
				loadLoginView(); // or reload index.html
			}
		}
	}
	xhr.open('GET', 'userInfo');
	xhr.send();
}