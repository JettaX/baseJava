package com.baseJava.lesson_1;

import java.util.Arrays;

public class MainTestArrayStorage {
    public static void main(String[] args) {
        ArrayStorage arrayStorage = new ArrayStorage();
        Resume resume1 = new Resume();
        resume1.uuid = "uuid1";
        Resume resume2 = new Resume();
        resume2.uuid = "uuid2";
        Resume resume3 = new Resume();
        resume3.uuid = "uuid3";

        arrayStorage.save(resume1);
        arrayStorage.save(resume2);
        arrayStorage.save(resume3);

        System.out.println(arrayStorage.get(resume1.uuid));
        System.out.println(arrayStorage.size());

        System.out.println(Arrays.toString(arrayStorage.getAll()));
        arrayStorage.delete(resume1.uuid);
        System.out.println(Arrays.toString(arrayStorage.getAll()));
        System.out.println(arrayStorage.size());
        arrayStorage.clear();
        System.out.println(Arrays.toString(arrayStorage.getAll()));
        System.out.println(arrayStorage.size());
    }
}