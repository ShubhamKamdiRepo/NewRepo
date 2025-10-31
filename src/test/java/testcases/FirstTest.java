package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://zoho.com");
		driver.manage().window().maximize();
//		Thread.sleep(4000);
		driver.findElement(By.linkText("Sign In")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("login_id")).sendKeys("ideam9363@gmail.com");
		driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Mandar@#9766");
		driver.findElement(By.xpath("//button[@id='nextbtn']//span[contains(text(),'Sign in')]")).click();
	}

}