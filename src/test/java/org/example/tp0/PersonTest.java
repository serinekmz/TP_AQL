package org.example.tp0;

import org.example.tp0.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getFullName_ShouldReturnCorrectFullName() {
        Person person = new Person("Alice", "Smith", 30);
        assertEquals("Alice Smith", person.getFullName());
    }

    @Test
    void getFullName_ShouldHandleEmptyFirstName() {
        Person person = new Person("", "Smith", 30);
        assertEquals(" Smith", person.getFullName());
    }

    @Test
    void getFullName_ShouldHandleEmptyLastName() {
        Person person = new Person("Alice", "", 30);
        assertEquals("Alice ", person.getFullName());
    }

    @Test
    void getFullName_ShouldHandleBothNamesEmpty() {
        Person person = new Person("", "", 30);
        assertEquals(" ", person.getFullName());
    }

    @Test
    void getFullName_ShouldHandleNamesWithSpaces() {
        Person person = new Person(" Alice ", " Smith ", 30);
        assertEquals(" Alice   Smith ", person.getFullName());
    }


    @Test
    void isAdult_ShouldReturnTrue_WhenAgeIs18() {
        Person person = new Person("Alice", "Smith", 18);
        assertTrue(person.isAdult(), "A person of 18 years should be considered an adult");
    }

    @Test
    void isAdult_ShouldReturnTrue_WhenAgeIsGreaterThan18() {
        Person person = new Person("Bob", "Brown", 25);
        assertTrue(person.isAdult(), "A person older than 18 should be considered an adult");
    }

    @Test
    void isAdult_ShouldReturnFalse_WhenAgeIsLessThan18() {
        Person person = new Person("Charlie", "White", 17);
        assertFalse(person.isAdult(), "A person younger than 18 should not be considered an adult");
    }

    @Test
    void isAdult_ShouldReturnFalse_WhenAgeIsZero() {
        Person person = new Person("Baby", "Doe", 0);
        assertFalse(person.isAdult(), "A newborn should not be considered an adult");
    }

    @Test
    void constructor_ShouldThrowException_WhenAgeIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Ghost", "Unknown", -5).isAdult());
    }
}
