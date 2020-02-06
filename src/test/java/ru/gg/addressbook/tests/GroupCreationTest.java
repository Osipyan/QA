package ru.gg.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.gg.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation () {
        app.getNavigationHelper().toGroup();
        List <GroupData> before = app.group().list();
        GroupData groupData = new GroupData("sdsdsd", "sdsdsd1", "sdsdsd2");
        app.group().create(groupData);
        List <GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        groupData.setId (after.stream().max(((o1, o2) -> Integer.compare(o1.getId(), o2.getId()))).get().getId());
        before.add(groupData);

        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }
}
