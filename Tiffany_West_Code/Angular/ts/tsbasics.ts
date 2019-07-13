




 

//Types -- ts allows for strict typing ie once var is declared w type,
// it cannot be reassigned to a value of a different type
let num: number =10;
let bool: boolean  = true;
let str: string = 'hello world';


num = 20;
// num ='hello World';

//Arrays
let jsArray = [1,'hello', null];
let tsArray: number[] = [1,3,4,5];

//Any type
let randomVar: any;
randomVar = 10;
randomVar = 'hi';
randomVar = false;


//generic typed arrays --> Array<elemType>
let arr2: Array<number> = [1,4,5];
arr2[0];

/**
 * Tuples
 * cannot switch the order
 */

 let kv:[number, string];
 kv = [1, 'Gen B.'];

 /**
  * Enum 
  */

enum Days{Monday, Tuesday , Wed, thurs,};
let today: Days = Days.thurs;
console.log(today);

/**
 * Ts functions
 */

 function add(a:number,b:number):number {
     return a+b;
 }

 function doesNotReturn(): void {
     console.log('does not return');
 }

 function neverType(): never {
     throw  new Error ('never return type means the function never completes');
 }

 /**
  * type Assertions
  */

  let something: any = "this something va is a string";
  let len: number = (<string>something).length;
  let test = something.length;

  /**
   * interfaces
   */

   interface User{
       id:number;
       username: string;
       password: string;
       bio?: string; //optional
       createAccount(): number; //functions can be properties
   }

   let u1: User ={
       id: 1,
       username: 'testuser',
       password: 'pw',
       bio: 'hi i am  a user',
       createAccount: () =>{
           return 100;
       }

   }
   let u2: User ={
    id: 1,
    username: 'user2',
    password: '123',
    createAccount: () =>{
        return 101;
    }

}

/**
 * Classes
 */

 class Point{
     x: number; //instance vars are publicly accessible
      private y: number;

     constructor(x:number, y:number){
         this.x = x;
         this.y = y;
     }

     //method
     getDistance(){
         return Math.sqrt(this.x*this.x + this.y*this.y);
     }
 }

 let pointA = new Point(5,10);
 console.log(pointA.getDistance());
 pointA.x = 10;

 class Point3D extends Point //extends here
 {
     z:number;
     constructor(x:number, y:number, z:number){
        super(x,y);
        this.z =z;
     };

     //overriding Points getDistance

     getDistance(){
         let dist = super.getDistance();
         return Math.sqrt(dist*dist + this.z* this.z);
     }
 }
 let pointB = new Point3D(3,4,5);
    console.log(pointB.getDistance());


/**
 * READONLY  modifiers
 */

 class Car{
     readonly brand: string;
     readonly numWheels: number = 4;
     readonly year: number;


     // cannot overload constructors
     // no arg constructor exists by default of none is defined
     constructor(brand: string){
         this.brand = brand;
     }
 }

 let car1 = new Car('Honda');
 console.log(car1.brand);
 console.log(car1.numWheels);
 console.log(car1.year);
 //car1.year = 2019;


 /**Static
  * 
  */
class Calculator {
    static add(a: number, b: number): number {
        return a+b;
    }
    static subtract(a: number, b: number): number {
        return a-b;
    }
}
let numb = Calculator.add(10,3);

/**Abstract classes */

abstract class Account{
    abstract generateReports():void;
}
class CheckingAccount extends Account
{
    generateReports(){
        console.log('concrete');
    }
}
