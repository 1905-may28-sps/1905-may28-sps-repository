package com.revature.interfacemethods;

public class ImplClass implements Question15 {
	

	public ImplClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int addition(int... args) {
		int sum=0;
		// TODO Auto-generated method stub
		for(int x:args) {
			sum+=x;
			}
		return sum;
	}

	@Override
	public int subtraction(int a, int b) {
		
		return a-b;
	}
	@Override
	public double division(double a,double b) {
		return a/b;
	}

	@Override
	public int multiplication(int... args) {
		int sum=1;
		for(int x:args) {
			sum=sum*x;
			}
		return sum;
	}
	

}