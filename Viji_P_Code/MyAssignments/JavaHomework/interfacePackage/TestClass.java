package homework.interfacePackage;

import homework.InterfaceMathOperation;

public  class TestClass implements InterfaceMathOperation{
	
	
	@Override
	public void addition(int a, int b) {
		int result = a + b;
		System.out.println("Sum = " + result);
	}
	
	@Override
	public void subtraction(int a, int b) {
		int result = a - b;
		System.out.println("Subtraction Result = " + result);
		}
	
	@Override
	public void multiplication(int a, int b) {
		int result = a * b;
		System.out.println("Product = " + result);
	}
	
	@Override
		public void division(int a, int b) {
		double result = a/b;
		System.out.println("Quotient = " + result);
	}

	public static void main(String[] args) {
		
		TestClass m = new TestClass();
		m.addition(5,25);
		m.subtraction(95,85);
		m.multiplication(6,5);
		m.division(90,9);
		
	}

}
