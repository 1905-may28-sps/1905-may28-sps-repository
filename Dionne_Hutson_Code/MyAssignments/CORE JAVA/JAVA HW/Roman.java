import java.util.Scanner;

public class Roman {
	static Scanner scan;
	static int num;
	
	

	public static void main(String[] args) {
		System.out.println("Enter a Integer number?");
		scan=new Scanner(System.in);
		num=scan.nextInt();
		// TODO Auto-generated method stub
		roman(num);

	}
	static String roman(int num) {
		String roman="";
		int rem=num%10;//ones place
		int div=(num/10)-(rem/10);//10s place
		if (div>10) {// 10s place for numbers over 10s plaec ie 100 1000 etc
			div=div%10;
		}
		int hundreds=(num/100)-((num%100)/100);
		if (hundreds>10) {// 100s place for numbers over 100s plaec ie 1000 
			hundreds=hundreds%10;
		}
		int thou=(num/1000)-((num%1000)/1000);
	
			switch(rem) {
			case 9:
			roman=roman.concat("I");
			case 0:
				roman=roman.concat("X");
				break;
			case 8:
				roman=roman.concat("I");
			case 7:
				roman=roman.concat("I");
			case 6:
				roman=roman.concat("I");
		case 5:
			roman="V"+roman;
			break;
		case 4:
			roman="IV";
			break;
		case 3:
			roman="I"+roman;
		case 2:
			roman="I"+roman;
		case 1:
			roman="I"+roman;
			break;
		}
			if (div>1) {
				if (div<10) {
					
				switch(div) {
				case 9:
					roman="XC"+roman;
					
						break;
					case 8:
						roman="X"+roman;
					case 7:
						roman="X"+roman;
					case 6:
						roman="X"+roman;
				case 5:
					roman="L"+roman;
					break;
				case 4:
					roman="XL"+roman;
					break;
				case 3:
					roman="X"+roman;
				case 2:
					roman="X"+roman;
				case 1:
					roman="X"+roman;
					break;
				}
				
				if (hundreds>1) {
					if (hundreds<10) {
						
					switch(hundreds) {
					case 9:
						roman="CM"+roman;
						
							break;
						case 8:
							roman="C"+roman;
						case 7:
							roman="C"+roman;
						case 6:
							roman="C"+roman;
					case 5:
						roman="D"+roman;
						break;
					case 4:
						roman="CD"+roman;
						break;
					case 3:
						roman="C"+roman;
					case 2:
						roman="C"+roman;
					case 1:
						roman="C"+roman;
						break;
					}
				
					
				}
				
			}
			
				if (thou>1) {
					if (thou<=10) {
						
					switch(thou) {
					case 10:
						roman="X"+roman;
						
							break;
					case 9:
						roman="IX"+roman;
						
							break;
						case 8:
							roman="M"+roman;
						case 7:
							roman="M"+roman;
						case 6:
							roman="M"+roman;
					case 5:
						roman="V"+roman;
						break;
					case 4:
						roman="MV"+roman;
						break;
					case 3:
						roman="M"+roman;
					case 2:
						roman="M"+roman;
					case 1:
						roman="M"+roman;
						break;
					}
				
					
				}
				
			}
			
		}
		
		
		
	}
			return roman;
	}
}
	
	
	

