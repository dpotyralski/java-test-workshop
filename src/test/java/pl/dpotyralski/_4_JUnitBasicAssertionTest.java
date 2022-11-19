package pl.dpotyralski;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class _4_JUnitBasicAssertionTest {

    @Test
    void assertionEquals() {
        BigDecimal expected = new BigDecimal("10");
        BigDecimal actual = new BigDecimal("10");

        assertEquals(expected, actual);
    }

    @Test
    void assertionTrue() {
        BigDecimal priceBefore = new BigDecimal("10");
        BigDecimal priceAfter = new BigDecimal("11");

        assertTrue(priceBefore.compareTo(priceAfter) < 0);
    }

    @Test
    void assertionFalse() {
        BigDecimal priceBefore = new BigDecimal("10");
        BigDecimal priceAfter = new BigDecimal("11");

        assertFalse(priceBefore.compareTo(priceAfter) > 0, "Price after is less than price before");
    }

    @Test
    void assertionNotNull() {
        BigDecimal priceBefore = new BigDecimal("10");

        assertNotNull(priceBefore);
    }

    @Test
    void assertionNull() {
        BigDecimal priceBefore = null;

        assertNull(priceBefore);
    }

    @Test
    void assertionSame() {
        Integer actualNumber = 10;
        Integer expectedNumber = 10;

        assertSame(expectedNumber, actualNumber);
    }

    @Test
    void assertionNotSame() {
        Integer actualNumber = 129;
        Integer expectedNumber = 129;

        assertNotSame(expectedNumber, actualNumber);
    }

    @Test
    void assertionArraysEqual() {
        String[] actualArray = {"a", "b", "c"};
        String[] expectedArray = {"a", "b", "c"};

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void assertionIterableList() {
        List<String> actualList = Arrays.asList("a", "b", "c");
        List<String> expectedList = Arrays.asList("a", "b", "c");

        assertIterableEquals(expectedList, actualList);
    }

    @Test
    void assertionSet() {
        Set<String> actualSet = Set.of("a", "b", "c");
        Set<String> expectedSet = Set.of("a", "b", "c");

        assertIterableEquals(expectedSet, actualSet);
    }

    @Test
    void assertionMultiple() {
        List<String> actualList = Arrays.asList("a", "b", "c");

        assertEquals(3, actualList.size());
        assertEquals("a", actualList.get(0));
    }

    @Test
    void assertionAll() {
        List<String> actualList = Arrays.asList("a", "b", "c");
        assertAll(
                () -> assertEquals("a", actualList.get(0)),
                () -> assertEquals(3, actualList.size())
        );
    }

    @Test
    @Disabled
    void testFails() {
        fail("Not yet implemented");
    }

}
