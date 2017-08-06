package com.A.training.B.sinitsynv.lesson06;

public class MatrixKey {
    private int i;
    private int j;
    private int hash;

    public MatrixKey(int i, int j) {
        this.i = i;
        this.j = j;
        hash = hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        MatrixKey matrixKey = (MatrixKey) o;
        return matrixKey.i == i && matrixKey.j == j && matrixKey.hash == hash;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + i;
        result = 31 * result + j;
        return result;
    }
}
