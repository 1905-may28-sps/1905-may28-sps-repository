package ExceptionBank;

public class CustomException {

	public static void validate(double balance)throws Exception{  
	     if(balance<0)  
	      throw new Exception("Must be a number greater then 0");  
	      
	    
	   }  
	
	public static void main(String[] args) {
		try {
			validate(-12.1);
		} catch (Exception e) {
			System.out.println("Excepion occured" + e);
			
		}
	}
}
