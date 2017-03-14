package epam.cdp.java_testng.alina_buzhynskaya.module3.page;

import epam.cdp.java_testng.alina_buzhynskaya.module3.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        driver.navigate().to(Config.getBaseUrl());
    }

    public LoginPage openLoginPage() {
        if (driver.getTitle().equals(Config.getTitleStartPage())) {
            buttonSignIn.click();
        }

        return new LoginPage(driver);
    }
}
