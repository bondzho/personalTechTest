import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class SentFolderPage extends BasePage {
    public SentFolderPage() throws MalformedURLException, InterruptedException {
        super();
    }

    @AndroidFindBy(accessibility = "Open navigation drawer")
    WebElement navMenu;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[10]/android.widget.LinearLayout")
    WebElement sentMessages;

    @AndroidFindBy(id = "senders")
    WebElement recipientEmail;

    public void goToMenu(){
        clickOnElement(navMenu);
    }

    public void chooseSentFolder(){
        clickOnElement(sentMessages);
    }

    public String getRecipientEmail(){
        return findTheElement(recipientEmail).getText();
    }
}
