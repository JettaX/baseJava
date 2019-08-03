package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        if (STORAGE_LIMIT == size) {
            System.out.println("You can not create a resume as the memory is over");
            return;
        }

        try {
            int index = -doNotExistedId(resume.getUuid()) - 1;
            System.arraycopy(storage, index, storage, index + 1, size - index);
            storage[index] = resume;
            size++;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("uuid exists");
        }
    }

    @Override
    public void delete(String uuid) {
        try {
            int index = doExistedId(uuid);
            int numMoved = size - index - 1;
            if (numMoved > 0) {
                System.arraycopy(storage, index + 1, storage, index, numMoved);
            }
            size--;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("uuid not found");
        }
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
