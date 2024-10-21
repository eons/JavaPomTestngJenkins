package utilities;

import java.io.IOException;
import web.controllers.FilesController;
import org.testng.annotations.DataProvider;

public class DataProvidersUtility {
    @DataProvider(name="customerData")
    public String [][] getData() throws IOException
    {
        String path=".\\testData\\createAccountData.xlsx";//taking xl file from testData

        FilesController fc =new FilesController(path);//creating an object for XLUtility

        int totalrows = fc.getRowCount("Sheet1");
        int totalcols = fc.getCellCount("Sheet1",1);

        String[][] logindata = new String[totalrows][totalcols];//created for two dimension array which can store the data user and password

        for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
        {
            for(int j=0;j<totalcols;j++)  //0    i is rows j is col
            {
                logindata[i-1][j] = fc.getCellData("Sheet1",i, j);  //1,0
            }
        }
        return logindata;//returning two dimension array

    }

    //DataProvider 2

    //DataProvider 3

    //DataProvider 4
}
