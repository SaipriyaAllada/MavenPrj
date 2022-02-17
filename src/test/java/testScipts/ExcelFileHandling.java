package testScipts;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelFileHandling {

	public static void main(String[] args) throws Exception {
		
		InputStream inp = new FileInputStream("C:\\Users\\91903\\Downloads\\newPrj\\newPrj\\src\\test\\resources\\list1.xls");

	    Workbook wb = WorkbookFactory.create(inp);
	    Sheet sheet = wb.getSheetAt(0);
	    for (int i =1;i<=4;i++)
	    {
	    Row row = sheet.getRow(i);
	    Cell cell = row.getCell(0);
	    System.out.println(cell);
	    
	    }
	}

}
