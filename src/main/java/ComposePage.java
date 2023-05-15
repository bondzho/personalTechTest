import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class ComposePage extends BasePage {
    public ComposePage() throws MalformedURLException, InterruptedException {
        super();
    }

    @AndroidFindBy(id = "dismiss_button")
    WebElement dismissBtn;

    @AndroidFindBy(id = "compose_button")
    WebElement composeBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.EditText")
    WebElement to;

    @AndroidFindBy(id = "peoplekit_listview_flattened_row")
    WebElement addRecipient;

    @AndroidFindBy(id = "subject")
    WebElement subject;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.widget.EditText")
    WebElement message;

    @AndroidFindBy(id = "send")
    WebElement send;


    public void clickDismiss() {
            clickOnElement(dismissBtn);
    }

    public void clickComposeButton() {
        clickOnElement(composeBtn);
    }

    public void enterRecipientEmail(String text){
        sendKeysOnElement(to,text);
    }

    public void addRecipient(){
        clickOnElement(addRecipient);
    }

    public void enterSubject(String subjectText){
        sendKeysOnElement(subject, subjectText);
    }

    public void enterMessageBody(String textMessage){
        sendKeysOnElement(message, textMessage);
    }

    public void sendEmail(){
        clickOnElement(send);
    }
}
