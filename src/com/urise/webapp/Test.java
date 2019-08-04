package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.SortedArrayStorage;
import com.urise.webapp.storage.Storage;

import java.util.Arrays;

public class Test {
    private static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("r1");
        Resume r2 = new Resume("r2222");
        Resume r3 = new Resume("r555");
        Resume r4 = new Resume("r9");
        Resume r5 = new Resume("r12");
        Resume r6 = new Resume("r18");

        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r6);
        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.save(r5);

        System.out.println(Arrays.toString(ARRAY_STORAGE.getAll()));

    }
}
