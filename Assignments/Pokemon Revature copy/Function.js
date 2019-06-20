window.onload = function(){

let list = document.getElementById("listPokemon")
                //create dynamic id to generate different poke monsters
            function consultPokemon(id, num) {
                fetch(`https://pokeapi.co/api/v2/pokemon/${id}`)
                .then(function (response){
                    response.json()
                    .then(function(pokemon){
                        createPokemon(pokemon, num)
                    })
                })
            }
                //button function
                function getMoves(url) {
                    console.log(url);
                    fetch(url)
                        .then(function (response) {
                            response.json()
                                .then(function (moves) {
                                    console.log(moves);
                                    console.log(moves.power);
                                     mon1Power = moves.power;
                    console.log(mon1Power);
                                    
                                })
                        })
                }
                function getForms(url) {
                    console.log(url);
                    fetch(url)
                        .then(function (response) {
                            response.json()
                                .then(function (forms) {
                                    console.log(forms);
                                })
                        })
                }
                //end button function

                //create a diff function which calls multiple sets of data
                function consultPokemons() {
                    let primeId = Math.round(Math.random() * 150)
                    let secondId = Math.round(Math.random() * 150)
                    let thirdId = Math.round(Math.random()* 150)
        
                    consultPokemon(primeId, 1)
                    consultPokemon(secondId, 2)
                    consultPokemon(thirdId, 3)
                }
                
            function createPokemon(pokemon, num) {
                let item = list.querySelector(`#pokemon-${num}`)
                
                let image = item.getElementsByTagName("img")[0]
                image.setAttribute("src", pokemon.sprites.front_default)
                
                
                let name  = item.getElementsByTagName("h1")[0] 
                name.textContent = pokemon.name
                name.textContent = pokemon.name

                let hp  = item.getElementsByTagName("h3")[0] 
                hp.textContent = pokemon.stats[5].base_stat

                //button Logic

                var move1 = item.getElementsByClassName("move1")[0]
           
            move1.textContent = (pokemon.moves[4].move.name + '' + pokemon.moves.power); 
            console.log(move1.textContent = pokemon.moves[0].move.name);

            var move2 = item.getElementsByClassName("move2")[0]
            move2.textContent = pokemon.moves[1].move.name;
            console.log(move2.textContent = pokemon.moves[1].move.name);

            var move3 = item.getElementsByClassName("move3")[0]
            move3.textContent = pokemon.moves[2].move.name;
            console.log(move3.textContent = pokemon.moves[2].move.name);

            var move4 = item.getElementsByClassName("move4")[0]
            move4.textContent = pokemon.moves[3].move.name;
            console.log(move4.textContent = pokemon.moves[3].move.name);

            document.getElementById('trainer1Name').innerHTML = JSON.parse(localStorage.trainer1);
            document.getElementById('trainer2Name').innerHTML = JSON.parse(localStorage.trainer2);
                
            }
            consultPokemons();

        }