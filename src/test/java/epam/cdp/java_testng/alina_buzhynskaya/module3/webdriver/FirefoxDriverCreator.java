package epam.cdp.java_testng.alina_buzhynskaya.module3.webdriver;

/**
 * Created by Alina_Buzhynskaya on 3/24/2017.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverCreator extends WebDriverCreator {
    @Override
    public WebDriver FactoryMethod() {
        driver = new FirefoxDriver();
        return driver;
    }
}