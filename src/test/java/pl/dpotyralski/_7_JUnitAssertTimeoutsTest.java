package pl.dpotyralski;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class _7_JUnitAssertTimeoutsTest {

    TimeoutPossibleResource timeoutResource = new TimeoutPossibleResource();

    @Test
    void testTimeoutsAssertions() {
        assertTimeout(Duration.ofSeconds(5), () -> timeoutResource.calculateImpact(1));
    }

    @Test
    void testTimeoutsPreemptivelyAssertions() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> timeoutResource.calculateImpact(1));
    }

    @Test
    @Timeout(value = 3000, unit = TimeUnit.MILLISECONDS)
    void testTimeoutWithAnnotation() {
        //when
        int actual = timeoutResource.calculateImpact(2);

        //then
        assertEquals(4, actual);
    }


}
