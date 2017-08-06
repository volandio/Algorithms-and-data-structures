package com.A.training.B.sinitsynv.lesson06;

import java.util.HashMap;
import java.util.Map;

public class MatrixSolution implements Matrix<Integer> {
    private Map<MatrixKey, Integer> matrix;

    public MatrixSolution(HashMap<MatrixKey, Integer> matrix) {
        this.matrix = matrix;
    }

    @Override
    public Integer get(int i, int j) {
        return matrix.get(new MatrixKey(i, j));
    }

    @Override
    public void set(int i, int j, Integer value) {
        matrix.put(new MatrixKey(i, j), value);
    }
}
