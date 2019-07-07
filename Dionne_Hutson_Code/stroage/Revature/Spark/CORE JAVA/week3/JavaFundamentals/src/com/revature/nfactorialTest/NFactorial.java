package com.revature.nfactorialTest;
import java.util.Scanner;

public class NFactorial {
	static Scanner scan;
	static int n;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("What N! factorial do you want to find");
		scan= new Scanner(System.in);
		n=scan.nextInt();
		nfact(n);
		System.out.println(nfact(n));
	}
	public static int nfact(int n) {
		int x=1;
		for (int i=1;i<=n;i++) {
			x=i*x;
			
		}
		
		return x;
	}
	

}
