package com.SeleniumProject.javaprogrammes;

public class TwoDimArrayEg {

	public static void main(String[] args) {
		
		Object[][] x = new Object[3][2];
		
		System.out.println("The number of rows "+ x.length);
		System.out.println("The number of columns for 0th indexed row "+ x[0].length);
		
		//Writing the data into array
		
		x[2][0] = "Selenium";
		x[1][1] = 400000;
		
		//Reading the data from an array
		
//		System.out.println(x[1][1]);
		
		for (int i = 0; i < x.length; i++) 
		{
			for (int j = 0; j < x[i].length; j++) 
			{
				System.out.println(x[i][j]);
			}
		}

	}

}
