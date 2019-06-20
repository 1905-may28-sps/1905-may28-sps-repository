//Sort two employees based on their name, department and age using the comparator interface.

package javaAssignments.comparator_7;
import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee>{
	
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}

}