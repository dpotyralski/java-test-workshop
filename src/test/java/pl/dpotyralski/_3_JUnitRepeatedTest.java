package pl.dpotyralski;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _3_JUnitRepeatedTest {

    @Test
    void testTestInfo(TestInfo testInfo) {
        assertEquals("testTestInfo(TestInfo)", testInfo.getDisplayName());
    }

    @RepeatedTest(3)
    void testRepeatedTest(RepetitionInfo repetitionInfo) {
        assertEquals(2, Math.addExact(1, 1), "1 + 1 should equal 2");
    }

}
