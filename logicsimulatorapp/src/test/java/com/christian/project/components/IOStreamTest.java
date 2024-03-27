package com.christian.project.components;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IOStreamTest {

    @Test
    public void testGettingValueByBandWidth() {
        IOStream stream = new IOStream(true, 2, Face.EAST);
        stream.setValue(1);
        assertEquals(1, stream.getValueByBandWidth());
    }

    @Test
    public void testSettingValuesWithDifferentWidths() {
        IOStream stream = new IOStream(true, 2, Face.EAST);
        assertFalse(stream.setValue(5L));
        assertFalse(stream.setValue(-1L));
        assertTrue(stream.setValue(2L));
    }
}