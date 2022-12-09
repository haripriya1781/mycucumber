package org.base.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Return;

public class Baseclass {
	public static WebDriver driver;
	public static void browserLaunch(String webbrowser) {
		if (webbrowser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		else if (webbrowser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new ChromeDriver();
		}
		else if (webbrowser.equals("edge")) {
			WebDriverManager.chromedriver().setup();
			 driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
	}
	public static void launchUrl(String url) {
     driver.get(url);
	}
	
	public static void titlePage() {
String title = driver.getTitle();
System.out.println(title);
	}
	public static void search(WebElement srchElement, String text) {
		srchElement.sendKeys(text);

	}
	public static void passText(WebElement txtElement, String txt) {
		txtElement.sendKeys(txt);

	}
	public static void click(WebElement clk) {
  clk.click();
	}
	public static Actions a ;
	public static void mouseAction(WebElement mous) {
		a = new Actions(driver)	;
	a.moveToElement(mous).perform();
	}
	public static Alert at ;
	public static void alert() {
	
 at = driver.switchTo().alert();
at.accept();
	}
	public static void window(Integer i) {
		Set<String> allwinid = driver.getWindowHandles();
		List<String> l = new LinkedList<String>();
		l.addAll(allwinid);
		driver.switchTo().window(l.get(i));
	}
	public static void screenShots(String imgname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File ss = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\vsath\\eclipse-workspace\\Maven\\Screenshots\\"+imgname+".png");
		FileUtils.copyFile(ss, des);
	}
	 static JavascriptExecutor js;
	public static void javaScript(WebElement txt) {
 js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].setAttribute('value','iphone')", txt);
Object returntxt = js.executeScript("return arguments[0].getAttribute('value')", txt);
String s = (String)returntxt;
System.out.println(s);
	}
	
	public static void jsToclick(WebElement clk) {
		 js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click()",clk);
		 }
	
		public static String readDataFromExcel(String sheetName,int getTheRow,int getTheCell) throws IOException {
			File f = new File("C:\\Users\\vsath\\eclipse-workspace\\Maven\\Excel files\\newsheet1.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fis);
			Sheet s = w.getSheet(sheetName);
			
				Row r = s.getRow(getTheRow);
				
					Cell c = r.getCell(getTheCell);
					int cellType = c.getCellType();
					String value = "";
					if (cellType == 1) {
						 value = c.getStringCellValue();
					
					}
					else if (DateUtil.isCellDateFormatted(c)) {
						Date dd = c.getDateCellValue();
						SimpleDateFormat sim = new SimpleDateFormat("dd-mm-yy");
						 value = sim.format(dd);
						
					}
					else {
						double d = c.getNumericCellValue();
						long l = (long) d;
						 value = String.valueOf(l);
						
					}
					return value;
					
			}
		public static void allDataFromExcel(String sheetName) throws IOException {
			File f = new File("C:\\Users\\vsath\\eclipse-workspace\\Maven\\Excel files\\newsheet1.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fis);
			Sheet s = w.getSheet(sheetName);
			for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
				Row r = s.getRow(i);
	
				for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
					Cell c = r.getCell(j);
					System.out.println(c);
	}
}

		}
		public static void totalRowCellCount(String sheetName) throws IOException {
			File f = new File("C:\\Users\\vsath\\eclipse-workspace\\Maven\\Excel files\\newsheet1.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fis);
			Sheet s = w.getSheet(sheetName);
			Row r = s.getRow(0);
			 r.getCell(0);
			int totalcell = r.getPhysicalNumberOfCells();
			int totalrow = s.getPhysicalNumberOfRows();
			System.out.println("Total number of Row is:" +totalrow);
			System.out.println("Total number of Cell is:" +totalcell);
		}
		public static void createExcelFile( int creTheRow,int creTheCell, String data) throws IOException {
		File f = new File("C:\\Users\\vsath\\eclipse-workspace\\Maven\\Excel files\\test.xlsx");
		
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Data");
		Row r = s.createRow(creTheRow);
		Cell c = r.createCell(creTheCell);
		c.setCellValue(data);
	FileOutputStream fos = new FileOutputStream(f);
	w.write(fos);
		System.out.println("created....");
		
		
		

		}
		public static void createRowOnly(int creTheRow,int creTheCell, String data) throws IOException {
			File f = new File("C:\\Users\\vsath\\eclipse-workspace\\Maven\\Excel files\\test.xlsx");
			FileInputStream fis = new FileInputStream(f);
			
			Workbook w = new XSSFWorkbook(fis);
			Sheet s = w.getSheet("Data");
			Row r = s.createRow(creTheRow);
			Cell c = r.createCell(creTheCell);
			c.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
			System.out.println("created....");

		}
		public static void createCellOnly(int getTheRow,int creTheCell, String data) throws IOException {
			File f = new File("C:\\Users\\vsath\\eclipse-workspace\\Maven\\Excel files\\test.xlsx");
			FileInputStream fis = new FileInputStream(f);
			
			Workbook w = new XSSFWorkbook(fis);
			Sheet s = w.getSheet("Data");
			Row r = s.getRow(getTheRow);
			Cell c = r.createCell(creTheCell);
			c.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
			System.out.println("created....");
		}
		public static void closeTheBrowser() {
			driver.close();
		}
public static void selectDrop(WebElement location, String value) {
	Select s = new Select(location);
	s.selectByValue(value);
}
public static String jdbcConnection() throws ClassNotFoundException, SQLException {
	Connection con = null;
	String snamecol="";
Class.forName("oracle.jdbc.driver.OracleDriver");
 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr@123");
String query = "select first_name from employees where first_name='Peter'";
PreparedStatement ps = con.prepareStatement(query);
ResultSet eq = ps.executeQuery();


while (eq.next()) {
	 snamecol = eq.getString("first_name");	
} 
con.close();
return snamecol;
}



		}
	
	

	


