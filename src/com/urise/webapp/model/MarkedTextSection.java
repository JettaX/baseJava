package com.urise.webapp.model;

import java.util.ArrayList;

public class MarkedTextSection extends AbstractSection {
    private java.util.List<String> list = new ArrayList<>();

    public void add(String value) {
        list.add(value);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Object aList : list) {
            builder.append(aList);
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