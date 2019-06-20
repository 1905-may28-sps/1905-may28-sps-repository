package com.rev.p1;

public class RomanNumerals {
	/*
	 * number range 1-4999
SYMBOL       VALUE
I             1
IV            4
V             5
IX            9
X             10
XL            40
L             50
XC            90
C             100
CD            400
D             500
CM            900 
M             1000  
	 */
	
	public static void main(String[] args) {
		System.out.println(String.valueOf(new char[90]).replace('\0', 'I'));
	}
	
	public String convert(int num) {
		return String.valueOf(new char[num]).replace('\0', 'I')
        .replace("IIIII", "V")
        .replace("IIII", "IV")
        .replace("VV", "X")
        .replace("VIV", "IX")
        .replace("XXXXX", "L")
        .replace("XXXX", "XL")
        .replace("LL", "C")
        .replace("LXL", "XC")
        .replace("CCCCC", "D")
        .replace("CCCC", "CD")
        .replace("DD", "M")
        .replace("DCD", "CM");
	}
	
	public String convert2(int num) {
		if(num < 1 || num > 4999) return null;
		String roman = "";
		while(num>0) {
			if(num>=999) { // M
				// 999 -> CMXCIX

				roman += "M";
				num -= 1000;
			}
			else if(num>=500) { //D
				
			}
			else if(num>=100) { //C
				
			}
			else if(num>= 50) { //L
				
			}
			else if(num>= 10) { //X
				
			}
			else if(num>5) { // V
				
			}
			else { // < 5 -> I
				
			}
		}
		
		return null;
	}

}
