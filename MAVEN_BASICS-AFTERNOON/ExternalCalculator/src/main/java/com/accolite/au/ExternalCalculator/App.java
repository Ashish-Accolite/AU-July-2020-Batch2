package com.accolite.au.ExternalCalculator;

import java.util.Scanner;

import com.accolite.au.Implementation.CalculatorImplementation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CalculatorImplementation calculator = new CalculatorImplementation();
        Double a=0.0,b = 0.0;
        String str;
        char operator;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter first operand");
        str = sc.nextLine();
        try {
        	a = Double.valueOf(str);
        }catch(NumberFormatException exc) {
        	exc.printStackTrace();
        }
        System.out.println("Enter second operand");
        str = sc.nextLine();
        try {
        	b = Double.valueOf(str);
        }
        catch(NumberFormatException exc) {
        	exc.printStackTrace();
        }
        
        System.out.println("Enter one of the following operators: +, -, /, *");
        operator = sc.nextLine().charAt(0);
        switch(operator) {
        	case '+': System.out.println("Add Result: " + calculator.add(a, b));
        			  break;
        	case '-': System.out.println("Subtract Result: " + calculator.substract(a, b));
        			  break;
        	case '*': System.out.println("Multiply Result: " + calculator.multiply(a, b));
        			  break;
        	case '/': Double ans = calculator.divide(a, b);
        			  if(ans == Integer.MIN_VALUE) {
        				  System.out.println("B can't be 0");
        			  }
        			  else {
        				  System.out.println("Divide Result: " + ans);
        			  }
        			  break;
        	default: System.out.println("Invalid Operator. Please try again!");
        }
    }
}
