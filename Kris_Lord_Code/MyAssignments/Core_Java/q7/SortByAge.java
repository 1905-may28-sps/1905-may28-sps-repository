package com.revature.q7;

import java.util.Comparator;

public class SortByAge implements Comparator<Employee> {
	
	public int compare(Employee emp1, Employee emp2) 
    { 
        return emp1.age - emp2.age; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
