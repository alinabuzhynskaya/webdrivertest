package epam.cdp.java_testng.alina_buzhynskaya.module3.config;

/**
 * Created by Alina Buzhynskaya on 3/10/2017.
 */
public class Config {

    private static final String DRIVER_PATH = "C:\\Program Files\\geckodriver\\";
    private static final String BASE_URL = "https://www.gmail.com";
    private static final String USER1_EMAIL = "annie505smith@gmail.com";
    private static final String USER1_PASSWORD = "annsmith123";
    private static final String USER2_EMAIL = "firstlasttest838@gmail.com";
    private static final String USER2_PASSWORD = "firstlasttest8381";
    private static final String SUBJECT_EMAIL = "test";
    private static final String TITLE_START_PAGE = "Gmail - Free Storage and Email from Google";

    public static String getDriverPath() {
        return DRIVER_PATH;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getUser1Email() {
        return USER1_EMAIL;
    }

    public static String getUser1Password() {
        return USER1_PASSWORD;
    }

    public static String getUser2Email() {
        return USER2_EMAIL;
    }

    public static String getUser2Password() {
        return USER2_PASSWORD;
    }

    public static String getSubjectEmail() {
        return SUBJECT_EMAIL;
    }

    public static String getTitleStartPage() {
        return TITLE_START_PAGE;
    }
}
