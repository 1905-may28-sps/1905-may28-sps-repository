package com.revature.q7;

import java.util.Comparator;

public class SortByDepartment implements Comparator<Employee> {
	
	public int compare(Employee emp1, Employee emp2) 
    { 
        return emp1.department.compareTo(emp2.department); 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
