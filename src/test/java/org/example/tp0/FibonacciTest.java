package org.example.tp0;

import org.example.tp0.Fibonacci;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fibonacci_ShouldReturn0_WhenNIs0() {
        assertEquals(0, Fibonacci.fibonacci(0));
    }

    @Test
    void fibonacci_ShouldReturn1_WhenNIs1() {
        assertEquals(1, Fibonacci.fibonacci(1));
    }

    @Test
    void fibonacci_ShouldReturnCorrectValue_WhenNIsPositive() {
        assertEquals(5, Fibonacci.fibonacci(5));  // 5ème terme : 5
        assertEquals(55, Fibonacci.fibonacci(10)); // 10ème terme : 55
    }

    @Test
    void fibonacci_ShouldThrowException_WhenNIsNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1));
        assertEquals("n must be positive", exception.getMessage());
    }
}