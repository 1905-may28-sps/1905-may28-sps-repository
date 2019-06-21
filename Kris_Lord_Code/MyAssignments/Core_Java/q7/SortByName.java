package com.revature.q7;

import java.util.Comparator;

public class SortByName implements Comparator<Employee> {
	
	public int compare(Employee emp1, Employee emp2) 
    { 
        return emp1.name.compareTo(emp2.name); 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
