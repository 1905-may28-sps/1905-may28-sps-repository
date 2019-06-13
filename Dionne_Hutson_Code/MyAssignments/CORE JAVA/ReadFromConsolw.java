import java.util.Scanner;

public class ReadFromConsolw {
	static String name;
	static String opt;
	static Scanner scan;

	public static void main(String[] args) {
		System.out.println("Whats your name?");
		scan=new Scanner(System.in);
		name=scan.nextLine();

		System.out.println("Hi "+name+"\n Would you like to: \n(1) Dec->Hex\n(2)Hex->Dec?");

		opt=scan.nextLine();
		System.out.println(opt);
		option(opt);

	}
	public static void option(String option) {
		switch(option) {
		case "1":
			System.out.println("You chose Dec to Hex. Enter a decimal number");
			opt=scan.nextLine();
			System.out.println(opt);
			dechex(opt);
			break;
		case "2":
			System.out.println("You chose Hex to Dex.Enter a hex number");
			opt=scan.nextLine();
			System.out.println(opt);
			hexdec(opt);


			break;
		default: System.out.println("You did not enter 1 or 2 try again");
		tryAgain();

		}

	}

	public static void tryAgain() {
		System.out.println("Hi "+name+"\n Would you like to: \n(1) Dec->Hex\n(2)Hex->Dec?");

		String opt2=scan.nextLine();
		System.out.println(opt2);

	}



	public static void dechex(String dec) {
		int whole=Integer.parseInt(dec);
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
	}

	public static void hexdec(String hex) {
		double output = 0;
		for(int i=0;i<hex.length();i++) {
			try {
				int whole=Integer.parseInt(""+hex.charAt(i));
				double num=whole*Math.pow(16, hex.length()-1-i);
				output=output+num;
			}catch(NumberFormatException e){
				 int letter=(int) hex.charAt(i);
				 letter-=87;
				 double num=letter*Math.pow(16, hex.length()-1-i);
				 output=output+num;
			}
			
		}
		System.out.println((int)output);
		
		

		 

	}
	
}

