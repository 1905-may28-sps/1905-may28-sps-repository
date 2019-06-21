package com.revature.introduction;

public class GarbageCollection {

	/*
	 * One of the benefits of Java is the included memory management 
	 * Unlike languages such as C, in Java we do not need to worry about 
	 * memory allocation/deallocation. There exists a daemon thread (thread
	 * that never dies) in the JVM that deallocates memory to unreferenced
	 * entities. Before an object gets garbage collected, the garbage
	 * collector calls the finalize() method of the object. 
	 * We cannot force garbage collection, but we can REQUEST it with 
	 * System.gc();
	 * 
	 * More info:
	 * https://www.geeksforgeeks.org/garbage-collection-java/
	 */
	
	public static void main(String[] args) {
		MyGarbage g1 = new MyGarbage("1");
		MyGarbage g2 = new MyGarbage("2");
		MyGarbage g3 = new MyGarbage("3");
		MyGarbage g4 = new MyGarbage("4");
		MyGarbage g5 = new MyGarbage("5");
		MyGarbage g6 = new MyGarbage("6");
		g6 = g2;
		g2 = null;
		g3 = g1;
		g5 = g1;
		g6 = null;
		System.gc(); //requests garbage collector to this thread urgently
		for(int i = 1; i < 1000; i++) {
			System.out.print("blah");
		}
		MyGarbage test = new MyGarbage("test");
	}
	
	public void eligible() {
		/*
		 * something becomes eligible for garbage collection 
		 * when there are no longer any references to it
		 */
		
		String str = "hello";
		String str2 = "hello";
		String str3 = null;
		String str4 = new String("hello");
		str = str4;
		String str5 = str2;
		str2 = null;
		str5 = str3;
	}
}


class MyGarbage{
	String name;
	
	public MyGarbage(String name) {
		this.name = name;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println(name + " IS BEING GARBAGE COLLECTED");
	}

}
