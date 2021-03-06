package ru.gg.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.gg.addressbook.model.GroupData;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void initGroupCreation () {
        click(By.name("new"));
    }

    public void submitGroupCreation () {
        click(By.name("submit"));
    }

    public void fillGroupForm (GroupData groupData) {
        fillField(By.name("group_name"), groupData.getName());
        fillField(By.name("group_header"), groupData.getHeader());
        fillField(By.name("group_footer"), groupData.getFooter());
    }

    public void deleteSelectedGroup() {
        click(By.name("delete"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void create(GroupData groupData) {
        initGroupCreation();
        fillGroupForm(groupData);
        submitGroupCreation();
        returnToGroupPage();
    }

    public void modify(int index, GroupData groupData) {
        selectGroup(index);
        initGroupModification();
        fillGroupForm(groupData);
        submitGroupModification();
        returnToGroupPage();
    }

    public void delete(int index) {
        selectGroup(index);
        deleteSelectedGroup();
        returnToGroupPage();
    }

    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));

        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String name = element.getText();
            groups.add(new GroupData(id, name, null, null));
        }

        return groups;
    }
}
