package com.urise.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayStorageTest.class,
        MapResumeStorageTest.class,
        MapUuidStorageTest.class,
        ListStorageTest.class,
        SortedArrayStorageTest.class,
        StreamSerializerFileStorageTest.class,
        StreamSerializerPathStorageTest.class,
        XmlPathStorageTest.class,
        JsonPathStorageTest.class,
        DataPathStorageTest.class,
        SqlStorageTest.class
})

public class AllStorageTest {
}