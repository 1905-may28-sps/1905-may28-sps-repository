//StrictTyping
let num: number=10;
let bool: boolean=true;
let str:string='hello world';

num=20;
let jsArray=[1,'hello',null,undefined,];
let tsArray: number[]=[1,2,4,5,6];

let randomVar: any;//best practice to always strictly type anny still allows for any type
randomVar=10;
randomVar='string now';
randomVar=false;

//generic tryped array     Array<elemType>
let arr2:Array<number>=[1,4,5,6];
arr2[0];



//Tuple array we can declare what type we want
let kv:[number,string];
kv=[1,'Genesis Bonds'];
let anothertuple: [number, string, string];
anothertuple=[1,'hi','test'];
//anothertuple=['test',1,'hi'];// no can do



//enum a way of giving friendly names to numeric values
enum Days {Monday,Tuesday, Wed, Thurs,Fri};
let today:Days= Days.Thurs;
console.log(today);


//Ts functions can have return types and specify data type of parameters

function add(a:number,b:number): number{
    return a+b;
}

function doesNotReturn():void{
    console.log('no return');
    //return 2;//does not work
}
//don't bother with never functions
function neverType(): never{
    throw new ErrorEvent('never return type means the function never completes');
}
function anotherNever(): never{
    while(true){

    }
}

//type assertion -- i know what im doing-- see this wen senidng http request with angular specifiy ype of object retrieved with observable
let something : any="this somethig var is a string";
let len: number=(<string>something).length;
let test:number = something.lenth;// still works in this format



/*Interfaces
not like java
make objects that holds properties of diff types */
interface User{
    id:number;
    username:string;
    password: string;
    bio?:string;//? means optuional
    createAccount(): number;//function which returns number
}

let u1: User={
    id:1,
    username:'testUser',
    password:'pw',
    bio: 'hi i am a user',
    createAccount: ()=>{
        return 100;

    }
}
let u2: User={
    id:2,
    username:'user2',
    password:'123',
    createAccount:()=>{return 101;}
}

/* class with acess modifiers and function like methods*/

class Point{
    x:number;// public acess modifier by default
    private y:number;
    protected test: string;

    constructor(x: number, yPoint:number){
        this.x=x;
        this.y=yPoint;
    }
    // method function inside of class
    getDistance(){
        return Math.sqrt(this.x*this.x+this.y*this.y);
    }
}
//instance of point
let pointa=new Point(5,10);
console.log(pointa.getDistance());
pointa.x=10;
//pointa.y=10;//wllnot work, this is private

//subclasses
class Point3d extends Point{
    z:number;
    constructor(x:number, y:number,z:number){
        super(x,y);
        this.z=z;
    }
    //override get distance . must have same return type
    getDistance(){
        let dist=super.getDistance();
        return Math.sqrt(dist*dist+this.z*this.z);

    }
    setTest(str:string){
        this.test=str;
    }
    getTest(){
        console.log(this.test);
    }
}


let pointb=new Point3d(3,4,5);
console.log(pointb.getDistance());

// read only modifier
class Car{
    readonly brand: string;
    readonly numWheels: number=4;
    readonly year: number;
   // constructor(){    }// cannot overload constructors// no args constructor exsists by default if none is defined
    constructor(brand: string){
        this.brand=brand;
    }
    // setYear(year:number){
    //     this.year=year;
    // }//this will not work
}
let car1=new Car('Honda');
console.log(car1.brand);
console.log(car1.numWheels);
console.log(car1.year);
//car1.year=2018// once value is created/instatiated we cannot set it, we can only read it

//static
class Calculator{
    static add(a:number,b:number):number{
        return a+b;
    }
    static subtract(a:number,b:number):number{
        return a-b;
    }
}
let numb= Calculator.add(10,3);




// abstract class
abstract class Account{
    abstract generateReports():void;
}
class CheckingAccount extends Account{
    generateReports(){
        console.log('concrete');
    }
}