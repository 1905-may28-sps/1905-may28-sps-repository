window.onload = loadname();
document.getElementById('joke').addEventListener('click', enterJoke);
document.getElementById('getWeather').addEventListener('click',getWeather);


function loadname() {
    var urlParams = new URLSearchParams(window.location.search);
    var myParam1 = urlParams.get('name');
    //alert(myParam1);
    var myParam2 = urlParams.get('lastname');
    //alert(myParam2);
    document.getElementById("displayName").innerHTML = myParam1 + " " + myParam2;
}

function enterJoke() {
    var num = document.getElementById('num').value;
    
    if (num == 0 || num == " ") {
        document.getElementById('message3').innerHTML =
            "Please enter a valid numeric !";
    }
    else {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState == 4) {
                var jokeJSON = JSON.parse(xhttp.responseText);
                var jokefoundflag = false;
                for (var i=0;i<jokeJSON.value.length;i++)
                {
                    if (jokeJSON.value[i].id == num) 
                    {
                        var joke = jokeJSON.value[i].joke;
                        // alert(joke);
                        document.getElementById('message3').innerHTML = joke;
                        jokefoundflag = true;                    
                    }                   
                }

                if (jokefoundflag == false)
                    {
                        document.getElementById('message3').innerHTML = "No Jokes Found!";
                    }                           
            }
        }
        xhttp.open('GET', `http://api.icndb.com/jokes`);
        xhttp.send();
    }  
}

function getWeather(){
    var xhttp = new XMLHttpRequest;
    var city= "new york"
    var url= "http://api.openweathermap.org/data/2.5/weather?q="+city+",us&units=imperial&APPID=859d47520ac736ebe8bbce1fef74269c";
    xhttp.onreadystatechange = function (){
        console.log(xhttp.responseText);
        if (xhttp.readyState == 4){
            var weatherArr = JSON.parse(xhttp.responseText); 
            var temp = weatherArr.main.temp;    
            var pressure = weatherArr.main.pressure;
            var humidity = weatherArr.main.humidity;
            document.getElementById('message5').innerHTML = (" Temperature: " +temp 
            + " Pressure: " + pressure + " Humidity: " +humidity );
        }
    } 
    xhttp.open('GET',url );
    xhttp.send();
}


