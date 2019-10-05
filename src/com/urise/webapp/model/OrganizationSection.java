package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class OrganizationSection extends AbstractSection{
    private List<Experience> list = new ArrayList<>();

    public void add(Experience value) {
        list.add(value);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Experience List : list) {
            builder.append(List);
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }
}