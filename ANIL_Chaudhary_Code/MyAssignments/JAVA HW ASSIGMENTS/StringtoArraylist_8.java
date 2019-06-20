//store the following strings in an ArrayList and Pelindroms in another Arraylist.

package javaAssignments;
import java.util.List;
import java.util.ArrayList;

public class StringtoArraylist_8 {
	
	public static void main(String args[]){
		
			        	ArrayList<String> alist=new ArrayList<String>();  
			        	ArrayList<String>palindromeArrlist = new ArrayList<String>(10);
			            alist.add("karan");
			            alist.add("madam");
			            alist.add("tom");
			            alist.add("civic");
			            alist.add("radar");
			            alist.add("sexes");
			            alist.add("jimmy");
			            alist.add("kayak");
			            alist.add("john");
			            alist.add("refer");
			            alist.add("billy");
			            alist.add("did");
			           
			            
			            for (String name : alist) {
			    			StringBuilder newName = new StringBuilder(name);
			    			if (name.equals(newName.reverse().toString())) {
			    				
			    				palindromeArrlist.add(name);
			    			} else {
			    					    				
			    				
			    				//System.out.println(name + " is not a palindrome");
			    			}

			    		}
			            System.out.println("The Arraylist is");
	    			    System.out.println(alist);
			            
			            
			            System.out.println("\n The Palindrome words are \n" + palindromeArrlist);
			    		
			    	}
	
}
