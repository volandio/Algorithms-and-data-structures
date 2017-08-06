package com.A.training.B.sinitsynv.lesson09;

import static com.A.training.B.util.Assert.assertEquals;

public class SearchCityTest {
    public static void main(String[] args) {
        testSearchCities();
    }

    private static void testSearchCities() {
        SearchCity cities = new SearchCity();
        cities.addCity("ab" + Character.MAX_VALUE + "cd");
        cities.addCity("Moscow");
        cities.addCity("Mogilev");
        assertEquals("SearchCityTest.testSearchCitiesTest1", "[ab\uFFFFcd]", cities.searchCities("ab").toString());
        assertEquals("SearchCityTest.testSearchCitiesTest2", "[Mogilev, Moscow]", cities.searchCities("mo").toString());
    }
}
