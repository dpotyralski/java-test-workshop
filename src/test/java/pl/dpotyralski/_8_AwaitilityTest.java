package pl.dpotyralski;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static java.util.function.Predicate.isEqual;
import static org.awaitility.Awaitility.await;

class _8_AwaitilityTest {

    TimeoutPossibleResource timeoutResource = new TimeoutPossibleResource();

    @Test
    void testWithAwaitility() {
        //then
        await().atMost(Duration.ofSeconds(10)).until(() -> timeoutResource.getValue(), isEqual("lateValue"));
    }


}
