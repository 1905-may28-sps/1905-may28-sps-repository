package sorts;

import java.util.Arrays;

import org.junit.Test;

public class Twisted37 {
	
	/*
	 * There is a planet... in a galaxy far far away. It is exactly like our planet, but it has one difference:

	   The values of the digits 3 and 7 are twisted. Our 3 means 7 on the planet Twisted-3-7. And 7 means 3.

       Your task is to create a method, that can sort an array the way it would be sorted on Twisted-3-7.

	   7 Examples from a friend from Twisted-3-7:
		[1,2,3,4,5,6,7,8,9] -> [1,2,7,4,5,6,3,8,9]
		[12,13,14] -> [12,14,13]
		[9,2,4,7,3] -> [2,7,4,3,9]
	
	   There is no need for a precheck. The array will always be not null and will always contain at least one number.

	   You should not modify the input array!
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	 public static Integer[] sortTwisted37(Integer[] array)
	  {
	    
	    array = twist(array);
	    Arrays.sort(array);
	    return twist(array);
	    
	  }
	  
	  static Integer[] twist(Integer[] array){
	    
	    Integer[] twisted = new Integer[array.length];
	    for(int i = 0; i < array.length; i++){
	      String temp = "";
	      String old = "" + array[i];
	      for(int j = 0; j < old.length(); j++){
	        if(old.charAt(j) == '3'){
	          temp+="7";
	        }
	        else if(old.charAt(j) == '7'){
	          temp+= "3";
	        }
	        else{
	          
	          temp += ""+ old.charAt(j);
	        }
	      }
	      Integer n = Integer.parseInt(temp);
	      twisted[i] = n;
	    }
	    return twisted;
	  }
	  

}
