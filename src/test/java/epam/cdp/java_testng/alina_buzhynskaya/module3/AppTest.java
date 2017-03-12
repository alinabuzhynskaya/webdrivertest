package epam.cdp.java_testng.alina_buzhynskaya.module3;

import epam.cdp.java_testng.alina_buzhynskaya.module3.page.LoginPage;
import epam.cdp.java_testng.alina_buzhynskaya.module3.page.MainPage;
import epam.cdp.java_testng.alina_buzhynskaya.module3.page.SendEmailPage;
import epam.cdp.java_testng.alina_buzhynskaya.module3.page.StartPage;
import epam.cdp.java_testng.alina_buzhynskaya.module3.user.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void runTest() {

        System.setProperty("webdriver.gecko.driver", ConfigData.DRIVER_PATH + "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        StartPage startPage = new StartPage(driver);
        startPage.open();
        LoginPage loginPage = startPage.openLoginPage();
        User user1 = new User(ConfigData.EMAIL, ConfigData.PASSWORD);
        MainPage mainPage = loginPage.logIn(user1.getEmail(), user1.getPassword());
        SendEmailPage sendEmailPage = mainPage.openSendEmaiPage();
        sendEmailPage.sendEmail();
        loginPage.logOut();

        loginPage.changeAccount();
        User user2 = new User(ConfigData.EMAIL2, ConfigData.PASSWORD2);
        mainPage = loginPage.logIn(user2.getEmail(), user2.getPassword());

    }
}
