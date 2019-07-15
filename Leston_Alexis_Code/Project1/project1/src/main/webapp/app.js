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
				console.log('works')
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
				if(user.getRoleId == 1) loadManagerHomePage();
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
				$('#create').on('click', addNew);
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
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}
	xhr.open('GET', 'ManagerHome.view');
	xhr.send();

}

function getUserData(){
	
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				console.log(info);
				$('#name').html(info.user.firstName);
				if(info.reimbursement.length == 0){
					
				}
				else {
					const formatter = new Intl.NumberFormat('en-US', {
						  style: 'currency',
						  currency: 'USD',
						  minimumFractionDigits: 2
						})
					for(let reimb of info.reimbursement){
						var row = $(`<tr class="Reimbursement" id=${reimb.id}> </tr>`);
						var cell1 = $(`<td>${reimb.id}</td>`);
						var cell2= $(`<td>${formatter.format(reimb.amount)}</td>`);
						var cell3= $(`<td>${reimb.sumbitted}</td>`);
						var cell4= $(`<td>${reimb.resolved}</td>`);
						var cell5= $(`<td>${reimb.description}</td>`);
						var cell6= $(`<td>${reimb.AuthorFirst} ${reimb.AuthorLast}</td>`);
						var cell7= $(`<td>${reimb.resolver}</td>`);
						var cell8= $(`<td>${reimb.statusId}</td>`);
						var cell9= $(`<td>${reimb.typeId}</td>`);
						
						row.append(cell1);
						row.append(cell2);
						row.append(cell3);
						row.append(cell4);
						row.append(cell5);
						row.append(cell6);
						row.append(cell7);
						row.append(cell8);
						row.append(cell9);
						$('#Reimdetails').append(row);
					}
					 
		            $('#Reimdetails').on('click', 'tr', function(){
		                var id = $(this).attr('id');
		                console.log(id);
		               
		            });
				}

			}
			else if(xhr.status == 403){
				alert('Invalid credentials');
				loadLoginView(); 
			}
		}
	}
	xhr.open('GET', 'userInfo');
	xhr.send();
}
 var idMan;
function getAllUserData(){
	
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				console.log(info);
				$('#name').html(info.user.firstName);
				if(info.reimbursement.length == 0){
					
				}
				else{
					const formatter = new Intl.NumberFormat('en-US', {
						  style: 'currency',
						  currency: 'USD',
						  minimumFractionDigits: 2
						})
					for(let reimb of info.reimbursement){
						var row = $(`<tr class="ReimbursementM" id=${reimb.id}> </tr>`);
						var cell1 = $(`<td>${reimb.id}</td>`);
						var cell2= $(`<td>${formatter.format(reimb.amount)}</td>`);
						var cell3= $(`<td>${reimb.sumbit}</td>`);
						var cell4= $(`<td>${reimb.resolve}</td>`);
						var cell5= $(`<td>${reimb.descript}</td>`);
						var cell6= $(`<td>${reimb.employeeFirst} ${reimb.employeeLast}</td>`);
						var cell7= $(`<td>${reimb.boss}</td>`);
						var cell8= $(`<td>${reimb.status}</td>`);
						var cell9= $(`<td>${reimb.type}</td>`);
						
						
						
						row.append(cell1);
						row.append(cell2);
						row.append(cell3);
						row.append(cell4);
						row.append(cell5);
						row.append(cell6);
						row.append(cell7);
						row.append(cell8);
						row.append(cell9);
						
						$('#managerView').append(row);
					}
					 
		            $('#managerView').on('click', 'tr', function(){
		            	
		                idMan = $(this).attr('id');
		                console.log(idMan);
		                update(); 
		                
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
	
	var rbm  = {
			Manager: info.user.id,
			status: $('#Status').val(),
			id: idMan,
	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				console.log('logged in user' );
				var rbm = JSON.parse(xhr.responseText);
				//getAllUserData()
				
			}
		}
	}
	xhr.open('POST', 'update');
	xhr.send(JSON.stringify(rbm));
}

function addNew(){
	console.log('adding rimburse');
	console.log(info);
	var opt = document.getElementById('type');
	var val = opt.options[opt.selectedIndex].value;
	var reimb = {
			amount: $('#amount').val(),
			descript: $('#description').val(), 
			employee: info.user.id,
			type: val		 
	}
	
	console.log(reimb);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				console.log('logged in user' );
				var reimb = JSON.parse(xhr.responseText);
				loadEmployeeHomePage()
				
			}
		}
	}
	xhr.open('POST', 'add');
	xhr.send(JSON.stringify(reimb));
}

function AddRe (){
	if($('#amount').val() == "")
	{alert("PLEASE ENTER AN AMOUNT")
		return
	}if($('#description').val() == "")
	{
		alert("PLEASE ENTER A DESCRIPTION!!")
		return
	}	if($('#type').val() == null)
	{
		alert("PLEASE CHOOSE A TYPE")
		return
	}
	
}