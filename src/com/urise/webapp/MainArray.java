package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.SortedArrayStorage;
import com.urise.webapp.storage.Storage;

import java.util.Arrays;
import java.util.Scanner;

public class MainArray {
    private static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String init;
        Resume resume;
        String uuid;

        while (true) {
            System.out.println("Enter one of the commands - | save | update | get | list | delete | clear | size | exit |");
            init = scanner.next().toLowerCase();
            switch (init) {
                case "save":
                    System.out.println("Enter uuid");
                    uuid = scanner.next();
                    resume = new Resume(uuid);
                    ARRAY_STORAGE.save(resume);
                case "list":
                    getAll();
                    break;
                case "update":
                    System.out.println("Enter new uuid");
                    uuid = scanner.next();
                    resume = new Resume(uuid);
                    ARRAY_STORAGE.update(resume);
                    break;
                case "get":
                    try {
                        System.out.println("Enter uuid");
                        uuid = scanner.next();
                        System.out.println(ARRAY_STORAGE.get(uuid));
                    } catch (NullPointerException e) {
                        System.out.println("Empty");
                    }
                    break;
                case "delete":
                    System.out.println("Enter uuid");
                    ARRAY_STORAGE.delete(scanner.next());
                    break;
                case "clear":
                    ARRAY_STORAGE.clear();
                    break;
                case "size":
                    System.out.println(ARRAY_STORAGE.size());
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    private static void getAll() {
        if (ARRAY_STORAGE.size() != 0) {
            System.out.println(Arrays.toString(ARRAY_STORAGE.getAll()));
        } else {
            System.out.println("Empty");
        }
    }
}
