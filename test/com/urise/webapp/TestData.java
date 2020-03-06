package com.urise.webapp;

import com.urise.webapp.model.*;

import java.util.UUID;

public class TestData {
    public static final String UUID_1 = UUID.randomUUID().toString();
    public static final String UUID_2 = UUID.randomUUID().toString();
    public static final String UUID_3 = UUID.randomUUID().toString();
    public static final String UUID_4 = UUID.randomUUID().toString();

    public static final Resume R1;
    public static final Resume R2;
    public static final Resume R3;
    public static final Resume R4;

    static {
        R1 = new Resume(UUID_1, "Name1");
        R2 = new Resume(UUID_2, "Name2");
        R3 = new Resume(UUID_3, "Name3");
        R4 = new Resume(UUID_4, "Name4");

        R1.addContact(ContactType.MAIL, "mail1@ya.ru");
        R1.addContact(ContactType.PHONE, "11111");
        R1.addSection(SectionType.OBJECTIVE, new SimpleTextSection("Objective1"));
        R1.addSection(SectionType.PERSONAL, new SimpleTextSection("Personal data"));
        R1.addSection(SectionType.ACHIEVEMENT, new MarkedTextSection("Achivment11", "Achivment12", "Achivment13"));
        R1.addSection(SectionType.QUALIFICATION, new MarkedTextSection("Java", "SQL", "JavaScript"));
        R1.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Experience("Organization11", "http://Organization11.ru",
                                new Experience.Position(2005, 1, "position1", "content1"),
                                new Experience.Position(2001, 3, 2005, 1, "position2", "content2"))));
        R1.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Experience("Institute", null,
                                new Experience.Position(1996, 1, 2000, 12, "aspirant", null),
                                new Experience.Position(2001, 3, 2005, 1, "student", "IT facultet")),
                        new Experience("Organization12", "http://Organization12.ru")));
        R2.addContact(ContactType.SKYPE, "skype2");
        R2.addContact(ContactType.PHONE, "22222");
        R2.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Experience("Organization2", "http://Organization2.ru",
                                new Experience.Position(2015, 1, "position1", "content1"))));
    }
}