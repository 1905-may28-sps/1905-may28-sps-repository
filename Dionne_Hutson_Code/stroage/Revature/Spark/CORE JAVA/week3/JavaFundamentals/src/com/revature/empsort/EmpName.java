package com.revature.empsort;
import java.util.Comparator;
//for emp name


public class EmpName implements Comparator<Emp>{
	
	@Override
	public int compare(Emp o1, Emp o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);
	}	
	
}