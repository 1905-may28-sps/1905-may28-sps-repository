//Sort two employees based on their name, department, and age using the Comparator interface.
package javaAssignments.comparator_7;


public class Employee implements Comparable<Employee>{

	private String name;
	private String department;
	private int age;
	
	public Employee(String name, 
		            String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
		
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
	
	
	@Override
	public int compareTo(Employee e1) {
		return this.department.compareTo(e1.department);
	}
	
	
	
					
}