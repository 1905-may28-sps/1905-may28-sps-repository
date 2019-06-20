package com.revature.introduction;

public class CatchingExceptions {
	public staic void catchRuntimeException(int index) {
		try {
			int[] arr = {1,2,3};
			//following line of code will throw exception
			System.out.println(arr[index]);
		}
		
	}
}
