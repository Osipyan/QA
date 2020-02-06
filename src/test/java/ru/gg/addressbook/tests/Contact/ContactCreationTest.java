package ru.gg.addressbook.tests.Contact;
import org.testng.annotations.Test;
import ru.gg.addressbook.model.ContactData;
import ru.gg.addressbook.model.GroupData;
import ru.gg.addressbook.tests.TestBase;

public class ContactCreationTest extends TestBase {

    @Test (enabled = false)
    public void testContactCreation () throws InterruptedException {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("dsfdsf", "789456", "sdsdsd"), true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToMainPage();
    }
}
