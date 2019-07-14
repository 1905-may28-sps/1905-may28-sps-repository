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


function loadManPage(status){
	console.log('load manager function');
	//var stat = status;
	console.log(status);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				if (status == 1)
					pending();
				else if (status == 2)
					approved();
				else if (status == 3)
					denied();
				else
				getEmpData();
				$('#logout').on('click', loadLoginView);
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}
	xhr.open('GET', 'mHome.view');
	xhr.send();

}

function eHomePage(){
	console.log('load employee homepage');
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				$('#back').on('click', loadEmpPage);
				$('#logout').on('click', loadLoginView);
				$('#refresh').on('click', eHomePage);
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
				
				$('#addReimb').on('click', submitRe);
				$('#addReimb').on('click', eHomePage);
				$('#viewPast').on('click', eHomePage);
				$('#logout').on('click', loadLoginView);
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
			// author: $('#id').val(),
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

function updateRe(id){
	console.log('update submittal');
	console.log(id);
	
	var status = prompt("Enter status:");
	// var mId = prompt("Manager Id:");
	var updated = {
			id: id,
			status: status,
			// resolver: mId
			
	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				console.log('reimbursement updated' );
				var user = JSON.parse(xhr.responseText);
				loadManPage();
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}
	xhr.open('POST', 'update');
	xhr.send(JSON.stringify(updated));

}



function getEmpData(){
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				
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
					 
		            $('#manTable').on('click', 'tr', function(){
		                var id = $(this).attr('id');
		                console.log(id);
		                updateRe(id);
		               
		            });
		            $('#pending').on('click', function(){
		                var status = 1;
		                loadManPage(status);
		               
		            });
		            $('#approved').on('click', function(){
		                var status = 2;
		                loadManPage(status);
		               
		            });
		            $('#denied').on('click', function(){
		                var status = 3;
		                loadManPage(status);
		               
		            });
		            $('#all').on('click', function(){
		                
		                loadManPage();
		               
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

function approved(){

	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				
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
					 
		            $('#manTable').on('click', 'tr', function(){
		                var id = $(this).attr('id');
		                console.log(id);
		                updateRe(id);
		               
		            });
		            $('#pending').on('click', function(){
		                var status = 1;
		                loadManPage(status);
		               
		            });
		            $('#approved').on('click', function(){
		                var status = 2;
		                loadManPage(status);
		               
		            });
		            $('#denied').on('click', function(){
		                var status = 3;
		                loadManPage(status);
		               
		            });
		            $('#all').on('click', function(){
		                
		                loadManPage();
		               
		            });
				}

			}
			else if(xhr.status == 403){
				alert('Invalid credentials');
				loadLoginView(); // or reload index.html
			}
		}
	}

	xhr.open('GET', 'approved');
	xhr.send();
}

function pending(){

	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				
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
					 
		            $('#manTable').on('click', 'tr', function(){
		                var id = $(this).attr('id');
		                console.log(id);
		                updateRe(id);
		               
		            });
		            $('#pending').on('click', function(){
		                var status = 1;
		                loadManPage(status);
		               
		            });
		            $('#approved').on('click', function(){
		                var status = 2;
		                loadManPage(status);
		               
		            });
		            $('#denied').on('click',  function(){
		                var status = 3;
		                loadManPage(status);
		               
		            });
		            $('#all').on('click',  function(){
		                
		                loadManPage();
		               
		            });
				}

			}
			else if(xhr.status == 403){
				alert('Invalid credentials');
				loadLoginView(); // or reload index.html
			}
		}
	}

	xhr.open('GET', 'pending');
	xhr.send();
}

function denied(){

	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				
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
					 
		            $('#manTable').on('click', 'tr', function(){
		                var id = $(this).attr('id');
		                console.log(id);
		                updateRe(id);
		               
		            });
		            $('#pending').on('click', function(){
		                var status = 1;
		                loadManPage(status);
		               
		            });
		            $('#approved').on('click', function(){
		                var status = 2;
		                loadManPage(status);
		               
		            });
		            $('#denied').on('click', function(){
		                var status = 3;
		                loadManPage(status);
		               
		            });
		            $('#all').on('click', function(){
		                
		                loadManPage();
		               
		            });
		           
				}

			}
			else if(xhr.status == 403){
				alert('Invalid credentials');
				loadLoginView(); // or reload index.html
			}
		}
	}

	xhr.open('GET', 'denied');
	xhr.send();
}

function getReimbData(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				console.log(info);
				// $('#employee').html(info.user.firstName);
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