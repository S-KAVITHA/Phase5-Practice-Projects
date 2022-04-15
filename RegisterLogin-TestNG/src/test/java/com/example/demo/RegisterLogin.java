package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegisterLogin {

	WebDriver driver;

	@Test(priority = 0, description = " This test is for setup")
	public void Setup() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/buyerlogin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		Thread.sleep(4000);
	}

	@Test(priority = 1, description = " This test is for Customer register")
	public void userFailTestcase() throws InterruptedException {

		WebElement emailId = driver.findElement(By.id("email"));
		emailId.sendKeys("karthik@gmail.com");

		WebElement passwordLog = driver.findElement(By.id("password"));
		passwordLog.sendKeys("123124");

		WebElement RememberMe = driver.findElement(By.id("rememberme"));
		RememberMe.click();
		Thread.sleep(4000);
		WebElement LoginBtn = driver.findElement(By.name("login"));
		LoginBtn.click();
		Thread.sleep(4000);

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

	@Test(priority = 2, description = " This test is for Customer login fail")
	public void userRegister() throws InterruptedException {

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
		Thread.sleep(4000);

	}

	@Test(priority = 3, description = " This test is for Customer login fail")
	public void userPassTestcase() throws InterruptedException {

		Thread.sleep(4000);
		WebElement emailId = driver.findElement(By.id("email"));
		System.out.println(emailId);
		emailId.sendKeys("karthik@gmail.com");

		WebElement passwordLog = driver.findElement(By.id("password"));
		passwordLog.sendKeys("123123");

		WebElement RememberMe = driver.findElement(By.id("rememberme"));
		RememberMe.click();

		Thread.sleep(4000);
		
		WebElement LoginBtn1 = driver.findElement(By.name("login"));
		System.out.println(LoginBtn1);
		LoginBtn1.click();

		}

	@Test(priority = 4, description = " This test is for Customer login fail")
	public void searchProduct() throws InterruptedException {

		Thread.sleep(4000);
		
		WebElement productsBar = driver.findElement(By.xpath("//a[@routerlink ='/buyproducts']"));
		System.out.println(productsBar);
		productsBar.click();

		WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder ='Search']"));
		System.out.println(searchBar);
		searchBar.sendKeys("Cabbage");

		Thread.sleep(4000);
		
		WebElement addTocart = driver.findElement(By.xpath("//a[text()='AddtoCart']"));
		addTocart.click();

		
		WebElement productsCart = driver.findElement(By.xpath("//a[@routerlink ='/cart']"));
		System.out.println(productsCart);
		productsCart.click();

		Thread.sleep(6000);
		
		WebElement checkoutbtn = driver.findElement(By.xpath("//button[text() ='Checkout']"));
		System.out.println(checkoutbtn);
		checkoutbtn.click();
		Thread.sleep(4000);

	}

	@Test(priority = 5, description = " This test is for Customer login fail")
	public void checkoutform() throws InterruptedException {

		Thread.sleep(4000);
		
		WebElement firstName = driver.findElement(By.id("firstName"));
		System.out.println(firstName);
		firstName.sendKeys("Karthik");

		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("Ramalingam");

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("karthik@gmail.com");

		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("124, Enclave Terrace");

		WebElement address2 = driver.findElement(By.id("address2"));
		address2.sendKeys("Suite 103");

		WebElement Country = driver.findElement(By.id("Country"));
		Country.sendKeys("USA");

		WebElement State = driver.findElement(By.id("State"));
		State.sendKeys("CA");

		WebElement zipcode = driver.findElement(By.id("zipcode"));
		zipcode.sendKeys("USA");

		WebElement ccname = driver.findElement(By.id("cc-name"));
		ccname.sendKeys("Karthik Ramalingam");

		WebElement ccnumber = driver.findElement(By.id("cc-number"));
		ccnumber.sendKeys("441212586987");

		WebElement ccexpiration = driver.findElement(By.id("cc-expiration"));
		ccexpiration.sendKeys("20281212");

		WebElement cccvv = driver.findElement(By.id("cc-cvv"));
		cccvv.sendKeys("256");

		Thread.sleep(9000);
		
		WebElement order = driver.findElement(By.name("order"));
		System.out.println(order);
		order.click();

		Thread.sleep(4000);

		WebElement LoginBtn = driver.findElement(By.name("logout"));
		LoginBtn.click();

	}

	@Test(priority = 6, description = " This test is for Customer register close")
	public void TearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
		System.out.println("After all Test methods");
	}

}
