package q23;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StrTodate {
	
	public static void main(String[] argv) {

        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
        String dateInString = "Thursday, Jun 20, 2019 09:33:00 PM";

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
