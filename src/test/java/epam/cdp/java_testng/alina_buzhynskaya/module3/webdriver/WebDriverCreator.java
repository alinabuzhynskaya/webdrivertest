package epam.cdp.java_testng.alina_buzhynskaya.module3.webdriver;

import org.openqa.selenium.WebDriver;

/**
 * Created by Alina_Buzhynskaya on 3/24/2017.
 */
public abstract class WebDriverCreator {
    protected WebDriver driver;

    public abstract WebDriver FactoryMethod();
}
