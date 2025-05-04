package org.example.tp0;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void push_ShouldAddElementToStack() {
        Stack stack = new Stack();
        stack.push(10);
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    void pop_ShouldRemoveAndReturnLastElement() {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.pop());
        assertEquals(1, stack.size());
    }

    @Test
    void pop_ShouldThrowException_WhenStackIsEmpty() {
        Stack stack = new Stack();
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    void peek_ShouldReturnLastElementWithoutRemovingIt() {
        Stack stack = new Stack();
        stack.push(30);
        stack.push(40);
        assertEquals(40, stack.peek());
        assertEquals(2, stack.size()); // Taille doit rester la même après peek
    }

    @Test
    void peek_ShouldThrowException_WhenStackIsEmpty() {
        Stack stack = new Stack();
        assertThrows(IllegalStateException.class, stack::peek);
    }

    @Test
    void isEmpty_ShouldReturnTrue_WhenStackIsEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
    }

    @Test
    void isEmpty_ShouldReturnFalse_WhenStackIsNotEmpty() {
        Stack stack = new Stack();
        stack.push(50);
        assertFalse(stack.isEmpty());
    }

    @Test
    void size_ShouldReturnCorrectSize() {
        Stack stack = new Stack();
        assertEquals(0, stack.size());
        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    void push_ShouldExpandStack_WhenFull() {
        Stack stack = new Stack();
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        assertEquals(15, stack.size());
        assertEquals(14, stack.peek());
    }
}
