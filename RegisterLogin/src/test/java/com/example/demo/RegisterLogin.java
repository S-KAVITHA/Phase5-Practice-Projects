package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:4200/buyerlogin");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		Thread.sleep(4000);

		RegisterLogin logintest = new RegisterLogin();
		 logintest.RegisterTestcase(driver);
		 Thread.sleep(4000);
		logintest.LoginFailTestcase(driver);
		 Thread.sleep(4000);
		 logintest.LoginPassTestcase(driver);

		Thread.sleep(4000);
		 driver.close();
	}

	public void LoginFailTestcase(WebDriver driver) throws InterruptedException {

		WebElement emailId = driver.findElement(By.id("email"));
		emailId.sendKeys("karthik@gmail.com");

		WebElement passwordLog = driver.findElement(By.id("password"));
		passwordLog.sendKeys("123124");

		WebElement RememberMe = driver.findElement(By.id("rememberme"));
		RememberMe.click();
		Thread.sleep(4000);
		WebElement LoginBtn = driver.findElement(By.name("login"));
		LoginBtn.click();

		WebElement ErrorMsg = driver.findElement(By.xpath("//div[contains(@class, 'alert alert-danger')]"));
		
		String ActMsg = ErrorMsg.getText();
		System.out.println("Error Message " + ActMsg);
		String ExpMsg = "Not a valid buyers credentails";
		if (ActMsg.equals(ExpMsg)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

	}

	public void LoginPassTestcase(WebDriver driver) throws InterruptedException {

	
		
		WebElement emailId = driver.findElement(By.id("email"));
		emailId.clear();
		Thread.sleep(4000);
				emailId.sendKeys("karthik@gmail.com");

		WebElement passwordLog = driver.findElement(By.id("password"));
		passwordLog.clear();
		Thread.sleep(4000);
		passwordLog.sendKeys("123123");
		
		WebElement LoginBtn1 = driver.findElement(By.name("login"));
		System.out.println(LoginBtn1);
		LoginBtn1.click();

	}
	
	public void RegisterTestcase(WebDriver driver) throws InterruptedException {

		WebElement registerBtn = driver.findElement(By.xpath("//button[@routerlink ='/buyerregister']"));
		registerBtn.click();

		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys("Karthik");

		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("Ramalingam");

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("karthik@gmail.com");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123123");

		WebElement state = driver.findElement(By.name("state"));
		state.sendKeys("TX");

		WebElement zipcode = driver.findElement(By.name("zipcode"));
		zipcode.sendKeys("123456");

		WebElement agree = driver.findElement(By.id("agree"));
		agree.click();
		
		Thread.sleep(4000);
		
		WebElement submitBtn = driver.findElement(By.name("register"));
		submitBtn.click();
		
	}
}
