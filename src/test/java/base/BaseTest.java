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
	public static Properties Loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;

	@BeforeMethod
	public void setUp() throws IOException {
		if (driver == null) {

//			FileReader fr = new FileReader("C:\\Users\\Shubham-PC\\eclipse-workspace\\TestAutomationFramwork\\src\\test\\resources\\configfiles\\config.properties");
			fr = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
			fr1 = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locaters.properties");
			prop.load(fr);
			Loc.load(fr1);
		}

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); // base
			driver = new ChromeDriver(); // base
			driver.get(prop.getProperty("testurl")); // properties
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("testurl")); // properties
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		System.out.println("Teardown succesfully");
	}
}
