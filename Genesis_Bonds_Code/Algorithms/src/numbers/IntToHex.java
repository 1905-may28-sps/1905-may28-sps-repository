package numbers;

import java.util.HashMap;
import java.util.Map;

public class IntToHex {

	public static void main(String[] args) {
		System.out.println(run(30));
	}


	public static String run(int n) {

		if(n>0) 
		{
			return findHexOptimal(n);
		}
		else if(n < 0){
			String negative = "-" + findHexOptimal(-n);
			return negative;
		}
		else{
			return "0";
		}

	}


	public static String intToHex(int num){
		StringBuilder out = new StringBuilder("");
		int rem = 0;
		while(num>0){
			rem = num%16;
			out.append(""+ (rem > 9 ?  (Character.toString((char)(rem+87))) : rem));
			num/=16;
		}

		return out.reverse().toString();
	}

	static String findHexOptimal(int n) {
		String hex = "";
		
		while(n > 0){
			int curr = n % 16; 

			hex += curr > 9 ? (Character.toString((char) (87+curr))) : curr;

			n /= 16; 
		}

		StringBuilder sb = new StringBuilder(hex);
		return sb.reverse().toString();
		
	}
	
	static String findHex(int n){
		// convert int n to hex string 

		String hex = "";
		//0-9, a 10, b 11, c 12, d 13, e 14, f 15 

		// 30 - 1e
		Map<Integer, String> values = new HashMap<Integer, String>();
		values.put(0, "0");
		values.put(1, "1");
		values.put(2, "2");
		values.put(3, "3");
		values.put(4, "4");
		values.put(5, "5");
		values.put(6, "6");
		values.put(7, "7");
		values.put(8, "8");
		values.put(9, "9");
		values.put(10, "a");
		values.put(11, "b");
		values.put(12, "c");
		values.put(13, "d");
		values.put(14, "e");
		values.put(15, "f");

		while(n > 0){
			int curr = n % 16; // 14

			hex += values.get(curr); // 21

			n /= 16; // 1
		}

		StringBuilder sb = new StringBuilder(hex);
		return sb.reverse().toString();


	}



}
