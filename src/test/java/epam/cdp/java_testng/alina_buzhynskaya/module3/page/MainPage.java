package epam.cdp.java_testng.alina_buzhynskaya.module3.page;

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

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SendEmailPage openSendEmailPage() {
        buttonCompose.click();
        return new SendEmailPage(driver);
    }
}
