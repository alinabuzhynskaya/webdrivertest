package epam.cdp.java_testng.alina_buzhynskaya.module3.webdriver;

import epam.cdp.java_testng.alina_buzhynskaya.module3.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alina_Buzhynskaya on 3/17/2017.
 */
public class WebDriverInstance {

    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    public static WebDriver getBrowser(String browserName) {
        WebDriver driver = null;
        switch (browserName) {
            case "Firefox":
                driver = drivers.get("Firefox");
                if (driver == null) {
                    System.setProperty("webdriver.gecko.driver", Config.getDriverPath() + "geckodriver.exe");
                    driver = new FirefoxDriver();
                    drivers.put("Firefox", driver);
                }
                break;
            case "Chrome":
                driver = drivers.get("Chrome");
                if (driver == null) {
                    System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
                    driver = new ChromeDriver();
                    drivers.put("Chrome", driver);
                }
                break;
        }
        return driver;
    }


    //reguired geckodriver v0.14.0
    //private static WebDriver driver = null;
//    protected WebDriverInstance() {
//        System.setProperty("webdriver.gecko.driver",Config.getDriverPath()+"geckodriver.exe");
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//    }
//
//    public static WebDriver getInstance() {
//        if (driver == null) {
//            new WebDriverInstance();
//        }
//        return driver;
//    }


}