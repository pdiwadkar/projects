package test.serve;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;


public class ServiceTest {

	//public static final String SAMPLE_XLSX_FILE_PATH = "D:\\Work\\Code\\Accion\\Report\\CarSales-2020.xlsx";
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		String Source = "D:\\Work\\Code\\Accion\\Report\\TruckSales-2020.xlsx";
		String Dest = "D:\\Work\\Code\\Accion\\Report\\TruckStats-2020.xlsx";
		writeClientData(Source,Dest);
		
	}
	
	public static void writeClientData(String source,String dest) {
		
		try {
		Workbook workbook = WorkbookFactory.create(new File(source));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        System.out.println("Retrieving Sheets using Iterator");
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            System.out.println("=> " + sheet.getSheetName());
        }

        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // 1. You can obtain a rowIterator and columnIterator and iterate over them
        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }

		workbook.close();
		XLSWriter.writeTruckSales(dest);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
