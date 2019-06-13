package com.revature.introduction;

public class Primitives {
	int a; // 4 bytes
	boolean b; // true or false 
	char ch; // '' single character values
	double d; // decimal values 8 bytes
	long e; // whole number values 8 bytes
	float f;  // smaller capacity than double. 4 bytes. 
	short g; // 2 bytes. whole number values
	byte h; 
	static int stat;
	
	//WRAPPER CLASSES -  there is one for each of the primitive types
	//objects that can be "unboxed" into primitives 
	
	Integer integer = new Integer(9);
	Boolean bool = new Boolean(false);
	Character character = ch; //boxing
	Double doub = new Double(100.0);
	Long lon; //null
	Float flo; //null
	Short shor; //null
	Byte by; //null
	
	
	public static void main(String[] args) {
		System.out.println(numToChar(200));
	}
	
	static void intro() {
		//create instance of class
				int test;
				Primitives prims = new Primitives();
				System.out.println("Default values are assigned to "
						+ "all instance and static variables "
						+ "The primitive default values are as follows " );
				System.out.println("int: " + prims.a);
				System.out.println("short: " + prims.g);
				System.out.println("boolean: " + prims.b);
				System.out.println("char: " + prims.ch);
				System.out.println("double " + prims.d);
				System.out.println("long: " + prims.e);
				System.out.println("float: " + prims.f);
				System.out.println("byte: " + prims.h);
				//System.out.println(test);
				
				
				System.out.println("INTEGER MAX VALUE " + 
				Integer.MAX_VALUE);
				
//				String num = "ten";
//				System.out.println(Integer.parseInt(num));
				//System.out.println(test);
				
				
				int x = 1_000_000;
				//int wrong = _199;
				double doub = 1__000.10;
				
				long l = 100000000000L;
				
				float f = 34.21F;
	}
	
	static void autoboxing() {
		/*
		 * Autoboxing is the automatic process of 
		 * a primitive data type converting to its
		 * wrapper class when a reference is changed
		 */
		
		int x = 10;
		Integer wrapper = x;
	}

	static void casting() {
		int x = 1300;
		long l = x; //casting is done automatically when changing reference to a broader type
		byte b = (byte) x; //must EXPLICITLY cast from a larger to smaller type
		System.out.println(b);
		
		//long <- int <- short <- byte
		
		char letter = 'a';
		int ch = (int) letter;
		System.out.println("ASCII VAL FOR 'a': " + ch);
		
	}
	
	static char numToChar(int n) {
		//will work easily up to 256. will repeat after
		return (char) n;	
	}
	
	static void bases() {
		int decimal = 10;
		
		//BINARY (base 2; val 0-1; 0b101 or 0B101)
		int binary = 0B10101011;
		
		//OCTAL (base 8; 0-7)
		int octal = 012347;
		
		//HEXADECIMAL (base 16; 0-9, a-f)
		int hex = 0Xa13f5;
		
	}

}
