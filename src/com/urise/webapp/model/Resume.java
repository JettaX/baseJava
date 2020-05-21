package com.urise.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Resume implements Comparable<Resume>, Serializable {
    private static final long serialVersionUID = 1L;
    public static final Resume EMPTY = new Resume();

    static {
        EMPTY.addSection(SectionType.OBJECTIVE, SimpleTextSection.EMPTY);
        EMPTY.addSection(SectionType.PERSONAL, SimpleTextSection.EMPTY);
        EMPTY.addSection(SectionType.ACHIEVEMENT, MarkedTextSection.EMPTY);
        EMPTY.addSection(SectionType.QUALIFICATION, MarkedTextSection.EMPTY);
        EMPTY.addSection(SectionType.EXPERIENCE, new OrganizationSection(Experience.EMPTY));
        EMPTY.addSection(SectionType.EDUCATION, new OrganizationSection(Experience.EMPTY));
    }

    private String uuid;
    private String fullName;

    private final Map<ContactType, String> contactsFields = new EnumMap<>(ContactType.class);
    private final Map<SectionType, Section> sectionsFields = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must no be null");
        Objects.requireNonNull(fullName, "fullName must no be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public Resume() {
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public Map<ContactType, String> getContacts() {
        return contactsFields;
    }

    public Map<SectionType, Section> getSections() {
        return sectionsFields;
    }

    public String getContact(ContactType type) {
        return contactsFields.get(type);
    }

    public Section getSection(SectionType type) {
        return sectionsFields.get(type);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void addContact(ContactType type, String value) {
        contactsFields.put(type, value);
    }

    public void addSection(SectionType type, Section section) {
        sectionsFields.put(type, section);
    }

    @Override
    public String toString() {
        return uuid + " " + '(' + fullName + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) &&
                Objects.equals(fullName, resume.fullName) &&
                Objects.equals(contactsFields, resume.contactsFields) &&
                Objects.equals(sectionsFields, resume.sectionsFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, contactsFields, sectionsFields);
    }

    @Override
    public int compareTo(Resume o) {
        int cmp = fullName.compareTo(o.fullName);
        return cmp != 0 ? cmp : uuid.compareTo(o.uuid);
    }
}