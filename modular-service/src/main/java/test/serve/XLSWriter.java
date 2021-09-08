package test.serve;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSWriter {
	
	 private static String[] columns = {"Company", "Model","Sale"};
	 //static final String bikePath = "D:\\Work\\Code\\Accion\\Report\\BikeSales-2020.xlsx";
	    private static List<Bike> bikes =  new ArrayList<>();
	    
	    static {
	    	Bike b1 = new Bike("Mercedez","18TY",17362);
	    	Bike b2 = new Bike("BMW","NX261",14362);
	    	bikes.add(b1);
	    	bikes.add(b2);	    	
	    }
	    
	
	    
	public static void writeTruckSales(String path) throws IOException {
		
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances of various things like DataFormat, 
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Truck-Sales");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Cell Style for formatting Date
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        // Create Other rows and cells with employees data
        int rowNum = 1;
        for(Bike bike: bikes) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(bike.getCompany());

            row.createCell(1)
                    .setCellValue(bike.getModel());

            Cell saleCell = row.createCell(2);
            saleCell.setCellValue(bike.getSale());
            //saleCell.setCellStyle(saleCellStyle);

            
        }

		// Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream(path);
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
		
		
	}
	    

}
class Bike {
	private String company,model;
	private int sale;
	public Bike(String company,String model,int sale) {
		
		this.company = company;
		this.model = model;
		this.sale = sale;
	}
	public String getCompany() {
		return this.company;
	}
	public String getModel() {
		return this.model;
		
	}
	public int getSale() {
		return this.sale;
	}
	
}
