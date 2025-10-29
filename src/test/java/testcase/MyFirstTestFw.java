package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.BaseTest;

public class MyFirstTestFw extends BaseTest {

@Test
	public static void LoginTest()  {
		driver.get("https://www.zoho.com"); //properties
		
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("login_id")).sendKeys("ideam9363@gmail.com");
		driver.findElement(By.id("nextbtn")).click();
	

		driver.findElement(By.id("password")).sendKeys("Mandar@#9766");
		driver.findElement(By.xpath("//button[@id='nextbtn']//span[contains(text(),'Sign in')]")).click();
	}
}
