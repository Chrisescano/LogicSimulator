package com.christian.project.components.logicgates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ANDTest {
    private AND objectToTest;

    @BeforeEach
    public void setup() {
        objectToTest = new AND();
    }

    @Test
    public void testSettingAndGettingOutput() {
        boolean streamOneFlag = objectToTest.setInputValue(0, 1);
        boolean streamTwoFlag = objectToTest.setInputValue(1, 1);

        assertTrue(streamOneFlag);
        assertTrue(streamTwoFlag);
        assertEquals(1L, objectToTest.getOutput());
    }

    @Test
    public void testChangingNumberOfInputs() {
        boolean changingInputFlag = objectToTest.changeNumberOfInputs(3);

        assertTrue(changingInputFlag);
        assertTrue(objectToTest.setInputValue(0, 1L));
        assertTrue(objectToTest.setInputValue(1, 1L));
        assertTrue(objectToTest.setInputValue(2, 1L));
        assertEquals(1L, objectToTest.getOutput());
    }

    @Test
    public void testSettingBandWidth() {
        assertTrue(objectToTest.setBandWidth(3));
        assertTrue(objectToTest.setInputValue(0, 0b111));
        assertTrue(objectToTest.setInputValue(1, 0b111));
        assertEquals(0b111, objectToTest.getOutput());
    }
}