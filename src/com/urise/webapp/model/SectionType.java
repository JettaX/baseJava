package com.urise.webapp.model;

public enum SectionType {
    OBJECTIVE("Позиция"),
    PERSONAL("Личные качества"),
    QUALIFICATION("Квалификация"),
    EXPERIENCE("Опыт работы"),
    ACHIEVEMENT("Достижения"),
    EDUCATION("Образование");

    private String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return  title;
    }
}
