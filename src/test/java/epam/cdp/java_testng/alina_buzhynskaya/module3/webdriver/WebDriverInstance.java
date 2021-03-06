package epam.cdp.java_testng.alina_buzhynskaya.module3.webdriver;

import epam.cdp.java_testng.alina_buzhynskaya.module3.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alina_Buzhynskaya on 3/17/2017.
 */
public class WebDriverInstance {

    private static WebDriver driver = null;
    private static WebDriverCreator creator;

    public static WebDriver getWebDriverInstance(String browserName) {
        if (driver == null) {
            switch (browserName) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", Config.getChromeDriverPath() + "chromedriver.exe");
                    creator = new ChromeDriverCreator();
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", Config.getFirefoxDriverPath() + "geckodriver.exe");
                    creator = new FirefoxDriverCreator();
                    break;
                default:
                    System.setProperty("webdriver.gecko.driver", Config.getFirefoxDriverPath() + "geckodriver.exe");
                    creator = new FirefoxDriverCreator();
                    break;
            }
            driver = creator.FactoryMethod();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            return driver;

        } else {
            return driver;
        }
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }
}
