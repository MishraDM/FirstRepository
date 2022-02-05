package com.task;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task1 {

	XSSFWorkbook excelWorkbook = null;
	XSSFSheet excelSheet = null;
	XSSFRow row = null;
	XSSFCell cell = null;
	public WebDriver driver = null;

	@BeforeSuite

	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\Chrome 95\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void url() {
		driver.get("http://demo.guru99.com/test/newtours/register.php");

	}

	@BeforeClass
	public void maximize() {
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void getAllCookies() {

		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cookie : cookies) {
			System.out.println("Current cookies Name =" + cookie.getName());
		}

	}

	@Test(dataProvider = "getData")
	public void reg(String fname, String lname, String phone, String email, String address, String city, String state,
			String pcode, String country, String uname, String pass, String cpass) {

		driver.findElement(By.name("firstName")).sendKeys(fname);
		driver.findElement(By.name("lastName")).sendKeys(lname);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("userName")).sendKeys(email);
		driver.findElement(By.name("address1")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("postalCode")).sendKeys(pcode);
		driver.findElement(By.name("country")).sendKeys(country);
		driver.findElement(By.name("email")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("confirmPassword")).sendKeys(cpass);
		driver.findElement(By.name("submit")).click();
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		{
			FileInputStream in = new FileInputStream("F:\\Excel Sheet\\Book1.xlsx");

			excelWorkbook = new XSSFWorkbook(in);
			excelSheet = excelWorkbook.getSheet("sheet2");
			row = excelSheet.getRow(1);

			XSSFCell c1 = row.getCell(0);
			String fname = c1.getStringCellValue();

			XSSFCell c2 = row.getCell(1);
			String lname = c2.getStringCellValue();

			XSSFCell c3 = row.getCell(2);
			String phone = c3.getStringCellValue();

			XSSFCell c4 = row.getCell(3);
			String email = c4.getStringCellValue();

			XSSFCell c5 = row.getCell(4);
			String address = c5.getStringCellValue();

			XSSFCell c6 = row.getCell(5);
			String city = c6.getStringCellValue();

			XSSFCell c7 = row.getCell(6);
			String state = c7.getStringCellValue();

			XSSFCell c8 = row.getCell(7);
			String pcode = c8.getStringCellValue();

			XSSFCell c9 = row.getCell(8);
			String country = c9.getStringCellValue();

			XSSFCell c10 = row.getCell(9);
			String uname = c10.getStringCellValue();

			XSSFCell c11 = row.getCell(10);
			String pass = c11.getStringCellValue();

			XSSFCell c12 = row.getCell(11);
			String cpass = c12.getStringCellValue();

			return new Object[][] { new Object[] { fname, lname, phone, email, address, city, state, pcode, country,
					uname, pass, cpass }, };

		}

	}
}
