package epam.cdp.java_testng.alina_buzhynskaya.module3.page;

import org.openqa.selenium.WebDriver;

/**
 * Created by Alina_Buzhynskaya on 3/23/2017.
 */
abstract public class AbstractPage {

    protected WebDriver driver;

    abstract void open();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
