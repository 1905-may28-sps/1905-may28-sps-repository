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
	$("#reimTable").find("tr").remove();
	var row2 = $(`<tr class="reim" ></tr>`);
	var cell= $(`<td>No Reimbursements Yet</td>`);
	row2.append(cell);
	
	$('#reimTable').append(row2);
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
						var i=0;
					for(let reim of info.reims){
						if(i++==0){
							$("#reimTable").find("tr").remove();
								}
						var row = $(`<tr class="reim" id=${reim.id}> </tr>`);
						var cell1 = $(`<td>${reim.id}</td>`);
						var cell2= $(`<td>${formatter.format(reim.amount)}</td>`);
						var cell3= $(`<td>${reim.submit}</td>`);
						var cell4= $(`<td>${reim.resolved}</td>`);
						var cell5= $(`<td>${reim.descrp}</td>`);
						var cell6= $(`<td>${reim.status}</td>`);
						var cell7= $(`<td>${reim.type}</td>`);
						var cell8= $(`<td>${reim.manfn}</td>`);
						var cell9= $(`<td>${reim.manln}</td>`);
						
						row.append(cell1);
						row.append(cell2);
						row.append(cell3);
						row.append(cell4);
						row.append(cell5);
						row.append(cell6);
						row.append(cell7);
						row.append(cell8);
						row.append(cell9);
						$('#reimTable').append(row);
					}
					 //add on click function to rows to select 
		           

					console.log(info.user.userID);
					//$('#addOpt').on('click', loadAddPage);
					$('#addBut').on('click', addReim);
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
var newstat;
function getUserDataM(){
	$("#reimTable").find("tr").remove();
	var row2 = $(`<tr class="reim" ></tr>`);
	var cell= $(`<td>No reimbursements yet</td>`);
	row2.append(cell);
	
	$('#reimTable').append(row2);
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
						if(i++==0){
							$("#reimTable").find("tr").remove();
								}
						var row = $(`<tr class="reim" > </tr>`);//id=${reim.id}
						
						var butt = $(`<td><button id=${reim.id} class="btn btn-outline-success my-2 my-sm-0" data-toggle="modal" data-target="#updating" type="submit">Update</button></td>`);
						var cell1 = $(`<td>${reim.id}</td>`);
						var cell2= $(`<td>${formatter.format(reim.amount)}</td>`);
						var cell3= $(`<td>${reim.submit}</td>`);
						var cell4= $(`<td>${reim.resolved}</td>`);
						var cell5= $(`<td>${reim.descrp}</td>`);
						var cell6= $(`<td>${reim.empfn}</td>`);
						var cell7= $(`<td>${reim.empln}</td>`);
						var cell8= $(`<td>${reim.status}</td>`);
						var cell9= $(`<td>${reim.type}</td>`);
						var cell10= $(`<td>${reim.manfn}</td>`);
						var cell11= $(`<td>${reim.manln}</td>`);
						row.append(butt);

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
						$('#reimTable').append(row);
					}
					 //add on click function to rows to select 
		            $('#reimTable').on('click', 'button', function(){
		               ide = $(this).attr('id');
						console.log(ide);
						
						//now allow user to update balance for selected element
						
					});
					$('#myupdate').on('click', 'button', function(){
						newstat= $(this).val();
						 console.log("newstat:"+ newstat);
						 updReim();
						 //now allow user to update balance for selected element
						 
					 });
					 $('#searchBut').on('click', function(){
						 console.log("but result");
	
						 console.log( $('#searchIn').val().toLowerCase());
						 searchReim();
						
						 
					 });
					 $('#logOut').on('click', function(){
						console.log("log out clickresult");

					
						logOut();
					   
						
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


function addReim(){
	console.log('add function');
	console.log(info.user.userID);

	var reim = {
			descrp: $('#descrpP').val(),
			amount: $('#amountP').val(),
			emp: info.user.userID,
			type: $( "#myselect" ).val(),//$('#typeP').val(),

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


	if (user.role==1){
		loadEmpPage();
		}if (user.role==2){
		loadManPage();
		}
}
function updReim(){
	console.log('add function');
	console.log(info.user.userID);




	var obj = {
			id: ide,
			status:newstat,
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
	
		loadManPage();
		
}

function searchReim(){
	$("#reimTable").find("tr").remove();
	var row2 = $(`<tr class="reim" ></tr>`);
	var cell= $(`<td>Search Results not Found</td>`);
	row2.append(cell);
	
	$('#reimTable').append(row2);

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
						if(reim.status.toLowerCase()==$('#searchIn').val().toLowerCase()){
							if(i++==0){
						$("#reimTable").find("tr").remove();
							}
						var row = $(`<tr class="reim" > </tr>`);//id=${reim.id}
						
						var butt = $(`<td><button id=${reim.id} class="btn btn-outline-success my-2 my-sm-0" data-toggle="modal" data-target="#updating" type="submit">Update</button></td>`);
						var cell1 = $(`<td>${reim.id}</td>`);
						var cell2= $(`<td>${formatter.format(reim.amount)}</td>`);
						var cell3= $(`<td>${reim.submit}</td>`);
						var cell4= $(`<td>${reim.resolved}</td>`);
						var cell5= $(`<td>${reim.descrp}</td>`);
						var cell6= $(`<td>${reim.empfn}</td>`);
						var cell7= $(`<td>${reim.empln}</td>`);
						var cell8= $(`<td>${reim.status}</td>`);
						var cell9= $(`<td>${reim.type}</td>`);
						var cell10= $(`<td>${reim.manfn}</td>`);
						var cell11= $(`<td>${reim.manln}</td>`);
						row.append(butt);

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
						$('#reimTable').append(row);


							 //add on click function to rows to select 
							 $('#reimTable').on('click', 'button', function(){
								ide = $(this).attr('id');
								 console.log(ide);
								 
								 //now allow user to update balance for selected element
								 
							 });
							 $('#myupdate').on('click', 'button', function(){
								 newstat= $(this).val();
								  console.log("newstat:"+ newstat);
								  updReim();
								  //now allow user to update balance for selected element
								  
							  });
					}else if($('#searchIn').val().toLowerCase()==""){


						if (user.role==1){
							loadEmpPage();
							}if (user.role==2){
							loadManPage();
							}



					}
						}

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


function logOut(){
	console.log('logout user function');
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("in on ready");
		if(xhr.readyState == 4){
			if(xhr.status == 205){
				
				console.log('logged out user' );
				loadLoginView();
			}else {
				console.log("Not logged out");
				
		}
	}
}
	xhr.open('GET', 'logout');
	xhr.send();
}
