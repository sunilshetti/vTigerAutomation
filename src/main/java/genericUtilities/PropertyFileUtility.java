package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * @author Sunil BHadrashetti	
 */

public class PropertyFileUtility 


{
	public String readDataFromFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
		
	}
	
	
	public String readDataFromExcelFile(String colomnNamem, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{

		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(colomnNamem);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value=cell.getStringCellValue();
		return value;
		
	}

	

}
