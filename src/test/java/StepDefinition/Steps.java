package StepDefinition;		

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;


import org.junit.runner.RunWith;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;		
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.junit.Cucumber;

public class Steps {				

    WebDriver driver;			
    		
    @Given("^Se abre el navegador y la pagina$")					
    public void open_the_Firefox_and_launch_the_application() throws Throwable							
    {		

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\manuel.bedoya\\Downloads\\chromedriver_win32_3\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");					
    }		

    @When("^Ingresar usuario y contraseña$")					
    public void enter_the_Username_and_Password() throws Throwable 							
    {		
       driver.findElement(By.name("username")).sendKeys("john");							
       driver.findElement(By.name("password")).sendKeys("demo");
       driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input")).click();
       
    }
    
    @Then("^Buscar cuenta$")					
    public void Agregar_chaqueta() throws Throwable 							
    {		
        driver.findElement(By.xpath("//a[contains(text(),'Accounts Overview')]")).click();
        
        //ESPERAR 3 SEGUNDOS
        WebElement element;
        WebDriverWait wait = new WebDriverWait(driver, 3);
        element= wait.until(ExpectedConditions.elementToBeClickable(By.id("usrUtils")));    
        
        // DAR CLICK EN LA CUENTA 12345
        driver.findElement(By.xpath("//a[contains(text(),'12345')]")).click();
       
        //SELECCIONAR MARZO Y CREDIT
        driver.findElement(By.xpath("//select[@id='month']")).sendKeys("March");
        driver.findElement(By.xpath("//div[@id='rightPanel']/div/div[2]/form/table/tbody/tr/td[2]/select")).sendKeys("Credit");
        //DAR CLIC EN GO
        driver.findElement(By.xpath("//input[@value='Go']")).click();



       
    }
	
}		