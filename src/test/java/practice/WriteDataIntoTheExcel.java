package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoTheExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {		
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		
		Sheet sheet=book.getSheet("WriteData");
		sheet.createRow(0).createCell(0).setCellValue("Test case is Pass");
		sheet.createRow(1).createCell(0).setCellValue("Test case is Pass");

		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		book.write(fos);
		fos.flush();

	}

}
