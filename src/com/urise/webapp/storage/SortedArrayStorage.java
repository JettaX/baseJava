package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private  static final Comparator RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected void insertElement(Resume resume, int searchKey) {
        int index = -searchKey - 1;
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = resume;
    }

    @Override
    protected void deleteElement(int searchKey) {
        int numMoved = size - searchKey - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, searchKey + 1, storage, searchKey, numMoved);
        }
    }

    @Override
    protected Object findIndex(String uuid) {
        Resume searchKey = new Resume(uuid, "name");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }
}
