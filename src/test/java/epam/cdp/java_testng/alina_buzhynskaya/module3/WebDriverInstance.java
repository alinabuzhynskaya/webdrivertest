package epam.cdp.java_testng.alina_buzhynskaya.module3;

import epam.cdp.java_testng.alina_buzhynskaya.module3.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alina_Buzhynskaya on 3/17/2017.
 */
public class WebDriverInstance {

    //reguired geckodriver v0.14.0
    private static WebDriver driver = null;

    protected WebDriverInstance() {
        System.setProperty("webdriver.gecko.driver",Config.getDriverPath()+"geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            new WebDriverInstance();
        }
        return driver;
    }
}