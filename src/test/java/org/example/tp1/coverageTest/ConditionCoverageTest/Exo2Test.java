package org.example.tp1.coverageTest.ConditionCoverageTest;

import org.example.tp1.Anagram;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exo2Test {

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

}
