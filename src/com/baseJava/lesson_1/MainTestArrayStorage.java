package com.baseJava.lesson_1;

import java.util.Arrays;

public class MainTestArrayStorage {
    public static void main(String[] args) {
        ArrayStorage arrayStorage = new ArrayStorage();
        Resume resume = new Resume();
        resume.uuid = "uuid";

        arrayStorage.save(resume);

        System.out.println(arrayStorage.get(resume.uuid));
        System.out.println(arrayStorage.size());

        System.out.println(Arrays.toString(arrayStorage.getAll()));
        arrayStorage.delete(resume.uuid);
        System.out.println(Arrays.toString(arrayStorage.getAll()));
        arrayStorage.clear();
        System.out.println(Arrays.toString(arrayStorage.getAll()));
        System.out.println(arrayStorage.size());
    }
}