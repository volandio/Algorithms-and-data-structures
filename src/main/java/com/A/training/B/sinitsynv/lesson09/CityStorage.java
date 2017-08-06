package com.A.training.B.sinitsynv.lesson09;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class CityStorage {
    private NavigableSet<String> storage = new TreeSet<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareToIgnoreCase(o2);
        }
    });

    public void add(String city) {
        storage.add(city);
    }

    public String search(String subString) {
        SortedSet<String> sortedSet = storage.subSet(subString, true, subString + (Character.MAX_VALUE), true);
        StringBuilder searchResult = new StringBuilder();
        for (String result : sortedSet) {
            searchResult.append(result).append(" ");
        }
        return searchResult.toString();
    }
}
