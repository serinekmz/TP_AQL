package org.example.tp1.coverageTest.BranchCoverageTest;

import org.example.tp1.Palindrome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Exo1Test {

    @Test
    void shouldReturnTrue_ForPalindromeWord() {
        // Ce test va échouer à cause de l'erreur dans la méthode
        assertTrue(Palindrome.isPalindrome("radar"));
    }



    @Test
    void shouldReturnFalse_ForNonPalindrome() {
        // Même les faux positifs peuvent échouer ici
        assertFalse(Palindrome.isPalindrome("hello"));
    }

    @Test
    void shouldReturnTrue_ForEmptyString() {
        // Devrait passer : 0 caractère → palindrome par défaut
        assertTrue(Palindrome.isPalindrome(""));
    }



    @Test
    void shouldThrowException_WhenInputIsNull() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

    @Test
    void testFailure_DetectWrongLoopLogic() {
        // Ce test montre bien que la méthode ne fonctionne pas comme prévu
        assertFalse(Palindrome.isPalindrome("abba")); // Devrait être true, mais ce sera false avec la logique actuelle
    }
}
