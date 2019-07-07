var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
//StrictTyping
var num = 10;
var bool = true;
var str = 'hello world';
num = 20;
var jsArray = [1, 'hello', null, undefined,];
var tsArray = [1, 2, 4, 5, 6];
var randomVar; //best practice to always strictly type anny still allows for any type
randomVar = 10;
randomVar = 'string now';
randomVar = false;
//generic tryped array     Array<elemType>
var arr2 = [1, 4, 5, 6];
arr2[0];
//Tuple array we can declare what type we want
var kv;
kv = [1, 'Genesis Bonds'];
var anothertuple;
anothertuple = [1, 'hi', 'test'];
//anothertuple=['test',1,'hi'];// no can do
//enum a way of giving friendly names to numeric values
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
//Ts functions can have return types and specify data type of parameters
function add(a, b) {
    return a + b;
}
function doesNotReturn() {
    console.log('no return');
    //return 2;//does not work
}
//don't bother with never functions
function neverType() {
    throw new ErrorEvent('never return type means the function never completes');
}
function anotherNever() {
    while (true) {
    }
}
//type assertion -- i know what im doing-- see this wen senidng http request with angular specifiy ype of object retrieved with observable
var something = "this somethig var is a string";
var len = something.length;
var test = something.lenth; // still works in this format
var u1 = {
    id: 1,
    username: 'testUser',
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
/* class with acess modifiers and function like methods*/
var Point = /** @class */ (function () {
    function Point(x, yPoint) {
        this.x = x;
        this.y = yPoint;
    }
    // method function inside of class
    Point.prototype.getDistance = function () {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    };
    return Point;
}());
//instance of point
var pointa = new Point(5, 10);
console.log(pointa.getDistance());
pointa.x = 10;
//pointa.y=10;//wllnot work, this is private
//subclasses
var Point3d = /** @class */ (function (_super) {
    __extends(Point3d, _super);
    function Point3d(x, y, z) {
        var _this = _super.call(this, x, y) || this;
        _this.z = z;
        return _this;
    }
    //override get distance . must have same return type
    Point3d.prototype.getDistance = function () {
        var dist = _super.prototype.getDistance.call(this);
        return Math.sqrt(dist * dist + this.z * this.z);
    };
    Point3d.prototype.setTest = function (str) {
        this.test = str;
    };
    Point3d.prototype.getTest = function () {
        console.log(this.test);
    };
    return Point3d;
}(Point));
var pointb = new Point3d(3, 4, 5);
console.log(pointb.getDistance());
// read only modifier
var Car = /** @class */ (function () {
    // constructor(){    }// cannot overload constructors// no args constructor exsists by default if none is defined
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
