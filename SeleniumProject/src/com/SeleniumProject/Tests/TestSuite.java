package com.SeleniumProject.Tests;

import java.io.IOException;

import com.SeleniumProject.ReusableClasses.BusinessMethods;

public class TestSuite {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Login
		String res = null;
		BusinessMethods bm = new BusinessMethods();
		
		res = bm.orgLaunch(bm.url);
		System.out.println("Application Launch "+ res);
		
		res = bm.orgLogin(bm.u, bm.p);
		System.out.println("Application Login "+ res);
		
		res = bm.orgLogout();
		System.out.println("Application Logout "+ res);
		
		bm.orgClose();
		System.out.println("Application closed successfully");
		
		//Empreg
		res = bm.orgLaunch(bm.url);
		System.out.println("Application Launch "+ res);
		
		res = bm.orgLogin(bm.u, bm.p);
		System.out.println("Application Login "+ res);
		
		res = bm.orgEmpReg("FirstTest11", "Automation11", "FTA7888");
		System.out.println("Employee Registration "+ res);
		
		res = bm.orgLogout();
		System.out.println("Application Logout "+ res);
		
		bm.orgClose();
		System.out.println("Application closed successfully");

		//UserReg
		res = bm.orgLaunch(bm.url);
		System.out.println("Application Launch "+ res);
		
		res = bm.orgLogin(bm.u, bm.p);
		System.out.println("Application Login "+ res);
		
		res = bm.orgUserReg("FirstTest11 Automation11", "FirstTest11Automation118547", "Test@8529637410");
		System.out.println("User Registration "+ res);
		
		res = bm.orgLogout();
		System.out.println("Application Logout "+ res);
		
		bm.orgClose();
		System.out.println("Application closed successfully");

		//userLogin
		res = bm.orgLaunch(bm.url);
		System.out.println("Application Launch "+ res);
		
		res = bm.orgLogin("FirstTest11Automation118547", "Test@8529637410");
		System.out.println("Application Login "+ res);
		
		res = bm.orgLogout();
		System.out.println("Application Logout "+ res);
		
		bm.orgClose();
		System.out.println("Application closed successfully");

	}

}
