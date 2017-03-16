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
public class MainPage {

    @FindBy(xpath = "//div[text()='НАПИСАТЬ']")
    private WebElement buttonCompose;

    @FindBy(xpath = "//div[@act='9']")
    private WebElement buttonActivateSpam;

    @FindBy(name = "rs")
    private WebElement buttonReportSpam;

    @FindBy(xpath = "//span[text()='Delete all spam messages now']")
    private WebElement buttonClearSpam;

    @FindBy(id = "gbqfq")
    private WebElement inputSearch;

    @FindBy(id = "gbqfb")
    private WebElement buttonSearch;

    @FindBy(name = "ok")
    private WebElement buttonClearSpamOk;

    @FindBy(name = "c")
    private WebElement senderName;

    @FindBy(className = "gbii")
    private WebElement buttonAccount;

    @FindBy(id = "gb_71")
    private WebElement buttonLogOut;

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
        buttonActivateSpam.click();
        buttonReportSpam.click();
    }

    public void clearSpamBox() {
        buttonClearSpam.click();
        buttonClearSpamOk.click();
    }

    public String findSenderNameInSpam() {
        return senderName.getText();
    }

    public void openSpamPage() {
        //waiting for opening of main page
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='COMPOSE']")));
        inputSearch.clear();
        inputSearch.sendKeys("in:spam");
        buttonSearch.click();
    }

    public LoginPage logOut() {
        buttonAccount.click();
        buttonLogOut.click();
        return new LoginPage(driver);
    }
}
