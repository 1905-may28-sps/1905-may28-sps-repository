import java.util.ArrayList;
import java.util.List;

public class primeNum {
	static List<Integer> list=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		storeNums();
		

	}
	public static List<Integer> storeNums(){
		
		for(int i=1;i<=100;i++) {
			list.add(i);
			
			if (i==2||i==3||i==5||i==7||i!=1&&i%2!=0&&i%3!=0&&i%5!=0&&i%7!=0) {//I chose to do mod 2,3,5,7 because 4,6,8,9 are all multiples of these so it would be redundated to included these
				
				System.out.println(i);
				
				
				
			}
		}
		
		return list;
		
	}

}
