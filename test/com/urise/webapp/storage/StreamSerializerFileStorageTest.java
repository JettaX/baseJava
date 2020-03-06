package com.urise.webapp.storage;

import com.urise.webapp.storage.serializer.ObjectStreamSerializer;

public class StreamSerializerFileStorageTest extends AbstractStorageTest {
    public StreamSerializerFileStorageTest() {
        super(new FileStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamSerializer()));
    }
}