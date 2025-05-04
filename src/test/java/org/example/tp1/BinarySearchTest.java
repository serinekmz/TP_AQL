package org.example.tp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

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
    void binarySearch_ShouldReturnCorrectIndex_WhenArrayHasOneElement() {
        int[] array = {5};
        int element = 5;
        assertEquals(0, BinarySearch.binarySearch(array, element)); // L'élément 5 est à l'indice 0
    }

    @Test
    void binarySearch_ShouldReturnNegativeOne_WhenElementNotFoundInSingleElementArray() {
        int[] array = {5};
        int element = 10;
        assertEquals(-1, BinarySearch.binarySearch(array, element)); // L'élément 10 n'est pas dans le tableau
    }

    @Test
    void binarySearch_ShouldWorkWithNegativeNumbers() {
        int[] array = {-10, -5, 0, 5, 10};
        int element = -5;
        assertEquals(1, BinarySearch.binarySearch(array, element)); // L'élément -5 est à l'indice 1
    }

    @Test
    void binarySearch_ShouldReturnNegativeOne_WhenElementIsNotInSortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        int element = 6;
        assertEquals(-1, BinarySearch.binarySearch(array, element)); // L'élément 6 n'est pas dans le tableau
    }
}
