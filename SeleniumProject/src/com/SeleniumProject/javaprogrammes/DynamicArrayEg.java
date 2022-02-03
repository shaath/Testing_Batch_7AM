package com.SeleniumProject.javaprogrammes;

public class DynamicArrayEg {

	public static void main(String[] args) {
		
		Object[] x = new Object[5];
		
		System.out.println(x.length);
		
		//Writing the data into an array
		
		x[0] = "Selenium";
		x[2] = 100000;
		x[0] = 'M';
		
		//Reading the data from 
		
//		System.out.println(x[2]);
		
		for (int i = 0; i < x.length; i++)
		{
			System.out.println(x[i]);
		}
		
	}

}
