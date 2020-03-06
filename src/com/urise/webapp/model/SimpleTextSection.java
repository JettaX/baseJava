package com.urise.webapp.model;

import java.util.Objects;

public class SimpleTextSection extends Section {
    private static final long serialVersionUID = 1L;

    private String content;

    public SimpleTextSection(String content) {
        this.content = content;
    }

    public SimpleTextSection() {
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleTextSection that = (SimpleTextSection) o;
        return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}