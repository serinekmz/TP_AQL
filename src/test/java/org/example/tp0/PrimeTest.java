package org.example.tp0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @Test
    void isPrime_ShouldReturnFalse_WhenNumberIsLessThan2() {
        assertFalse(Prime.isPrime(0));  // 0 n'est pas un nombre premier
        assertFalse(Prime.isPrime(1));  // 1 n'est pas un nombre premier
    }

    @Test
    void isPrime_ShouldReturnTrue_WhenNumberIsPrime() {
        assertTrue(Prime.isPrime(2));  // 2 est un nombre premier
        assertTrue(Prime.isPrime(3));  // 3 est un nombre premier
        assertTrue(Prime.isPrime(5));  // 5 est un nombre premier
        assertTrue(Prime.isPrime(7));  // 7 est un nombre premier
        assertTrue(Prime.isPrime(13)); // 13 est un nombre premier
        assertTrue(Prime.isPrime(29)); // 29 est un nombre premier
    }

    @Test
    void isPrime_ShouldReturnFalse_WhenNumberIsNotPrime() {
        assertFalse(Prime.isPrime(4));  // 4 n'est pas un nombre premier
        assertFalse(Prime.isPrime(6));  // 6 n'est pas un nombre premier
        assertFalse(Prime.isPrime(8));  // 8 n'est pas un nombre premier
        assertFalse(Prime.isPrime(9));  // 9 n'est pas un nombre premier
        assertFalse(Prime.isPrime(15)); // 15 n'est pas un nombre premier
        assertFalse(Prime.isPrime(20)); // 20 n'est pas un nombre premier
    }

    @Test
    void isPrime_ShouldReturnTrue_WhenNumberIsLargePrime() {
        assertTrue(Prime.isPrime(104729));  // Un grand nombre premier
    }

    @Test
    void isPrime_ShouldReturnFalse_WhenNumberIsLargeNonPrime() {
        assertFalse(Prime.isPrime(104728));  // Un grand nombre non premier
    }
}
