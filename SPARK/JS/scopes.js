/*
UNDERSTANDING VARIABLE SCOPES
- Scope refers to the visibility of vairables 
- Basically, which part of your program can see or use the variable 
- in JavaScript, we can delcare variables in three ways: using the 
    let, const, or var keywords. They each allow us to do differnt things
- var - the original variable declaration keyword, only allows us to
    declare variables as GLOBAL or FUNCTION scope.
- let allows us to declare variables as BLOCK, FUNCTION, and GLOBAL scope
- const is the same as let, except it does not allow us to CHANGE our 
    variable values after they have been initialized

so what does any of this mean...

*/

//GLOBAL
var global = "this is a globally scoped varibale as it has "+
    "been declared outside of any function or block. This varibale "+
    "can be accessed ANYWHERE in this script, AND from within the browser";
global2 = "this is also a globally scoped variable. Any var "+ 
    "that is not declared is global. I repeat, ANY variable that " + 
    "is used without every being declared is G L O B A L";
let globalLet = "this is also a global var. ";
const globalConst = "this is a global constant value";

function test(){
    //the following three values are function scoped
    var functionScope = "This is a function scoped variable. it has " + 
    "been declared within a function";
    let functionScopeLet = "This, too, is a function scoped varibale, as " + 
    "it has been declared within a function OUTSIDE of any block of code";
    const functionScopeVar = "This is a constant value scoped within this "+
    "function. This value cannot change once we initialize it (which is " +
    "what we are doing now by setting the variable = to something)";


    if(true){
        //Everything between the above and below curly braces is a BLOCK of code
        var notBlockScope = "Even though this is declared within this " + 
        "block of code, it is NOT block scoped. Why? becuase VAR only " + 
        "lets us define GLOBAL and FUNCTION scoped variables. We can access " + 
        "this variable notBlockScope anywhere in our function test()";
        
        let blockScope = "THIS, friends, is a block-scoped variable. it will " + 
        "not be accessible outside of this if-statement. Why? because LET " + 
        "gives us the ABILITY to make BLOCK scoped variables if we declare " + 
        "them with LET within a BLOCK";

        const blockScopeConst = "this is a block scoped constant value";
    }
}
