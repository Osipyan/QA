package ru.gg.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String userlogin, String userpassword) {
        fillField(By.name("user"), userlogin);
        fillField(By.name("pass"), userpassword);
        click(By.xpath("//*[@id='LoginForm']/input[3]"));
    }
}
