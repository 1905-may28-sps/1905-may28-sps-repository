function intoHex(){
    var num = Number(document.getElementById("conersionInput").value);
    //sanity check
    console.log(num);
    var out = "";
    while(num>0){
        var remainder = num%16;
        if(rem<10) out = remainder+out;
        else{
            switch(remainder){
                case 10: out = 'a'+ out; break;
                case 11: out = 'b'+ out; break;
                case 12: out = 'c'+ out; break;
                case 13: out = 'd'+ out; break;
                case 14: out = 'e'+ out; break;
                case 15: out = 'f'+ out; break;
            }
        }
        num = (num-remainder)/16;
    }
    console.log(out);
    document.getElementById('convOut').innerHTML = out;
}