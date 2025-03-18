package com.alatoo.edu.librarymanagementsystem.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NotFoundExceptionTest {

    @Test
    void testNotFoundExceptionMessage() {
        String errorMessage = "Entity not found";

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            throw new NotFoundException(errorMessage);
        });

        assertEquals(errorMessage, exception.getMessage());
    }
}
