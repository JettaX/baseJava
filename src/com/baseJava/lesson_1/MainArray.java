package com.baseJava.lesson_1;

import java.util.Arrays;
import java.util.Scanner;

public class MainArray {
    static private ArrayStorage arrayStorage = new ArrayStorage();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String init;
        Resume resume = new Resume();
        String uuid;

        while (true) {
            System.out.println("Введите одну из команд - | save | get | list | delete | clear | size | exit |");
            init = scanner.next().toLowerCase();
            uuid = resume.uuid;
            switch (init) {
                case "save":
                    System.out.println("Введите uuid");
                    uuid = scanner.next();
                    resume = new Resume();
                    resume.uuid = uuid;
                    arrayStorage.save(resume);
                case "list":
                    printAll();
                    break;
                case "get":
                    try {
                        System.out.println(arrayStorage.get(uuid));
                    } catch (NullPointerException e) {
                        System.out.println("Empty");
                    }
                    break;
                case "delete":
                    System.out.println("Введите uuid");
                    arrayStorage.delete(scanner.next());
                    break;
                case "clear":
                    arrayStorage.clear();
                    break;
                case "size":
                    System.out.println(arrayStorage.size());
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неверный ввод");
                    break;
            }
        }
    }

    private static void printAll() {
        if (arrayStorage.size() != 0) {
            System.out.println(Arrays.toString(arrayStorage.getAll()));
        } else {
            System.out.println("Empty");
        }
    }
}
