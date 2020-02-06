package ru.gg.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.gg.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().toGroup();
        if(app.group().list().size() == 0) {
            app.group().create(new GroupData("sdsdsd", "sdsdsd1", "sdsdsd2"));
        }
    }

    @Test
    public void testGroupModification() {
        int index = 1;
        List<GroupData> before = app.group().list();
        GroupData groupData = new GroupData(before.get(before.size() - 1).getId(),"sdsdsd44", "sdsdsd55", "sdsdsd66");
        app.group().modify(index, groupData);
        List <GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(groupData);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
