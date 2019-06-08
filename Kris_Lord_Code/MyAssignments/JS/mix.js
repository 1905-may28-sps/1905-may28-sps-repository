window.onload = function () {
    // click();
    liquor();
    juice();
    soda();
    type();
    startOver();
    order();
}

function liquor() {

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var liquors = JSON.parse(xhr.responseText);
            console.log(liquors);
            for (let liq of liquors) {
                var li = $(`<li id="liquor${liq.id}" 
                        cost=${liq.price}>
                                ${liq.type}
                                </li>`);
                //then append to list
                $('#liquor').append(li);
            }


            //after you create list items
            $('#liquor').on('click', 'li', function () {
                $('.drink').append(this);
                var id = $(this).attr('id');
                var cost = $(this).attr('cost');
                console.log(id);
                console.log(cost);
                //this will be your liquor ID
                let currCostStr = $('#liquorCost').html();
                let total = Math.floor(currCostStr) + Math.floor(cost); //make this a number, not a string
                console.log(total);
                $('#liquorCost').html(total);
                totalLiqCost=total;
            })

        }
    }

    xhr.open('GET', `http://localhost:3000/liquor`);
    xhr.send();
}

function juice() {

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var juice = JSON.parse(xhr.responseText);
            console.log(juice);
            for (let jui of juice) {
                var li = $(`<li id="juice${jui.id}" 
                            cost=${jui.price}>
                                    ${jui.name}
                                    </li>`);
                //then append to list
                $('#juice').append(li);
            }


            //after you create list items
            $('#juice').on('click', 'li', function () {
                $('.drink').append(this);
                var id = $(this).attr('id');
                var cost = $(this).attr('cost');
                console.log(id);
                console.log(cost);
                //this will be your juice ID
                let currCostStr = $('#juiceCost').html();
                let total = Math.floor(currCostStr) + Math.floor(cost); //make this a number, not a string
                console.log(total);
                $('#juiceCost').html(total);
                totalJuiCost=total;
            })

        }
    }

    xhr.open('GET', `http://localhost:3000/juice`);
    xhr.send();
}

function soda() {

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var soda = JSON.parse(xhr.responseText);
            console.log(soda);
            for (let sod of soda) {
                var li = $(`<li id="soda${sod.id}" 
                                cost=${sod.price}>
                                        ${sod.name}
                                        </li>`);
                //then append to list
                $('#soda').append(li);
            }


            //after you create list items
            $('#soda').on('click', 'li', function () {
                $('.drink').append(this);
                var id = $(this).attr('id');
                var cost = $(this).attr('cost');
                console.log(id);
                console.log(cost);
                //this will be your soda ID
                let currCostStr = $('#sodaCost').html();
                let total = Math.floor(currCostStr) + Math.floor(cost); //make this a number, not a string
                console.log(total);
                $('#sodaCost').html(total);
                totalSodCost=total;
            })

        }
    }

    xhr.open('GET', `http://localhost:3000/soda`);
    xhr.send();
}

function type() {

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var type = JSON.parse(xhr.responseText);
            console.log(type);
            for (let ty of type) {
                var li = $(`<li id="type${ty.id}" 
                                    cost=${ty.price} photo=${ty.img} name=${ty.name}>
                                            ${ty.name}
                                            </li>`);
                //then append to list
                $('#type').append(li);
            }


            //after you create list items
            $('#type').on('click', 'li', function () {
                $('.drink').append(this);
                var id = $(this).attr('id');
                var cost = $(this).attr('cost');
                photoType = $(this).attr('photo');
                photoName = $(this).attr('name');
                console.log(id);
                console.log(cost);
                console.log(photoType);
                //this will be your type ID
                let currCostStr = $('#typeCost').html();
                let total = Math.floor(currCostStr) + Math.floor(cost); //make this a number, not a string
                console.log(total);
                $('#typeCost').html(total);
                totalTyCost=total;
            })

        }
    }

    xhr.open('GET', `http://localhost:3000/type`);
    xhr.send();
}

function startOver() {
document.getElementById("reset").addEventListener('click',reset);
}

function reset(){
    location.href = "mix.html";
}

function order(){
    document.getElementById("order").addEventListener('click',orderSummary);
}

function orderSummary(){
    document.getElementById("mixTable").remove();
    document.getElementById("orderSummary").removeAttribute("hidden");
    document.getElementById("photoType").src=photoType;
    document.getElementById("totalCost").innerHTML=totalLiqCost+totalJuiCost+totalSodCost+totalTyCost;

}