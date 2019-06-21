package com.revature.JavaHomework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JavaAssignment {
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		 Scanner scan = new Scanner(System.in);
		
			System.out.println("hi, what's your name?");
			
			String name = scan.nextLine();
			
			System.out.println("Hey, " + name+ "!"); 
			menu();
			
		//	scan.close(); //close resource to prevent leaks
		}
		
		static void menu() {
			System.out.println("What would you like to do today? "
					+ "You can either \n"
					+ "1. Bubble Sort\n"
					+ "2. Find the factorial\n"
					+ "3. Find the Nth number in the Fibonacci sequence\n"
					+ "4. Reverse a string\n"
					+ "5. Check to see if a number is even\n"
					+ "6. Print the Prime numbers in an array between 1 and 100\n"
					+ "7. Find the minimum of two numbers\n"
					+ "8. Print the Even numbers in an array between 1 and 100\n"
					+ "9. Print a triangle\n"
					+ "10. Calculate interest\n"
					+ "11. Read in from a file\n"
					+ "12. Turn a decimal into a hexadecimal\n"
					+ "13. Print the substring of the entered string\n"
					+ "14. Printing Array Lists\n"
					+ "15. Remove duplicated characters from a string");
						String option = scan.nextLine();

			switch(option) {
			case "1": bubbleSort(); break;
			case "2": factorial(); break;	
			case "3": fibonacci(); break;
			case "4": reverseString(); break;
			case "5": isEven(); break;
			case "6": isPrimeNum(); break;
			case "7": isMinimum(); break;
			case "8": isEvenNum(); break;
			case "9": printTriangle(); break;
			case "10": principleInterest(); break;
			case "11": readInFile(); break;
			case "12": decToHex(); break;
			case "13": subString(); break;
			case "14": ArrLists(); break;
			case "15": removeDuplicates(); break;
			default: 
				System.out.println("please enter a valid choice from the menu");
				scan.close();
				menu();
				//invalid option, maybe repeat the menu 
			}
		}
		
		
		
		
	static void bubbleSort() {
	    int i, j, temp;
	
        Scanner s = new Scanner(System.in);

        System.out.println("Enter number of elements in your array:");

        int n = s.nextInt();

        int arr[] = new int[n];

        System.out.println("Please enter all the elements in your array:");

        for(int l = 0; l < n; l++)

        {

            arr[l] = s.nextInt();
           
	 
        }
	 
	 
	 
	    for (i = 0; i < (arr.length - 1 ); i++) {
	      for (j = 0; j < arr.length - i - 1; j++) {
	        if (arr[j] > arr[j+1]) 
	        {
	           temp = arr[j];
	           arr[j] = arr[j+1];
	           arr[j+1] = temp;
	        }
	      }
	    }
	 
	    System.out.println("Sorted list of integers:");
	 
	    for (i = 0; i < arr.length; i++) 
	      System.out.println(arr[i]);
	    
	   
	  }
	
	static void factorial() {
		 int num;
	        System.out.println("Please enter the number you would like to find the factorial of: ");
	        Scanner scanner = new Scanner(System.in);
	        num = scanner.nextInt();
	        scanner.close();
	        long facNum = 1;
	        int i = 1;
	        while(i<=num)
	        {
	            facNum = facNum * i;
	            i++;
	        }
	        System.out.println("The factorial of "+num+" is: "+facNum);
	    }   
		 
	
	
	
	static void fibonacci() {
		int fibNum = 0; 
		 int fNum = 0;
		 int sNum = 1;
		 
		    System.out.println("How many numbers would you like to be printed in the Fibonacci sequence:");
	        Scanner scanner = new Scanner(System.in);
	        fibNum = scanner.nextInt();
	        scanner.close();
	        System.out.print("The Fibonacci Sequence of "+fibNum+" numbers is: ");

	        for (int i = 1; i <= fibNum; ++i)
	        {
	            System.out.print(fNum+" ");
	            /* On each iteration, we are assigning second number
	             * to the first number and assigning the sum of last two
	             * numbers to the second number
	             */

	      
	            int sum = fNum + sNum;
	            fNum = sNum;
	            sNum = sum;
	        }
	}
	
	
	
	
	static void reverseString() {

		System.out.println("Please enter the string you would like to reverse:");
        
        Scanner read = new Scanner(System.in);
        String str = read.nextLine();
        String rev = "";
        
        
        for(int i = str.length() - 1; i >= 0; i--)
        {
            rev = rev + str.charAt(i);
        }
        
        System.out.println("The reversed string is: ");
        System.out.println(rev);
    }
	
	
	static void isEven() {
		int num;
	    Scanner inVal= new Scanner(System.in);
	 
	    System.out.println("Plesase enter the number you would like to check whether it's even or odd");
	    num=inVal.nextInt();
	 
	    if((num / 2)*2==num){
	        System.out.println(+num+" is an Even number");
	    }else{
	        System.out.println(+num+" is an Odd Number");
	    }
	}
	
	
	
	
	
	static void isPrimeNum() {
		int num = 100;
		 
		System.out.print("The Arraylist of numbers between 1 and 100 are: "+ System.lineSeparator());

        	
        	ArrayList<Integer>  numArr = new ArrayList<>();{
        		for (int i = 1; i<=num; i++) {
        		{
        	numArr.add(i);
        	  
        		};
        	}
        	System.out.print(numArr+ System.lineSeparator());
}
		
		
		
		System.out.println("The prime numbers between 1 and 100 are: ");
        // loop through the numbers one by one
        for (int i = 1; i<num; i++) {
        	
        	
        	
        	
        
            boolean isPrimeNumber = true;
 
            // check to see if the number is prime
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break; // exit the inner for loop
                }
            }
             
            // print the number if prime
            if (isPrimeNumber) {
                
                System.out.print(i + ", ");
            }
            
        }
	}
	

	static void isMinimum() {
		
		int num1, num2, min;
		System.out.println("Please enter the two numbers you would you like to be compared: ");
        Scanner scanner = new Scanner(System.in);
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        scanner.close();
		
		 // Largest among n1 and n2  
	    min = (num1 < num2) ? num1 : num2;  
	      
	    // Print the largest number  
	    System.out.println("The minimum number between " + num1 +  
	                  " and " + num2 + " is " + min + ". " );  
		
	}

	static void isEvenNum() {
		int num = 100;
		 
		System.out.print("The Array of numbers between 1 and 100 are: "+ System.lineSeparator());

        	
        	ArrayList<Integer>  numArr = new ArrayList<>();{
        		for (int i = 1; i<=num; i++) {
        		{
        	numArr.add(i);
        	  
        		};
        	}
        	System.out.print(numArr+ System.lineSeparator());
}
		
		
		
		System.out.println("The even numbers between 1 and 100 are: ");
        // loop through the numbers one by one
        for (int item: numArr) {
        	
        	
        	
        	
        
        	if((item / 2)*2==item){
    	        System.out.print(+item+", ");
    	    }
            
        }
	}



		static void printTriangle() {
			int num, len, wid;
			System.out.println("Please enter the number of rows you would like your triangle to have: ");
	        Scanner scanner = new Scanner(System.in);
	        num = scanner.nextInt();
            scanner.close();
            for (int i = 1; i <= num; i++)
            {
                if (i % 2 == 0)
                { len = 1; wid = 0; }
                else
                { len = 0; wid = 1; }
                for (int j = 1; j <= i; j++)
                    if (j % 2 == 0)
                        System.out.print(len);
                    else
                        System.out.print(wid);
                System.out.println();
     
            }
		}


			static void principleInterest() {
				double principle, interest,rate;
				int years;
				System.out.println("Please enter the principle balance: ");
		        Scanner scanner = new Scanner(System.in);
		        principle = scanner.nextDouble();
			
		        System.out.println("Please enter the interest rate: ");
		        
		         rate= scanner.nextDouble();
			
		        System.out.println("Please enter the number of  years remaining to pay: ");
		        
		        years = scanner.nextInt();
		        scanner.close();
		        
		        interest = (principle*rate*years)/100;
		        
		        System.out.println("The total interest paid over "+years+" years is: $"+interest);
		        
			}
			
			
			static void readInFile() {

				String entry;
				StringTokenizer str = null;
				
				try ( BufferedReader br = new BufferedReader(new FileReader("src/Data.txt")) )
				{
					while( (entry = br.readLine()) != null )
					{
						str = new StringTokenizer(entry, ":");
						String[] data = {"Name", "Age", "State"};
						
						int i = 0;                     
						
						// Gets Name
						System.out.println( data[i] + ": " + str.nextToken() + " " + str.nextToken() );
						
						// Gets Age and State
						while( str.hasMoreTokens() ) 
						{
							i++;
							System.out.println( data[i] + ": " + str.nextToken() );						
						}
						
						System.out.println();
					}
				}
				catch(FileNotFoundException e)
				{
					System.out.println("File not found, please ensure the file is there");;
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		
			}

			static void decToHex() {
				System.out.println("Please enter the Decimal Number you would like to convert to a Hexadecimal");
				Scanner scan = new Scanner(System.in);
				String Num = scan.nextLine();
				int dec =Integer.parseInt(Num);
				scan.close();
				int Dec=dec;
				int rem;
		        
			     //stores result
			     String hex=""; 
			 
			     //list of hexadecimal variables
			     char hexlist[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
			 
			     while(dec>0)
			     {
			       rem=dec%16; 
			       hex=hexlist[rem]+hex; 
			       dec=dec/16;
			     }
				
				
				//String hex=Integer.toHexString(dec);
				System.out.println(Dec + " is '" +  hex + "' written as a Hexadecimal");
			}




			static void subString() {

				

				int num;
				System.out.println("Please enter a string as a series of words: ");
		        
		        Scanner read = new Scanner(System.in);
		        String strng = read.nextLine();
		        
		        String sub=" ";
		        System.out.println("Please enter the number not greater than the length of your string: ");
		        
		        num = read.nextInt();
	            read.close();
		        // creates a StringBuffer object with a String passed as the parameter
		        StringBuffer str = new StringBuffer(strng); 
		  
		        // print string 
		        System.out.println("String contains = " + str); 
		  
		        
		     try {    
		        for(int i = 0; i < num; i++)
		        {
		            sub = sub + str.charAt(i);
		           
		        }
		        System.out.println("The substring Sequence between 0 and "+num+" is: " +sub);
		     	
			}
			catch (StringIndexOutOfBoundsException e) { 
				  
	            System.out.println("Exception Found!!!!: " + e); 
	        } 
			}



			static void ArrLists() {
				int evenSum = 0;
				int oddSum = 0;
				
				ArrayList<Integer> arr = new ArrayList<Integer>();

				for(int i = 1; i <= 10; i++)

				arr.add(i);

				System.out.println("Original ArrayList: " + arr);
				

				// sum even, sum odd, remove primes

				for(int i = 0; i < arr.size(); i++ )

				{

				Integer num = arr.get(i);



				if( num % 2 == 0 )

				evenSum = evenSum + num;

				if( num % 2 == 1 )

				oddSum = oddSum + num;



				boolean isPrimeNumber = true;
				 
	            // check to see if the number is prime
	            for (int j = 2; j < i; j++) {
	                if (i % j == 0) {
	                    isPrimeNumber = false;
	                    break; 
	                }
	            }

				if( isPrimeNumber )

				{ 

				arr.remove(i); //removes prime number from array list

				i--; 

				}



				}



				System.out.println("The sum of the even numbers is: " + evenSum);

				System.out.println("The sum of the odd numbers is: " + oddSum);

				System.out.println( "ArrayList without any prime numbers: " + arr );

			}


			static void removeDuplicates() {
				 
				System.out.println("Please enter a string with repeated characters: ");
		        
		        Scanner read = new Scanner(System.in);
		        String strng = read.nextLine();
		        
				read.close();
				
				String str = new String(); 
			        int len = strng.length(); 
			          
			       
			        // for loop to check for repeating characters using IndexOf() method in Java 
			      
			        for (int i = 0; i < len; i++)  
			        { 
			            
			            char c = strng.charAt(i); 
			              
			            //if c is in str, it returns the index of c else it returns -1
			            if (str.indexOf(c) < 0) 
			            { 
			                //c is added to str everytime -1 is returned
			                str += c; 
			            } 
			        } 
			        
			        System.out.println("The String with Duplicate Characters removed is: "+str);
			}












}

