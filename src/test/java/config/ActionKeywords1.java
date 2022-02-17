package config;

import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
 
public class ActionKeywords1 {
 
		public static WebDriver driver;
		public String productName = "Car Care";
		static ActionKeywords a1;
	
		public static void openBrowser(){		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		}
 
	public static void navigate(){	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		}
 
	public static void select_category() throws Exception{
		WebElement element1=driver.findElement(By.id("searchDropdownBox"));
		Select listbox1 = new Select(element1);
		Thread.sleep(2000);	
		listbox1.selectByVisibleText("Automotive");
		}
 
	public static void search_product(){
		a1 = new ActionKeywords();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(a1.productName); 
		}
 
	public static void clickSearchBtn(){
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		}
 
	
	public static void waitFor() throws Exception{
		Thread.sleep(2000);
		}
 
	public static void verifyTitle(){
		a1 = new ActionKeywords();
		Assert.assertEquals(driver.getTitle(), "Amazon.com : "+a1.productName);
		Reporter.log("Title Verified: "+driver.getTitle(),true);
		}
 
	public static void closeBrowser(){
			driver.quit();
		}
 
	}