package arrays;

import java.util.HashSet;


public class Socks {

	/*
	 * take in array listing socks(by id)
	 * 
	 */
	public static void main(String[] args) {
		int[] socks = {10, 20, 20, 10, 30, 30, 30, 10, 20, 40, 20, 40};
		int pairs = sockMerchant(socks);
		System.out.println(pairs);

	}
	
	 static int sockMerchant( int[] ar) {
	     int count = 0;	
		 
	     HashSet<Integer> socks = new HashSet<Integer>();
	     for(int i = 0; i < ar.length; i++) {
	    	 if(socks.contains(ar[i])) {
	    		 count++;
	    		 socks.remove(ar[i]);
	    	 }
	    	 else {
	    		 socks.add(ar[i]);
	    	 }
	     }
	     
		 return count;
	    }
	 

}
