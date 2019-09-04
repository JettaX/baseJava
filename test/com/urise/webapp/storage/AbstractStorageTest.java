package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageExeption;
import com.urise.webapp.exeption.NotExistStorageExeption;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public abstract class AbstractStorageTest {
    protected Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String NAME_1 = "Vity Pupkin";
    private static final Resume RESUME_1 = new Resume(UUID_1, NAME_1);
    private static final String UUID_2 = "uuid2";
    private static final String NAME_2 = "Ivan Ivanod";
    private static final Resume RESUME_2 = new Resume(UUID_2, NAME_2);
    private static final String UUID_3 = "uuid3";
    private static final String NAME_3 = "Alex Lev";
    private static final Resume RESUME_3 = new Resume(UUID_3, NAME_3);
    private static final String UUID_4 = "uuid4";
    private static final String NAME_4 = "Masha Shashka";
    private static final Resume RESUME_4 = new Resume(UUID_4, NAME_4);

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test(expected = ExistStorageExeption.class)
    public void saveExist() {
        storage.save(RESUME_1);
    }

    @Test
    public void update() {
        Resume resume = new Resume(UUID_1, NAME_1);
        storage.update(resume);
        assertSame(resume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageExeption.class)
    public void updateNotExist() {
        storage.update(RESUME_4);
    }

    @Test(expected = NotExistStorageExeption.class)
    public void delete() {
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageExeption.class)
    public void deleteNotExist() {
        storage.delete("day");
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageExeption.class)
    public void getNotExist() {
        storage.get("day");
    }

    @Test
    public void getAllSorted() {
        Resume[] expected = {RESUME_1, RESUME_2, RESUME_3};
        List array = storage.getAllSorted();
        array.sort(Comparator.comparing(Resume::getUuid));
        assertEquals(Arrays.asList(expected), array);
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}