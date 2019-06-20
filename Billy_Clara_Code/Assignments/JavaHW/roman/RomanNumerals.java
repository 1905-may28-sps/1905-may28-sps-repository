package com.billy.roman;

public class RomanNumerals {
	
	public static void main(String[] args) {
		System.out.println(String.valueOf(new char[90]).replace('\0', 'I'));
	}
	
	public String convert(int num) {
		
		//Tried out the code that we saw in the morning of 6/20 but
		//not it is not working. Have to test it.
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

}
