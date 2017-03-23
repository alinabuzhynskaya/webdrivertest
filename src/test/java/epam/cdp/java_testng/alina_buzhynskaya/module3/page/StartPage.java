package epam.cdp.java_testng.alina_buzhynskaya.module3.page;

import epam.cdp.java_testng.alina_buzhynskaya.module3.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Alina Buzhynskaya on 3/10/2017.
 */
public class StartPage extends AbstractPage{

    private static final String START_PAGE_URL = "https://gmail.com";

    @FindBy(className = "gmail-nav__nav-link__sign-in")
    private WebElement buttonSignIn;

    private WebDriver driver;

    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void open() {
        driver.navigate().to(START_PAGE_URL);
    }

    public LoginPage openLoginPage() {
        if (driver.getTitle().equals(Config.getTitleStartPage())) {
            buttonSignIn.click();
        }

        return new LoginPage(driver);
    }
}
