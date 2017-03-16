package epam.cdp.java_testng.alina_buzhynskaya.module3.page;

import epam.cdp.java_testng.alina_buzhynskaya.module3.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Alina Buzhynskaya on 3/10/2017.
 */
public class MainPage {

    @FindBy(xpath = "//div[text()='НАПИСАТЬ']")
    private WebElement buttonCompose;

    @FindBy(className = "asl")
    private WebElement buttonReportSpam;

    @FindBy(className = "G-asx")
    private WebElement buttonMore;

    @FindBy(className = "J-Ke")
    private WebElement buttonSpam;

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SendEmailPage openSendEmailPage() {
        buttonCompose.click();
        return new SendEmailPage(driver);
    }

    public void sendToSpam(String userName) {
        WebElement email = driver.findElement(By.name(userName));
        email.click();
        //buttonReportSpam.click();
    }

    public void openSpamPage() {
        buttonMore.click();
        buttonSpam.click();
    }
}
