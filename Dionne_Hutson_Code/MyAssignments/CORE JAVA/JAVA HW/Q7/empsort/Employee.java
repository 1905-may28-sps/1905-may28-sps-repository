package com.revature.empsort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee implements Comparator<Emp> {

	public static void main(String[] args) {
		List<Emp> list =new ArrayList<>();
		list.add(new Emp("pohn", 23,"finance"));
		list.add(new Emp("jon", 24,"housing"));
		
		// TODO Auto-generated method stub
		System.out.println(list);
		Collections.sort(list, new EmpName());
		System.out.println(list);
		Collections.sort(list,new EmpAge());
		System.out.println(list);
		Collections.sort(list,new EmpDept());
		System.out.println(list);

	}

	@Override
	public int compare(Emp o1, Emp o2) {
		// TODO Auto-generated method stub
		return o1.dept.compareTo(o2.dept);
	}

}