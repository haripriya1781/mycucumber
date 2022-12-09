package org.stepdefinition;

import java.sql.SQLException;

import org.base.classes.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleDB extends Baseclass{
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String jc = jdbcConnection();
		System.out.println(jc);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(jc);
	}

}
