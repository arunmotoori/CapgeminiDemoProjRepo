package packone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OneTest {
	
	WebDriver driver;
	
	@Test
	public void testOneA() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://tutorialsninja.com/demo/");
		driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());	
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}

}
