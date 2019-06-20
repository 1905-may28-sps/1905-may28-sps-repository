package com.revature.interfacemethods;

public class TestClass {
	static ImplClass imp=new ImplClass();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(works());
		

	}
	public static boolean works() {
		boolean out=false;
		int add=imp.addition(3,4,5);
		
		int sub=imp.subtraction(4,5);
		
		double div=imp.division(3.7,5);
		System.out.println(div);
		
		int mul=imp.multiplication(1*2*3*4);
		System.out.println(mul);
		if(add==12&&sub==-1&&div==0.74&&mul==24) {
			out=true;
		}
	return out;	
	}

}
