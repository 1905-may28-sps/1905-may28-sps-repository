package com.revature.empsort;
import java.util.Comparator;
//for emp name


public class EmpAge implements Comparator<Emp>{
	
	@Override
	public int compare(Emp o1, Emp o2) {
		// TODO Auto-generated method stub
		return o1.age.compareTo(o2.age);
	}	
	
}
