package org.example.tp1.coverageTest.ConditionCoverageTest;

import org.example.tp1.RomanNumeral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exo5Test {


    @Test
    void toRoman_ShouldConvert1ToRomanI() {
        assertEquals("I", RomanNumeral.toRoman(1));
    }


    @Test
    void toRoman_ShouldConvert400ToRomanCD() {
        assertEquals("CD", RomanNumeral.toRoman(400));
    }


    @Test
    void toRoman_ShouldConvert3999ToRomanMMMCMXCIX() {
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999));
    }

    @Test
    void toRoman_ShouldThrowException_WhenOutOfBounds() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));  // n < 1
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000)); // n > 3999
    }
}
