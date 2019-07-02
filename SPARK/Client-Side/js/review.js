function testHoisting(){
    //var x;
    console.log(`x has not been declared yet. it is ${x}`);
    var x = 10;
    console.log(`x has been declared. it is ${x}`);
}
testHoisting();

console.log(`printing x outside of function test Hoisting - ${x}`)

function test(){
    console.log("first");
}


function test(b){
    console.log("second");
}


test();

console.log(this);