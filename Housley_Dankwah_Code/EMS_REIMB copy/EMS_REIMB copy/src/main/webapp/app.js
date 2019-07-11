window.onload = function(){
	loadLoginView();
}

function loadLoginView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				console.log('about to login');
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
	var user = {			
			ersUsername: $('#username').val(),
			password: $('#password').val()
	}
	console.log(user);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			console.log(xhr.readyState);
			if(xhr.status == 200){
				console.log(xhr.status);
				console.log('logged in user' );
				var user = JSON.parse(xhr.responseText);
				loadHomePage();
			}
			else if(xhr.status == 204){
				$('#message').html('Sorry, invalid credentials! Please try again');
				console.log('204 error')
			}
		}
	}
	xhr.open('POST', 'login');
	xhr.send(JSON.stringify(user));
	
	
}

function loadHomePage(){
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
	xhr.open('GET', 'homepage.view');
	xhr.send();

}


function getUserData(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				console.log(info);
				$('#name').html(info.user.subUserFirstName);
				console.log(info.user);
				console.log(info.reimbursmentInfo);

				if(info.user.length == 0){
					//no accounts, hide table, ask user to create accounts
				}
				else{
					const formatter = new Intl.NumberFormat('en-US', {
						  style: 'currency',
						  currency: 'USD',
						  minimumFractionDigits: 2
						})
					for(let riemb of info.reimbursmentInfo){
						var row = $(`<tr class="reimbursement"> </tr>`);
						var cell1 = $(`<td>${riemb.reimbId}</td>`);
						var cell2 = $(`<td>${riemb.subUserFirstName}</td>`);
						var cell3 = $(`<td>${riemb.subUserLastName}</td>`);
						var cell4= $(`<td>${formatter.format(riemb.reimbAmount)}</td>`);
						var cell5 = $(`<td>${riemb.reimbDescription}</td>`);
						var cell6 = $(`<td>${riemb.reimbSubmittedDate}</td>`);
						var cell7 = $(`<td>${riemb.reimbType}</td>`);
						var cell8 = $(`<td>${riemb.reimbStatus}</td>`);
						var cell9 = $(`<button id=${riemb.reimbId} class="btn btn-success">APPROVE!</button>`)
						var cell10 = $(`<button id=${riemb.reimbId} class="btn btn-primary">DENY!</button>`);
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
						$('#ReimbursementTable').append(row);
					}
					 //add on click function to rows to select 
		            $('button').on('click', function(){
		                var buttonClass = $(this).attr('class');
		                var id = $(this).attr('id');
		                if(buttonClass == 'btn btn-success'){
		                	console.log('approving reimbursement ' + id);
		                	resolveReimbursement(2, id);
		                }
		                else{
		                	console.log('denying reimbursement ' + id);
		                	resolveReimbursement(3, id);
		                }
		                //now allow user to update balance for selected element
		            });
				}
			}
			else if(xhr.status == 403){
				loadLoginView(); //or reload index.html
			}
		}
	}
	xhr.open('GET', 'userInfo');
	xhr.send();
}

function resolveReimbursement(status, id){
	//call servlet to either approve or deny and pass in status and reimbursemnet id 
}