
public class IndexString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subString("popolopogous",9));
	}
	public static String subString(String str, int idx) {
		String strNew="";
		for (int i=0;i<idx;i++) {// from zero to the given index-1
			strNew=strNew+str.charAt(i);//add the scan value to the new string and store it in the new string since string is immutable
		}
		
		return strNew;
	}
	

}
