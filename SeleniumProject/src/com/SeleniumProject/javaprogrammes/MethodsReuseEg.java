package com.SeleniumProject.javaprogrammes;

public class MethodsReuseEg {

	public static void main(String[] args) {
		
//		MethodsEg.method1();
//		String res = MethodsEg.method2();
//		System.out.println(res);
		
		MethodsEg me = new MethodsEg();
		
//		me.method3();
//		boolean flag = me.method4();
//		System.out.println(flag);
		
		double res = me.sum(60.93 , 40.76);
		System.out.println(res);
		

	}

}
