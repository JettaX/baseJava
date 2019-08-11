package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageExeption;
import com.urise.webapp.exeption.NotExistStorageExeption;
import com.urise.webapp.exeption.StorageExeption;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    private final int STORAGE_LIMIT = 3;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void save() {
        Resume resume = new Resume(UUID_4);
        storage.save(resume);
        assertEquals(4, storage.size());
        assertEquals(resume, storage.get(resume.getUuid()));
    }

    @Test(expected = ExistStorageExeption.class)
    public void saveExist() {
        storage.save(new Resume(UUID_1));
    }

    @Test
    public void update() {
        Resume resume = new Resume(UUID_1);
        storage.update(resume);
        assertEquals(resume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageExeption.class)
    public void delete() {
        storage.delete(UUID_1);
        assertEquals(2, storage.size());
        assertEquals(new Resume(UUID_1), storage.get(UUID_1));
    }

    @Test(expected = StorageExeption.class)
    public void deleteStackOverflow() {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (Exception e) {
            fail();
        }
        storage.save(new Resume());
    }

    @Test(expected = NotExistStorageExeption.class)
    public void deleteNotExist() {
        storage.delete("day");
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void get() {
        assertEquals(new Resume(UUID_1), storage.get(UUID_1));
        assertEquals(new Resume(UUID_2), storage.get(UUID_2));
        assertEquals(new Resume(UUID_3), storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageExeption.class)
    public void getNotExist() {
        storage.get("day");
    }

    @Test
    public void getAll() {
        Resume[] resumes = storage.getAll();
        assertEquals(3, resumes.length);
        assertEquals(new Resume(UUID_1), resumes[0]);
        assertEquals(new Resume(UUID_2), resumes[1]);
        assertEquals(new Resume(UUID_3), resumes[2]);
    }
}