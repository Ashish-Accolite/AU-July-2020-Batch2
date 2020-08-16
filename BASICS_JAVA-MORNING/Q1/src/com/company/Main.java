package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    String mainStr,subStr,repStr;

	    Scanner sc = new Scanner(System.in);

	    System.out.println("Enter Main String");
	    mainStr = sc.nextLine();
	    System.out.println("Enter SubString");
	    subStr = sc.nextLine();
	    System.out.println("Enter String to be replaced");
	    repStr = sc.nextLine();

	    while(mainStr.contains(subStr)){
	    	mainStr = mainStr.replace(subStr,repStr);
		}
	   System.out.println(mainStr);
    }
}
