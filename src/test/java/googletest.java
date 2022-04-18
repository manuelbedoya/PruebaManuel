import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class googletest {

	private WebDriver driver;
	
	@Before
	
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\manuel.bedoya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/?hl=es");
		
		
		
	}
	@Test
	public void testdemo() {
		
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("hola mundo");
		searchbox.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("hola mundo", driver.getTitle());
		
		
	}
	@After
	public void tearDown() {
		
		driver.quit();
		
	}
	
}






