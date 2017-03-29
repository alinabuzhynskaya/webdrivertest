package epam.cdp.java_testng.alina_buzhynskaya.module3.tests;

import epam.cdp.java_testng.alina_buzhynskaya.module3.webdriver.WebDriverInstance;
import epam.cdp.java_testng.alina_buzhynskaya.module3.config.Config;
import epam.cdp.java_testng.alina_buzhynskaya.module3.page.LoginPage;
import epam.cdp.java_testng.alina_buzhynskaya.module3.page.MainPage;
import epam.cdp.java_testng.alina_buzhynskaya.module3.page.SendEmailPage;
import epam.cdp.java_testng.alina_buzhynskaya.module3.page.StartPage;
import epam.cdp.java_testng.alina_buzhynskaya.module3.user.User;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Unit test for simple App.
 */
public class SpamFunctionalityTest {

    private StartPage startPage;
    private LoginPage loginPage;
    private MainPage mainPage;
    private SendEmailPage sendEmailPage;
    private WebDriver driver;
    private static final Logger log = Logger.getLogger(SpamFunctionalityTest.class);

    @BeforeClass
    public void beforeClass() {
        log.info("Test is started: init webDriver");
        driver = WebDriverInstance.getWebDriverInstance("firefox");
    }

    @Test
    public void checkSpamFunctionalityTest() {

        User user1 = new User(Config.getUser1Email(), Config.getUser1Password(), Config.getUser1Name());
        User user2 = new User(Config.getUser2Email(), Config.getUser2Password(), Config.getUser2Name());

        log.info("1.Login as registered user1");
        startPage = new StartPage(driver);
        startPage.open();
        loginPage = startPage.openLoginPage();
        mainPage = loginPage.logIn(user1.getEmail(), user1.getPassword());
        log.info("2.Send message to user2");
        sendEmailPage = mainPage.openSendEmailPage();
        sendEmailPage.sendEmail();
        loginPage = mainPage.logOut();

        log.info("3.Login as registered user2");
        loginPage.changeAccount();
        loginPage.addAccount();
        mainPage = loginPage.logIn(user2.getEmail(), user2.getPassword());
        log.info("4.Mark letter from user1 as \"spam\"");
        mainPage.sendToSpam(user1.getName());
        mainPage.openSpamPage();
        mainPage.clearSpamBox();
        loginPage = mainPage.logOut();

        log.info("5.Login user1");
        loginPage.addAccount();
        mainPage = loginPage.logIn(user1.getEmail(), user1.getPassword());
        sendEmailPage = mainPage.openSendEmailPage();
        log.info("6.Send letter to user2");
        sendEmailPage.sendEmail();
        loginPage = mainPage.logOut();

        log.info("7.Login user2");
        loginPage.addAccount();
        mainPage = loginPage.logIn(user2.getEmail(), user2.getPassword());
        log.info("8.Go to folder: Spam");
        log.info("9.Check that the letter from user1 in Spam");
        mainPage.openSpamPage();
        String senderName = mainPage.findSenderNameInSpam();
        Assert.assertEquals(senderName, user1.getName());
    }

    @AfterClass
    public void AfterClass() {
        mainPage.logOut();
        WebDriverInstance.quit();
        log.info("Test is finished: close webDriver, close browser");
    }
}
