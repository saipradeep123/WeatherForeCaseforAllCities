package StepDef;


import Common_Utilizations.Url_Launch;
import Common_Utilizations.Web_driver;
import Page_Objects.EnterCityName_Objects;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.PageFactory;

public class StepInit {
    EnterCityName_Objects enterCityName;
    String cityName;


    @Before
    public void beforeSuite() throws Throwable {
        Url_Launch url = new Url_Launch();
        Web_driver.browser("chrome");
        boolean actual = (url.URL_NAVIGATION("http://localhost:3000/ "));
        if (actual = true) {
            System.out.println("Url Navigated successfully");
        } else {
            System.out.println("Url failed");
        }
    }
    @After
    public void afterSuite() throws Throwable {
        Web_driver.driver.quit();
    }
}


