package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class MarkedTextSection extends AbstractSection {
    private List<String> list = new ArrayList<>();

    public void add(String value) {
        list.add(value);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String List : list) {
            builder.append(List);
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarkedTextSection that = (MarkedTextSection) o;

        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }
}