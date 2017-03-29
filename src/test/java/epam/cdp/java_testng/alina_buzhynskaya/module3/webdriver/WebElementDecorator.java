package epam.cdp.java_testng.alina_buzhynskaya.module3.webdriver;

import org.openqa.selenium.*;

import java.util.List;

/**
 * Created by Alina_Buzhynskaya on 3/24/2017.
 */
public class WebElementDecorator implements WebElement {

    private WebElement element;

    public WebElementDecorator(WebElement element) {
        this.element = element;
    }

    public void highlightElement(WebDriver driver) {
        String bg = element.getCssValue("backGroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "red" + "'", element);
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public void submit() {
        element.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        element.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        element.clear();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return element.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return element.getLocation();
    }

    @Override
    public Dimension getSize() {
        return element.getSize();
    }

    @Override
    public Rectangle getRect() {
        return element.getRect();
    }

    @Override
    public String getCssValue(String s) {
        return element.getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return element.getScreenshotAs(outputType);
    }
}
