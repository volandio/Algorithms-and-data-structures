package com.A.training.B.sinitsynv.lesson06;

import java.util.LinkedHashSet;
import java.util.Set;

import static com.A.training.B.util.Assert.assertEquals;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        testAdd();
    }

    private static void testAdd() {
        Set<Integer> set = new LinkedHashSet<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer a : set) {
            stringBuilder.append(a).append(" ");
        }
        assertEquals("LinkedHashSetTest.testAdd", "1 2 3 ", stringBuilder.toString());
    }
}
