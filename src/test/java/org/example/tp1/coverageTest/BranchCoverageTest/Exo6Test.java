package org.example.tp1.coverageTest.BranchCoverageTest;

import org.example.tp1.FizzBuzz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exo6Test {


    @Test
    void fizzBuzz_ShouldReturnFizz_WhenNumberIsMultipleOfThree() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));  // 3 est un multiple de 3
        assertEquals("Fizz", FizzBuzz.fizzBuzz(6));  // 6 est un multiple de 3
        assertEquals("Fizz", FizzBuzz.fizzBuzz(9));  // 9 est un multiple de 3
    }

    @Test
    void fizzBuzz_ShouldReturnBuzz_WhenNumberIsMultipleOfFive() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));  // 5 est un multiple de 5
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10)); // 10 est un multiple de 5
        assertEquals("Buzz", FizzBuzz.fizzBuzz(20)); // 20 est un multiple de 5
    }

    @Test
    void fizzBuzz_ShouldReturnFizzBuzz_WhenNumberIsMultipleOfBothThreeAndFive() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15)); // 15 est un multiple de 3 et 5
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30)); // 30 est un multiple de 3 et 5
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(45)); // 45 est un multiple de 3 et 5
    }

    @Test
    void fizzBuzz_ShouldReturnNumber_WhenNumberIsNotMultipleOfThreeOrFive() {
        assertEquals("1", FizzBuzz.fizzBuzz(1));  // 1 n'est pas multiple de 3 ou 5
        assertEquals("2", FizzBuzz.fizzBuzz(2));  // 2 n'est pas multiple de 3 ou 5
        assertEquals("7", FizzBuzz.fizzBuzz(7));  // 7 n'est pas multiple de 3 ou 5
    }

    @Test
    void fizzBuzz_ShouldThrowException_WhenNumberIsLessThanOrEqualToOne() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0));  // 0 est <= 1
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-5)); // -5 est <= 1
    }
}
