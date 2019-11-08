package com.urise.webapp.model;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume>, Serializable {
    private static final long serialVersionUID = 1L;

    private final String uuid;
    private String fullName;

    private final Map<ContactType, String> contactsFields = new EnumMap<>(ContactType.class);
    private final Map<SectionType, AbstractSection> sectionsFields = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must no be null");
        Objects.requireNonNull(fullName, "fullName must no be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getContact(ContactType type) {
        return contactsFields.get(type);
    }

    public AbstractSection getSection(SectionType type) {
        return sectionsFields.get(type);
    }

    public void addContact(ContactType type, String value) {
        contactsFields.put(type, value);
    }

    public void addSection(SectionType type, AbstractSection section) {
        sectionsFields.put(type, section);
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
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

        if (!uuid.equals(resume.uuid)) return false;
        if (!fullName.equals(resume.fullName)) return false;
        if (!contactsFields.equals(resume.contactsFields)) return false;
        return sectionsFields.equals(resume.sectionsFields);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + contactsFields.hashCode();
        result = 31 * result + sectionsFields.hashCode();
        return result;
    }

    @Override
    public int compareTo(Resume o) {
        int cmp = fullName.compareTo(o.fullName);
        return cmp != 0 ? cmp : uuid.compareTo(o.uuid);
    }
}
