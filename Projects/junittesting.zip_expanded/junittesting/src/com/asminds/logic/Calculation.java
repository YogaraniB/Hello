package com.asminds.logic;

import java.util.Scanner;

public class Calculation {
	public static int factorial(int n){      
         if (n == 1)      
           return 1;      
         else      
           return(n * factorial(n-1));      
   }      
 
public static void main(String[] args)
{ 
	int n;
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the Factorial number: ");
	n=s.nextInt();
	System.out.println("Welcome");
System.out.println("Factorial value is:" +factorial(n) );  
}  
	}

