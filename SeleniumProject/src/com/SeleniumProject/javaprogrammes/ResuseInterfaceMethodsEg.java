package com.SeleniumProject.javaprogrammes;

public class ResuseInterfaceMethodsEg {

	public static void main(String[] args) {
		
//		InterfaceImplementsEg1 im1 = new InterfaceImplementsEg1();
		InterfaceEg im1 = new InterfaceImplementsEg1();
		im1.Vehicle();

//		InterfaceImplementsEg2 im2 = new InterfaceImplementsEg2();
		InterfaceEg im2 = new InterfaceImplementsEg2();
		im2.Vehicle();
	}

}
