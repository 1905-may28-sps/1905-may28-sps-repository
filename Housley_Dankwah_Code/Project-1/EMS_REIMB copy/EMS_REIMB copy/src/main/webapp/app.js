window.onload = function(){
	loadLoginView();
}


function loadLoginView(){
	console.log('loading login');
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
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				$('#addReimb').on('click', newReImbPage)

				getUserData();
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}
	xhr.open('GET', 'homepage.view');
	xhr.send();
}


function newReImbPage(){
//	console.log(obj);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				$('#submitAdd').on('click', addNewReimbursement)
				getUserData();
			} else if (xhr.status >= 500){
				console.log('server error');
			}
		}
	}
	xhr.open('GET', 'addNew.view');
	xhr.send();

}


function addNewReimbursement (){
	console.log(Date());
		var newReimb = {
				reimbAmount: $('#reimbAmount').val(),
				reimbSubmittedDate:Date(),
				reimbResolvedDate: null,
				reimbDescription: $('#reimbDescription').val(),
				reimbAuthor: $('#reimbId').val(),
				reimbResolver: null,
				reimbStatusId:1,
				reimbTypeId: $('#reimbTypeId').val()	
		}
		console.log(newReimb);
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				console.log(xhr.readyState);
				if(xhr.status == 200){
					console.log(xhr.status);
					console.log('adding new reimbursement' );
					var user = JSON.parse(xhr.responseText);
					loadHomePage();
				}
				else if(xhr.status == 204){
					$('#message').html('Sorry, invalid credentials! Please try again');
					console.log('204 error')
				}
			}
		}
		xhr.open('POST', 'addNewReimb');
		xhr.send(JSON.stringify(newReimb));
	}


function getUserData(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				info = JSON.parse(xhr.responseText);
				console.log(info);
				$('#name').html(info.user.userFirstName + ' ' + info.user.userLastName ) ;
				if(info.user.length == 0){
				}
				else if(info.user.userRoleId == 1){
					const formatter = new Intl.NumberFormat('en-US', {
						  style: 'currency',
						  currency: 'USD',
						  minimumFractionDigits: 2
						})
					for(let riemb of info.reimbursmentInfo){
						var row = $(`<tr class="reimbursement"> </tr>`);
						var cell1 = $(`<td>${riemb.reimbId}</td>`);
						var cell2 = $(`<td>${riemb.subUserFirstName}  ${riemb.subUserLastName}</td>`);
						var cell3= $(`<td>${formatter.format(riemb.reimbAmount)}</td>`);
						var cell4 = $(`<td>${riemb.reimbDescription}</td>`);
						var cell5 = $(`<td>${riemb.reimbSubmittedDate}</td>`);
						var cell6 = $(`<td>${riemb.reimbType}</td>`);
						var cell7 = $(`<td>${riemb.reimbStatus}</td>`);
						var cell8 = $(`<button id=${riemb.reimbId} class="btn btn-warning">APPROVE!</button>`)
						var cell9 = $(`<button id=${riemb.reimbId} class="btn btn-danger">DENY!</button>`);
						row.append(cell1);
						row.append(cell2);
						row.append(cell3);
						row.append(cell4);
						row.append(cell5);
						row.append(cell6);
						row.append(cell7);
						row.append(cell8);
						row.append(cell9);
						$('#ReimbursementTable').append(row);
					}
					 //add on click function to rows to select 
		            $('button').on('click', function(){
		                var buttonClass = $(this).attr('class');
		                console.log(info.reimbursmentInfo);
		                var id = $(this).attr('id');
		                if(buttonClass == 'btn btn-warning'){
		                	console.log('approving reimbursement ' + id);
		                	resolveReimbursement(2, id);
		                }
		                else{
		                	console.log('denying reimbursement ' + id);
		                	resolveReimbursement(3, id);
		                }
		                //now allow user to update balance for selected element
		            });
				} else {
					const formatter = new Intl.NumberFormat('en-US', {
						  style: 'currency',
						  currency: 'USD',
						  minimumFractionDigits: 2
						})
					for(let riemb of info.reimbursmentInfo){
						var row = $(`<tr class="reimbursement"> </tr>`);
						var cell1 = $(`<td>${riemb.reimbId}</td>`);
						var cell2 = $(`<td>${riemb.subUserFirstName}  ${riemb.subUserLastName}</td>`);
						var cell3= $(`<td>${formatter.format(riemb.reimbAmount)}</td>`);
						var cell4 = $(`<td>${riemb.reimbDescription}</td>`);
						var cell5 = $(`<td>${riemb.reimbSubmittedDate}</td>`);
						var cell6 = $(`<td>${riemb.reimbType}</td>`);
						var cell7 = $(`<td>${riemb.reimbStatus}</td>`);
						row.append(cell1);
						row.append(cell2);
						row.append(cell3);
						row.append(cell4);
						row.append(cell5);
						row.append(cell6);
						row.append(cell7);
						$('#ReimbursementTable').append(row);
					}
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
	var  resolveReimb = { 
			reimbStatusId: status, 
			reimbId: id
	};
	console.log(resolveReimb);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				console.log(info);
				$('#name').html(info.user.subUserFirstName);
				console.log(info.user);
				console.log(info.reimbursmentInfo);
				if(info.user.length == 0){
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
		            });
				}
				loadHomePage();
			}
			else if(xhr.status == 403){
				loadLoginView(); //or reload index.html
			}
		}
	}
	xhr.open('POST', 'update');
	xhr.send(JSON.stringify(resolveReimb));
}
