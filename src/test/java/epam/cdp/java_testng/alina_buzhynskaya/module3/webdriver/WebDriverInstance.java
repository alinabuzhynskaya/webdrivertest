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

    public static WebDriver getWebDriverInstance(String browserName) {

        switch (browserName) {
            case "chrome":
                if (driver == null) {
                    System.setProperty("webdriver.chrome.driver", Config.getChromeDriverPath() + "chromedriver.exe");
                    driver = new ChromeDriver();
                }
                break;
            case "firefox":
                if (driver == null) {
                    System.setProperty("webdriver.chrome.driver", Config.getChromeDriverPath() + "geckodriver.exe");
                    driver = new ChromeDriver();
                }
                break;
            default:
                if (driver == null) {
                    System.setProperty("webdriver.gecko.driver", Config.getFirefoxDriverPath() + "geckodriver.exe");
                    driver = new FirefoxDriver();
                }
                break;
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }
}
