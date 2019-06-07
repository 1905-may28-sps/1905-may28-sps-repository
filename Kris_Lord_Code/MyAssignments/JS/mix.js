window.onload = function () {
    // click();
    cost();
    }
    
    // function click(){
    // $('#liquor').on('click', 'li', drink)
    // $('#juice').on('click', 'li', drink)
    // $('#soda').on('click', 'li', drink)
    // $('#type').on('click', 'li', drink)
    // }

    // function drink(){
    //     $('.drink').append(this);
    // }

    function cost(){

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function(){
            if(xhr.readyState == 4 ){
                var liquors = JSON.parse(xhr.responseText);
                console.log(liquors);
                for(let liq of liquors){
                    var li = $(`<li id="liquor${liq.id}" 
                        cost=${liq.cost}>
                                ${liq.type}
                                </li>`);
                    //then append to list
                    $('#liquor').append(li);
                }
                    
                }
                    //after you create list items
                    $('#mixTable').on('click', 'li', function(){var id = $(this).attr('id'); 
                    var cost = $(this).attr('cost');
                    //this will be your liquor ID
                })          
            }
        
        xhr.open('GET', `http://localhost:3000/liquor`);
        xhr.send();
        }
    //     xhr.open('GET', 'drinks.json', false);
    //     xhr.onreadystatechange = function () {
	//     if (xhr.readyState===4 && xhr.status===200) {			
	// 	var items = JSON.parse(xhr.responseText);
	// 	var output = ;
	// 	document.getElementById('cost').innerHTML = output;
	//     }
    //     }
    //     xhr.send();
