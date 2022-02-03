package com.SeleniumProject.javaprogrammes;

import java.util.ArrayList;

public class ArrayListEg {

	public static void main(String[] args) {
		
		ArrayList<Object> al = new ArrayList<>();
		
		al.add("Selenium");
		al.add(200000);
		al.add('M');
		al.add(true);
		al.add(4, "Apple");
		al.add(2, "Selenium");
		
//		al.remove(1);
//		al.clear();
		
		al.set(1, "Boll");
		
		
		System.out.println(al.size());
		
//		System.out.println(al.get(1));
		
		for (int i = 0; i < al.size(); i++) 
		{
			System.out.println(al.get(i));
		}
		
		

	}

}
