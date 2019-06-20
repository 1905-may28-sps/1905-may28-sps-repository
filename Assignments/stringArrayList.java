import java.util.ArrayList;
import java.util.Arrays;  
import java.util.List;  

public class stringArrayList {

	public static void main(String[] args) {
		
		 String[] names = {"Karan", "madam", "tom", "civic", "radar","sexes","jimmy","kajak","John"
				 ,"refer","billy","did"};  

	      List<String> wordList = Arrays.asList(names);  
		

		System.out.println(wordList.toString());
		
		   for(int i = 0; i < wordList.size();i++) {
			   String words = wordList.get(i);
			   String wordReversed = new StringBuilder(words).reverse().toString();
			   
			   if(words.equals(wordReversed)) {
				   System.out.println("is a palindrome: " + wordList.get(i) );
			   }else {
				   System.out.println("Not palindrome: " + wordList.get(i));
			   }
		   }
		   

	}

}
