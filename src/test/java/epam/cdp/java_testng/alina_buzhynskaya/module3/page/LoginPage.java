package epam.cdp.java_testng.alina_buzhynskaya.module3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Alina Buzhynskaya on 3/10/2017.
 */
public class LoginPage extends AbstractPage {

    private static final String LOGIN_URL = "https://gmail.com";

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

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        driver.navigate().to(LOGIN_URL);
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
