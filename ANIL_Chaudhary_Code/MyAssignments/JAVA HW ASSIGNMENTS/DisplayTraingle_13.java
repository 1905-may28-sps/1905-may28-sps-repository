/*display traingle in cosole
0
1 0
1 0 1
0 1 0 1
*/

package javaAssignments;

public class DisplayTraingle_13 {
	
	public static void main(String args[]){
		int n=12,a=0;
		for(int i=1;i<=n;i++){
		for(int j=0;j<i;j++){
		a=n%2;
		System.out.print(a +" ");
		n--;
		}
		System.out.println();
		}
		}
		}