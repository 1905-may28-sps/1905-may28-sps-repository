package com.revature.empsort;

import java.util.Comparator;

public class EmpDept implements Comparator<Emp> {
	@Override
	public int compare(Emp o1, Emp o2) {
		// TODO Auto-generated method stub
		return o1.dept.compareTo(o2.dept);
	}

}
