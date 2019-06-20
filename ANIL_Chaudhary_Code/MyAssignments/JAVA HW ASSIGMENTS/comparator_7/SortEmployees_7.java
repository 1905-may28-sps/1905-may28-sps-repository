//Sort two employees based on their name, department and age using the comparator interface.

package javaAssignments.comparator_7;
/*
  * 1 create Employee and sortEmployees class
  * 2 create EmployeeAgeComparator and EmployeeNameComparator using comparator interface
  * 3 Call EmployeeNameComparator and EmployeeAgeComparator
  * 4 Use comparable interface to sort employee by department.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortEmployees_7 {

	public static void main(String[] args) {
	
		ArrayList<Employee> empObj = new ArrayList<Employee>();
		empObj.add(new Employee( "Peter", "Chemistry", 25));
		empObj.add(new Employee( "Mirza", "Physics", 30));
		
		System.out.println("\n a) Sorting by Department is as follows:");
		Collections.sort(empObj);
		for (Employee e1: empObj) {
		System.out.println(e1.getName() +", " +e1.getDepartment() + ", "
					+ e1.getAge());
		}	
		System.out.println("\n b) Sorting by Name is as follows:");	
		Collections.sort(empObj, new EmployeeNameComparator());
		for (Employee e2: empObj) {
		System.out.println(e2.getName() +", " +e2.getDepartment() + ", "
					+ e2.getAge());
		}
		System.out.println("\n c) Sorting by Age is as follows:");	
		Collections.sort(empObj, new EmployeeAgeComparator());
		for (Employee e3: empObj) {
		System.out.println(e3.getName() +", " +e3.getDepartment() + ", "
					+ e3.getAge());
		}
	}
	
}
