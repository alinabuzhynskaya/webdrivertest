package epam.cdp.java_testng.alina_buzhynskaya.module3.page;

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

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public SendEmailPage openSendEmaiPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='НАПИСАТЬ']")));
        buttonCompose.click();
        return new SendEmailPage(driver);
    }
}
