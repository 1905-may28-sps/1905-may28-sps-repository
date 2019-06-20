package com.revature.introduction;

public class GarbageCollection {

	/*
	 * One of the benefits of Java is the included memory management
	 * unlike languages such as C, in Java we do not need to worry about
	 * memory allocation/deallocation. There exists a daemon thread (thread
	 * that never dies) in the JVM that deallocates memory to unreferenced
	 * entities. Before an object gets garbage collected, the garbage
	 * collector calls the finalize() method of the object.
	 * we cannot force garbage collection, but we can REQUEST it with
	 * System.gc()
	 * 
	 * More info:
	 * geeksforgeeks.org/garbage-collection-java/
	 */
	public void eligible() {
		/*
		 * something beomces eligible for garbage collection
		 * whenthere are no longer any references to it
		 */
		
		String str = "hello";
		String str2 = "hello";
		String str3 = null;
		String str4 = new String("hello");
		str = str4;
		String str5 = str2;
		str2 = null;
		str3 = str5;
		
	}
}

	class myGarbage{
		String text;
		
		public myGarbage(String name) {
			this.name = name;
		}
		
		@Override
		
		protected void finalize() throwable{
			super.finalize();
			System.out.println();
		}
		
	}