package ru.gg.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.gg.addressbook.model.ContactData;
import ru.gg.addressbook.model.GroupData;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initContactCreation () {
        click(By.linkText("add new"));
    }

    public void initContactModification () {
        click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification () {
        click(By.name("update"));
    }

    public void fillContactForm (ContactData contactData, boolean creation) {
        fillField(By.name("firstname"), contactData.getFirstName());
        fillField(By.name("mobile"), contactData.getMobilePhone());
        if(creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitContactCreation () {
        click(By.name("submit"));
    }

    public void returnToMainPage() {
        click(By.linkText("home page"));
    }
}
