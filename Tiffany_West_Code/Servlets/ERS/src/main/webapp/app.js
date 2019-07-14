window.onload = function(){
	console.log('TESTING CHANGES: JQ 3');
	loadHomeView();
	

	function loadHomeView(){
		
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 ){
				if(xhr.status == 200){
					console.log('loaded Home view');
					$('#view').html(xhr.responseText);
					$('#goToLogin').on('click', loadLoginView);
				} else if (xhr.status >= 500){
					console.log('server error');
				}

			}
		}
		xhr.open('GET', 'Home.view');
		xhr.send();
	}
	
	function loadLoginView(){
	
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 ){
				if(xhr.status == 200){
					console.log('loaded login view');
					$('#view').html(xhr.responseText);
					$('#doLogin').on('click', login);
					$('#goToHome').on('click', loadHomeView);
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
					
					if(user.roleId==2)loadManagerView(); // check this
	                else loadTablePage();
					//loadTablePage(); 
				}
				else if(xhr.status == 204){
					$('#message').html('Sorry, invalid credentials! Please try again');
				}
			}
		}
		xhr.open('POST', 'login');
		xhr.send(JSON.stringify(user));
	}

	function loadManagerView(){
		console.log('in manager view');
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 ){
				if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				getEmpData(); //   <---
					//$('#manLogin').on('click', manager); // change this to manager login
					$('#goToLogin').on('click', loadLoginView);
				} else if (xhr.status >= 500){
					console.log('server error');
				}

			}
		}
		xhr.open('GET', 'Manager.view'); 
		xhr.send();
	}
	function manager(){ 
		console.log('manager function');
		}
	
	//employee page
	function loadTablePage(){
		console.log('load home function');
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 ){
				if(xhr.status == 200){
					$('#view').html(xhr.responseText);
					getUserData();
					$('#goToLogin').on('click', loadLoginView);
				} else if (xhr.status >= 500){
					console.log('server error');
				}
			}
		}
		xhr.open('GET', 'tables.view'); // change to tables
		xhr.send();

	}
	
	function loadReimbursementView(){
		
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 ){
				if(xhr.status == 200){
					$('#view').html(xhr.responseText);
					$('#addReimb').on('click', reimbursement); 
					$('#goLogin').on('click', loadLoginView);
				} else if (xhr.status >= 500){
					console.log('server error');
				}
			}
		}
		xhr.open('GET', 'reimbursement.view'); 
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
							var row = $(`<tr class="account" id=${acc.id}> </tr>`);
							var cell1 = $(`<td>${acc.id}</td>`);
							var cell2= $(`<td>${formatter.format(acc.amount)}</td>`);
							var cell3= $(`<td>${acc.submitted}</td>`);
							var cell4= $(`<td>${acc.resolved}</td>`);
							var cell5= $(`<td>${acc.description}</td>`);
							var cell6= $(`<td>${acc.type}</td>`);
							var cell7= $(`<td>${acc.status}</td>`);							
							row.append(cell1);
							row.append(cell2);
							row.append(cell3);
							row.append(cell4);
							row.append(cell5);
							row.append(cell6);
							row.append(cell7);
						
							$('#ersTable').append(row);
						}
						$('#doReimb').on('click', loadReimbursementView); 

						 //add on click function to rows to select 
			            $('#example').on('click', 'tr', function(){
			                var id = $(this).attr('id');
			                console.log(id);
			                
			                //now allow user to update balance for selected element
			            
			           });
						$('#doReimb').on('click', loadReimbursementView); // change this to manager login

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

}
//for managers table
function getEmpData(){ 
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				$('#name').html(info.user.firstName);
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
						var row = $(`<tr class="account" id=${acc.id}> </tr>`);
						var cell1 = $(`<td>${acc.id}</td>`);
						var cell2 = $(`<td>${acc.author}</td>`);
						var cell3= $(`<td>${formatter.format(acc.amount)}</td>`);
						var cell4= $(`<td>${acc.submitted}</td>`);
						var cell5= $(`<td>${acc.resolved}</td>`);
						var cell6= $(`<td>${acc.description}</td>`);
						var cell7= $(`<td>${acc.status}</td>`);							
						var cell8= $(`<td>${acc.type}</td>`);
						row.append(cell1);
						row.append(cell2);
						row.append(cell3);
						row.append(cell4);
						row.append(cell5);
						row.append(cell6);
						row.append(cell7);
						row.append(cell8);

					
						$('#mTable').append(row);
					}

					 //add on click function to rows to select 
		            $('#mTable').on('click', 'tr', function(){
		                var id = $(this).attr('id');
		                console.log(id);
		                updReim(id);

		            
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


 function updReim(id){
	console.log(info.user.id);
	console.log('update');
	
	var obj= {
			id: id,
			status: $('#status').val(),
			resolver: info.user.id,
	}
	console.log('OBJECT BELOW');
	console.log(obj);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				console.log('UPP reimb' );
				console.log(info.user.id);
				var reim = JSON.parse(xhr.responseText);
				console.log(id);
				//console.log(acc);
				console.log('success');
			}
			else if(xhr.status == 204){
				$('#message').html('Sorry!');
			}
		}
	}
	xhr.open('POST', 'upRem');
	xhr.send(JSON.stringify(obj));
}








//add functionality now


function reimbursement(){
	console.log('TEST');
	console.log('reimbursment function here');
	var re = document.getElementById('opts');
	var value = re.options[re.selectedIndex].value;
	var obj = {
			amount: $('#amount').val(),
			description: $('#description').val(),
			author: info.user.id,
			type: value
	}
	console.log('lets get here');
	console.log(obj);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				console.log('add reimb' );
				var obj = JSON.parse(xhr.responseText);
				//do stuff w user if you want
				//loadTablePage(); // change to tables
				console.log(obj);
			}
			else if(xhr.status == 204){
				$('#message').html('Sorry!');
			}
		}
	}
	xhr.open('POST', 'addreimb');
	xhr.send(JSON.stringify(obj));
	
}
//search function here
function myFunction() {
	  // Declare variables 
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("manTable");
	  tr = table.getElementsByTagName("tr");

	  // Loop through all table rows, and hide those who don't match the search query
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[1];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    } 
	  }
	}

//home page functions
