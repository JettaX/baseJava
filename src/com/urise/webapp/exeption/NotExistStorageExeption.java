package com.urise.webapp.exeption;

public class NotExistStorageExeption extends StorageExeption {

    public NotExistStorageExeption(String uuid) {
        super("Resume " + uuid + " not exist", uuid);
    }
}
