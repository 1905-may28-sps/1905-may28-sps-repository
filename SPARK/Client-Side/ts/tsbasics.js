/*
TypeScript is a superset of JS, meaning that any valid
JS code is also valid TS code, however TS code must be
TRANSPILED into JS code.
(not compiled, in the sense of turning our code into some
    sort of bytecode but transpiled turning our TS into
    valid vanilla JS to be interpreted by the browser)

- TS allows for strict typing, arrow notation, interfaces,
classes, constructors, access modifiers, properties, and
modules

- Strict typing is optional but it is encouraged
- number, boolean, string, void, null, undefined, any, never
*/
//TYPES - TS allows for strict typing ie once var is declared w type, 
// it cannot be reassigned to a value of a different type 
var num = 10;
var bool = true;
var str = 'hello world';
num = 20;
//num = 'hello world';
//ARRAYS
var jsArray = [1, 'hello', null, undefined,];
var tsArray = [1, 3, 4, 5, 6];
//any type
var randomVar;
randomVar = 10;
randomVar = 'hi this is a string now';
randomVar = false;
//generic typed arrays --> Array<elemType>
var arr2 = [1, 4, 5, 6];
arr2[0];
/*   Tuple:
Tuple types allow you to express an array where
the type of a fixed number of elements is known,
but need not be the same
*/
var kv;
kv = [1, 'Genesis Bonds'];
var anotherTuple;
anotherTuple = [1, 'hi', 'test'];
//cannot switch order:
//anotherTuple = ['test', 1, 'hi'];
/*
ENUM - way of giving friendly names to numeric values
*/
var Days;
(function (Days) {
    Days[Days["Monday"] = 0] = "Monday";
    Days[Days["Tuesday"] = 1] = "Tuesday";
    Days[Days["Wed"] = 2] = "Wed";
    Days[Days["Thurs"] = 3] = "Thurs";
    Days[Days["Fri"] = 4] = "Fri";
})(Days || (Days = {}));
;
var today = Days.Thurs;
console.log(today);
/*
TS functions can have RETURN TYPES and we can
specify the data types of our parameters
*/
function add(a, b) {
    return a + b;
}
function doesNotReturn() {
    console.log('does not return anything');
    // return 2; //does not work
}
function neverType() {
    throw new Error('never return type means the function never completes');
}
function anotherNever() {
    while (true) {
    }
}
/*
Type Assertions
- a way to tell the transpiler "hey i know what im doing"
- its like a type cast in other languages, but performs
no special checking or restructuring of data. it is purely
used by the transpiler
- will see this a lot when sending HTTP requests with
angular, as we must specify the type of object we intend to
retrieve with our Observable
*/
var something = "this something var is a string";
var len = something.length;
var test = something.length; //still works here
var u1 = {
    id: 1,
    username: 'testuser',
    password: 'pw',
    bio: 'hi i am a user',
    createAccount: function () {
        return 100;
    }
};
var u2 = {
    id: 2,
    username: 'user2',
    password: '123',
    createAccount: function () { return 101; }
};
