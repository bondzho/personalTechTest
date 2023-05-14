import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class BaseTest {

    protected AppiumDriver driver;
    protected WebDriverWait wait;
    protected ComposePage composePage;
    protected SentFolderPage sentFolderPage;
    protected DraftsPage draftsPage;

    @BeforeClass
    public void setup() throws MalformedURLException, InterruptedException {
        driver = AppiumConfig.getDriver();
        composePage = new ComposePage();
        sentFolderPage = new SentFolderPage();
        draftsPage = new DraftsPage();
    }

//    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void clickOnElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
