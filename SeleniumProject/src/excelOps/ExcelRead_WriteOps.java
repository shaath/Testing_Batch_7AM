package excelOps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.SeleniumProject.ReusableClasses.BusinessMethods;

public class ExcelRead_WriteOps {

	public static void main(String[] args) throws IOException {
		
		Date d = new Date();
		System.out.println(d);       //  2101202273244
		
		SimpleDateFormat sf = new SimpleDateFormat("ddMMyyyyHHmmss");
		String date = sf.format(d);
		System.out.println(date);
		
		String xlPath = System.getProperty("user.dir")+"\\src\\com\\SeleniumProject\\TestData\\TestData.xlsx";
		String xlOut = System.getProperty("user.dir")+"\\src\\com\\SeleniumProject\\Results\\TestRes"+date+".xlsx";
		String res = null;
		
		FileInputStream fi = new FileInputStream(xlPath);
		
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("EmpReg");
//		XSSFRow r = ws.getRow(4);
//		XSSFCell c = r.getCell(2);
		
//		System.out.println( c.getStringCellValue() );
		
		int lRI = ws.getLastRowNum();
		System.out.println(lRI);
		
//		System.out.println(r.getLastCellNum());
		BusinessMethods bm = new BusinessMethods();
		
		bm.orgLaunch(bm.url);
		bm.orgLogin(bm.u, bm.p);
		
		for (int i = 1; i <= lRI; i++)
		{
			XSSFRow r = ws.getRow(i);
			
			XSSFCell c1 = r.getCell(0);
			XSSFCell c2 = r.getCell(1);
			XSSFCell c3 = r.getCell(2);
			XSSFCell c4 = r.createCell(3);
			
			String f = c1.getStringCellValue();
			String l = c2.getStringCellValue();
			String eid = c3.getStringCellValue();
			
			System.out.println(f+"---"+l+"---"+eid);
			
			res = bm.orgEmpReg(f, l, eid);
			
			c4.setCellValue(res);
		}
		
		FileOutputStream fo = new FileOutputStream(xlOut);
		
		wb.write(fo);
		wb.close();
		
		bm.orgLogout();
		bm.orgClose();
	}

}
