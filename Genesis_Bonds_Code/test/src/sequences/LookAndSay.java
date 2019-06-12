package sequences;

public class LookAndSay {

	public static void main(String[] args) {

		String[] values = lookSay(5);
		for(String v : values) {
			System.out.println(v);
		}

	}

	static String[] lookSay(int n) {
		String[] values = new String[n];
		
		values[0] = "1";
		if(n <= 1) return values;
		
		//add empty strings to string array so they are not null vals
		for(int i = 1; i < n; i++) {
			values[i] = "";
		}
		System.out.println("added empty strings");
		
		for(int i = 1; i < n; i++) {
			String look = values[i-1];
			System.out.println(look);
			System.out.println("getting char at 0 " + look.charAt(0));
			int count = 0;	
			char prev = look.charAt(0);
			for(int j = 1; j < look.length(); j++) {
				char curr = look.charAt(j);
				if(curr == prev) {
					count++;
				}
				else {
					values[i] += count + prev;
					prev = curr;
				}
			}
		}

		return values;
	}

}
