package employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class employees {
	/*
 //Sort two employees based on their name, department, 
//	and age using the Comparator interface.
 * 
 */
	public static void main(String[] args) {
		sortEmployees();
	}

	
	
	public static void sortEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1,"Deborah", "George-West", "Social Work", 59));
		employees.add(new Employee(2,"Whitney", "Richardson", "Case Work", 31));

		
			System.out.println(employees);
			
		Collections.sort(employees, new SortEmployeeByAge());
	System.out.println("Employees sorted by age: " +employees);
	Collections.sort(employees, new EmpName());
	for (Employee str: employees) {
		System.out.println("Name Sort: "+ str);
	}
	
	Collections.sort(employees, new DepName());
	for (Employee str: employees) {
		System.out.println("Dept Sort: "+ str);
	}
	}
	
	
	
}

/*
 * public static  Comparator<Employee>  EmpName = new Comparator<Employee>() {
	
	public int compare (Employee o1, Employee o2) {
		String empName1 = o1.getFirstName();
		String empName2 = o2.getFirstName();
	}
	return empName1.compareTo(empName2);
}
 */

class SortEmployeeByAge implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getAge()- o2.getAge();
	}
}
class EmpName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		String empName1 = o1.getFirstName();
		String empName2 = o2.getFirstName();
		
		return empName1.compareTo(empName2);
	}
	
}

class DepName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		String DepName1 = o1.getDepartment();
		String DepName2 = o2.getDepartment();
		
		
		return DepName1.compareTo(DepName2);
	}
	
}


