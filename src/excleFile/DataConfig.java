package excleFile;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataConfig {

	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public DataConfig(String excelPath) {

		try {
			File src = new File(excelPath);
			FileInputStream file = new FileInputStream(src);
			wb = new XSSFWorkbook(file);

			sheet1 = wb.getSheetAt(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String getData(int sheetNum, int row, int column) {

		sheet1 = wb.getSheetAt(sheetNum);

		String rowData = sheet1.getRow(row).getCell(column).getStringCellValue();
		return rowData;

	}

	public int getRowCounts(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();

		row = row + 1;

		return row;
	}

}
