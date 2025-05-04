package org.example.tp0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void factorial_ShouldThrowException_WhenNumberIsNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-1);
        });
        assertEquals("n must be positive", exception.getMessage());
    }

    @Test
    void factorial_ShouldReturnOne_WhenNumberIsZero() {
        assertEquals(1, Factorial.factorial(0)); // 0! = 1 par définition
    }

    @Test
    void factorial_ShouldReturnCorrectValue_WhenNumberIsPositive() {
        assertEquals(1, Factorial.factorial(1));  // 1! = 1
        assertEquals(2, Factorial.factorial(2));  // 2! = 2
        assertEquals(6, Factorial.factorial(3));  // 3! = 6
        assertEquals(24, Factorial.factorial(4)); // 4! = 24
        assertEquals(120, Factorial.factorial(5)); // 5! = 120
        assertEquals(720, Factorial.factorial(6)); // 6! = 720
        assertEquals(5040, Factorial.factorial(7)); // 7! = 5040
    }

    @Test
    void factorial_ShouldReturnCorrectValue_WhenNumberIsLarge() {
        assertEquals(3628800, Factorial.factorial(10)); // 10! = 3628800
        assertEquals(39916800, Factorial.factorial(11)); // 11! = 39916800
    }
}
