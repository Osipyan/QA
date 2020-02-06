package ru.gg.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.gg.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().toGroup();
        if(app.group().list().size() == 0) {
            app.group().create(new GroupData("sdsdsd", "sdsdsd1", "sdsdsd2"));
        }
    }

    @Test
    public void testGroupDeletion () {
        int index = 0;
        List<GroupData> before = app.group().list();
        app.group().delete(index);
        List <GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(index);
        Assert.assertEquals(before, after);
    }
}
