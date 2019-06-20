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
		for (int i=1; i<=10;i++) {
			list.add(i);	
		}	
	return list;	
	}
	public static int evenSum(List<Integer> list) {
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
