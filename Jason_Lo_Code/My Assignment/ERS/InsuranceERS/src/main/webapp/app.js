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
				loadHomePage();
			}
			else if(xhr.status == 204){
				$('#message').html('Sorry, invalid credentials! Please try again');
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
	xhr.open('GET', 'home.view');
	xhr.send();

}
function getUserData(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				$('#name').html(info.user.firstName);
				if(info.accounts.length == 0){
					
				}
				else{
					const formatter = new Intl.NumberFormat('en-US', {
						  style: 'currency',
						  currency: 'USD',
						  minimumFractionDigits: 2
						})
					for(let acc of info.accounts){
						var row = $(`<tr class="account" id=${acc.id}> </tr>`);
						var cell1 = $(`<td>${acc.id}</td>`);
						var cell2= $(`<td>${formatter.format(acc.balance)}</td>`);
						var cell3= $(`<td>${acc.type}</td>`);
						row.append(cell1);
						row.append(cell2);
						row.append(cell3);
						$('#accountTable').append(row);
					}
					 // add on click function to rows to select
		            $('#accountTable').on('click', 'tr', function(){
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