package org.example.tp1.coverageTest.BranchCoverageTest;

import org.example.tp1.BinarySearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exo3Test {

    @Test
    void binarySearch_ShouldReturnIndex_WhenElementIsPresent() {
        int[] array = {1, 3, 5, 7, 9};
        int element = 5;
        assertEquals(2, BinarySearch.binarySearch(array, element)); // L'élément 5 est à l'indice 2
    }

    @Test
    void binarySearch_ShouldReturnNegativeOne_WhenElementIsNotPresent() {
        int[] array = {1, 3, 5, 7, 9};
        int element = 4;
        assertEquals(-1, BinarySearch.binarySearch(array, element)); // L'élément 4 n'est pas dans le tableau
    }

    @Test
    void binarySearch_ShouldReturnNegativeOne_WhenArrayIsEmpty() {
        int[] array = {};
        int element = 5;
        assertEquals(-1, BinarySearch.binarySearch(array, element)); // Le tableau est vide, aucun élément
    }

    @Test
    void binarySearch_ShouldReturnFirstIndex_WhenElementIsAtStart() {
        int[] array = {1, 3, 5, 7, 9};
        int element = 1;
        assertEquals(0, BinarySearch.binarySearch(array, element)); // L'élément 1 est à l'indice 0
    }

    @Test
    void binarySearch_ShouldReturnLastIndex_WhenElementIsAtEnd() {
        int[] array = {1, 3, 5, 7, 9};
        int element = 9;
        assertEquals(4, BinarySearch.binarySearch(array, element)); // L'élément 9 est à l'indice 4
    }

    @Test
    void binarySearch_ShouldThrowException_WhenArrayIsNull() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 5));
    }


    @Test
    void binarySearch_ShouldWorkWithNegativeNumbers() {
        int[] array = {-10, -5, 0, 5, 10};
        int element = -5;
        assertEquals(1, BinarySearch.binarySearch(array, element)); // L'élément -5 est à l'indice 1
    }

}
