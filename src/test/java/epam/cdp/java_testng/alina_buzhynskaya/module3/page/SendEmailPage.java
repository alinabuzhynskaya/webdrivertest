package epam.cdp.java_testng.alina_buzhynskaya.module3.page;

import epam.cdp.java_testng.alina_buzhynskaya.module3.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alina Buzhynskaya on 3/10/2017.
 */
public class SendEmailPage extends AbstractPage{

    private static final String SEND_EMAIL_PAGE_URL = "https://mail.google.com/mail/#inbox?compose=new";

    @FindBy(name = "to")
    private WebElement inputTo;

    @FindBy(name = "subjectbox")
    private WebElement inputSubject;

    @FindBy(xpath = "//div[text()='Отправить']")
    private WebElement buttonSend;

    public SendEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        driver.navigate().to(SEND_EMAIL_PAGE_URL);
    }

    public void sendEmail() {
        inputTo.sendKeys(Config.getUser2Email());
        inputSubject.sendKeys(Config.getSubjectEmail());
        buttonSend.click();

        //waiting for success notification
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link_vsm")));
    }
}
