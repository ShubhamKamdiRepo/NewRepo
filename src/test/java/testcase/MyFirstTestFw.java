package testcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import base.BaseTest;

public class MyFirstTestFw extends BaseTest {

	@Test(dataProvider = "testdata")
	public static void LoginTest(String username, String password) throws InterruptedException {

		System.out.println("Clicked successfully");
		driver.manage().window().maximize();
		Thread.sleep(4000);
//		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.linkText(Loc.getProperty("signin_link"))).click();
		Thread.sleep(4000);
		driver.findElement(By.id(Loc.getProperty("email_field"))).sendKeys(username);
		driver.findElement(By.xpath(Loc.getProperty("next_button"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(Loc.getProperty("pwd_field"))).sendKeys(password);
		Thread.sleep(4000);
		driver.findElement(By.xpath(Loc.getProperty("signin_login"))).click();
	}

	@DataProvider(name = "testdata")
	public Object[][] createData() {
		return new Object[][] { 
				 { "ideam363@gmail.com", "Mandar@9766" },
				{ "ideam963@gmail.com", "andar@#9766" },
				{ "ideam9363@gmail.com", "Mandar@#9766" } };
	}
}
