package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;


public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	
	@BeforeTest
	public void setUp() throws IOException {
		if (driver == null) {
			FileReader fr = new FileReader(
					"C:\\Users\\Shubham-PC\\eclipse-workspace\\TestAutomationFramwork\\src\\test\\resources\\configfiles\\config.properties");
			prop.load(fr);
		}

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); // base
			WebDriver driver = new ChromeDriver(); // base
			driver.get(prop.getProperty("testurl")); // properties
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			driver.get(prop.getProperty("testurl")); // properties
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("Teardown succesfully");
	}
}
