package com.SeleniumProject.javaprogrammes;

public class MethodsEg {

	public static void main(String[] args) 
	{
		method1();
		String res = method2();
		System.out.println(res);
		
		MethodsEg me = new MethodsEg();
		
		me.method3();
		boolean flag = me.method4();
		System.out.println(flag);
	}
	
	//static method without returning any value
	public static void method1()
	{
		System.out.println("This is method1 code");
	}
	
	//static method with returning value
	public static String method2()
	{
		System.out.println("This is method2 code");
		return "Pass";
	}
	
	// Non static method without returning any value
	public void method3()
	{
		System.out.println("This is method3 code");
	}
	
	// Non static method with returning value
	public boolean method4()
	{
		System.out.println("This is method4 code");
		return true;
	}
	
	public int sum(int a , int b)
	{
		int c = a + b;
		
		return c;
	}
	
	public int sum(int a ,int b, int c)
	{
		int d = a + b + c;
		return d;
	}
	
	public double sum(double a , double b)
	{
		double c = a + b;
		
		return c;
	}
	
}
