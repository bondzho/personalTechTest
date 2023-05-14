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

    @AndroidFindBy(id = "")
    WebElement composeBtn;

    @AndroidFindBy(id = "from_account_name")
    WebElement from;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.EditText")
    WebElement to;

    @AndroidFindBy(id = "peoplekit_listview_flattened_row")
    WebElement addRecipient;

    @AndroidFindBy(id = "subject")
    WebElement subject;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.widget.EditText")
    WebElement message;

    private static final String textMessage = "Добрый вечер!\n\nПрисылаю письмо по тестовому заданию. Хотел бы учесть несколько моментов.\n1. Так как к заданию смог приступить в Субботу (в выходной день), сделал предположение, выбрав в качестве нативного моб.приложения gmail (не браузер).\n2. По причине того, что это нативное моб.приложение, appium/selenide не состыкуются. Вследствие решил использовать PageFactory.\n3. Тесткейсов на это задание можно прописать более 15, проверяя: (i) появится ли автоматически адрес получателя; (ii) перейдёт ли письмо в шаблоны; (iii) можно ли восстановить это письмо из шаблонов; (iv) можно ли отменить отправленное письмо; И так далее.\n\nПредполагаю, что это задание представляет из себя проверку правописания и логику написания автотестов.\n\nТакже, прикрепляю ссылку на проект";

    @AndroidFindBy(id = "send")
    WebElement send;

    public void composeMessage() {
        clickOnElement(composeBtn);
    }


    public void clickDismiss() {
        try {
            clickOnElement(dismissBtn);
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("No dismiss button");
        }
    }

    public void composeMessageBody(){
        sendKeysOnElement(message, "");
    }
}
