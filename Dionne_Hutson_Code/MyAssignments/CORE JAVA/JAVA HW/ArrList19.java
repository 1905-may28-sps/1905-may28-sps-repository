import java.util.ArrayList;
import java.util.List;

public class ArrList19 {
		static List<Integer> list=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(list);
		list=listFill();
		System.out.println(list);
		System.out.println(evenSum(list));
		System.out.println(oddSum(list));
		System.out.println(noPrime(list));
		
		

	}
	public static List<Integer> listFill(){
		//filling list
		for (int i=1; i<=10;i++) {
			list.add(i);	
		}	
	return list;	
	}
	public static int evenSum(List<Integer> list) {
		//even mod 2=0 
		int sum=0;
		for (int i=0; i<list.size();i++) {
			int a=list.get(i);	
			if(a%2==0) {
				sum+=a;
			}
		}	
		
		return sum;
		
	}
	public static int oddSum(List<Integer> list) {
		//odd mod 2==1
		int sum=0;
		for (int i=0; i<list.size();i++) {
			int a=list.get(i);	
			if(a%2!=0) {
				sum+=a;
			}
		}	
		
		return sum;
		
	}
	public static List<Integer> noPrime(List<Integer> list) {
		//for a list 1-10 I know that the prime numbers are 2,3,5,7
		//I dont know a mathmathical way to exclude these numbers so I do so manually
		List<Integer> noPrime=new ArrayList<>();
		for (int i=0; i<list.size();i++) {
			int a=list.get(i);
			
			if(a!=2&&a!=3&&a!=5&&a!=7) {
				noPrime.add(a);
			}
		}	
		
		return noPrime;
		
	}
	

}
