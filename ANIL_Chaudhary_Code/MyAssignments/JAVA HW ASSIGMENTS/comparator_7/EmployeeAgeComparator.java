//Sort two employees based on their name, department and age using the comparator interface.
package javaAssignments.comparator_7;

import java.util.*;

public class EmployeeAgeComparator implements Comparator<Employee> {

	public int compare(Employee e1, Employee e2) {
	int	e1Age = e1.getAge();
	int e2Age = e2.getAge();
		if (e1Age == e2Age) {
			return 0;
		}
		else if (e1Age > e2Age) {
			return 1;
		}
		else
			return -1;
	}
}