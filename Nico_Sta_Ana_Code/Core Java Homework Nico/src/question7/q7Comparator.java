package question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class q7Comparator extends Employee {
	
	private int id;
	private String name;
	private String department;
	private int age;
	
	 public void Employee(int id, String name, String department, int age) {
		 	this.id = id;
	        this.name = name;
	        this.department = department;
	        this.age = age;
	    }
	
	 
	 

	 public int getId () {
		 return id;
	 }
	 
	 public int setId() {
		 this.id = id;
	 }
	
	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getDepartment() {
		return department;
	}





	public void setDepartment(String department) {
		this.department = department;
	}





	public int getAge() {
		return age;
	}





	public void setAge(int age) {
		this.age = age;
	}

public static void sortEmployee() {
	List<Employee> employees = new ArrayList<>();
	
	
	employees.add(new Employee("Nico", "department 1", 28));
	employees.add(new Employee("Billy", "department 2", 26));
	
	System.out.println("Employess before sorting : " + employees);
	
	
	 Collections.sort(employees);

     System.out.println("\nEmployees (After Sorting) : " + employees);
     
     Comparator<Employee> employeeNameComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        };
        
        
        // Sort employees by Name
        Collections.sort(employees, Comparator.comparing(Employee::getName));
        System.out.println("\nEmployees (Sorted by Name) : " + employees);

}



	public static void main(String[] args) {
		
		sortEmployee();
		
//end of main
	}
	
	
	//end of class
}
