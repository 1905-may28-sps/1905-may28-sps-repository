package com.revature.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Write  a  program  that  stores  the  following  strings  in  an 
//ArrayList  and  saves  all  the palindromes in another ArrayList
public class Q9 {
	
	public static void main(String[] args) {
		//create the string to be moved into an an arraylist
		String[] arr= {"karan", "madam","tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		//creating the arraylist
		List<String> arrL=new ArrayList<String>(12);
		//quickly populate the arraylist
		arrL.addAll(Arrays.asList(arr));
		//create an arraylist for things that return as palidrone
		List<String> paliArrL=new ArrayList<String>();
		for(int i=0;i<arrL.size();i++) {
			boolean ifPali=false;
			String word=arrL.get(i);
			
			for(int j=0;j<word.length()/2;j++) {
				String letter=""+word.charAt(j);
				String lLetter=""+word.charAt(word.length()-1-j);
				if(letter.equalsIgnoreCase(lLetter)) {
				ifPali=true;
				
				}
				else ifPali=false;
				
				break;
			
			}
			if (ifPali) {
		
				paliArrL.add(arrL.get(i));
				
			}
		}
		System.out.println(Arrays.toString(paliArrL.toArray()));
		
	}
}
