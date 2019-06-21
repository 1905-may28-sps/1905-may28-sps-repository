package q25;

import java.util.Scanner;

public class numToRoman {
    public static void main(String[] args) {
    	
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
    	System.out.println("Enter a number below 5000");
    	int number =sc.nextInt();
    	if (number < 5000) {
            String roman = numToRoman.toRoman(number);
      
            System.out.println(number + "=" +roman);
    	}else {
    		System.out.println(number + " is bigger than 5000. Please try again!");
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
  
}
