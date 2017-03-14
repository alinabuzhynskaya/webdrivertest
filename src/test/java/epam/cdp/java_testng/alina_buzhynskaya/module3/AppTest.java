package epam.cdp.java_testng.alina_buzhynskaya.module3;

import epam.cdp.java_testng.alina_buzhynskaya.module3.config.Config;
import epam.cdp.java_testng.alina_buzhynskaya.module3.page.LoginPage;
import epam.cdp.java_testng.alina_buzhynskaya.module3.page.MainPage;
import epam.cdp.java_testng.alina_buzhynskaya.module3.page.SendEmailPage;
import epam.cdp.java_testng.alina_buzhynskaya.module3.page.StartPage;
import epam.cdp.java_testng.alina_buzhynskaya.module3.user.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private LoginPage loginPage;
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        //reguired geckodriver v0.14.0
        System.setProperty("webdriver.gecko.driver", Config.getDriverPath() + "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void checkSpamFunctionalityTest() {

        User user1 = new User(Config.getUser1Email(), Config.getUser1Password(), Config.getUser1Name());
        User user2 = new User(Config.getUser2Email(), Config.getUser2Password(), Config.getUser2Name());

        StartPage startPage = new StartPage(driver);
        startPage.open();
        loginPage = startPage.openLoginPage();
        MainPage mainPage = loginPage.logIn(user1.getEmail(), user1.getPassword());
        SendEmailPage sendEmailPage = mainPage.openSendEmailPage();
        sendEmailPage.sendEmail();
        loginPage.logOut();

        loginPage.changeAccount();
        loginPage.addAccount();
        mainPage = loginPage.logIn(user2.getEmail(), user2.getPassword());
        mainPage.archiveEmail(user1.getName());
        loginPage.logOut();

        loginPage.addAccount();
        mainPage = loginPage.logIn(user1.getEmail(), user1.getPassword());
        sendEmailPage = mainPage.openSendEmailPage();
        sendEmailPage.sendEmail();
        loginPage.logOut();

        loginPage.addAccount();
        mainPage = loginPage.logIn(user2.getEmail(), user2.getPassword());
//        //todo check email in archive box
//        //Assert.assertEquals();
    }

    @AfterTest
    public void afterTest() {
        loginPage.logOut();
        driver.quit();
    }
}
