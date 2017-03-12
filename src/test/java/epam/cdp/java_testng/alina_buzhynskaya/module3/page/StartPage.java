package epam.cdp.java_testng.alina_buzhynskaya.module3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static epam.cdp.java_testng.alina_buzhynskaya.module3.ConfigData.TITLE_START_PAGE;
import static epam.cdp.java_testng.alina_buzhynskaya.module3.ConfigData.BASE_URL;

/**
 * Created by Alina Buzhynskaya on 3/10/2017.
 */
public class StartPage {

    @FindBy(className = "gmail-nav__nav-link__sign-in")
    private WebElement buttonSignIn;

    private WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(BASE_URL);
    }

    public LoginPage openLoginPage() {
        if (driver.getTitle().equals(TITLE_START_PAGE)) {
            buttonSignIn.click();
        }

        return new LoginPage(driver);
    }
}
