package q24;

import java.util.Scanner;

public class base10toHex {

	public static void main(String[] args) {
		 int num,counter=0;
	        @SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
	     
	        System.out.print("Enter any integer number: ");
	        num = sc.nextInt();
	     
	        String hexVal="";
	        int dig;
	        while(num > 0){
	            dig= num%16;
	            switch(dig)
	            {
	                case 15:
	                    hexVal+="F"; break;
	                case 14:
	                    hexVal+="E"; break;
	                case 13:
	                    hexVal+="D"; break;
	                case 12:
	                    hexVal+="C"; break;
	                case 11:
	                    hexVal+="B"; break;
	                case 10:
	                    hexVal+="A"; break;
	                default:
	                    hexVal+=Integer.toString(dig);          
	            }
	            num = num/16;
	        }
	     
	        for(counter=hexVal.length()-1;  counter>=0; counter--)
	            System.out.print(hexVal.charAt(counter));

	}

}
