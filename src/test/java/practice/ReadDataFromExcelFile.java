package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		//Open the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

		//create a workbook
		Workbook wb=WorkbookFactory.create(fis);
		
		//Navigate to required sheet
		Sheet st = wb.getSheet("Contacts");
		
		//Navigate to required row
		Row rw = st.getRow(4);
		
		//Navigate to required cell
		Cell cl = rw.getCell(3);
		
		//Capture the data in the cell.
		String value = cl.getStringCellValue();
		
		//Print the data/value
		System.out.println(value);		
		

	}

}
