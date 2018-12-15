package DemoDataDriven;

import org.testng.annotations.*;
import datadriven.*;
public class NewTest {

	@DataProvider(name = "LoginTestData")
	public Object[][] DataSource() throws Exception {
		Object[][] data = new Object[2][2];
		
		//Read data from Excel
		ExcelUtils.setExcelFile("C:\\TestData\\Data.xlsx", "Sheet1");
		
		int startRow = 1;
		int endRow = 2;
		int startCol = 1;
		int endCol=2;
		
		int arrRow=0, arrCol=0;
		for(int i = startRow; i<=endRow; i++)
		{
			arrCol=0;
			for(int j=startCol; j<=endCol; j++)
			{
				String value = ExcelUtils.getCellData(i, j);
				data[arrRow][arrCol] = value;
				arrCol++;
			}
			arrRow++;
		}
		return data;
	}

	@Test(dataProvider="LoginTestData")
	public void TestLogin(String UserName, String Password) {
		System.out.println(UserName + ": "+ Password);
	}
}
