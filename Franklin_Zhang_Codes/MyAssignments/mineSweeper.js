window.onload = function(){
    document.getElementById('login').addEventListener('click',loginUser);
    document.getElementById('register').addEventListener('click',registerUser);
    var gRegElements = document.getElementsByClassName('goRegister');
        for(let e of gRegElements){
            e.addEventListener('click',swapLog2Reg);
        }
    
    var gLogElements = document.getElementsByClassName('goLogin');
        for(let e of gLogElements){
            e.addEventListener('click',swapReg2Log);
        }
}
function validateRegUserName(){
    var username = document.getElementById('logUsername').value;
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function(){
    console.log(xhttp.readyState)
    if(xhttp.readyState == 4){
        var userArr = JSON.parse(xhttp.responseText);
        if(userArr.length == 0){
            document.getElementById('message').innerHTML = '';
            document.getElementById('register').removeAttribute('disabled');
        }
        else{
            document.getElementById('message').innerHTML = 
                'Username has been taken, please choose a different one';
            document.getElementById('register').setAttribute('disabled', "true");
        }
    }
}
xhttp.open("GET", `http://localhost:3000/users?username=${username}`);
xhttp.send();
}
function registerUser(){
    var userObj = {
        username : document.getElementById('logUsername').value,
        password : document.getElementById('logPass').value,
        highScore : '0'
}
var fieldEmptyTest = false;
for(let prop in userObj){
    if(userObj[prop] == null || userObj[prop].trim() == ''){
        fieldEmptyTest = true;
        document.getElementById('message').innerHTML = 
        'Sorry, please fill out form completely';
    }
}
    if(fieldEmptyTest == false){
        document.getElementById('message').innerHTML = '';
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function(){
            if(xhr.readyState == 4){
                console.log(xhr.status);
                alert('Thank you for registering!')
                swapReg2Log();
            }
        }
    xhr.open('POST', 'http://localhost:3000/users');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(userObj));
}
}


//   function showLoginView(){
//     document.getElementById('registrationForm').remove();
//     document.getElementById('loginForm').removeAttribute('hidden');
//     //add listener for login button
//     document.getElementById('login').addEventListener('click', login)
// }

function loginUser(){
    var name = document.getElementById('logUsername').value;
    var pass = document.getElementById('logPass').value;
    if(name == null || name.trim() == '' || pass == null || pass.trim() == ''){
        document.getElementById('message').innerHTML = "All fields must be completed";
    }
    else{
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function(){
            if(xhr.readyState == 4){
                var userArr=JSON.parse(xhr.responseText);
                if(userArr.length==0){
                    document.getElementById('message').innerHTML= '<i class="goLogin">Username Does NOT Exist! Please try again or create one here!</i>';
                    }
                else if(userArr[0].password == document.getElementById('logPass').value){
                    //alert('Login Success');
                    //remove logon
                    document.getElementById('loginRegPage').remove();
                    //add in game
                    window.location = 'Minesweeper.html';
                    //console.log(userArr[0].username);
                    
                }
                else{document.getElementById('message').innerHTML="Password does not match, please try again"}
            
            //document.getElementById('message2').innerHTML="Welcome " + userArr[0].username + " Hope you enjoy this Experience";
          }}
        xhr.open('GET', `http://localhost:3000/users`);
        xhr.send();
    }
}
function swapLog2Reg(){
    document.getElementById('logField').setAttribute('hidden',true);
    document.getElementById('regField').removeAttribute('hidden');
}       
function swapReg2Log(){
    document.getElementById('regField').setAttribute('hidden',true);
    document.getElementById('logField').removeAttribute('hidden');

}
















//call the grid element from the html page
//Generate grid

var mineGrid = document.getElementById("grid");
var clickedMode = false; //Becomes true for tiles with mines
var score=0;
createGrid();

function createGrid() {
mineGrid.innerHTML="";
for (var i=0; i<10; i++) {
row = mineGrid.insertRow(i);   //Generates a grid with 10 rows and 10 columns    
for (var j=0; j<10; j++) {
  cell = row.insertCell(j);              
  cell.onclick = function() { selectedTile(this); };
  var isMine = document.createAttribute("data-mine");       
 isMine.value = "false";             
  cell.setAttributeNode(isMine);
}
}
//saveScore();
createMines();
}

// 20 Mines are created randomly along the grip
function createMines() {
for (var i=0; i<20; i++) {
var hori = Math.floor(Math.random() * 10);
var vert = Math.floor(Math.random() * 10);
var tile = grid.rows[hori].cells[vert];
tile.setAttribute("data-mine","true");
if (clickedMode) tile.innerHTML="X";
score = 0;
}
}


//Highlights all 20 mines
function showMines() {
   for (var i=0; i<10; i++) {
  for(var j=0; j<10; j++) {
    var tile2 = grid.rows[i].cells[j];
    if (tile2.getAttribute("data-mine")=="true") tile2.className="isMine";
  }
}
}

function isGameComp() {
var GameOver = true;
for (var i=0; i<10; i++) {
  for(var j=0; j<10; j++) {
    if ((grid.rows[i].cells[j].getAttribute("data-mine")=="false") && (grid.rows[i].cells[j].innerHTML=="")) GameOver=false;
    
  }
}
if (GameOver) {
alert("You Win!" + " You scored " + score);
showMines();
saveScore();
createGrid();
}

}

//checks to see if the user selected a mine
function selectedTile(tile) {
if (tile.getAttribute("data-mine")=="true") {
showMines();
//getScore();
alert("Game Over" + " You scored " + score);
saveScore();
createGrid();
} 
else {
tile.className="clicked";


var numOfMines=0;
var tileRow = tile.parentNode.rowIndex;                             //Counts and displays the number of adjacent mines
var tileCol = tile.cellIndex;


for (var i=Math.max(tileRow-1,0); i<=Math.min(tileRow+1,9); i++) {
  for(var j=Math.max(tileCol-1,0); j<=Math.min(tileCol+1,9); j++) {
    if (grid.rows[i].cells[j].getAttribute("data-mine")=="true") numOfMines++;
  }
}
tile.innerHTML=numOfMines;
if (numOfMines==0) { 
  for (var i=Math.max(tileRow-1,0); i<=Math.min(tileRow+1,9); i++) {
    for(var j=Math.max(tileCol-1,0); j<=Math.min(tileCol+1,9); j++) {       //reveals all adjacent tiles without mines
      if (grid.rows[i].cells[j].innerHTML=="") selectedTile(grid.rows[i].cells[j]);
    }
  }
}
isGameComp(); 
}
if((tile.className="clicked")){

     score++

  }
//if(isGameComp()){

}    








function saveScore(){

var nScore = score;
var scoreObj = {
score : nScore
}

var xhr2 = new XMLHttpRequest();

xhr2.onreadystatechange = function(){
if(xhr2.readyState == 4){
  console.log(xhr2.status);;
}   
}
xhr2.open('POST', `http://localhost:3000/scores`);
xhr2.setRequestHeader('Content-Type', 'application/json');
xhr2.send(JSON.stringify(scoreObj));

}

/* $.ajax(`http://localhost:3000/users/${user}`, {
method:'PUT',
contentType: 'application/json',
processData: false,
data: JSON.stringify({
  highScore: score
})

})

.then(
function Success(users){
  console.log(users)
}
)*/