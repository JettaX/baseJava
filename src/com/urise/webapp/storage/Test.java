package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class Test {
    private static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        try {
            System.out.println(ARRAY_STORAGE.get("id9"));
        } catch (NullPointerException e) {
            System.out.println("Empty");
        }

    }
}
