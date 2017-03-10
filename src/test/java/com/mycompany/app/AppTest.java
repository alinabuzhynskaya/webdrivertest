package com.mycompany.app;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private static final String DRIVER_PATH = "C:\\Program Files\\geckodriver\\";
    private static final String EMAIL = "annie505smith@gmail.com";
    private static final String PASSWORD = "annsmith123";
    private static final String EMAIL2 = "firstlasttest838@gmail.com";
    private static final String PASSWORD2 = "firstlasttest8381";
    private static final String TEXTOFEMAIL = "Hello! This is my first test email!";
    public WebDriver driver;

    @Test
    public void launchBrowser() {
        System.out.println("launching firefox browser");
        System.setProperty("webdriver.gecko.driver", DRIVER_PATH + "geckodriver.exe");
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.navigate().to("http://www.gmail.com");

        driver.findElement(By.id("Email")).sendKeys(EMAIL);
        driver.findElement(By.id("next")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
        driver.findElement(By.id("Passwd")).sendKeys(PASSWORD);
        driver.findElement(By.id("signIn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='НАПИСАТЬ']")));
        driver.findElement(By.xpath("//div[text()='НАПИСАТЬ']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
        driver.findElement(By.name("to")).sendKeys(EMAIL2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("subjectbox")));
        driver.findElement(By.name("subjectbox")).sendKeys("new test");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":9f")));
//        driver.findElement(By.id(":9f")).sendKeys(TEXTOFEMAIL);
        driver.findElement(By.xpath("//div[text()='Отправить']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link_vsm")));

        driver.findElement(By.className("gbii")).click();
        driver.findElement(By.id("gb_71")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account-chooser-link")));
        driver.findElement(By.id("account-chooser-link")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account-chooser-add-account")));
        driver.findElement(By.id("account-chooser-add-account")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        driver.findElement(By.id("Email")).sendKeys(EMAIL2);
        driver.findElement(By.id("next")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
        driver.findElement(By.id("Passwd")).sendKeys(PASSWORD2);
        driver.findElement(By.id("signIn")).click();

    }
}
