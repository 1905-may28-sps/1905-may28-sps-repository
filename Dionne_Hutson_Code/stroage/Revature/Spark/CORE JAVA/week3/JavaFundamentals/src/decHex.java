import java.util.Scanner;

public class decHex {

	private static int opt;
	private static Scanner scan;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a base 10 number");
		scan=new Scanner(System.in);
		opt=scan.nextInt();
		decHexMeth(opt);

	}

	public static String decHexMeth(int whole) {
		// TODO Auto-generated method stub
		String output="";

		while(whole>0){// when whole ==0 wthe number is no longer divisible by 16

			int rem = whole%16;

			if(rem<10) { output = rem+output;}// add this value in front of string

			else{

				switch(rem){//if the remainder is greater than 9, then that is equal to a letterinhex, as opposed to a nuber
// the cases are from 10-15 because rem cannot be 16 ever
				case 10: output = 'a'+ output; break;

				case 11: output = 'b'+ output; break;

				case 12: output = 'c'+ output; break;

				case 13: output = 'd'+ output; break;

				case 14: output = 'e'+ output; break;

				case 15: output = 'f'+ output; break;

				}

			}

			whole = (whole-rem)/16;// we we replace whole with the quotient(not including the remainder from the div// when this value is zero we exit the while loop
			

		}
		System.out.println(output);
		return output;// made this a return so that I could test it
		
	}

}
