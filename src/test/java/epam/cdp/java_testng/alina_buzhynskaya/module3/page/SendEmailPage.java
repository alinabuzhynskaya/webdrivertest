package epam.cdp.java_testng.alina_buzhynskaya.module3.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static epam.cdp.java_testng.alina_buzhynskaya.module3.ConfigData.EMAIL2;
import static epam.cdp.java_testng.alina_buzhynskaya.module3.ConfigData.SUBJECT_EMAIL;

/**
 * Created by Alina Buzhynskaya on 3/10/2017.
 */
public class SendEmailPage {

    @FindBy(name = "to")
    private WebElement inputTo;

    @FindBy(name = "subjectbox")
    private WebElement inputSubject;

    @FindBy(xpath = "//div[text()='Отправить']")
    private WebElement buttonSend;

    private WebDriver driver;
    private WebDriverWait wait;

    public SendEmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public void sendEmail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
        inputTo.sendKeys(EMAIL2);
        inputSubject.sendKeys(SUBJECT_EMAIL);
        buttonSend.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link_vsm")));
    }
}
