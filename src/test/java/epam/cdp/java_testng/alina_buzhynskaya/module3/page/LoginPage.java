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
public class LoginPage {

    @FindBy(id = "Email")
    private WebElement inputLogin;

    @FindBy(id = "next")
    private WebElement buttonNext;

    @FindBy(id = "Passwd")
    private WebElement inputPassword;

    @FindBy(id = "signIn")
    private WebElement buttonSignIn;

    @FindBy(className = "gbii")
    private WebElement buttonAccount;

    @FindBy(id = "gb_71")
    private WebElement buttonLogOut;

    @FindBy(id = "account-chooser-link")
    private WebElement buttonChangeAccount;

    @FindBy(id = "account-chooser-add-account")
    private WebElement buttonAddAccount;

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public MainPage logIn(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        inputLogin.sendKeys(email);
        buttonNext.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
        inputPassword.sendKeys(password);
        buttonSignIn.click();
        return new MainPage(driver);
    }

    public void logOut() {
        buttonAccount.click();
        buttonLogOut.click();
    }

    public void changeAccount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account-chooser-link")));
        buttonChangeAccount.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account-chooser-add-account")));
        buttonAddAccount.click();
    }
}
