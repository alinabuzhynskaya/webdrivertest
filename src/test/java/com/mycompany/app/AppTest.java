package com.mycompany.app;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private static final String DRIVER_PATH = "C:\\Program Files\\geckodriver\\";
    private static final String EMAIL = "alinabuzhynskaya@gmail.com";
    public WebDriver driver;

    @Test
    public void launchBrowser() {
        System.out.println("launching firefox browser");
        System.setProperty("webdriver.gecko.driver", DRIVER_PATH + "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.navigate().to("http://www.gmail.com");
        driver.findElement(By.id("Email")).sendKeys(EMAIL);
        //driver.findElement(By.className("gmail-nav__nav-link__sign-in")).click();
    }
}
