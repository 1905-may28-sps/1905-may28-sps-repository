function testHoisting(){
    //var x;
   // console.log(`x has not been declared yet. it is ${x}`);
     x = 10;
    console.log(`x has been declared. it is ${x}`);
}
testHoisting();

console.log(`printing x outside of function test Hoisting - ${x}`)