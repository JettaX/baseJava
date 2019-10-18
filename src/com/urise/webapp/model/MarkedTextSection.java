package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class MarkedTextSection extends AbstractSection {
    private List<String> items = new ArrayList<>();

    public void add(String value) {
        items.add(value);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String text : items) {
            builder.append(text);
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarkedTextSection that = (MarkedTextSection) o;

        return items.equals(that.items);
    }

    @Override
    public int hashCode() {
        return items.hashCode();
    }
}