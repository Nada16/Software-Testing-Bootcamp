import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportingExcel {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell cell;
	//private static XSSFRow Row;

	public static void setExcelFile(String path,String sheet) throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(path);

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheet);
		} catch (Exception e){ throw (e); }
	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {
		//Returns the value of the cell in the location (rowNum, colNum)
		try{
			cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			CellType dataType = cell.getCellType();

			//If cell is empty, return an empty string
			if  (dataType == CellType.BLANK) {
				return "";
			}
			//Otherwise return the value of the cell
			else{
				String CellData = cell.getStringCellValue();
				return CellData;
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);
		}
	}

	public static int getRowsNum() throws Exception {
		//Returns an int indicating the number of used rows in the sheet
		try{
			int RowCount = ExcelWSheet.getLastRowNum();
			return RowCount;
		}catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);
		}
	}

	public static String[] getTestCaseValues(String path, String sheet, int testcaseRow) throws Exception {
		//Create a string array with all the values in the testcase row and return it
		String[] values = null;
		try{
			//Open the required sheet
			setExcelFile(path, sheet);
			
			int startCol = 1;
			int i=0;
			int totalCols = ExcelWSheet.getRow(testcaseRow).getLastCellNum()-1;
			values=new String[totalCols];
			
			//Loop through the values in the row and store them
			for (int j=startCol;j<=totalCols;j++, i++)	{
				values[i]=getCellData(testcaseRow,j);
			}
		}
		catch (FileNotFoundException e)	{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}

		catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return(values);	
	}
}