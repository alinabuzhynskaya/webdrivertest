package epam.cdp.java_testng.alina_buzhynskaya.module3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(id = "account-chooser-link")
    private WebElement buttonChangeAccount;

    @FindBy(id = "account-chooser-add-account")
    private WebElement buttonAddAccount;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage logIn(String email, String password) {
        inputLogin.sendKeys(email);
        buttonNext.click();
        inputPassword.clear();
        inputPassword.sendKeys(password);
        buttonSignIn.click();
        return new MainPage(driver);
    }

    public void changeAccount() {
        buttonChangeAccount.click();
    }

    public void addAccount() {
        buttonAddAccount.click();
    }
}
