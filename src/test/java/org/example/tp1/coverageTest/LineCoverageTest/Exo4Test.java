package org.example.tp1.coverageTest.LineCoverageTest;

import org.example.tp1.QuadraticEquation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exo4Test {


    @Test
    void solve_ShouldReturnOneRoot_WhenDeltaIsZero() {
        double[] result = QuadraticEquation.solve(1, -2, 1);
        assertEquals(1, result.length);
        assertEquals(1, result[0], 0.0001); // x = 1 est la solution
    }

    @Test
    void solve_ShouldReturnTwoRoots_WhenDeltaIsPositive() {
        double[] result = QuadraticEquation.solve(1, -3, 2);
        assertEquals(2, result.length);
        assertEquals(2, result[0], 0.0001); // x1 = 2
        assertEquals(1, result[1], 0.0001); // x2 = 1
    }

    @Test
    void solve_ShouldReturnNull_WhenDeltaIsNegative() {
        double[] result = QuadraticEquation.solve(1, 1, 1);
        assertNull(result); // Pas de racines réelles, delta < 0
    }

    @Test
    void solve_ShouldThrowException_WhenAIsZero() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1)); // a = 0 => exception
    }

    @Test
    void solve_ShouldHandleNegativeRoots() {
        double[] result = QuadraticEquation.solve(1, 2, 1);
        assertEquals(1, result.length);
        assertEquals(-1, result[0], 0.0001); // x = -1 est la solution
    }

    @Test
    void solve_ShouldHandleLargeCoefficients() {
        double[] result = QuadraticEquation.solve(1000, -2000, 1000);
        assertEquals(2, result.length);
        assertEquals(2, result[0], 0.0001); // x1 = 2
        assertEquals(0, result[1], 0.0001); // x2 = 0
    }
}
