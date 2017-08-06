package com.A.training.B.sinitsynv.lesson06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.A.training.B.util.Assert.assertEquals;

public class MatrixSolutionTest {
    public static void main(String[] args) {
        testMatrixSetAndGet();
    }

    private static void testMatrixSetAndGet() {
        MatrixSolution matrix = new MatrixSolution(new HashMap<>());
        int n = 1_000_000;
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            matrix.set(i, n, i);
            expected.add(i);
        }
        for (int i = 0; i < n; i++) {
            actual.add(matrix.get(i, n));
        }
        assertEquals("MatrixSolutionTest.testMatrixSetAndGet", expected.toString(), actual.toString());
    }
}
