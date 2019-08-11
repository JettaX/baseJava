package com.urise.webapp.exeption;

public class ExistStorageExeption extends StorageExeption {

    public ExistStorageExeption(String uuid) {
        super("Resume " + uuid + " already exist", uuid);
    }
}
