package com.SeleniumProject.javaprogrammes;

public class NestedIFEg {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 15;
		int c = 15;
			
		if( a > b & a > c)
		{
			System.out.println("A is greater");
		}
		else if(b > a & b > c)
		{
			System.out.println("B is greater");
		}
		else if (c > a & c > b)
		{
			System.out.println("C is greater");
		}
		else
		{
			System.out.println("Assign proper values to the variables");
		}

	}

}
