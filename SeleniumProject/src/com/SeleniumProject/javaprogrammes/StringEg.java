package com.SeleniumProject.javaprogrammes;

public class StringEg {

	public static void main(String[] args) {
		
//		String course = "Selenium";
		
//		System.out.println(course.startsWith("Selb"));
//		System.out.println(course.endsWith("m"));
		
//		System.out.println("You are selected "+ course + " It is a course");
		
//		System.out.println(course.concat(" is a functional automation testing tool"));
		
//		System.out.println(course.join(" ", "You are selected", course, "It is an automation testing tool"));
		
//		System.out.println(course.length());
		
//		System.out.println(course.toUpperCase());
//		System.out.println(course.toLowerCase());
		
//		System.out.println(course.charAt(4));
//		System.out.println(course.indexOf('e'));
//		System.out.println(course.lastIndexOf('e'));
		
//		System.out.println(course.substring(2, 5));
//		System.out.println(course.substring(2));
		
//		System.out.println(course.trim().length());
		
//		System.out.println(course.replace("len", "xy"));
//		System.out.println(course.replaceFirst("e", "x"));
		
//		System.out.println(course.equals("Selenium"));
//		System.out.println(course.equalsIgnoreCase("selenium"));
		
//		System.out.println(course.contains("len"));
		
//		System.out.println(course.isEmpty());
		
		String x = "I am learning Java";
		
		String[] ss = x.split(" ");
		
		System.out.println(ss.length);
		
		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);
		}
	}

}
