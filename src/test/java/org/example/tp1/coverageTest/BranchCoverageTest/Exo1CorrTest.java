package org.example.tp1.coverageTest.BranchCoverageTest;

import org.example.tp1.PalindromeChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exo1CorrTest {


    @Test
    void isPalindrome_ShouldReturnTrue_WhenPalindrome() {
        // Tests avec des palindromes
        assertTrue(PalindromeChecker.isPalindrome("A man a plan a canal Panama"));
        assertTrue(PalindromeChecker.isPalindrome("racecar"));
        assertTrue(PalindromeChecker.isPalindrome("madam"));
    }

    @Test
    void isPalindrome_ShouldReturnFalse_WhenNotPalindrome() {
        // Tests avec des chaînes non-palindromes
        assertFalse(PalindromeChecker.isPalindrome("hello"));
        assertFalse(PalindromeChecker.isPalindrome("world"));
    }

    @Test
    void isPalindrome_ShouldReturnTrue_WhenSingleCharacter() {
        // Test avec une seule lettre (toujours un palindrome)
        assertTrue(PalindromeChecker.isPalindrome("a"));
    }

    @Test
    void isPalindrome_ShouldThrowException_WhenNullString() {
        // Test si la chaîne est nulle
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            PalindromeChecker.isPalindrome(null);
        });
        assertEquals("String must not be null", exception.getMessage());
    }
}
