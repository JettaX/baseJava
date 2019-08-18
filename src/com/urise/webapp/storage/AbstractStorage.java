package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageExeption;
import com.urise.webapp.exeption.NotExistStorageExeption;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void doSave(Resume resume, Object searchKey);

    protected abstract void doUpdate(Resume resume, Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract Object findIndex(String uuid);

    @Override
    public void save(Resume resume) {
        Object searchKey = findIndex(resume.getUuid());
        if ((int) searchKey >= 0) {
            throw new ExistStorageExeption(resume.getUuid());
        } else {
            doSave(resume, searchKey);
        }
    }

    @Override
    public void update(Resume resume) {
        doUpdate(resume, getExistedIndex(resume.getUuid()));
    }

    @Override
    public Resume get(String uuid) {
        return doGet(getExistedIndex(uuid));
    }

    @Override
    public void delete(String uuid) {
        doDelete(getExistedIndex(uuid));
    }

    private Object getExistedIndex(String uuid) {
        Object searchKey = findIndex(uuid);
        if ((int) searchKey < 0) {
            throw new NotExistStorageExeption(uuid);
        } else {
            return searchKey;
        }
    }
}
