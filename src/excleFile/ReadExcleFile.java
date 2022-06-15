package excleFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcleFile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		File src = new File("/Users/user/Documents/testdata.xlsx");
		FileInputStream file = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(file);

		XSSFSheet sheet1 = wb.getSheetAt(0);
		int rowCounts = sheet1.getLastRowNum();

		for (int i = 0; i < rowCounts; i++) {
			String data1 = sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("data from rom" + " " + i + " " + data1);

		}

		wb.close();
	}

}
