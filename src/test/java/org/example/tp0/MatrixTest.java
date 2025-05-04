package org.example.tp0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void setAndGet_ShouldReturnCorrectValue() {
        Matrix matrix = new Matrix(3);
        matrix.set(0, 0, 5);
        matrix.set(1, 1, 10);
        matrix.set(2, 2, 15);

        assertEquals(5, matrix.get(0, 0));
        assertEquals(10, matrix.get(1, 1));
        assertEquals(15, matrix.get(2, 2));
    }

    @Test
    void add_ShouldAddMatricesCorrectly_WhenMatricesAreTheSameSize() {
        Matrix matrix1 = new Matrix(2);
        Matrix matrix2 = new Matrix(2);

        matrix1.set(0, 0, 1);
        matrix1.set(0, 1, 2);
        matrix1.set(1, 0, 3);
        matrix1.set(1, 1, 4);

        matrix2.set(0, 0, 5);
        matrix2.set(0, 1, 6);
        matrix2.set(1, 0, 7);
        matrix2.set(1, 1, 8);

        matrix1.add(matrix2);

        assertEquals(6, matrix1.get(0, 0));
        assertEquals(8, matrix1.get(0, 1));
        assertEquals(10, matrix1.get(1, 0));
        assertEquals(12, matrix1.get(1, 1));
    }

    @Test
    void add_ShouldThrowException_WhenMatricesAreNotTheSameSize() {
        Matrix matrix1 = new Matrix(2);
        Matrix matrix2 = new Matrix(3);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            matrix1.add(matrix2);
        });
        assertEquals("Matrices must have the same size", exception.getMessage());
    }

    @Test
    void add_ShouldThrowException_WhenOtherMatrixIsNull() {
        Matrix matrix = new Matrix(2);

        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            matrix.add(null);
        });
        assertEquals("Other matrix must not be null", exception.getMessage());
    }

    @Test
    void multiply_ShouldMultiplyMatricesCorrectly_WhenMatricesAreTheSameSize() {
        Matrix matrix1 = new Matrix(2);
        Matrix matrix2 = new Matrix(2);

        matrix1.set(0, 0, 1);
        matrix1.set(0, 1, 2);
        matrix1.set(1, 0, 3);
        matrix1.set(1, 1, 4);

        matrix2.set(0, 0, 5);
        matrix2.set(0, 1, 6);
        matrix2.set(1, 0, 7);
        matrix2.set(1, 1, 8);

        matrix1.multiply(matrix2);

        assertEquals(19, matrix1.get(0, 0));
        assertEquals(22, matrix1.get(0, 1));
        assertEquals(43, matrix1.get(1, 0));
        assertEquals(50, matrix1.get(1, 1));
    }

    @Test
    void multiply_ShouldThrowException_WhenMatricesAreNotTheSameSize() {
        Matrix matrix1 = new Matrix(2);
        Matrix matrix2 = new Matrix(3);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            matrix1.multiply(matrix2);
        });
        assertEquals("Matrices must have the same size", exception.getMessage());
    }

    @Test
    void multiply_ShouldThrowException_WhenOtherMatrixIsNull() {
        Matrix matrix = new Matrix(2);

        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            matrix.multiply(null);
        });
        assertEquals("Other matrix must not be null", exception.getMessage());
    }

    @Test
    void transpose_ShouldTransposeMatrixCorrectly() {
        Matrix matrix = new Matrix(2);

        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(1, 0, 3);
        matrix.set(1, 1, 4);

        matrix.transpose();

        assertEquals(1, matrix.get(0, 0));
        assertEquals(3, matrix.get(0, 1));
        assertEquals(2, matrix.get(1, 0));
        assertEquals(4, matrix.get(1, 1));
    }

    @Test
    void toString_ShouldReturnCorrectStringRepresentation() {
        Matrix matrix = new Matrix(2);

        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(1, 0, 3);
        matrix.set(1, 1, 4);

        String expected = "[1, 2]\n[3, 4]\n";
        assertEquals(expected, matrix.toString());
    }
}
