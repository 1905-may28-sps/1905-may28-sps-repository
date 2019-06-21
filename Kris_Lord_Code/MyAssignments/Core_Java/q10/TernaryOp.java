package com.revature.q10;

public class TernaryOp {
	
	public static int TernaryOperate(int num1, int num2) {
		
		int minNum = (num1 < num2)? num1 : num2;
		
		return minNum;
	}

	public static void main(String[] args) {
		
		System.out.println(TernaryOperate(67,47));

	}

}
