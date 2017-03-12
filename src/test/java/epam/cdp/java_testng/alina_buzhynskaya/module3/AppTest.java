package epam.cdp.java_testng.alina_buzhynskaya.module3;

import epam.cdp.java_testng.alina_buzhynskaya.module3.config.Config;
import epam.cdp.java_testng.alina_buzhynskaya.module3.page.LoginPage;
import epam.cdp.java_testng.alina_buzhynskaya.module3.page.MainPage;
import epam.cdp.java_testng.alina_buzhynskaya.module3.page.SendEmailPage;
import epam.cdp.java_testng.alina_buzhynskaya.module3.page.StartPage;
import epam.cdp.java_testng.alina_buzhynskaya.module3.user.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void runTest() {

        System.setProperty("webdriver.gecko.driver", Config.getDriverPath() + "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        User user1 = new User(Config.getUser1Email(), Config.getUser1Password());
        User user2 = new User(Config.getUser2Email(), Config.getUser2Password());

        StartPage startPage = new StartPage(driver, wait);
        startPage.open();
        LoginPage loginPage = startPage.openLoginPage();
        MainPage mainPage = loginPage.logIn(user1.getEmail(), user1.getPassword());
        SendEmailPage sendEmailPage = mainPage.openSendEmailPage();
        sendEmailPage.sendEmail();
        loginPage.logOut();

        loginPage.changeAccount();
        loginPage.addAccount();
        mainPage = loginPage.logIn(user2.getEmail(), user2.getPassword());
        //todo add email to spam box
        loginPage.logOut();

        loginPage.addAccount();
        mainPage = loginPage.logIn(user1.getEmail(), user1.getPassword());
        sendEmailPage = mainPage.openSendEmailPage();
        sendEmailPage.sendEmail();
        loginPage.logOut();

        loginPage.addAccount();
        mainPage = loginPage.logIn(user2.getEmail(), user2.getPassword());
        //todo check email in spam box
        //Assert.assertEquals();
        loginPage.logOut();

        driver.quit();
    }
}
