package com.revature.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparingObjects {
	public static void main(String[] args) {
		sortStudents();
	}
	
	public void sortArr() {
		int arr[] = {90, -100, 2, 2, 5, 23, 43, 3};
		
		//90 - -100 --> 90 + 100 = > 0
		// -100 - 2 --> -102 -- < b
		Arrays.sort(arr);
	}
	
	public static void sortStudents() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, "b", "auifdjiu", 0));
		students.add(new Student(2, "d", "Student", -91));
		students.add(new Student(3, "c", "test", 6));
		students.add(new Student(4, "a", "bon", 3));
		//Collections.sort(students);
		Collections.sort(students, new SortStudentByGrade());
		System.out.println(students);
	}

}




class SortStudentByGrade implements Comparator<Student>{

	@Override
	public int compare(Student arg0, Student arg1) {
		return arg0.getGrade() - arg1.getGrade();
	}
	
}
