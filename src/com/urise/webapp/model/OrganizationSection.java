package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class OrganizationSection extends AbstractSection{
    private List<Experience> items = new ArrayList<>();

    public void add(Experience value) {
        items.add(value);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Experience text : items) {
            builder.append(text);
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return items.equals(that.items);
    }

    @Override
    public int hashCode() {
        return items.hashCode();
    }
}