package Common_Utilizations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Web_driver
{
		public static WebDriver driver = null;
		public static WebDriver browser(String browser)
		 {
			try
			  {
				if(browser.equalsIgnoreCase("firefox")) {
					 
						//If browser is Firefox, then do this  
					  driver = new FirefoxDriver();
					 System.out.println("firefox is successfully opened");
					 
					  // If browser is IE, then do this   
					  }else if (browser.equalsIgnoreCase("ie")) 
					  {
					 
					  // Here I am setting up the path for my IEDriver
					  System.setProperty("webdriver.ie.driver", "D:\\ToolsQA\\OnlineStore\\drivers\\IEDriverServer.exe");
					  driver = new InternetExplorerDriver();
					  System.out.println("IE is successfully opened");
					  } 
					  else if (browser.equalsIgnoreCase("chrome")) 
					  {
					 
					  // Here I am setting up the path for my IEDriver
					  System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
					 	driver = new ChromeDriver();
					  System.out.println("chrome is successfully opened");
					  } 
				

			  }

			catch(Exception e)
			{
				return null;
			}
	return driver;
	 }
		
		
		public static void Browser_close()
		{
			driver.close();
		}
	
}