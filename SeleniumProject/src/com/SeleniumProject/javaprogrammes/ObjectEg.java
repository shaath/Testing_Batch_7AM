package com.SeleniumProject.javaprogrammes;

public class ObjectEg {

	public static void main(String[] args) {
		
		Object[] x = {100000, "Selenium", 'M', 2429.232, true, 39243904};
		
		System.out.println(x.length);
		
		for (int i = 0; i < x.length; i++) 
		{
			System.out.println(x[i]);
		}

	}

}
