package com.SeleniumProject.driverScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.SeleniumProject.ReusableClasses.BusinessMethods;

public class Keyword {

	public static void main(String[] args) throws IOException, InterruptedException {
		Date d = new Date();
		System.out.println(d);       //  2101202273244
		
		SimpleDateFormat sf = new SimpleDateFormat("ddMMyyyyHHmmss");
		String date = sf.format(d);
			
		BusinessMethods bm = new BusinessMethods();
		String res = null;
		String xlPath = System.getProperty("user.dir")+"\\src\\com\\SeleniumProject\\TestData\\Keyword.xlsx";
		String xlout = System.getProperty("user.dir")+"\\src\\com\\SeleniumProject\\Results\\keyRes"+date+".xlsx";
		FileInputStream fi = new FileInputStream(xlPath);
		
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet Tc_Sht = wb.getSheet("Testcase");
		XSSFSheet Ts_Sht = wb.getSheet("Teststeps");
		XSSFSheet Td_Sht = wb.getSheet("TestData");
		
		int Tc_Rc = Tc_Sht.getLastRowNum();
		int Ts_Rc = Ts_Sht.getLastRowNum();
		
		for (int i = 1; i <= Tc_Rc; i++) {
			Tc_Sht.getRow(i).createCell(3);
			String exe = Tc_Sht.getRow(i).getCell(2).getStringCellValue();
			
			if (exe.equalsIgnoreCase("Y")) {
				String Tc_TcId =  Tc_Sht.getRow(i).getCell(0).getStringCellValue();
				
				for (int j = 1; j <= Ts_Rc; j++) {
					String Ts_TcId = Ts_Sht.getRow(j).getCell(0).getStringCellValue();
					
					if (Tc_TcId.equalsIgnoreCase(Ts_TcId)) {
						String key = Ts_Sht.getRow(j).getCell(3).getStringCellValue();
						System.out.println(key);
						
						switch (key) {
						case "Launch":
							String url = Td_Sht.getRow(1).getCell(0).getStringCellValue();
							res = bm.orgLaunch(url);
							break;
						case "login":
							String u = Td_Sht.getRow(1).getCell(1).getStringCellValue();
							String p = Td_Sht.getRow(1).getCell(2).getStringCellValue();
							res = bm.orgLogin(u, p);	
							break;
						case "logout":	
							res = bm.orgLogout();
							bm.orgClose();
							break;
						case "Empreg":
							String f = Td_Sht.getRow(1).getCell(3).getStringCellValue();
							String l = Td_Sht.getRow(1).getCell(4).getStringCellValue();
							String eid = Td_Sht.getRow(1).getCell(5).getStringCellValue();
							res = bm.orgEmpReg(f, l, eid);
							break;
						case "Usereg":
							String ename = Td_Sht.getRow(1).getCell(6).getStringCellValue();
							String uname = Td_Sht.getRow(1).getCell(7).getStringCellValue();
							String pwd = Td_Sht.getRow(1).getCell(8).getStringCellValue();
							res = bm.orgUserReg(ename, uname, pwd);
							break;
						case "Ulogin":
							String un = Td_Sht.getRow(1).getCell(7).getStringCellValue();
							String pw = Td_Sht.getRow(1).getCell(8).getStringCellValue();
							bm.orgLogin(un, pw);
							break;
						default:
							System.out.println("Please take a proper keyword");
							break;
						}
						//Writing results into Test steps sheet
						Ts_Sht.getRow(j).createCell(4).setCellValue(res);
						//Writing the results into the Test case sheet
						if(!Tc_Sht.getRow(i).getCell(3).getStringCellValue().equalsIgnoreCase("Fail")){
							Tc_Sht.getRow(i).getCell(3).setCellValue(res);
						}
					}
				}
			}
			else{
				Tc_Sht.getRow(i).getCell(3).setCellValue("BLOCKED");
			}
		}
		
		FileOutputStream fo = new FileOutputStream(xlout);
		
		wb.write(fo);
		wb.close();
	}

}
