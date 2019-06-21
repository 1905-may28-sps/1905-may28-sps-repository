package com.revature.q7;

import java.util.ArrayList;
import java.util.Collections; 

public class Employee {//class to represent Employee
	
	public int id;
    public String name;
    public String department;
    public int age;
 
    //Constructor
    public Employee(int idVal, String nameVal, String departmentVal, int ageVal) {
        this.id = idVal;
        this.name = nameVal;
        this.department = departmentVal;
        this.age = ageVal;
    }
        
    public String toString() 
        { 
            return this.id + " " + this.name +
            		" " + this.department + " "
            		+ this.age;
        } 
    

	public static void main(String[] args) {

		ArrayList<Employee> empInfo = new ArrayList<Employee>(); 
		empInfo.add(new Employee(101, "Kris", "Electrical Engineering", 37)); 
		empInfo.add(new Employee(235, "John", "Chemistry", 58)); 
		empInfo.add(new Employee(196, "Jamie", "Statistics", 79)); 
  
        System.out.println("Unsorted"); 
        for (int i=0; i<empInfo.size(); i++) 
            System.out.println(empInfo.get(i)); 
  
        Collections.sort(empInfo, new SortByAge()); 
  
        System.out.println("\nSorted by age"); 
        for (int i=0; i<empInfo.size(); i++) 
            System.out.println(empInfo.get(i)); 
  
        Collections.sort(empInfo, new SortByName()); 
  
        System.out.println("\nSorted by Name"); 
        for (int i=0; i<empInfo.size(); i++) 
            System.out.println(empInfo.get(i));
        
        Collections.sort(empInfo, new SortByDepartment()); 
        
        System.out.println("\nSorted by Department"); 
        for (int i=0; i<empInfo.size(); i++) 
            System.out.println(empInfo.get(i));

	}

}
