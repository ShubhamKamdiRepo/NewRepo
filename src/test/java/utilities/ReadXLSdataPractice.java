package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//public class ReadXLSdataPractice {
//
//	public static void main(String[] args) {
//
//	}
//	
//	public void getData(String XLsheet) throws EncryptedDocumentException, IOException {
//		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
//		FileInputStream fileinputs = new FileInputStream(file);
//		Workbook wB = WorkbookFactory.create(fileinputs);
//		Sheet sheetName = wB.getSheet(XLsheet);
//		
//		int totalRows = sheetName.getLastRowNum();
//		System.out.println(totalRows);
//		
//		Row rowCells = sheetName.getRow(0);
//		int totalCols = rowCells.getLastCellNum();
//		System.out.println(totalCols);
//		
//		DataFormatter format = new DataFormatter();
//		
//		for (int i=1; i<=totalRows; i++) {
//			for(int j=0; j<totalCols; j++) {
//				testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
//			System.out.println(testData[i-1][j] );
//			}
//		}
//		
//	}
//}


//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.usermodel.*;

public class ReadXLSdataPractice {

    public static void main(String[] args) throws EncryptedDocumentException, IOException {
        ReadXLSdataPractice reader = new ReadXLSdataPractice();
        reader.getData("login");
    }

    public String[][] getData(String excelSheetName) throws EncryptedDocumentException, IOException {
        File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet(excelSheetName);

        int totalRows = sheet.getLastRowNum(); // last row index (0-based)
        Row headerRow = sheet.getRow(0);
        int totalCols = headerRow.getLastCellNum();

        System.out.println("Total Rows (including header): " + (totalRows + 1));
        System.out.println("Total Cols: " + totalCols);

        DataFormatter format = new DataFormatter();

        // Include header -> totalRows + 1
        String[][] testData = new String[totalRows + 1][totalCols];

        // Start from row 0 (header)
        for (int i = 0; i <= totalRows; i++) {
            Row currentRow = sheet.getRow(i);
            for (int j = 0; j < totalCols; j++) {
                testData[i][j] = format.formatCellValue(currentRow.getCell(j));
            }
        }

        // Print the full data (header + data)
        System.out.println("=== Excel Data (Including Header) ===");
        for (String[] row : testData) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }

        wb.close();
        fis.close();
        return testData;
    }
}
