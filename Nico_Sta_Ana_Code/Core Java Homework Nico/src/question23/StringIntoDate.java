package question23;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringIntoDate {

	
	public static void main(String[] args) throws ParseException {
	    String sDate1="02/02/1991";  
	    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
	    System.out.println(sDate1+"\t"+date1);  
	}
}
