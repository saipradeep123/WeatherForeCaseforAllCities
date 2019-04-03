package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Common_Utilizations.Read_Excel;
import Common_Utilizations.Url_Launch;
import Common_Utilizations.Web_driver;


public class Browser_URL_Launch
{

		Read_Excel re = new Read_Excel();
		Url_Launch url;
		//Web_driver driver;


		@Test
	    @Parameters("browser")
		public void Browser_Launch(String browser) throws InterruptedException
		{
		    //Open the Browser
			((Web_driver) Web_driver.driver).browser("chrome");
			Thread.sleep(2000);
//			Web_driver.driver.manage().window().maximize();
			System.out.println("test1234");
		}
		
		
		@Test (dataProvider = "url_launch", dependsOnMethods="Browser_Launch")
		public void urllaunch(String url1) throws InterruptedException
		{
			System.out.println("test");
			boolean expected = true;
			System.out.println("Pradeep :" +url1);
			
			boolean actual = (url.URL_NAVIGATION(url1));
			if (actual = true)
			{
				System.out.println("Url Navigated successfully");
			}
			else
			{
				System.out.println("Url failed");
			}
			
		
			//Comparing both Boolean values
			Assert.assertEquals(expected, actual);
			Thread.sleep(10000);
		}
		
		
		@DataProvider(name = "url_launch")
	    public Object[][] createData5() throws Exception
		{
	        Object[][] retObjArr=re.getTableArray("./Excel/read_inputs.xls", "Sheet1", "URL_launch");
	        return(retObjArr);
	       
		}
		
		
	}
		
		
		
		
		
		
	
	
	
	
	

