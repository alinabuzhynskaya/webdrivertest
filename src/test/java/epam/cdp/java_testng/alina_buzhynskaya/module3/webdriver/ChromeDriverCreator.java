package epam.cdp.java_testng.alina_buzhynskaya.module3.webdriver;

/**
 * Created by Alina_Buzhynskaya on 3/24/2017.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreator extends WebDriverCreator {
    @Override
    public WebDriver FactoryMethod() {
        driver = new ChromeDriver();
        return driver;
    }
}