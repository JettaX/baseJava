package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume resume) {
        if (STORAGE_LIMIT == size) {
            System.out.println("You can not create a resume as the memory is over");
            return;
        }

        try {
            doNotExistedId(resume.getUuid());
            storage[size++] = resume;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("uuid exists");
        }
    }

    public void delete(String uuid) {
        try {
            int indexResume = doExistedId(uuid);
            int numMoved = size - indexResume - 1;
            if (numMoved > 0) {
                storage[indexResume] = storage[size - 1];
            }
            storage[--size] = null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("uuid not found");
        }
    }

    protected int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}