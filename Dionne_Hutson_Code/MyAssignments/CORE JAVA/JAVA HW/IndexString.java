
public class IndexString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subString("popolopogous",9));
	}
	public static String subString(String str, int idx) {
		String strNew="";
		for (int i=0;i<idx;i++) {
			strNew=strNew+str.charAt(i);
		}
		
		return strNew;
	}
	

}
