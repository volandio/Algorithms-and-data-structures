package com.A.training.B.sinitsynv.lesson09;

import java.util.SortedSet;
import java.util.TreeSet;

class SearchCity {
    private SortedSet<String> treeSet = new TreeSet<>(java.lang.String.CASE_INSENSITIVE_ORDER);

    void addCity(String str) {
        treeSet.add(str);
    }

    SortedSet<String> searchCities(String string) {
        return treeSet.subSet(string, string + Character.MAX_VALUE + Character.MAX_VALUE);
    }
}
