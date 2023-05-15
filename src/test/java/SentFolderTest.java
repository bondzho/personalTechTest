import org.testng.annotations.Test;

public class SentFolderTest extends BaseTest {

    @Test(dependsOnMethods = "ComposeTest.createMessage")
    public void checkingSentEmail(){
        sentFolderPage.goToMenu();
        sentFolderPage.chooseSentFolder();
        assert sentFolderPage.getRecipientEmail().contains("e.kupriyanova@quality-lab.ru");
    }
}
