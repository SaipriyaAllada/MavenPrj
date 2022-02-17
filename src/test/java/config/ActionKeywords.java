package config;

import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
 
public class ActionKeywords {
 
		public static final CharSequence productName = null;
		public static WebDriver driver;
		
	public static void openBrowser(){		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		}
 
	public static void navigate(){	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		}
	public static void navigateBack()
	{
		driver.navigate().back();
	}
	public static void searchFunc(String searchData) throws Exception{
		WebElement element1=driver.findElement(By.name("q"));
		
		element1.sendKeys(searchData);
		}
 
	 
	public static void clickSearchBtn(){
		driver.findElement(By.name("btnK")).click();
		}
 
	
	public static void waitFor() throws Exception{
		Thread.sleep(2000);
		}
 
	public static void verifyTitle(String searchStr){
		
		Assert.assertEquals(driver.getTitle(), searchStr+" - Google Search");
		Reporter.log("Title Verified: "+driver.getTitle(),true);
		}
 
	public static void closeBrowser(){
			driver.quit();
		}
 
	}