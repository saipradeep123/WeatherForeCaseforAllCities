package Page_Objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Common_Utilizations.Web_driver;
public class EnterCityName_Objects 
{

	//For checking whether login successfully or not
	@FindBy (xpath="//*[@type='text']")
	private WebElement enterCityNmae;
	
	@FindBy (xpath="//*[@class='summary']//*[contains(@data-test, 'maximum')]")
	private List<WebElement> expectedMaxTempUi;	
	
	@FindBy (xpath="//*[@class='summary']//*[contains(@data-test, 'minimum')]")
	private List<WebElement> expectedMinTempUi;	
	
	@FindBy (xpath="//*[@class='summary']//*[contains(@data-test, 'speed')]")
	private List<WebElement> expectedWindSpeedUi;	
	
	@FindBy (xpath="//*[@class='summary']//*[contains(@data-test, 'rainfall')]")
	private List<WebElement> expectedRainFallUi;	
	
	@FindBy (xpath="//*[@class='summary']//*[contains(@data-test, 'pressure')]")
	private List<WebElement> expectedPressure;
	
	@FindBy (xpath="//*[@class='summary']//*[contains(@data-test, 'maximum')]")
	private List<WebElement> FiveDaysForcaseCount;	
	
	WebDriver driver=Web_driver.driver;
	
	
	public void ENTERCITYNAME(String uname) throws InterruptedException
	{
		enterCityNmae.clear();
		enterCityNmae.sendKeys(uname);
		enterCityNmae.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
	}
	
	public List<String> forecast_days_count ()  throws InterruptedException
	{
		List<WebElement> listOfElements = FiveDaysForcaseCount;
		 System.out.println("Number of elements:" +listOfElements.size());
		 List<String> all_elements_text=new ArrayList<>();


	    for (int i=0; i<listOfElements.size();i++){
	      System.out.println("Radio button text:" + listOfElements.get(i).getText());
	      all_elements_text.add(listOfElements.get(i).getText());
	    }
	    Assert.assertEquals(listOfElements.size(), 5);
	    return all_elements_text;
	
	}
	
	
	public void Checking_date_changes_after_enter_the_city_name() throws InterruptedException
	{
	
		List<String> test = forecast_days_count();
		System.out.println("Pradeep :" +test);
	}
	
	public void verifyMaxAndMinTemperature(int expectedMaxTemp,int expectedMinTemp,int day,SoftAssert softAssertion) {
		
		String xpathMax="//*[contains(@data-test,'day-"+day+"')]/../../following-sibling::div[@class='details']//span[contains(@data-test,'maximum')]";
		String xpathMin="//*[contains(@data-test,'day-"+day+"')]/../../following-sibling::div[@class='details']//span[contains(@data-test,'minimum')]";
		
		List<WebElement> maxTemps=driver.findElements(By.xpath(xpathMax));
		List<WebElement> MinTemps=driver.findElements(By.xpath(xpathMin));
		int min=0;
		int max=0;
		for(WebElement temp:maxTemps) {
			int value=Integer.valueOf(temp.getText().replace("°", ""));
			if(value>max) {
				max=value;
			}
		}
		int k=0;
		for(WebElement temp:MinTemps) {
			int value=Integer.valueOf(temp.getText().replace("°", ""));
			if(k==0) {
				min=value;
			}
			
			if(value<min) {
				min=value;
			}
			k++;
		}
		
		
		  softAssertion.assertEquals(expectedMinTemp,
		  min,"Verifying the minimum temperature displayed in ui for the day "+day);
		  softAssertion.assertEquals(expectedMaxTemp,
		  max,"Verifying the maximum temperature displayed in ui for the day "+day);
		 
		/*
		 * Assert.assertEquals(expectedMinTemp,
		 * min,"Verifying the minimum temperature displayed in ui");
		 * Assert.assertEquals(expectedMaxTemp,
		 * max,"Verifying the maximum temperature displayed in ui");
		 */
		  System.out.println("Successfully verified Temperature for day "+day);
		
	}
	
	public void verifyMaxWindSpeed(int expectedMaxWindSpeed,int day,SoftAssert softAssertion) {
	
		String xpathWind="//*[contains(@data-test,'day-"+day+"')]/../../following-sibling::div[@class='details']//span[contains(@data-test,'speed')]";
		
		List<WebElement> maxTemps=driver.findElements(By.xpath(xpathWind));
		int max=0;
		for(WebElement temp:maxTemps) {
			int value=Integer.valueOf(temp.getText().trim().replace("kph", "").trim());
			if(value>max) {
				max=value;
			}
		}
		
		softAssertion.assertEquals(expectedMaxWindSpeed, max,"Verifying the maximum wind speed displayed in ui for the day "+day);	
		//Assert.assertEquals(expectedMaxWindSpeed, max,"Verifying the maximum wind speed displayed in ui");
	
			System.out.println("Successfully verified wind speed for day "+day);
	}
	
	public void verifyRainFall(int expectedSumValue,int expectedMaxValue,int day,SoftAssert softAssertion) {
		
			String xpathMax="//*[contains(@data-test,'day-"+day+"')]/../../following-sibling::div[@class='details']//span[contains(@data-test,'rainfall')]";
			String xpathMin="//*[contains(@data-test,'day-"+day+"')]/../../following-sibling::div[@class='details']//span[contains(@data-test,'pressure')]";
			
			List<WebElement> maxTemps=driver.findElements(By.xpath(xpathMax));
			List<WebElement> MinTemps=driver.findElements(By.xpath(xpathMin));
			int sum=0;
			int max=0;
			for(WebElement temp:maxTemps) {
				int value=Integer.valueOf(temp.getText().replace("mm", "").trim());
				sum=sum+value;
			}
			
			for(WebElement temp:MinTemps) {
				int value=Integer.valueOf(temp.getText().replace("mb", "").trim());
				if(value>max) {
					max=value;
				}
			}
		
		
		  softAssertion.assertEquals(expectedSumValue,
		  sum,"Verifying the sum of rainfall for the day "+day);
		  softAssertion.assertEquals(expectedMaxValue,
		  max,"Verifying the maximum pressure for the day "+day);
		 /*
			 * Assert.assertEquals(expectedSumValue, sum,"Verifying the sum of rainfall");
			 * Assert.assertEquals(expectedMaxValue, max,"Verifying the maximum pressure");
			 */
			System.out.println("Successfully verified rain fall for day "+day);
			
		}
	public void verifyWeatherForeCastForAllDays(String city) {
		SoftAssert softAssertion = new SoftAssert();
		List<WebElement> listOfElements = FiveDaysForcaseCount;
		 System.out.println("Number of elements:" +listOfElements.size());
		 List<String> all_elements_text=new ArrayList<>();
	    for (int i=0; i<listOfElements.size();i++){
	    expectedMaxTempUi.get(i).click();
	    verifyMaxAndMinTemperature(Integer.valueOf(expectedMaxTempUi.get(i).getText().replace("°", "").trim()), Integer.valueOf(expectedMinTempUi.get(i).getText().replace("°", "").trim()), i+1,softAssertion);
	    verifyMaxWindSpeed(Integer.valueOf(expectedWindSpeedUi.get(i).getText().replace("kph", "").trim()), i+1,softAssertion);
		verifyRainFall(Integer.valueOf(expectedRainFallUi.get(i).getText().replace("mm", "").trim()), Integer.valueOf(expectedPressure.get(i).getText().replace("mb", "").trim()), i+1,softAssertion);
	    }
	    softAssertion.assertAll();
	    
	    System.out.println("Successfully verified all the weather forecasting values for the city "+city);
	
}}