package com.christian.project.components;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IOStreamTest {
    private IOStream objectToTest;

    @BeforeEach
    public void setup() {
        objectToTest = new IOStream(true);
    }

    @Test
    public void testObjectMadeCorrectly() {
        assertEquals(1, objectToTest.bitSize());
        assertTrue(objectToTest.isInput());
        assertEquals(0L, objectToTest.payload());
    }

    @Test
    public void testChangingIOSettings() {
        objectToTest.setDirection(Face.SOUTH);
        objectToTest.setBitSize(4);

        assertEquals(Face.SOUTH, objectToTest.direction());
        assertEquals(4, objectToTest.bitSize());
        assertEquals(0L, objectToTest.payload());
    }

    @Test
    public void testGettingDataAt() {
        objectToTest.setBitSize(8);
        objectToTest.togglePayloadBit(2);

        assertEquals(-1, objectToTest.getPayloadBit(8));
        assertEquals(0, objectToTest.getPayloadBit(4));
        assertEquals(1, objectToTest.getPayloadBit(2));
    }

    @Test
    public void testChangingDataAt() {
        boolean status = objectToTest.togglePayloadBit(0);

        assertTrue(status);
        assertEquals(1L, objectToTest.payload());
    }

}