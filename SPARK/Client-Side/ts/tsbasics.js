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
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
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
var Point = /** @class */ (function () {
    function Point(x, y) {
        this.x = x; //must use "this" to refer to instance var
        this.y = y;
    }
    //method (function inside of class that doesnt use function keword)
    Point.prototype.getDistance = function () {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    };
    return Point;
}());
var pointA = new Point(5, 10);
console.log(pointA.getDistance());
pointA.x = 10;
// pointA.y = 10; //will not work since we made this private
//pointA.test = 'hi';
var Point3D = /** @class */ (function (_super) {
    __extends(Point3D, _super);
    function Point3D(x, y, z) {
        var _this = _super.call(this, x, y) || this;
        _this.z = z;
        return _this;
    }
    //overriding Point's getDistance(). must be of same return type
    Point3D.prototype.getDistance = function () {
        var dist = _super.prototype.getDistance.call(this);
        return Math.sqrt(dist * dist + this.z * this.z);
    };
    /*
    test is a protected instance var from this class's
    superclass, so it is accessible here, but not directly outside
    of these two classes
    */
    Point3D.prototype.setTest = function (str) {
        this.test = str;
    };
    Point3D.prototype.getTest = function () {
        console.log(this.test);
    };
    return Point3D;
}(Point));
var pointB = new Point3D(3, 4, 5);
console.log(pointB.getDistance());
//understanding private 
var Animal = /** @class */ (function () {
    function Animal(name) {
        this.name = name;
    }
    Animal.prototype.getName = function () {
        return this.name;
    };
    Animal.prototype.setName = function (name) {
        this.name = name;
    };
    return Animal;
}());
var animal = new Animal('Puppy');
//let animal2 = new Animal();//no overriden constructors  
//console.log(animal.name); //will not work; name is private
console.log(animal.getName()); //works. using Encapsulation***
//animal.name = 'Tomcat'; //same; still does not work
animal.setName('Tomcat');
//understanding protected 
var Person = /** @class */ (function () {
    function Person(name) {
        this.name = name;
    }
    return Person;
}());
var Employee = /** @class */ (function (_super) {
    __extends(Employee, _super);
    function Employee(name, department) {
        var _this = _super.call(this, name) || this;
        _this.department = department;
        return _this;
    }
    Employee.prototype.getElevatorPitch = function () {
        return "Hello, my name is " + this.name + " and I work\n        in " + this.department + ".";
    };
    return Employee;
}(Person));
var emp1 = new Employee("John", "Sales");
//console.log(emp1.name); //cannot access name directly outside of subclass
console.log(emp1.getElevatorPitch()); //works fine
/* READONLY modifier
    You can make properties read only.
    These properties must be initialized at their declaration or in the constructor
    Allows you to work in a functional way(unexpected mutation is bad)
    Can use modifier in interfaces as well. Can be initialized but not reassigned
*/
var Car = /** @class */ (function () {
    //  constructor(){} //CANNOT OVERLOAD CONSTRUCTORS, 
    //no arg constructor exists by default of none is defined
    function Car(brand) {
        this.numWheels = 4;
        this.brand = brand;
    }
    return Car;
}());
var car1 = new Car('Honda');
console.log(car1.brand);
console.log(car1.numWheels);
console.log(car1.year);
//car1.year = 2018;
/*  STATIC
Thus far, we've only discussed instance members of a class. But it's important
to note that we have static members, which are visible on the class itself
and not instances
*/
var Calculator = /** @class */ (function () {
    function Calculator() {
    }
    Calculator.add = function (a, b) {
        return a + b;
    };
    Calculator.subtract = function (a, b) {
        return a - b;
    };
    return Calculator;
}());
var numb = Calculator.add(10, 3);
/* ABSTRACT CLASS
Abstract classes are base classes from which other classes may be derived. They
may not be instantiated directly. Unlike an interface, an abstract class may
contain implementation details for its members. The abstract keyword is used
to define abstract classes as well as abstract methods within an abstract class

Methods within an abstract class that are marked abstract have no implementation
and must be implemented in derived classes; they must use the abstract keyword;
*/
var Account = /** @class */ (function () {
    function Account() {
    }
    return Account;
}());
var CheckingAccount = /** @class */ (function (_super) {
    __extends(CheckingAccount, _super);
    function CheckingAccount() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    CheckingAccount.prototype.generateReports = function () {
        console.log('concrete');
    };
    return CheckingAccount;
}(Account));
/*
There's lots more to explore with typescript. check out the handbook at
https://www.typescriptlang.org/docs/handbook/basic-types.html
*/
