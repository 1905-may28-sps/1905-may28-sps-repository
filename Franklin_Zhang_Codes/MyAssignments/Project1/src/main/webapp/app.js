window.onload = function(){
	console.log('app.js loaded');
	loadLoginView();
}
function loadLoginView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				console.log('loaded login view!');
				$('#view').html(xhr.responseText);
				$('#doLogin').on('click', login);
			} else if (xhr.status >= 400 ){
				console.log('client error');
			}else if (xhr.status >= 500){
				console.log('server error');
			}

		}
	}
	xhr.open('GET', 'login.view');
	xhr.send();

}
function loadHomePage(){
	console.log('load home function');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				
				$('#view').html(xhr.responseText);
				$('#allCurReim').on('click', loadAllCurUserReimbursement);
				$('#newREIM').on('click', loadAddReimbursement);
				$('#logout').on('click', logout);
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}
	xhr.open('GET', 'homepage.view');
	xhr.send();
}

function loadManagerHomePage(){
	console.log('load Manger home function');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				//console.log(info);
				$('#view').html(xhr.responseText);
				$('#newREIM').on('click', loadAddReimbursement);
				$('#allCurReim').on('click', MNGloadAllUserReimbursement);
				$('#logout').on('click', logout);
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}
	xhr.open('GET', 'managerhomepage.view');
	xhr.send();
}
function loadAddReimbursement(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				$('#view').html(xhr.responseText);
				$('#doAdd').on('click', addReimbursement);
				
			}
		}
	}
	xhr.open('GET', 'addReimbursements.view');
	xhr.send();
}
function loadAllCurUserReimbursement(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				$('#view').html(xhr.responseText);
				$('#logout').on('click', logout);
				AllCurUserReimbursement();
			}	
		}}
	xhr.open('GET', 'userallReimbursements.view');
	xhr.send();
}


function logout(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				console.log('out');
				loadLoginView();
			} else if (xhr.status >= 400 ){
				console.log('client error');
			}else if (xhr.status >= 500){
				console.log('server error');
			}

		}
	}
	xhr.open('GET', 'logoutServlet');
	xhr.send();
	
}

function loadAllUserReimbursement(){

	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				$('#view').html(xhr.responseText);
				AllUserReimbursement();
			}
		}}
	xhr.open('GET', 'userallReimbursements.view');
	xhr.send();
}
function AllUserReimbursement(){
	console.log('AllUserReimbursement');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){		
				info = JSON.parse(xhr.responseText);
				console.log(info);
				//$('#name').html(info.userID.fname);
			
					//need acc to be matched to the java(reimbursementinfo)
					for(let acc of info.accounts){
						var row = $(`<tr class="account"> </tr>`);
						var cell1 = $(`<td>${acc.reimb_id}</td>`);
						var cell2 = $(`<td>${acc.reimb_amount}</td>`);
						var cell3= $(`<td>${acc.reimb_submitted}</td>`);
						var cell4= $(`<td>${acc.reimb_resolved}</td>`);
						var cell5= $(`<td>${acc.reimb_description}</td>`);
						var cell6= $(`<td>${acc.reimb_receipt}</td>`);
						var cell7= $(`<td>${acc.reimb_author}</td>`);
						var cell8= $(`<td>${acc.reimb_resolver}</td>`);
						var cell9= $(`<td>${acc.reimb_status_id}</td>`);
						var cell10= $(`<td>${acc.reimb_type_id}</td>`);
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
						$('#accountTable').append(row);
					}
					//add on click function to rows to select 
					$('#accountTable').on('click', 'tr', function(){
						var id = $(this).attr('id');
						console.log(id);
						//now allow user to update balance for selected element
					});
					$('#doUpdate').on('click', updateReimbursement);
					
					//$('#logout').on('click', logout);
					
					

			}
			else if(xhr.status == 403){
				alert('Invalid credentials');
				loadLoginView(); //or reload index.html
			}
		} else if (xhr.status >= 500){
			console.log('server error');	
		}
	
}
xhr.open('GET', 'AllUserReimbursement');
xhr.send();
}

