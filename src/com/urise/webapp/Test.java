package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.SortedArrayStorage;
import com.urise.webapp.storage.Storage;

import java.util.Arrays;

public class Test {
    private static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("r1");
        Resume r2 = new Resume("r2");
        Resume r3 = new Resume("r3");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);
        System.out.println(Arrays.toString(ARRAY_STORAGE.getAll()));
        ARRAY_STORAGE.delete("r1");
        System.out.println(Arrays.toString(ARRAY_STORAGE.getAll()));
        ARRAY_STORAGE.delete("r2");
        System.out.println(Arrays.toString(ARRAY_STORAGE.getAll()));
        ARRAY_STORAGE.delete("r3");
        System.out.println(Arrays.toString(ARRAY_STORAGE.getAll()));



    }
}
