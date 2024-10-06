package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.stdDSA;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.PublicEncryptionKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	
	@BeforeTest
	public static void setup() throws IOException {
		
		if(driver==null) {
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\Config.properties");
			prop.load(fr);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firfox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
		}		
	}
	
	@AfterTest
	public void teardown() {
		
		driver.close();
		System.out.println("Teardown completed");
		
	}
	
	@DataProvider
	public String[] tasks() {
		String[] data= new String[] {
				"KT for new joiner",
				"Assignment complete",
				"Submit Timesheet",
				"Check All Task Completed"
		};
		return data;
	}

}
