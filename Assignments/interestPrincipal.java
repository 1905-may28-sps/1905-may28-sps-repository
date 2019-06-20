import java.util.Scanner; 

public class interestPrincipal {

	public static void main(String[] args) {
		// Interest = Principal * Rate * Time
		int principal = 100;
		double rate = .50;
		int time = 2019;
		
		
		
		  Scanner myObj = new Scanner(System.in);
		    long prinInput;
		    double rateInput;
		    int timeInput;
		    
		    
		    // Enter principal and press Enter
		    System.out.println("Enter Principal:"); 
		    prinInput = myObj.nextInt();
		    
		    System.out.println("Enter Rate:"); 
		    rateInput = myObj.nextDouble();   
		       
		    System.out.println("Enter Time:"); 
		    timeInput = myObj.nextInt();   
		       
		       
		    double interest = prinInput * rateInput * timeInput;
		    System.out.println("User Interest is: " + interest);
	}

}
