//Types -- ts allows for strict typing ie once var is declared w type,
// it cannot be reassigned to a value of a different type
var num = 10;
var bool = true;
var str = 'hello world';
num = 20;
// num ='hello World';
//Arrays
var jsArray = [1, 'hello', null];
var tsArray = [1, 3, 4, 5];
//Any type
var randomVar;
randomVar = 10;
randomVar = 'hi';
randomVar = false;
//generic typed arrays --> Array<elemType>
var arr2 = [1, 4, 5];
arr2[0];
/**
 * Tuples
 * cannot switch the order
 */
var kv;
kv = [1, 'Gen B.'];
/**
 * Enum
 */
var Days;
(function (Days) {
    Days[Days["Monday"] = 0] = "Monday";
    Days[Days["Tuesday"] = 1] = "Tuesday";
    Days[Days["Wed"] = 2] = "Wed";
    Days[Days["thurs"] = 3] = "thurs";
})(Days || (Days = {}));
;
var today = Days.thurs;
console.log(today);
/**
 * Ts functions
 */
function add(a, b) {
    return a + b;
}
function doesNotReturn() {
    console.log('does not return');
}
function neverType() {
    throw new Error('never return type means the function never completes');
}
/**
 * type Assertions
 */
var something = "this something va is a string";
var len = something.length;
var test = something.length;
var u1 = {
    id: 1,
    username: 'testuser',
    password: 'pw',
    bio: 'hi i am  a user',
    createAccount: function () {
        return 100;
    }
};
var u2 = {
    id: 1,
    username: 'user2',
    password: '123',
    createAccount: function () {
        return 101;
    }
};
