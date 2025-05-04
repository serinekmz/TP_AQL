package org.example.tp1.coverageTest.LineCoverageTest;

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
    void toRoman_ShouldConvert4ToRomanIV() {
        assertEquals("IV", RomanNumeral.toRoman(4));
    }

    @Test
    void toRoman_ShouldConvert5ToRomanV() {
        assertEquals("V", RomanNumeral.toRoman(5));
    }

    @Test
    void toRoman_ShouldConvert9ToRomanIX() {
        assertEquals("IX", RomanNumeral.toRoman(9));
    }

    @Test
    void toRoman_ShouldConvert10ToRomanX() {
        assertEquals("X", RomanNumeral.toRoman(10));
    }

    @Test
    void toRoman_ShouldConvert40ToRomanXL() {
        assertEquals("XL", RomanNumeral.toRoman(40));
    }

    @Test
    void toRoman_ShouldConvert50ToRomanL() {
        assertEquals("L", RomanNumeral.toRoman(50));
    }

    @Test
    void toRoman_ShouldConvert90ToRomanXC() {
        assertEquals("XC", RomanNumeral.toRoman(90));
    }

    @Test
    void toRoman_ShouldConvert100ToRomanC() {
        assertEquals("C", RomanNumeral.toRoman(100));
    }

    @Test
    void toRoman_ShouldConvert400ToRomanCD() {
        assertEquals("CD", RomanNumeral.toRoman(400));
    }

    @Test
    void toRoman_ShouldConvert500ToRomanD() {
        assertEquals("D", RomanNumeral.toRoman(500));
    }

    @Test
    void toRoman_ShouldConvert900ToRomanCM() {
        assertEquals("CM", RomanNumeral.toRoman(900));
    }

    @Test
    void toRoman_ShouldConvert1000ToRomanM() {
        assertEquals("M", RomanNumeral.toRoman(1000));
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
