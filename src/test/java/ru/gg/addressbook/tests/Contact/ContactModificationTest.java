package ru.gg.addressbook.tests.Contact;
import org.testng.annotations.Test;
import ru.gg.addressbook.model.ContactData;
import ru.gg.addressbook.tests.TestBase;

public class ContactModificationTest extends TestBase {

    @Test (enabled = false)
    public void testContactModification () throws InterruptedException {
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("dfsdfds", "465465", null), false);
        app.getContactHelper().submitContactModification();
    }
}
