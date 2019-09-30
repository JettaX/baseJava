package com.urise.webapp.model;

public enum ContactType {
    PHONE("Телефон"),
    SKYPE("Профиль skype"),
    MAIL("Почта"),
    LINKEDIN("Профиль linkedIn"),
    GITHUB("Профиль gitHub"),
    STACKOVERFLOW("Профиль stackoverflow"),
    HOMEPAGE("Домашняя страница");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return  '\n' + title;
    }
}
