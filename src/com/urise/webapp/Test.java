package com.urise.webapp;

import com.urise.webapp.storage.SortedArrayStorage;
import com.urise.webapp.storage.Storage;

public class Test {
    private static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Runnable noArguments = () -> System.out.println("Hello World");
        noArguments.run();

    }
}
