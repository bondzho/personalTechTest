import org.testng.annotations.Test;

public class ComposeTest extends BaseTest {

    @Test(priority = 0)
    public void dismissModal(){
        composePage.clickDismiss();
    }

    @Test(priority = 1)
    public void createMessage(){
        composePage.composeMessage();
    }


}
