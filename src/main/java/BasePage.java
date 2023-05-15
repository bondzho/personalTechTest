import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class BasePage {
    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public BasePage() throws MalformedURLException, InterruptedException {
        this.driver = AppiumConfig.getDriver();
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebElement waitElementIsVisible(WebElement element){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException noSuchElementException){
            System.out.println(element+" element not found");
        }
        return element;
    }

    public void clickOnElement(WebElement element){
        waitElementIsVisible(element);
        element.click();
    }

    public void sendKeysOnElement(WebElement element, String text){
        waitElementIsVisible(element);
        element.sendKeys(text);
    }

    public WebElement findTheElement(WebElement element){
        waitElementIsVisible(element);
        return element;
    }
}
