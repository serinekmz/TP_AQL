package org.example.tp1.coverageTest.BranchCoverageTest;

import org.example.tp1.Anagram;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exo2Test {
    //lignes et branches
    @Test
    void shouldReturnTrue_ForValidAnagrams() {
        assertTrue(Anagram.isAnagram("listen", "silent"));
        assertTrue(Anagram.isAnagram("Triangle", "Integral"));
        assertTrue(Anagram.isAnagram("A gentleman", "Elegant man"));
    }

    //lignes et branches
    @Test
    void shouldReturnFalse_ForNonAnagrams() {
        assertFalse(Anagram.isAnagram("hello", "world"));
        assertFalse(Anagram.isAnagram("apple", "pale"));
    }

    //lignes et branches
    @Test
    void shouldReturnTrue_ForSameStrings() {
        assertTrue(Anagram.isAnagram("abc", "abc"));
    }

    //lignes et branches
    @Test
    void shouldReturnTrue_WhenOnlySpacesDiffer() {
        assertTrue(Anagram.isAnagram("a bc", "cba"));
    }

    //lignes et branches
    @Test
    void shouldReturnFalse_IfLengthsDifferAfterCleanup() {
        assertFalse(Anagram.isAnagram("abc", "abcd"));
    }

    @Test
    void shouldThrowException_IfFirstInputIsNull() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "abc"));
    }

    @Test
    void shouldThrowException_IfSecondInputIsNull() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("abc", null));
    }

    @Test
    void shouldThrowException_IfBothInputsAreNull() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, null));
    }

    //lignes et branches
    @Test
    void shouldReturnTrue_ForEmptyStrings() {
        assertTrue(Anagram.isAnagram("", ""));
    }

}


