import org.testng.annotations.Test;

public class ComposeTest extends BaseTest {

    private static final String textMessage = "Добрый вечер!\n\nПрисылаю письмо по тестовому заданию. Хотел бы отметить несколько моментов.\n1. Так как к заданию смог приступить в Субботу (в выходной день), сделал предположение, выбрав в качестве нативного моб.приложения gmail (не браузер).\n2. По причине того, что это нативное моб.приложение, appium/selenide не состыкуются. Вследствие решил использовать PageFactory.\n3. Тесткейсов на это задание можно прописать более 15, проверяя: (i) появится ли автоматически адрес получателя; (ii) перейдёт ли письмо в шаблоны; (iii) можно ли восстановить это письмо из шаблонов; (iv) можно ли отменить отправленное письмо; И так далее.\n\nМогу предположить, что основным требованием выполнения задания это проверка логики написания автотестов.\n\nПрикрепляю ссылку на проект:\n https://github.com/bondzho/personalTechTest.git\n\nС уважением,\nБайжан";

    @Test(priority = 0)
    public void createMessage() {
        composePage.clickDismiss();
        composePage.clickComposeButton();
        composePage.enterRecipientEmail("e.kupriyanova@quality-lab.ru");
        composePage.addRecipient();
        composePage.enterSubject("Tech.Test");
        composePage.enterMessageBody(textMessage);
    }
}
