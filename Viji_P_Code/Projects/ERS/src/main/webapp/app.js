
var userId;
var reimAmount;
window.onload = function(){
	console.log('App.js loaded');
	loadLoginView();
}

function loadLoginView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				console.log('Loaded login view');
				$('#view').html(xhr.responseText);
				$('#doLogin').on('click', login);
				} 
			else if (xhr.status >= 500){
				console.log('Server Error');
			}
		}
	}
	xhr.open('GET', 'login.view');
	xhr.send();
	}

function login(){
	console.log('Login user Function');
	var user = {
			username: $('#username').val(),
			password: $('#password').val()
	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4){
			if(xhr.status == 200){
				console.log('Logged in user');
				var user = JSON.parse(xhr.responseText);
				
				userId=user.id;
				
				if (user.userRoleId == 1){
					loadEmpPage();					
				}else{
					loadManagerPage();
				}
			}
			else if(xhr.status == 204){
				$('#message').html('Sorry, Invalid credentials, Please try again');
			}
		}
	}
	xhr.open('POST','login');
	xhr.send(JSON.stringify(user));
}
 
function loadEmpPage(){
	console.log('Load Employee Home Page');
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
				console.log(info);
				$('#name').html(info.user.firstname);
				if(info.accounts.length == 0){
					//no accounts, hide table, ask user to create accounts
				}
				else{
					const formatter = new Intl.NumberFormat('en-US', {
						style: 'currency',
						currency: 'USD',
						minimumFractionDigits: 2
					})
					for(let acc of info.accounts){
						var row = $(`<tr class="account" id=${acc.reimbId}> </tr>`);
						var cell1 = $(`<td>${acc.id}</td>`);
						var cell2 = $(`<td>${acc.firstname}</td>`);
						var cell3 = $(`<td>${acc.lastname}</td>`);
						var cell4 = $(`<td>${acc.reimbId}</td>`);
						var cell5 = $(`<td>${formatter.format(acc.amount)}</td>`);
						var cell6 = $(`<td>${acc.rSubDate}</td>`);
						var cell7 = $(`<td>${acc.rResDate}</td>`);
						var cell8 = $(`<td>${acc.rResId}</td>`);
						var cell9 = $(`<td>${acc.reimStatus}</td>`);
						row.append(cell1);
						row.append(cell2);
						row.append(cell3);
						row.append(cell4);
						row.append(cell5);
						row.append(cell6);
						row.append(cell7);
						row.append(cell8);
						row.append(cell9);
						$('#accountInfo').append(row);
					}
					$('#goToReimb').on('click', loadAddReimbusementView);
					//add on click function to rows to select 
					$('#accountInfo').on('click', 'tr', function(){
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

function loadAddReimbusementView(){
	console.log("Reimbursement page loaded");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("Add Reimbusement Page");
		if(xhr.readyState == 4){
			if(xhr.status==200){
				//make response text the innerHTML of #view
				$('#view').html(xhr.responseText);
				//alert ('Load reimbursement');
				$('#addReimb').on('click', addReimbursement);
				}
			else if(xhr.status == 403){
				alert('Invalid credentials');
				loadEmpPage(); //or reload index.html
			}
		}
	}
	xhr.open('GET', 'addReimbursement.view');
	xhr.send();
}

function addReimbursement(){
	
	console.log('Add new reimbursement function...');
	//alert("USER ID Logged in : "+userId);
	//alert ('Manager Info'+$('#managerList').val());
	var reimb = {
			amount: $('#amount').val(),
			description: $('#description').val(),
			rResId: $('#managerList').val(),		
			typeId: $('#typeList').val(),
			rAuthId:userId
			}
	
	//alert ('Manager Info'+$('#managerList').val());
//	console.log("Testing reimb object");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4){
			if(xhr.status == 200){
				console.log('Add reimbursement');
				var reimb1 = JSON.parse(xhr.responseText);
				//getUserData();
				console.log("Reimb object in App.js : "+reimb1);
				reimAmount = reimb1.amount;
				alert("Reimbusement Added Sccessfully");
				
				if (reimAmount <= 0){
					alert("Please Enter Valid Amount !");
				}
				}
			else if(xhr.status == 204){
				$('#message1').html('Please enter valid credentials');
			}
		}
	}
	xhr.open('POST','addReimbursement');
	xhr.send(JSON.stringify(reimb));
}

function loadManagerPage(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				//make response text the innerHTML of #view
				$('#view').html(xhr.responseText);
				managerHomeInfo();
			}
			else if(xhr.status == 403){
				alert('Invalid credentials');
				loadLoginView(); //or reload index.html
			}
		}
	}
	xhr.open('GET', 'manager.view');
	xhr.send();
}
	
function managerHomeInfo(){
	console.log('loading manager info');
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				console.log(info);
				$('#name').html(info.user.firstname);
		if(info.accounts.length == 0){
			//no accounts, hide table, ask user to create accounts
			console.log("Please create accounts!")
		}
		else{
			const formatter = new Intl.NumberFormat('en-US', {
				style: 'currency',
				currency: 'USD',
				minimumFractionDigits: 2
			})
			for(let acc of info.accounts){
				var row = $(`<tr class="account" id=${acc.reimbId}> </tr>`);
				var cell1 = $(`<td>${acc.id}</td>`);
				var cell2 = $(`<td>${acc.firstname}</td>`);
				var cell3 = $(`<td>${acc.lastname}</td>`);
				var cell4 = $(`<td>${acc.reimbId}</td>`);
				var cell5 = $(`<td>${formatter.format(acc.amount)}</td>`);
				var cell6 = $(`<td>${acc.rSubDate}</td>`);
				var cell7 = $(`<td>${acc.rResDate}</td>`);
				var cell8 = $(`<td>${acc.rResId}</td>`);
				var cell9 = $(`<td>${acc.reimStatus}</td>`);
				row.append(cell1);
				row.append(cell2);
				row.append(cell3);
				row.append(cell4);
				row.append(cell5);
				row.append(cell6);
				row.append(cell7);
				row.append(cell8);
				row.append(cell9);
				$('#manageraccountInfo').append(row);
			}
			$('#doEdit').on('click', loadEditReimbView);
			//add on click function to rows to select 
			$('#manageraccountInfo').on('click', 'tr', function(){
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
		console.log("End Manager view");
		xhr.open('GET', 'userInfo');
		xhr.send();
}


function loadEditReimbView(){
	console.log("Inside edit page...");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
	console.log("Edit reimbursement status page");
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				console.log('Loaded edit reimbursement view');
				$('#view').html(xhr.responseText);
				$('#editStatus').on('click', updateReimbursement);
				
				} 
			else if (xhr.status >= 500){
				console.log('Server Error');
				managerHomeInfo();
			}
		}
	}
	console.log("load out");
	xhr.open('GET', 'update.view');
	xhr.send();
}


function updateReimbursement(){
	//alert('Edit reimbursement status:');
	console.log("update reimbursement function....");
	//userId=user.id;
	//alert("USER ID Logged in : "+userId);
	var reimb = {
			statusId: $('#statusList1').val(),
			reimbId: $('#reimbId').val(),
			rResId:userId
	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4){
			if (xhr.status == 200){
				console.log("Editing reimbursement");
				var reimb = JSON.parse(xhr.responseText);
				loadManagerPage();
				}
			else if(xhr.status == 204){
				$('#message2').html("Please fill in all required fields");
			}
		}
	}
	xhr.open('POST','update');
	xhr.send(JSON.stringify(reimb));
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
