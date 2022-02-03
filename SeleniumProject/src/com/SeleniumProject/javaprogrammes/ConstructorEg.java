package com.SeleniumProject.javaprogrammes;

public class ConstructorEg {

	ConstructorEg(int id, String course)
	{
		System.out.println("This is Constructor code");
		System.out.println("This is ConstructorEg method running code");
		
		System.out.println(id +"----"+course);
	}
	
	ConstructorEg(int id1, int id2, int id3)
	{
		System.out.println(id1 +"---"+id2+"---"+id3);
	}
	
}
