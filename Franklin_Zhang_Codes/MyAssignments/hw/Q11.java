package com.revature.hw;
//Write  a  program  that  would  access  two  float-variables from a  
//class  that  exists  in another  package. Note,  you willneed 
//to  create two  packages  to  demonstrate  thesolution.

//created package com.revature.q11variable
//created class Q11FloatVariables.java for x
import com.revature.q11variables.*;
//created package Q11VariableY
//created class Q112ndVarriable for y
import Q11VariableY.*;

public class Q11 {
//created package com.revature.q11variable
//created class Q11FloatVariables.java
	public static void main(String[] args) {
		System.out.println(Q11FloatVariables.x);
		System.out.println(Q112ndVarriable.y);
	}
	
	
}
