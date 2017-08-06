package com.A.training.B.sinitsynv.lesson06;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.A.training.B.util.Assert.assertEquals;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        testPut();
    }

    private static void testPut() {
        Map<Integer, Character> map = new LinkedHashMap<Integer, Character>() {{
            put(1, 'a');
            put(2, 'b');
            put(3, 'c');
        }};
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, Character> m : map.entrySet()) {
            stringBuilder.append(m.getKey()).append(m.getValue()).append(" ");
        }
        assertEquals("LinkedHashMapTest.testPut", "1a 2b 3c ", stringBuilder.toString());
    }
}
