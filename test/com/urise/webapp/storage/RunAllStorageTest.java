package com.urise.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayStorageTest.class,
        MarkedTextSectionStorageTest.class,
        MapResumeStorageTest.class,
        MapUuidStorageTest.class,
        SortedArrayStorageTest.class
})

public class RunAllStorageTest {
}