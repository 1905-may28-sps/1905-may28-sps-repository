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
let num: number = 10;
let bool: boolean = true;
let str: string = 'hello world';

num = 20;
//num = 'hello world';

//ARRAYS
let jsArray = [1, 'hello', null, undefined,];
let tsArray: number[] = [1, 3, 4, 5, 6];

//any type
let randomVar: any;
randomVar = 10;
randomVar = 'hi this is a string now';
randomVar = false;


//generic typed arrays --> Array<elemType>
let arr2: Array<number> = [1, 4, 5,6];
arr2[0];


/*   Tuple:
Tuple types allow you to express an array where 
the type of a fixed number of elements is known, 
but need not be the same
*/ 
let kv: [number, string];
kv = [1, 'Genesis Bonds'];

let anotherTuple: [number, string, string];
anotherTuple = [1, 'hi', 'test'];
//cannot switch order:
//anotherTuple = ['test', 1, 'hi'];

/*
ENUM - way of giving friendly names to numeric values
*/
enum Days {Monday, Tuesday, Wed, Thurs, Fri};
let today: Days = Days.Thurs;
console.log(today);


/*
TS functions can have RETURN TYPES and we can 
specify the data types of our parameters 
*/
function add(a: number, b: number): number{
    return a + b;
}

function doesNotReturn(): void{
    console.log('does not return anything');
   // return 2; //does not work
}

function neverType(): never{
    throw new Error('never return type means the function never completes');
}

function anotherNever(): never{
    while(true){

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

let something: any = "this something var is a string";
let len: number = (<string>something).length;
let test = something.length; //still works here

/* INTERFACES
Defining an interface in TS allows you to type-check
combinations of variables. They do not transpile to JS
They exist solely to help developers
*/

interface User{
    id: number;
    username: string;
    password: string;
    bio?: string; //? indicates that this property is optional
    createAccount(): number; //functions can be properties, this is one that returns a number
}

let u1: User = {
    id: 1, 
    username: 'testuser', 
    password: 'pw', 
    bio: 'hi i am a user',
    createAccount: () => {
        return 100;
    }
}

let u2: User = {
    id: 2, 
    username: 'user2',
    password: '123',
    createAccount: ()=>{return 101;}
}

/* CLASSES
classes in TS are similar to classes in most OOP languages 
properties are made public by defauly but can be made private 
or protected
- when a member is private, it cannot be accessed from outside 
of its containing class
- protected acts similarly to private, except members declared 
protected can also be accessed in deriving classes 
- public entities can be accessed anywhere 
- "functions" inside of classes are now referred to as methods, 
and do not use the function keyword
 */

 class Point{
     x: number; //instance vars are publicly accessibly by default
     private y: number;

     constructor(x: number, y: number){
         this.x = x; //must use "this" to refer to instance var
         this.y = y;
     }

     //method (function inside of class that doesnt use function keword)
     getDistance(){
        return Math.sqrt(this.x*this.x + this.y*this.y);
     }
 }

 let pointA = new Point(5, 10);
 console.log(pointA.getDistance());
 pointA.x = 10;
// pointA.y = 10; //will not work since we made this private

class Point3D extends Point{
    z: number;
    constructor(x: number, y: number, z: number){
        super(x, y);
        this.z = z;
    }

    //overriding Point's getDistance(). must be of same return type
    getDistance(){
        let dist = super.getDistance();
        return Math.sqrt(dist*dist + this.z*this.z);
    }
}

let pointB = new Point3D(3, 4, 5);
console.log(pointB.getDistance());