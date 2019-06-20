import java.util.ArrayList;
import java.util.List;

public class storePalArrList {
	static List<String> pal=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> word=new ArrayList<>();
		word.add("karan");
		word.add("madam");
		word.add("tom");
		word.add("civic");
		word.add("radar");
		word.add("sexes");
		word.add("jimmy");
		word.add("kayak");
		word.add("john");
		word.add("refer");
		word.add("billy");
		word.add("did");
		List<String> palw=palStore(word);
		System.out.println(palw);
	}
	public static List<String> palStore(List<String> word) {
		
		for(int i=0; i<word.size();i++) {//loop to get index i array
			boolean valid=true;
			String checkWord=word.get(i);
			
			for (int j=0;j<checkWord.length()/2; j++) {//loop to get character in string from index in array
				if(checkWord.charAt(j)!=checkWord.charAt(checkWord.length()-j-1)){
					
					valid=false;	
				} 
				
			}
			
			if(valid){
					pal.add(word.get(i));
				}
		
		
		
	}
		return pal;

}
}
