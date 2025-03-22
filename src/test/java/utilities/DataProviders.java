package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	 
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		//String path = ".\\testData\\Opencart_loginData.xlsx"; //Taking excel file from testData Section
		String path = System.getProperty("user.dir") + "/testData/Opencart_loginData.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility(path);  // creating an object for xlUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]= new String[totalrows][totalcols]; //created for 2D String array
		
		for(int i=1;i<=totalrows;i++) //1 //read the data from excel storing in 2D array 
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j); //1,0
			}
		}
		return logindata; //returning two dimensional array
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4

}
