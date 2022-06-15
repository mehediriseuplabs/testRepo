package excleFile;

public class ReadExcelData {

	public static void main(String[] args) {

		DataConfig excleData = new DataConfig("/Users/user/Documents/testdata.xlsx");

		System.out.println(excleData.getData(1, 0, 0));

	}

}
