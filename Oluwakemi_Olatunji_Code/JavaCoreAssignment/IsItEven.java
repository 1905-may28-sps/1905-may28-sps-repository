package Assignements;

public class IsItEven {
    static boolean isItEven(int n) 
    { 
        boolean isItEven = true; 
          
        for (int i = 1; i <= n; i++)  
            isItEven = !isItEven; 
        return isItEven; 
    } 
    public static void main(String args[]) 
    { 
          
        int n = 10; 
        if(isItEven(n)) 
            System.out.println("Hey "+n+" is even!"); 
        else
            System.out.println("Hey "+n+" is odd!"); 
          
    } 
} 

