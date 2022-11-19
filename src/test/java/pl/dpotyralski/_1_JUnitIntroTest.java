package pl.dpotyralski;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _1_JUnitIntroTest {

    @Test
    void introTest() {
        String actual = "result1";
        String expected = "result1";

        assertEquals(expected, actual);
    }

}
