package StepDef;



import Common_Utilizations.Url_Launch;
import Common_Utilizations.Web_driver;
import Page_Objects.EnterCityName_Objects;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import org.openqa.selenium.support.PageFactory;

public class ValidateResourceStepDef {
    EnterCityName_Objects enterCityName;
    String cityName;
    @Given("^I launch UI in \"([^\"]*)\" and navigate to \"([^\"]*)\"$")
    public void i_launch_UI_in_and_navigate_to(String browser, String browserUrl) throws Throwable {
        Url_Launch url=new Url_Launch();
         Web_driver.browser(browser);
        boolean actual = (url.URL_NAVIGATION(browserUrl));
        if (actual = true)
        {
            System.out.println("Url Navigated successfully");
        }
        else
        {
            System.out.println("Url failed");
        }
    }

    @Then("^I enter city name \"([^\"]*)\" in application$")
    public void i_enter_city_name_in_application(String cityName) throws Throwable {
        enterCityName = PageFactory.initElements(Web_driver.driver,
                EnterCityName_Objects.class);
        enterCityName.ENTERCITYNAME(cityName);
        this.cityName=cityName;
        System.out.println("--Started test scenario validation for city "+cityName+"--");
        System.out.println("I entered the city : " +cityName);
        Thread.sleep(1000);
        enterCityName.Checking_date_changes_after_enter_the_city_name();

    }

    @Then("^I validate all the weatherforecast factors displayed in ui$")
    public void i_validate_all_the_weatherforecast_factors_displayed_in_ui() throws Throwable {
        enterCityName.verifyWeatherForeCastForAllDays(cityName);
        System.out.println("--Finished test scenario validation for city "+cityName+"--");
       // Web_driver.driver.quit();
    }

}