function AllCurUserReimbursement(){
	console.log('AllCurUserReimbursement');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){		
				info = JSON.parse(xhr.responseText);
				$('#name').html(info.userID.fname);
				$('#logout').on('click', logout);
				if(info.accounts.length == 0){
					//no accounts, hide table, ask user to create accounts
					console.log("empty");
				}
				else{
					//need acc to be matched to the java(reimbursementinfo)
					for(let acc of info.accounts){
						var row = $(`<tr class="account"> </tr>`);
						var cell1 = $(`<td>${acc.reimb_id}</td>`);
						var cell2 = $(`<td>${acc.reimb_amount}</td>`);
						var cell3= $(`<td>${acc.reimb_submitted}</td>`);
						var cell4= $(`<td>${acc.reimb_resolved}</td>`);
						var cell5= $(`<td>${acc.reimb_description}</td>`);
						var cell6= $(`<td>${acc.reimb_receipt}</td>`);
						var cell7= $(`<td>${acc.reimb_author}</td>`);
						var cell8= $(`<td>${acc.reimb_resolver}</td>`);
						var cell9= $(`<td>${acc.reimb_status_id}</td>`);
						var cell10= $(`<td>${acc.reimb_type_id}</td>`);


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


						$('#accountTable').append(row);
					}
					//add on click function to rows to select 
					$('#accountTable').on('click', 'tr', function(){
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
		} else if (xhr.status >= 500){
			console.log('server error');	
		}
	
}
xhr.open('GET', 'AllCurUserReimbursement');
xhr.send();
}
function login(){
	console.log('login user function');
	var user = {
			uname: $('#username').val(),
			pword: $('#password').val()
	}
	var xhr = new XMLHttpRequest();
	console.log(user);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				var user = JSON.parse(xhr.responseText);
				console.log("user or manager");
				console.log(user.uroleID);
				if (user.uroleID==1){
					console.log("manager here");
					loadManagerHomePage();
				}
				else{
					console.log("not a manager");
				loadHomePage();
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

function addReimbursement(){
	console.log('new reimbursements');
	var newReimb = {
			reimb_amount: $('#amount').val(),
			reimb_description: $('#description').val(),
			reimb_type_id: $('#type').val()
	}
	var xhr = new XMLHttpRequest();
	console.log(newReimb);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				var newReimb = JSON.parse(xhr.responseText);
				console.log(newReimb);
				console.log("added");
				alert("Successfully entered in new Request, returning to homepage!");
				loadHomePage();
				
			}
			else if(xhr.status == 204){
				$('#message').html('Sorry no work');
			}
		}
	}
	xhr.open('POST', 'AddNewReimbursement');
	xhr.send(JSON.stringify(newReimb));
}
function updateReimbursement(){
	console.log('new reimbursements');
	var upReimb = {
			reimb_id: $('#reimb_id').val(),
			reimb_status_id: $('#reimb_status_id').val(),
			
	}
	var xhr = new XMLHttpRequest();
	console.log(upReimb);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				var upReimb = JSON.parse(xhr.responseText);
				$('#logout').on('click', logout);
				alert("Successfully entered in UPDATE");
				console.log("refresh");
				MNGloadAllUserReimbursement();
				console.log("refresh2");
				
			}
			else if(xhr.status == 204){
				$('#message').html('Sorry no work');
			}
		}
	}
	xhr.open('POST', 'UpdateNewReimbursement');
	xhr.send(JSON.stringify(upReimb));
}













































//

function MNGloadAllUserReimbursement(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				$('#view').html(xhr.responseText);
				$('#logout').on('click', logout);
				AllUserReimbursement();
			}
		}}
	xhr.open('GET', 'ManagerAllReimb.view');
	xhr.send();
}
function MNGAllUserReimbursement(){
	console.log('AllUserReimbursement');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){		
				info = JSON.parse(xhr.responseText);
				console.log(info);
				$('#logout').on('click', logout);
				//$('#name').html(info.userID.fname);
			
					//need acc to be matched to the java(reimbursementinfo)
					for(let acc of info.accounts){
						var row = $(`<tr class="account"> </tr>`);
						var cell1 = $(`<td>${acc.reimb_id}</td>`);
						var cell2 = $(`<td>${acc.reimb_amount}</td>`);
						var cell3= $(`<td>${acc.reimb_submitted}</td>`);
						var cell4= $(`<td>${acc.reimb_resolved}</td>`);
						var cell5= $(`<td>${acc.reimb_description}</td>`);
						var cell6= $(`<td>${acc.reimb_receipt}</td>`);
						var cell7= $(`<td>${acc.reimb_author}</td>`);
						var cell8= $(`<td>${acc.reimb_resolver}</td>`);
						var cell9= $(`<td>${acc.reimb_status_id}</td>`);
						var cell10= $(`<td>${acc.reimb_type_id}</td>`);
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
						$('#accountTable').append(row);
					}
					//add on click function to rows to select 
					$('#accountTable').on('click', 'tr', function(){
						var id = $(this).attr('id');
						console.log(id);
						//now allow user to update balance for selected element
					});
					$('#doUpdate').on('click', updateReimbursement);
					
					
					
					

			}
			else if(xhr.status == 403){
				alert('Invalid credentials');
				loadLoginView(); //or reload index.html
			}
		} else if (xhr.status >= 500){
			console.log('server error');	
		}
	
}
xhr.open('GET', 'AllUserReimbursement');
xhr.send();
}



