package testcases;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Common_Utilizations.Read_Excel;
import Common_Utilizations.Url_Launch;
import Common_Utilizations.Web_driver;
import Page_Objects.EnterCityName_Objects;



public class EnterCItyName_Testcases 
{
	EnterCityName_Objects login;
	Read_Excel re = new Read_Excel();
	Url_Launch url;
	
	@Test(dataProvider = "checking_property")
	public void Login_process(String cityname) throws InterruptedException
	{
	
		  login = PageFactory.initElements(Web_driver.driver,
		  EnterCityName_Objects.class); login.ENTERCITYNAME(cityname);
		System.out.println("--Started test scenario validation for city "+cityname+"--");	
		System.out.println("I entered the city : " +cityname);		
		Thread.sleep(1000);
		login.Checking_date_changes_after_enter_the_city_name();
		login.verifyWeatherForeCastForAllDays(cityname);
		System.out.println("--Finished test scenario validation for city "+cityname+"--");		
	}
	
	
	@DataProvider(name = "checking_property")
    public Object[][] createData1() throws Exception
	{
        Object[][] retObjArr=re.getTableArray("./Excel/read_inputs.xls", "Sheet1", "cityname");
        return(retObjArr);
       
	}
	
}
