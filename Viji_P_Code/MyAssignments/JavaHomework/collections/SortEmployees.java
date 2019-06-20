package homework.collections;
/*
 * Sort two employees based on their name, department and age using the comparator interface.
 * Step 1: Develop Employee class
 * step 2: Develop sort employees class
 * step 3: Develop EmployeeAgeComparator using comparator interface
 * step 4: Develop EmployeeNameComparator using comparator interface
 * step 5: Call EmployeeNameComparator and EmployeeAgeComparator
 * Step 6: Used comparable interface to sort employee by department.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortEmployees {

	public static void main(String[] args) {
	
		ArrayList<Employee> empObj = new ArrayList<Employee>();
		empObj.add(new Employee( "Peter", "Chemistry", 25));
		empObj.add(new Employee( "Mirza", "Physics", 30));
		
		System.out.println("Sorting by Employee Department:");
		Collections.sort(empObj);
		for (Employee e1: empObj) {
		System.out.println(e1.getName() +", " +e1.getDepartment() + ", "
					+ e1.getAge());
		}	
		System.out.println("Sorting by Employee Name:");	
		Collections.sort(empObj, new EmployeeNameComparator());
		for (Employee e2: empObj) {
		System.out.println(e2.getName() +", " +e2.getDepartment() + ", "
					+ e2.getAge());
		}
		System.out.println("Sorting by Employee Age:");	
		Collections.sort(empObj, new EmployeeAgeComparator());
		for (Employee e3: empObj) {
		System.out.println(e3.getName() +", " +e3.getDepartment() + ", "
					+ e3.getAge());
		}
	}
	
}