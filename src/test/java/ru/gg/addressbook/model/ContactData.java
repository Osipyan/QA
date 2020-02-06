package ru.gg.addressbook.model;

public class ContactData {

    private String firstName;
    private String mobilePhone;
    private String group;

    public ContactData(String firstName, String mobilePhone, String group) {
        this.firstName = firstName;
        this.mobilePhone = mobilePhone;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getGroup () {
        return group;
    }
}
