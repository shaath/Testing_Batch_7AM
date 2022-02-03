package com.SeleniumProject.Tests;

import java.io.IOException;

import com.SeleniumProject.ReusableClasses.BusinessMethods;

public class UserLoginTC {

	public static void main(String[] args) throws InterruptedException, IOException {
		String res = null;
		BusinessMethods bm = new BusinessMethods();
		
		res = bm.orgLaunch(bm.url);
		System.out.println("Application Launch "+ res);
		
		res = bm.orgLogin("FirstTestAutomation8547", "Test@8529637410");
		System.out.println("Application Login "+ res);
		
		res = bm.orgLogout();
		System.out.println("Application Logout "+ res);
		
		bm.orgClose();
		System.out.println("Application closed successfully");


	}

}
