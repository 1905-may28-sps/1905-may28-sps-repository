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

		while(whole>0){

			int rem = whole%16;

			if(rem<10) { output = rem+output;}

			else{

				switch(rem){

				case 10: output = 'a'+ output; break;

				case 11: output = 'b'+ output; break;

				case 12: output = 'c'+ output; break;

				case 13: output = 'd'+ output; break;

				case 14: output = 'e'+ output; break;

				case 15: output = 'f'+ output; break;

				}

			}

			whole = (whole-rem)/16;

		}
		System.out.println(output);
		return output;
		
	}

}
