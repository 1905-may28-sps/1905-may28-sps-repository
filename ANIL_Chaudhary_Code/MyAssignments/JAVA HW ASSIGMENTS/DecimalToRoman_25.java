// To convert Decimal Number to Roman
package javaAssignments;
import java.util.Scanner;
public class DecimalToRoman_25 {

	public static void main(String[] args) {

		/*
		ROMAN      DECIMAL
		 
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
		
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a number : ");
		int num = reader.nextInt(); 
		reader.close();
		 {
        String roman = DecimalToRoman_25.toRoman(num);
        int number = DecimalToRoman_25.toNumber(roman);
		
        System.out.println("For Decimal Number " +number + " Roman Numeral is   " + roman);
	}
        }

    private static String toRoman(int number) {
        return String.valueOf(new char[number]).replace('\0', 'I')
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

    private static Integer toNumber(String roman) {
        return roman.replace("CM", "DCD")
                .replace("M", "DD")
                .replace("CD", "CCCC")
                .replace("D", "CCCCC")
                .replace("XC", "LXL")
                .replace("C", "LL")
                .replace("XL", "XXXX")
                .replace("L", "XXXXX")
                .replace("IX", "VIV")
                .replace("X", "VV")
                .replace("IV", "IIII")
                .replace("V", "IIIII").length();
    }
}