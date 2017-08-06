package com.A.training.B.sinitsynv.lesson09;

import static com.A.training.B.util.Assert.assertEquals;

public class CityStorageTest {
    public static void main(String[] args) {
        testSearchOne();
        testSearchTwo();
    }

    private static void testSearchOne() {
        CityStorage storage = new CityStorage();
        storage.add("Minsk");
        storage.add("Minneapolis");
        storage.add("Milan");
        storage.add("Gomel");
        storage.add("Rechica");

        assertEquals("CityStorageTest.testSearchOne", "Milan Minneapolis Minsk ", storage.search("mi"));
    }

    private static void testSearchTwo() {
        CityStorage storage = new CityStorage();
        storage.add("Valencia");
        storage.add("Vatican");
        storage.add("vacation");
        storage.add("Rome");

        assertEquals("CityStorageTest.testSearchTwo", "vacation Valencia Vatican ", storage.search("va"));
    }
}
