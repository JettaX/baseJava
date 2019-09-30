package com.urise.webapp.model;

import java.util.ArrayList;

public class List<T> extends Section{
    private java.util.List<T> list = new ArrayList<>();

    public void add(T value) {
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
}