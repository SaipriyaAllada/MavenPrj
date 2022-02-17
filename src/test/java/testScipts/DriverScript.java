
/*package executionEngine;
 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class DriverScript {

	private static WebDriver driver;
    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.store.demoqa.com");
 
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
        driver.findElement(By.id("log")).sendKeys("testuser_3"); 
        driver.findElement(By.id("pwd")).sendKeys("Test@123");
        driver.findElement(By.id("login")).click();
        driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
        driver.quit();
            }
}*/
package testScipts;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.ActionKeywords1;
import utility.ExcelUtils;
 
public class DriverScript {
	String sPath;
	@BeforeTest
    public void setUp() throws Exception {
    //	System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
    	// Declaring the path of the Excel file with the name of the Excel file
    	
    	sPath = System.getProperty("user.dir")+"\\src\\test\\resources\\DataEngine.xlsx";
 
    	// Here we are passing the Excel path and SheetName as arguments to connect with Excel file 
    	ExcelUtils.setExcelFile(sPath, "Test Steps");
 
    	//Hard coded values are used for Excel row & columns for now
    	//In later chapters we will replace these hard coded values with varibales
    	//This is the loop for reading the values of the column 3 (Action Keyword) row by row
	}
	@Test
	public static void test1() throws Exception
	{
    	for (int iRow=1;iRow<=10;iRow++){
		    //Storing the value of excel cell in sActionKeyword string variable
    		String sActionKeyword = ExcelUtils.getCellData(iRow, 3);
    		System.out.println(sActionKeyword);
    		//Comparing the value of Excel cell with all the project keywords
    		if(sActionKeyword.equals("openBrowser")){
                        //This will execute if the excel cell value is 'openBrowser'
    			//Action Keyword is called here to perform action
    			ActionKeywords1.openBrowser();}
    		else if(sActionKeyword.equals("navigate")){
    			ActionKeywords1.navigate();}
    		else if(sActionKeyword.equals("select_category")){
    			ActionKeywords1.select_category();}
    		else if(sActionKeyword.equals("search_product")){
    			ActionKeywords1.search_product();}
    		else if(sActionKeyword.equals("clickSearchBtn")){
    			ActionKeywords1.clickSearchBtn();}
    		else if(sActionKeyword.equals("verifyTitle")){
    			ActionKeywords1.verifyTitle();}
    		else if(sActionKeyword.equals("waitFor")){
    			ActionKeywords1.waitFor();}
    		else if(sActionKeyword.equals("closeBrowser")){
    			ActionKeywords1.closeBrowser();}
 
    		}
    	}
 }