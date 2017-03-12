package epam.cdp.java_testng.alina_buzhynskaya.module3.user;

/**
 * Created by Alina Buzhynskaya on 3/10/2017.
 */
public class User {

    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
