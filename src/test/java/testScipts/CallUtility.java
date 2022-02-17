package testScipts;

//import org.testng.annotations.Test;

import config.ActionKeywords;
import utility.ExcelUtils;

public class CallUtility {
	static String sPath;
	//@Test
	public static  void main(String[] args) throws Exception {
		sPath = System.getProperty("user.dir")+"\\src\\test\\resources\\list2.xlsx";
		System.out.println(System.getProperty("user.dir"));
		ExcelUtils.setExcelFile(sPath, "sheet1");
		ActionKeywords.openBrowser();
		ActionKeywords.navigate();
		for (int iRow=1;iRow<=4;iRow++){
			String searchKeyword = ExcelUtils.getCellData(iRow, 0);
			System.out.println(searchKeyword);			
			ActionKeywords.searchFunc(searchKeyword);
			ActionKeywords.clickSearchBtn();
			ActionKeywords.verifyTitle(searchKeyword);
			ActionKeywords.navigateBack();
	}
		ActionKeywords.closeBrowser();
		
	}
}
