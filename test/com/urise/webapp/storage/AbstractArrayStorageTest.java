package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageExeption;
import com.urise.webapp.model.Resume;
import org.junit.Test;

import static junit.framework.TestCase.fail;

public class AbstractArrayStorageTest extends AbstractStorageTest {
    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageExeption.class)
    public void saveOverflow() {
        storage.clear();
        try {
            for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume(""));
            }
        } catch (StorageExeption e) {
            fail("the array is full");
        }
        storage.save(new Resume(""));
    }
}